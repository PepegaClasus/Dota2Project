package com.example.dota2project

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.RemoteModel.MyMajors
import com.example.dota2project.UI.MajorAdapter
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentMajorsBinding
import com.google.firebase.firestore.*
import java.util.ArrayList

class Majors : Fragment() {

    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    private lateinit var binding: FragmentMajorsBinding
    lateinit var db: FirebaseFirestore
    private lateinit var myAdapter: MajorAdapter
    private lateinit var majorArrayList: ArrayList<MyMajors>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_majors, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentMajorsBinding.bind(view)


        binding.majorRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.majorRecyclerView.setHasFixedSize(true)

        majorArrayList = arrayListOf()

        myAdapter = MajorAdapter(majorArrayList)

        binding.majorRecyclerView.adapter = myAdapter
        majorArrayList.clear()
        EventChangeListener()

//        val db = Firebase.firestore
//        db.collection("Majors")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result){
//                    Log.d("TAG", "${document.id} => ${document.data}")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w("TAGEXC", "Error geting document")
//            }

    }

    private fun EventChangeListener() {
        db = FirebaseFirestore.getInstance()

        db.collection("Majors").addSnapshotListener(object : EventListener<QuerySnapshot> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null) {
                    Log.d("error!!!", error.toString())
                    return
                }

                for (dc: DocumentChange in value?.documentChanges!!) {

                    if (dc.type == DocumentChange.Type.ADDED) {
                        Log.d("dcMajor", dc.document.toString())
                        majorArrayList.add(dc.document.toObject(MyMajors::class.java))
                    }
                }

                myAdapter.notifyDataSetChanged()
            }


        })

    }





}