package com.example.dota2project.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentHeroesListBinding
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import kotlinx.android.synthetic.main.heroes_item.*

class HeroesList : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    private lateinit var binding: FragmentHeroesListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentHeroesListBinding.bind(view)





        binding.recyclerView.adapter = HeroesAdapter(viewModel.heroesLive.value!!, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as MainActivity)



        viewModel.heroesLive.value!!.clear()
        viewModel.getHeroes()







        bottom_heroes_navigation.setOnNavigationItemSelectedListener { item ->
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
            Log.d("!!!", it.toString())
            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })

        Log.d("===!!!===", viewModel.heroesLive.value!!.toString())




    }

    fun nextFragment(position:Int){
        if (layout_hero_info.visibility == View.GONE){
            layout_hero_info.visibility = View.VISIBLE
        }else {
            layout_hero_info.isVisible = false
        }
    }




}