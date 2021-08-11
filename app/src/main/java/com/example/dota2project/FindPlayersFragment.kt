package com.example.dota2project

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
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.RemoteModel.PlayersSearch
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.UI.PlayersInfoAdapter
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentFindPlayersBinding
import kotlinx.android.synthetic.main.fragment_find_players.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FindPlayersFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    private lateinit var binding: FragmentFindPlayersBinding
    val apiService = ApiService.create()
    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)
        return inflater.inflate(R.layout.fragment_find_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentFindPlayersBinding.bind(view)


        binding.listPlayers.adapter = PlayersInfoAdapter(viewModel.playersLive.value!!, this)
        binding.listPlayers.layoutManager = LinearLayoutManager(activity as MainActivity)




        binding.btnSearch.setOnClickListener {
            scope.launch {
                val playerSearch = apiService.getPlayers(binding.etFind.text.toString())
                viewModel.playersLive.value?.addAll(playerSearch)
                Log.d("===!!!", viewModel.playersLive.value.toString())
                binding.listPlayers.adapter?.notifyDataSetChanged()
            }



        }





    }


}