package com.example.dota2project.UI.Tournaments.Past

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
import com.example.dota2project.databinding.FragmentTournamentPastBinding


class TournamentPast : Fragment() {
    val viewModel: DotaViewModel by activityViewModels()
    lateinit var navController: NavController
    private lateinit var binding:FragmentTournamentPastBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_tournament_past, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTournamentPastBinding.bind(view)

        binding.tournamentsPastList.adapter = TournamentPastAdapter(viewModel.runningTournamentsLive.value!!, this)
        binding.tournamentsPastList.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.runningTournamentsLive.value?.clear()

        viewModel.getPastTournaments()

        binding.bottomIntNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_past_tourn ->{
                    navController.navigate(R.id.tournamentPast)
                    true
                }
                R.id.menu_running_tourn ->{
                    navController.navigate(R.id.tournamentsRunning)
                    true
                }
                R.id.menu_upcoming_tourn -> {
                    navController.navigate(R.id.tournamentsUpcoming)
                    true
                }
                else -> false
            }
        }


        viewModel.runningTournamentsLive.observe(viewLifecycleOwner, Observer {
            binding.tournamentsPastList.adapter?.notifyDataSetChanged()
        })
    }


}