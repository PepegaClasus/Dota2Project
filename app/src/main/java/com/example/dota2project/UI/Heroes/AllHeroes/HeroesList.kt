package com.example.dota2project.UI.Heroes.AllHeroes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.UI.Heroes.Model.Heroes
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentHeroesListBinding
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroesList : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentHeroesListBinding
    lateinit var adapter: HeroesAdapter
    val scope = CoroutineScope(Dispatchers.Main)
    val heroes = mutableListOf<Heroes>()
    val apiSevice = ApiService.create()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        adapter = HeroesAdapter(heroes, this)
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentHeroesListBinding.bind(view)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.heroesLive.value!!.clear()



        bottom_heroes_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_heroesList -> {
                    navController.navigate(R.id.heroesList)
                    true
                }
                R.id.menu_strength -> {
                    navController.navigate(R.id.strengthList)
                    true
                }
                R.id.menu_agility -> {
                    navController.navigate(R.id.agility_list)
                    true
                }
                R.id.menu_intelligence -> {
                    navController.navigate(R.id.int_list)
                    true
                }
                else -> false
            }
        }



        viewModel.heroesLive.observe(viewLifecycleOwner, Observer { it ->
            scope.launch {
                val hero = apiSevice.getHeroes()
                heroes.addAll(hero)
                binding.recyclerView.adapter?.notifyDataSetChanged()

            }



            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            binding.recyclerView.adapter?.notifyDataSetChanged()

        })

        Log.d("===!!!===", viewModel.heroesLive.value!!.toString())


    }

    fun heroesInfo(position: Int) {
        viewModel.hero_id = heroes[position].id
        navController.navigate(R.id.hero_info)
    }


}








