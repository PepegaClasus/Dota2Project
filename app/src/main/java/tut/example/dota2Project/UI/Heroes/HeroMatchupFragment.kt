package tut.example.dota2Project.UI.Heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import tut.example.dota2Project.databinding.FragmentHeroMatchupBinding


class HeroMatchupFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentHeroMatchupBinding
    val scope = MainScope()
    val matchUps = mutableListOf<MatchUps>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hero_matchup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentHeroMatchupBinding.bind(view)

        binding.listMatchups.adapter = MatchUpAdapter(matchUps, this)
        binding.listMatchups.layoutManager = LinearLayoutManager(activity as MainActivity)




        viewModel.heroMatchups.observe(viewLifecycleOwner, {
            scope.launch {
                val smth = viewModel.getHeroMatchup(viewModel.hero_id)
                matchUps.addAll(smth)
                binding.listMatchups.adapter?.notifyDataSetChanged()
            }
        })

    }


}