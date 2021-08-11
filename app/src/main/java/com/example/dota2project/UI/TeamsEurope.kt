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
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsEuropeBinding

class TeamsEurope : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsEuropeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)
        return inflater.inflate(R.layout.fragment_teams_europe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsEuropeBinding.bind(view)

        viewModel.heroesLive.observe(viewLifecycleOwner, Observer {
            binding.recyclerTeamView.adapter?.notifyDataSetChanged()
        })
    }


    fun showTeamInfo(position: Int) {
        viewModel.myTeamsFireBaseForInfo = viewModel.myTeamsFireBaseLive.value?.get(position)
        navController.navigate(R.id.teamsInfo)
    }


}