package com.example.dota2project.UI.Players.ProPlayers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.UI.Matches.RecentMatches
import com.example.dota2project.UI.Players.ProPlayers.Model.PlayerInfoAdapter
import com.example.dota2project.UI.Players.ProPlayers.Model.ProPlayersAccount
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentPlayerInfoBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class PlayerInfo : Fragment() {
    lateinit var navController: NavController
    private lateinit var binding: FragmentPlayerInfoBinding
    val players = mutableListOf<ProPlayersAccount>()
    val recentMatches = mutableListOf<RecentMatches>()
    private val scope = MainScope()
    val apiService = ApiService.create()
    val viewModel: DotaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentPlayerInfoBinding.bind(view)
        binding.recentMatchesList.adapter = PlayerInfoAdapter(recentMatches, this)
        binding.recentMatchesList.layoutManager = LinearLayoutManager(activity as MainActivity)

        var id = viewModel.player_id


        scope.launch {
            try {
                val player = viewModel.getPlayerById(id)
                val wl = viewModel.getWLPlayerById(id)
                val wins = wl?.win
                val loses = wl?.lose
                val mmr = player?.mmr_estimate?.estimate
                val leaderRank = player?.leaderboard_rank
                binding.playerWin.text = wins.toString()
                binding.playerName.text = player?.profile?.personaname.toString()
                binding.playerLose.text = loses.toString()
                binding.playerMmr.text = mmr.toString()

                if (wins == null&&loses == null&&leaderRank == null){
                    Toast.makeText(context, "Проблема с профилем", Toast.LENGTH_LONG).show()
                }


                if(leaderRank == null){
                    binding.playerRank.text = "0"
                }

                context?.let {
                    Glide.with(it).load(player?.profile?.avatarfull).into(binding.playerImage)
                }
            } catch (e: Exception) {
                Log.d("!!!", e.toString())
            }

        }

        viewModel.recentMatches.observe(viewLifecycleOwner, {
            scope.launch {
                try {
                    val matches = viewModel.getRecentMatchesById(id)
                    recentMatches.addAll(matches)
                    binding.recentMatchesList.adapter?.notifyDataSetChanged()
                    Log.d("!!!recent", recentMatches.toString())
                } catch (e: Exception) {
                    Log.d("!!!profEx", e.toString())
                }
            }


        })


    }


    fun showMatchDetails(position: Int) {
        viewModel.match_id = recentMatches[position].match_id
        navController.navigate(R.id.proMatchInfo)
    }


}