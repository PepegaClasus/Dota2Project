package tut.example.dota2Project.UI.Leagues

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
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentLeagueTeamsBinding


class LeagueTeamsFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentLeagueTeamsBinding
    val scope = MainScope()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_league_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentLeagueTeamsBinding.bind(view)

        binding.leagueTeamsList.adapter = LeagueTeamsAdapter(viewModel.leagueTeams.value!!, this)
        binding.leagueTeamsList.layoutManager = LinearLayoutManager(activity as MainActivity)









        viewModel.leagueTeams.observe(viewLifecycleOwner, {
            scope.launch {
                try {
                    val leaguesMatches = viewModel.getLeagueTeams(viewModel.league_id)
                    viewModel.leagueTeams.value?.clear()
                    viewModel.leagueTeams.value?.addAll(leaguesMatches)
                    if (viewModel.leagueTeams.value?.isEmpty() == true) {
                        Toast.makeText(context, "Нет данных о команде", Toast.LENGTH_LONG).show()
                    }
                    binding.leagueTeamsList.adapter?.notifyDataSetChanged()
                } catch (e: Exception) {
                    Log.d("LeagueTeams error", e.toString())
                }


            }
        })

    }

    fun showTeamInfo(position: Int) {
        viewModel.team_id = viewModel.leagueTeams.value?.get(position)?.team_id!!
        navController.navigate(R.id.teamsInfoFragment)
    }


}