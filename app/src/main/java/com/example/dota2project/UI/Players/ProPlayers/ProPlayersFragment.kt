package com.example.dota2project.UI.Players.ProPlayers

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
import com.example.dota2project.databinding.FragmentProPlayersBinding

class ProPlayersFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentProPlayersBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProPlayersBinding.bind(view)
        navController = view.findNavController()

        binding.listProPlayers.adapter = ProPlayerAdapter(viewModel.proPlayersLive.value!!, this)
        binding.listProPlayers.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.proPlayersLive.value?.clear()
        viewModel.getProPlayers()








        viewModel.proPlayersLive.observe(viewLifecycleOwner, Observer {
            binding.listProPlayers.adapter?.notifyDataSetChanged()
        })
    }


}