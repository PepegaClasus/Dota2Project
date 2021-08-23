package com.example.dota2project.UI.Teams.World


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.MyTeamsFireBase
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsBinding
import com.google.firebase.firestore.*

class TeamsList : Fragment() {
    val viewModel: DotaViewModel by viewModels()
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: TeamWorldAdapter
    private lateinit var teamArrayList: ArrayList<MyTeamsFireBase>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsBinding.bind(view)

        binding.recyclerTeamView.layoutManager = LinearLayoutManager(context)
        binding.recyclerTeamView.setHasFixedSize(true)

        teamArrayList = arrayListOf()

        myAdapter = TeamWorldAdapter(teamArrayList)
        binding.recyclerTeamView.adapter = myAdapter
        teamArrayList.clear()

        EventChangeListener()

        binding.bottomTeamNavigation.setOnItemSelectedListener { item ->
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


    }

    fun showTeamInfo(position: Int) {

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
                        Log.d("dcMajor", dc.document.toString())
                        teamArrayList.add(dc.document.toObject(MyTeamsFireBase::class.java))
                    }
                }

                myAdapter.notifyDataSetChanged()
            }


        })

    }


}