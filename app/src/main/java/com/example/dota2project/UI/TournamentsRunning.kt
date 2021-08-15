package com.example.dota2project.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.Tournaments
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTournamentsRunningBinding
import kotlinx.android.synthetic.main.running_tournaments_item.*


class TournamentsRunning : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    val tourn = ArrayList<Tournaments>()
    private lateinit var binding: FragmentTournamentsRunningBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel :: class.java)
        return inflater.inflate(R.layout.fragment_tournaments_running, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTournamentsRunningBinding.bind(view)

        binding.tournamentsRunningList.adapter =
            RunningTournamentAdapter(viewModel.runningTournamentsLive.value!!, this)

        binding.tournamentsRunningList.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.runningTournamentsLive.value?.clear()



        viewModel.getRunningTournaments()


        Log.d("Running", viewModel.runningTournamentsLive.value!!.toString())

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
            binding.tournamentsRunningList.adapter?.notifyDataSetChanged()
        })
    }


}