package com.example.dota2project.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsInfoBinding

class TeamsInfo : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsInfoBinding




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get (DotaViewModel :: class.java)

        return inflater.inflate(R.layout.fragment_teams_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTeamsInfoBinding.bind(view)
        navController = view.findNavController()

//        val team_flag = view.findViewById<ImageView>(R.id.team_flag)
//        val player1 = view.findViewById<ImageView>(R.id.player1)
//        val player2 = view.findViewById<ImageView>(R.id.player2)
//        val player3 = view.findViewById<ImageView>(R.id.player3)
//        val player4 = view.findViewById<ImageView>(R.id.player4)
//        val player5 = view.findViewById<ImageView>(R.id.player5)
//        val trofeys = view.findViewById<TextView>(R.id.num_trofeys)
//        val description = view.findViewById<TextView>(R.id.description)


        binding.teamLogo.setImageResource(viewModel.teamsForInfo!!.img_team)

        binding.player1.setImageResource(viewModel.teamsForInfo!!.player1)
        binding.namePlayer1.text = viewModel.teamsForInfo?.name_player1 ?:  "Unknown"
        binding.agePlayer1.text = viewModel.teamsForInfo?.age_player1 ?:  "Unknown"
        binding.rolePlayer1.text = viewModel.teamsForInfo?.role_player1 ?:  "Unknown"
        binding.earnPlayer1.text = viewModel.teamsForInfo?.earn_player1 ?:  "Unknown"

        binding.player2.setImageResource(viewModel.teamsForInfo!!.player2)
        binding.namePlayer2.text = viewModel.teamsForInfo?.name_player2 ?:  "Unknown"
        binding.agePlayer2.text = viewModel.teamsForInfo?.age_player2 ?:  "Unknown"
        binding.rolePlayer2.text = viewModel.teamsForInfo?.role_player2 ?:  "Unknown"
        binding.earnPlayer2.text = viewModel.teamsForInfo?.earn_player2 ?:  "Unknown"

        binding.player3.setImageResource(viewModel.teamsForInfo!!.player3)
        binding.namePlayer3.text = viewModel.teamsForInfo?.name_player3 ?:  "Unknown"
        binding.agePlayer3.text = viewModel.teamsForInfo?.age_player3 ?:  "Unknown"
        binding.rolePlayer3.text = viewModel.teamsForInfo?.role_player3 ?:  "Unknown"
        binding.earnPlayer3.text = viewModel.teamsForInfo?.earn_player3 ?:  "Unknown"

        binding.player4.setImageResource(viewModel.teamsForInfo!!.player4)

        binding.namePlayer4.text = viewModel.teamsForInfo?.name_player4 ?:  "Unknown"
        binding.agePlayer4.text = viewModel.teamsForInfo?.age_player4 ?:  "Unknown"
        binding.rolePlayer4.text = viewModel.teamsForInfo?.role_player4 ?:  "Unknown"
        binding.earnPlayer4.text = viewModel.teamsForInfo?.earn_player4 ?:  "Unknown"


        binding.player5.setImageResource(viewModel.teamsForInfo!!.player5)
        binding.namePlayer5.text = viewModel.teamsForInfo?.name_player5 ?:  "Unknown"
        binding.agePlayer5.text = viewModel.teamsForInfo?.age_player5 ?:  "Unknown"
        binding.rolePlayer5.text = viewModel.teamsForInfo?.role_player5 ?:  "Unknown"
        binding.earnPlayer5.text = viewModel.teamsForInfo?.earn_player5 ?:  "Unknown"

        binding.numTrofeys.text = viewModel.teamsForInfo?.trofeys ?: "Unknown"
        binding.description.text = viewModel.teamsForInfo?.description ?: "Unknown"
        binding.teamFlag.setImageResource(viewModel.teamsForInfo!!.img_counryTeam)



    }




}