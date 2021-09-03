package tut.example.dota2Project.UI.Teams.Europe

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
import com.google.firebase.firestore.*
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Teams.Model.MyTeams
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentTeamsEuropeBinding

class TeamsEurope : Fragment() {
    val viewModel: DotaViewModel by activityViewModels()
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsEuropeBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: TeamEuropeAdapter
    private lateinit var teamArrayList: ArrayList<MyTeams>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_teams_europe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsEuropeBinding.bind(view)

        binding.recyclerTeamView.layoutManager = LinearLayoutManager(context)
        binding.recyclerTeamView.setHasFixedSize(true)

        teamArrayList = arrayListOf()

        myAdapter = TeamEuropeAdapter(viewModel.myTeamsFireBaseLive.value!!)
        binding.recyclerTeamView.adapter = myAdapter
        viewModel.myTeamsFireBaseLive.value?.clear()
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

                else -> false
            }

        }

        viewModel.myTeamsFireBaseLive.observe(viewLifecycleOwner, Observer {
            binding.recyclerTeamView.adapter?.notifyDataSetChanged()
        })
    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()

        db.collection("TeamEurope").addSnapshotListener(object : EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null) {
                    Log.d("error!!!", error.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!) {

                    if (dc.type == DocumentChange.Type.ADDED) {
                        viewModel.myTeamsFireBaseLive.value?.add(dc.document.toObject(MyTeams::class.java))
                        viewModel.myTeamsFireBaseLive.value?.sortByDescending { it.rank }
                    }
                }

                myAdapter.notifyDataSetChanged()
            }


        })

    }


}