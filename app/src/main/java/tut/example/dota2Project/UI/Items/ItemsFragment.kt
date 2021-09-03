package tut.example.dota2Project.UI.Items

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Items.Model.Items
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentItemsBinding
import java.util.*


class ItemsFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentItemsBinding
    val items = arrayListOf<Items>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
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
        Log.d("!!!Items", viewModel.itemsLive.value!!.toString())



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                if (newText!!.isNotEmpty()) {
                    viewModel.itemsLive.value?.clear()
                    val search = newText.lowercase(Locale.getDefault())
                    items.forEach {
                        if (it.name.lowercase(Locale.getDefault()).contains(search)) {
                            viewModel.itemsLive.value?.add(it)
                        }
//
                    }
                    binding.itemsList.adapter?.notifyDataSetChanged()
                } else {
                    viewModel.itemsLive.value?.addAll(items)
                    binding.itemsList.adapter?.notifyDataSetChanged()
                }
                return true
            }

        })






        viewModel.itemsLive.observe(viewLifecycleOwner, Observer {
            items.addAll(viewModel.itemsLive.value!!)
            viewModel.itemsLive.value?.sortBy { it.id }
            binding.itemsList.adapter?.notifyDataSetChanged()
        })
    }


}