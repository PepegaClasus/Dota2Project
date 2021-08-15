package com.example.dota2project.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsCISBinding

class TeamsCIS : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsCISBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_c_i_s, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsCISBinding.bind(view)




        binding.bottomTeamNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.allTeams ->{
                    navController.navigate(R.id.teams)
                    true
                }
                R.id.EuropeTeams ->{
                    navController.navigate(R.id.teamsEurope)
                    true
                }

                R.id.CisTeams ->{
                    navController.navigate(R.id.teamsCIS)
                    true
                }
                R.id.ChinaTeams -> {
                    navController.navigate(R.id.teamsChina)
                    true
                }
                else -> false
            }

        }

//        viewModel.teamsLive.value?.add(Teams("Virtus Pro",
//            "9,958,499 $",
//            1,
//            R.drawable.virtuspro,
//            R.drawable.vpcarry,
//            R.drawable.vpmid,
//            R.drawable.vpofflane,
//            R.drawable.vpsemisup,
//            R.drawable.vpsupport,
//            "11",
//            utils.VPDescription,
//            R.drawable.cis))

//        viewModel.teamsLive.value?.add(Teams("NAVi", "4, 922, 752 $", 2,))
//        viewModel.teamsLive.value?.add(Teams("Team Spirit", "496, 284 $", 3,))
//        viewModel.teamsLive.value?.add(Teams("Winstrike", "491, 483 $", 4))
//        viewModel.teamsLive.value?.add(Teams("ASM.GMB", "743, 800 $", 5))
//        viewModel.teamsLive.value?.add(Teams("PuckChamp", "71, 000 $", 6,))
//        viewModel.teamsLive.value?.add(Teams("Team Unique", "104, 472 $", 7))

        viewModel.myTeamsFireBaseLive.observe(viewLifecycleOwner, Observer {
            binding.recyclerTeamView.adapter?.notifyDataSetChanged()
        })
    }
    fun showTeamInfo(position:Int){
        viewModel.myTeamsFireBaseForInfo = viewModel.myTeamsFireBaseLive.value?.get(position)
        navController.navigate(R.id.teamsInfo)
    }


}