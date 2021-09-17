package tut.example.dota2Project.UI.Leagues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentLeaguesBinding

class LeaguesFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentLeaguesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leagues, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentLeaguesBinding.bind(view)

        binding.leagueList.adapter = LeagueAdapter(viewModel.leaguesLive.value!!, this)
        binding.leagueList.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.leaguesLive.value?.clear()
        viewModel.getLeagues()





        viewModel.leaguesLive.observe(viewLifecycleOwner, {
            viewModel.leaguesLive.value?.sortByDescending { it.tier }
            binding.leagueList.adapter?.notifyDataSetChanged()
        })


    }

    fun showLeagueInfo(position: Int) {
        viewModel.league_id = viewModel.leaguesLive.value?.get(position)?.leagueid!!
        navController.navigate(R.id.leagueTeamsFragment)
    }


}