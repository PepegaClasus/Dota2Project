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
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentProTeamsBinding


class ProTeamsFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentProTeamsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProTeamsBinding.bind(view)
        navController = view.findNavController()


        binding.proTeamsList.adapter = ProTeamsAdapter(viewModel.proTeams.value!!, this)
        binding.proTeamsList.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.proTeams.value?.clear()
        viewModel.getTeams()




        viewModel.proTeams.observe(viewLifecycleOwner, {
            binding.proTeamsList.adapter?.notifyDataSetChanged()
        })


    }

    fun showTeamInfo(position: Int) {
        viewModel.team_id = viewModel.proTeams.value?.get(position)?.team_id!!
        navController.navigate(R.id.teamsInfoFragment)
    }


}