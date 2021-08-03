package com.example.dota2project.UI

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.MyTeams
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsBinding


import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.fragment_teams.*
import java.util.ArrayList

class TeamsList : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: TeamAdapter
    private lateinit var teamArrayList: ArrayList<MyTeams>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)



        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsBinding.bind(view)

        binding.recyclerTeamView.layoutManager = LinearLayoutManager(context)
        binding.recyclerTeamView.setHasFixedSize(true)






        binding.bottomTeamNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.allTeams -> {
                    navController.navigate(R.id.teams)
                    true
                }
                R.id.EuropeTeams -> {
                    navController.navigate(R.id.teamsEurope)
                    true
                }

                R.id.CisTeams -> {
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





        teamArrayList = arrayListOf()

        myAdapter = TeamAdapter(teamArrayList, this)

        binding.recyclerTeamView.adapter = myAdapter
        teamArrayList.clear()
        EventChangeListener()






    }

    fun showTeamInfo(position: Int) {
        viewModel.myTeamsForInfo = viewModel.myTeamsLive.value?.get(position)
        navController.navigate(R.id.teamsInfo)
    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()

        db.collection("TeamWorld").addSnapshotListener(object : EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null) {
                    Log.d("error!!!", error.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!) {

                    if (dc.type == DocumentChange.Type.ADDED) {

                        teamArrayList.add(dc.document.toObject(MyTeams::class.java))
                    }
                }

                myAdapter.notifyDataSetChanged()
            }


        })

    }


}