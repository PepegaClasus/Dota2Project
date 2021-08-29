package com.example.dota2project.UI.ProTeams.ProMatchesList

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
import com.example.dota2project.R
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentProMatchesBinding
import kotlinx.coroutines.MainScope


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







        viewModel.proMatches.observe(viewLifecycleOwner, {
            Log.d("!!!matches", viewModel.proMatches.value!!.toString())
            binding.proMatchList.adapter?.notifyDataSetChanged()
        })
    }

    fun showMatch(position: Int) {
        viewModel.match_id = viewModel.proMatches.value?.get(position)?.match_id!!
        navController.navigate(R.id.matchInfo)
    }


}