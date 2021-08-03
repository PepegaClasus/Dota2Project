package com.example.dota2project

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.dota2project.RemoteModel.ApiService
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import kotlinx.android.synthetic.main.fragment_player_id_info.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.NumberFormatException

class PlayerIdInfo : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    val apiService = ApiService.create()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel :: class.java)
        return inflater.inflate(R.layout.fragment_player_id_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()






        button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    val value = editText.text.toString()
                    val play = apiService.getPlayers(Integer.parseInt(value))
                    Log.d("!!!play", play.toString())
                    tv_info_player.text = play.toString()
                }catch (e: NumberFormatException){

                }


            }
        }



    }


}