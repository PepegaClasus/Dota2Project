package com.example.dota2project.UI.Players.FindPlayers

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
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.UI.Players.FindPlayers.Model.PlayersSearch
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentFindPlayersBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FindPlayersFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentFindPlayersBinding
    val apiService = ApiService.create()
    val list: PlayersSearch? = null
    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_find_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentFindPlayersBinding.bind(view)



        binding.listPlayers.adapter = FindPlayersAdapter(viewModel.playersLive.value!!, this)
        binding.listPlayers.layoutManager = LinearLayoutManager(activity as MainActivity)





        binding.btnSearch.setOnClickListener { it ->

            scope.launch {


                viewModel.playersLive.value?.clear()
                val playerSearch = apiService.getPlayers(binding.etFind.text.toString())
                viewModel.playersLive.value?.addAll(playerSearch)

                binding.listPlayers.adapter?.notifyDataSetChanged()
            }



        }


        binding.bottomPlayersNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.pro_player -> {
                    navController.navigate(R.id.proPlayersFragment)
                    true
                }
                R.id.players -> {
                    navController.navigate(R.id.findPlayersFragment)
                    true
                }
                else ->true
            }
        }

        viewModel.playersLive.observe(viewLifecycleOwner, Observer {


            viewModel.playersLive.value?.sortBy { it.similarity }
            binding.listPlayers.adapter?.notifyDataSetChanged()
        })





    }


}