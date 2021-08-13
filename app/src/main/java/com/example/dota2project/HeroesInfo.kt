package com.example.dota2project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel


class HeroesInfo : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel:: class.java)
        return inflater.inflate(R.layout.fragment_heroes_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()



    }


}