package tut.example.dota2Project.UI.ProMatchesList.ProMatches

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.MainScope
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentProMatchesBinding


class ProMatchesFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentProMatchesBinding
    val scope = MainScope()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentProMatchesBinding.bind(view)

        binding.proMatchList.adapter = ProMatchesAdapter(viewModel.proMatches.value!!, this)
        binding.proMatchList.layoutManager = LinearLayoutManager(activity as MainActivity)

        var id = viewModel.match_id
        viewModel.proMatches.value?.clear()
        viewModel.getProMatches()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.proMatchesFragment -> {
                    navController.navigate(R.id.proMatchesFragment)
                    true
                }
                R.id.liveMatchFragment -> {
                    navController.navigate(R.id.liveMatchFragment)
                    true
                }
                else -> false
            }
        }








        viewModel.proMatches.observe(viewLifecycleOwner, {
            Log.d("!!!matches", viewModel.proMatches.value!!.toString())
            binding.proMatchList.adapter?.notifyDataSetChanged()
        })
    }

    fun showMatch(position: Int) {
        viewModel.match_id = viewModel.proMatches.value?.get(position)?.match_id!!
        navController.navigate(R.id.proMatchInfo)
    }


}