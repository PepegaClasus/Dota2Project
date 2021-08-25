package com.example.dota2project.UI.Teams.CIS

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.UI.Teams.Model.MyTeams
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsCISBinding
import com.google.firebase.firestore.*

class TeamsCIS : Fragment() {
    val viewModel: DotaViewModel by activityViewModels()
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsCISBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: TeamCISAdapter
    private lateinit var teamArrayList: ArrayList<MyTeams>


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

        binding.recyclerTeamView.layoutManager = LinearLayoutManager(context)
        binding.recyclerTeamView.setHasFixedSize(true)

        teamArrayList = arrayListOf()

        myAdapter = TeamCISAdapter(viewModel.myTeamsFireBaseLive.value!!)
        binding.recyclerTeamView.adapter = myAdapter
        viewModel.myTeamsFireBaseLive.value?.clear()
        EventChangeListener()






        binding.bottomTeamNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.allTeams -> {
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

                else -> false
            }

        }



        viewModel.myTeamsFireBaseLive.observe(viewLifecycleOwner, Observer {


            binding.recyclerTeamView.adapter?.notifyDataSetChanged()

        })
    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()

        db.collection("TeamCIS").addSnapshotListener(object : EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null) {
                    Log.d("error!!!", error.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!) {

                    if (dc.type == DocumentChange.Type.ADDED) {
                        viewModel.myTeamsFireBaseLive.value?.add(dc.document.toObject(MyTeams::class.java))
                        Log.d("!!!", viewModel.myTeamsFireBaseLive.value.toString())
                        viewModel.myTeamsFireBaseLive.value?.sortByDescending { it.rank }
                    }
                }
                myAdapter.notifyDataSetChanged()
            }

        })

    }


}