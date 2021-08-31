package com.example.dota2project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.UI.Players.ProPlayers.MatchesTeamDireAdapter
import com.example.dota2project.UI.Players.ProPlayers.MatchesTeamRadiantAdapter
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentMatchInfoBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class MatchInfo : Fragment() {
    lateinit var navController: NavController
    val radiant = mutableListOf<MatchPlayerModel>()
    val dire = mutableListOf<MatchPlayerModel>()
    val apiService = ApiService.create()
    private lateinit var binding: FragmentMatchInfoBinding
    val viewModel: DotaViewModel by activityViewModels()
    val scope = MainScope()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentMatchInfoBinding.bind(view)

        val radiantAdapter =
            MatchesTeamRadiantAdapter(viewModel.proPlayersRadiantLive.value!!, this)
        val direAdapter = MatchesTeamDireAdapter(viewModel.proPlayersDireLive.value!!, this)
        binding.radiantList.adapter = radiantAdapter
        binding.direList.adapter = direAdapter
        binding.radiantList.layoutManager = LinearLayoutManager(activity as MainActivity)
        binding.direList.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.proPlayersRadiantLive.value?.clear()
        viewModel.proPlayersDireLive.value?.clear()

        var id = viewModel.match_id







        viewModel.matchesInfo.observe(viewLifecycleOwner, {

            scope.launch {


                val match = viewModel.getMatchesById(id)
                val players = match?.players
                val radiantId = match?.radiant_team_id
                val direId = match?.dire_team_id
                val getDireId = viewModel.getFuckingTeamById(direId!!)
                val getRadiantTeam = viewModel.getFuckingTeamById(radiantId!!)
                val radiantName = getRadiantTeam?.name.toString()
                val direName = getDireId?.name.toString()


                binding.RadiantName.text = radiantName
                binding.DireName.text = direName

                if(radiantName == "null" && direName == "null"){
                    binding.RadiantName.text = "Team Radiant"
                    binding.DireName.text = "Team Dire"
                }



                binding.matchInfoRadiantScore.text = match.radiant_score.toString()
                binding.matchInfoDireScore.text = match.dire_score.toString()







                try {


                    Log.d("===111===", binding.DireName.text.toString())
                    if (match?.radiant_win == true) {
                        binding.RadiantWin.isVisible = true
                        binding.DireWin.isVisible = false
                        binding.RadiantWin.text = "${binding.RadiantName.text} win"

                    } else {
                        binding.DireWin.isVisible = true
                        binding.RadiantWin.isVisible = false
                        binding.DireWin.text = "${binding.DireName.text} win"

                    }


                    when (match?.game_mode) {
                        0 -> binding.gameModeMatch.text = "Unknown"
                        1 -> binding.gameModeMatch.text = "All Pick"
                        2 -> binding.gameModeMatch.text = "Captains Mode"
                        3 -> binding.gameModeMatch.text = "Random Draft"
                        4 -> binding.gameModeMatch.text = "Single Draft"
                        5 -> binding.gameModeMatch.text = "All Random"
                        6 -> binding.gameModeMatch.text = "Intro"
                        7 -> binding.gameModeMatch.text = "Diretide"
                        8 -> binding.gameModeMatch.text = "Reverse CM"
                        9 -> binding.gameModeMatch.text = "Greeviling"
                        10 -> binding.gameModeMatch.text = "Tutorial"
                        11 -> binding.gameModeMatch.text = "Mid Only"
                        12 -> binding.gameModeMatch.text = "Least Played"
                        13 -> binding.gameModeMatch.text = "Limited Heroes"
                        14 -> binding.gameModeMatch.text = "Compendium Match"
                        15 -> binding.gameModeMatch.text = "Custom"
                        16 -> binding.gameModeMatch.text = "Captains Draft"
                        17 -> binding.gameModeMatch.text = "Balanced Draft"
                        18 -> binding.gameModeMatch.text = "Ability Draft"
                        19 -> binding.gameModeMatch.text = "Event"
                        20 -> binding.gameModeMatch.text = "AR DeathMatch"
                        21 -> binding.gameModeMatch.text = "1vs1 Mid"
                        22 -> binding.gameModeMatch.text = "All Pick"
                        23 -> binding.gameModeMatch.text = "Turbo"
                        24 -> binding.gameModeMatch.text = "Mutation"
                    }


                    var time = match?.duration
                    val minutes = time?.div(60)
                    time = time?.rem(60)
                    val seconds = time
                    if (seconds != null) {
                        if (seconds >= 10) {
                            val timeString = "$minutes:$seconds"
                            binding.time.text = timeString
                        } else {
                            val timeString = "$minutes:0$seconds"
                            binding.time.text = timeString
                        }
                    }
                    val playerRadiant = players?.filter {
                        it.player_slot <= 5
                    }
                    val playerDire = players?.filter {
                        it.player_slot >= 6
                    }
                    radiant.clear()
                    dire.clear()
                    if (playerRadiant != null) {
                        viewModel.proPlayersRadiantLive.value?.addAll(playerRadiant)
                    }
                    if (playerDire != null) {
                        viewModel.proPlayersDireLive.value?.addAll(playerDire)
                    }

                    binding.radiantList.adapter?.notifyDataSetChanged()
                    binding.direList.adapter?.notifyDataSetChanged()

                } catch (e: Exception) {

                }
            }


        })


    }


    fun showPlayerRadiantInfo(position: Int) {
        viewModel.player_id = viewModel.proPlayersDireLive.value?.get(position)?.account_id!!
        navController.navigate(R.id.playerInfo)
    }

    fun showPlayerDireInfo(position: Int) {
        viewModel.player_id = viewModel.proPlayersRadiantLive.value?.get(position)?.account_id!!
        navController.navigate(R.id.playerInfo)
    }


}