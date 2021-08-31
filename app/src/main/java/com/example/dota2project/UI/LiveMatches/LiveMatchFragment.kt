package com.example.dota2project.UI.LiveMatches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentLiveMatchBinding
import java.text.FieldPosition


class LiveMatchFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel:DotaViewModel by activityViewModels()
    private lateinit var binding:FragmentLiveMatchBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentLiveMatchBinding.bind(view)

        binding.liveMatchList.adapter = LiveMatchAdapter(viewModel.liveMatches.value!!, this)
        binding.liveMatchList.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.liveMatches.value?.clear()

        viewModel.getLiveMatches()


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.proMatchesFragment -> {
                    navController.navigate(R.id.proMatchesFragment)
                    true
                }
                R.id.liveMatchFragment -> {
                    navController.navigate(R.id.liveMatchFragment)
                    true
                }
                else -> false
            }
        }





        viewModel.liveMatches.observe(viewLifecycleOwner, {
            viewModel.liveMatches.value?.sortByDescending { it.average_mmr }
            binding.liveMatchList.adapter?.notifyDataSetChanged()
        })
    }

    fun showMatchInfo(position: Int){
        viewModel.match_id = viewModel.liveMatches.value?.get(position)?.match_id!!
        navController.navigate(R.id.proMatchInfo)
    }


}