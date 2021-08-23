package com.example.dota2project.UI.Items

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dota2project.R
import com.example.dota2project.UI.MainActivity
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentItemsBinding


class ItemsFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var viewModel:DotaViewModel
    private lateinit var binding:FragmentItemsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel:: class.java)
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        binding = FragmentItemsBinding.bind(view)

        binding.itemsList.adapter = ItemAdapter(viewModel.itemsLive.value!!, this)
        binding.itemsList.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.itemsLive.value?.clear()
        viewModel.getItems()
        viewModel.getSecondItems()
        viewModel.getThirdItems()
        viewModel.getFourthItems()
        Log.d("!!!Items",viewModel.itemsLive.value!!.toString() )






        viewModel.itemsLive.observe(viewLifecycleOwner, Observer {
            viewModel.itemsLive.value?.sortBy { it.id }
            binding.itemsList.adapter?.notifyDataSetChanged()
        })
    }


}