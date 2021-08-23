package com.example.dota2project.UI.Heroes.AllHeroes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentHeroesListBinding
import kotlinx.android.synthetic.main.fragment_heroes_list.*
import java.util.*

class HeroesList : Fragment(), HeroesAdapter.ItemClickListener {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    private lateinit var binding: FragmentHeroesListBinding
    lateinit var adapter: HeroesAdapter
    val heroes = arrayListOf<Heroes>()
    lateinit var transaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)
        adapter = HeroesAdapter(viewModel.heroesLive.value!!, this)
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentHeroesListBinding.bind(view)





        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.heroesLive.value!!.clear()
        viewModel.getHeroes()











        binding.seachView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText!!.isNotEmpty()) {
                    viewModel.heroesLive.value?.clear()
                    val search = newText.lowercase(Locale.getDefault())
                    heroes.forEach {
                        if (it.localized_name.lowercase(Locale.getDefault()).contains(search)) {
                            viewModel.heroesLive.value?.add(it)
                        }
                    }
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                } else {
                    viewModel.heroesLive.value?.addAll(heroes)
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                }
                return true
            }

        })

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
            heroes.addAll(viewModel.heroesLive.value!!)
            Log.d("Heroes!!!", heroes.toString())
            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            binding.recyclerView.adapter?.notifyDataSetChanged()
        })

        Log.d("===!!!===", viewModel.heroesLive.value!!.toString())


    }

    fun onHeroClick(position: Int) {


//        val fragment = HeroesInfo.newInstance(list.localized_name)
//        transaction = (activity as MainActivity).supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.layout_replace, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()

    }


}








