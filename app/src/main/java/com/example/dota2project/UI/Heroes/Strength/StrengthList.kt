package com.example.dota2project.UI.Heroes.Strength

import android.os.Bundle
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
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentStrengthListBinding

class StrengthList : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentStrengthListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_strength_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentStrengthListBinding.bind(view)

        binding.recyclerStrengthView.adapter = StrengthAdapter(viewModel.heroesLive.value!!, this)
        binding.recyclerStrengthView.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.heroesLive.value?.clear()



        binding.bottomStrNavigation.setOnItemSelectedListener { item ->
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

        viewModel.heroesLive.observe(viewLifecycleOwner, Observer {
            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("int") }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("agi") }
            binding.recyclerStrengthView.adapter?.notifyDataSetChanged()
        })


    }


}