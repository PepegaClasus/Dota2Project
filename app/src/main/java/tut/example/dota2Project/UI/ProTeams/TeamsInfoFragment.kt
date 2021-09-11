package tut.example.dota2Project.UI.ProTeams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentTeamsInfoBinding


class TeamsInfoFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentTeamsInfoBinding
    val scope = MainScope()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsInfoBinding.bind(view)

        binding.teamMatches.adapter = ProTeamsInfoAdapter(viewModel.proTeamsMatches.value!!, this)
        binding.teamMatches.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.proTeamsMatches.value?.clear()

        teams()

        viewModel.proTeamsMatches.observe(viewLifecycleOwner, {
            scope.launch {
                val matches = viewModel.getTeamMatchesById(viewModel.team_id)
                viewModel.proTeamsMatches.value?.addAll(matches)
                binding.teamMatches.adapter?.notifyDataSetChanged()
            }


        })


    }


    fun teams() {
        val id = viewModel.team_id
        scope.launch {
            val teams = viewModel.getFuckingTeamById(id)

            val wins = teams?.wins
            val losses = teams?.losses
            val rating = teams?.rating
            val logo_url = teams?.logo_url

            binding.teamWins.text = wins.toString()
            binding.teamLosses.text = losses.toString()
            binding.teamInfoRating.text = rating.toString()

            context.let {
                if (it != null) {
                    Glide.with(it).load(logo_url).into(binding.teamInfoLogo)
                }
            }


        }
    }

    fun showMatches(position: Int) {
        viewModel.match_id = viewModel.proTeamsMatches.value?.get(position)?.match_id!!
        navController.navigate(R.id.proMatchInfo)
    }


}