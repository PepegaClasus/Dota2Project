package com.example.dota2project.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentIntListBinding

class IntList : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    lateinit var binding: FragmentIntListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel :: class.java)
        return inflater.inflate(R.layout.fragment_int_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentIntListBinding.bind(view)
        binding.recyclerIntView.adapter = IntelligenceAdapter(viewModel.heroesLive.value!!, this)
        binding.recyclerIntView.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.heroesLive.value?.clear()
        viewModel.getHeroes()

        binding.bottomIntNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_heroesList ->{
                    navController.navigate(R.id.heroesList)
                    true
                }
                R.id.menu_strength ->{
                    navController.navigate(R.id.strengthList)
                    true
                }
                R.id.menu_agility ->{
                    navController.navigate(R.id.agility_list)
                    true
                }
                R.id.menu_intelligence ->{
                    navController.navigate(R.id.int_list)
                    true
                }
                else -> false
            }
        }

        viewModel.heroesLive.observe(viewLifecycleOwner, Observer {
            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("agi") }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("str") }
            binding.recyclerIntView.adapter?.notifyDataSetChanged()
        })
    }




}