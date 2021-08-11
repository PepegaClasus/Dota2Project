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
import com.example.dota2project.R
import com.example.dota2project.RemoteModel.MyTeamsFireBase
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsInfoBinding
import com.google.firebase.firestore.*
import java.util.ArrayList

class TeamsInfo : Fragment() {

    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsInfoBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: TeamAdapterInfo
    lateinit var teamArrayList:ArrayList<MyTeamsFireBase>



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get (DotaViewModel :: class.java)

        return inflater.inflate(R.layout.fragment_teams_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTeamsInfoBinding.bind(view)
        navController = view.findNavController()

        teamArrayList = arrayListOf()

        myAdapter = TeamAdapterInfo(teamArrayList, this)


        teamArrayList.clear()
        EventChangeListener()












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

                        teamArrayList.add(dc.document.toObject(MyTeamsFireBase::class.java))

                    }
                }

                myAdapter.notifyDataSetChanged()
            }


        })

    }




}


//        binding.teamLogo.setImageResource(viewModel.myTeamsForInfo!!.logo.toInt())
//
//        binding.player1.setImageResource(viewModel.myTeamsForInfo!!.carry_image.toInt())
//        binding.namePlayer1.text = viewModel.myTeamsForInfo?.carry ?:  "Unknown"
//        binding.agePlayer1.text = viewModel.myTeamsForInfo?.carry_year ?:  "Unknown"
//        binding.rolePlayer1.text = viewModel.myTeamsForInfo?.carry_role ?:  "Unknown"
//        binding.earnPlayer1.text = viewModel.myTeamsForInfo?.carry_country ?:  "Unknown"
//
//        binding.player2.setImageResource(viewModel.myTeamsForInfo!!.mid_image.toInt())
//        binding.namePlayer2.text = viewModel.myTeamsForInfo?.mid ?:  "Unknown"
//        binding.agePlayer2.text = viewModel.myTeamsForInfo?.mid_year ?:  "Unknown"
//        binding.rolePlayer2.text = viewModel.myTeamsForInfo?.mid_role ?:  "Unknown"
//        binding.earnPlayer2.text = viewModel.myTeamsForInfo?.mid_country ?:  "Unknown"
//
//        binding.player3.setImageResource(viewModel.myTeamsForInfo!!.offlane_image.toInt())
//        binding.namePlayer3.text = viewModel.myTeamsForInfo?.offlane ?:  "Unknown"
//        binding.agePlayer3.text = viewModel.myTeamsForInfo?.offlane_year ?:  "Unknown"
//        binding.rolePlayer3.text = viewModel.myTeamsForInfo?.offlane_role ?:  "Unknown"
//        binding.earnPlayer3.text = viewModel.myTeamsForInfo?.offlane_country ?:  "Unknown"
//
//        binding.player4.setImageResource(viewModel.myTeamsForInfo!!.semiSupport_image.toInt())
//
//        binding.namePlayer4.text = viewModel.myTeamsForInfo?.semiSupport ?:  "Unknown"
//        binding.agePlayer4.text = viewModel.myTeamsForInfo?.semiSupport_year ?:  "Unknown"
//        binding.rolePlayer4.text = viewModel.myTeamsForInfo?.semiSupport_role ?:  "Unknown"
//        binding.earnPlayer4.text = viewModel.myTeamsForInfo?.semiSupport_country ?:  "Unknown"
//
//
//        binding.player5.setImageResource(viewModel.myTeamsForInfo!!.support_image.toInt())
//        binding.namePlayer5.text = viewModel.myTeamsForInfo?.support ?:  "Unknown"
//        binding.agePlayer5.text = viewModel.myTeamsForInfo?.support_year ?:  "Unknown"
//        binding.rolePlayer5.text = viewModel.myTeamsForInfo?.support_role ?:  "Unknown"
//        binding.earnPlayer5.text = viewModel.myTeamsForInfo?.support_country ?:  "Unknown"
//
//        binding.numTrofeys.text = viewModel.myTeamsForInfo?.trofeys ?: "Unknown"
//        binding.description.text = viewModel.myTeamsForInfo?.description ?: "Unknown"
//        binding.teamFlag.setImageResource(viewModel.myTeamsForInfo!!.team_country_image.toInt())