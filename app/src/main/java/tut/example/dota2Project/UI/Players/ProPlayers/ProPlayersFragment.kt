package tut.example.dota2Project.UI.Players.ProPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import tut.example.dota2Project.R
import tut.example.dota2Project.RemoteModel.ApiService
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.UI.Players.ProPlayers.Model.ProPlayers
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentProPlayersBinding

class ProPlayersFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentProPlayersBinding
    val proPlayers = mutableListOf<ProPlayers>()
    val scope = CoroutineScope(Dispatchers.Main)
    val apiService = ApiService.create()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pro_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProPlayersBinding.bind(view)
        navController = view.findNavController()

        binding.listProPlayers.adapter = ProPlayerAdapter(viewModel.proPlayersLive.value!!, this)
        binding.listProPlayers.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.proPlayersLive.value?.clear()


        viewModel.getProPlayers()



        binding.bottomProPlayersNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pro_player -> {
                    navController.navigate(R.id.proPlayersFragment)
                    true
                }
                R.id.players -> {
                    navController.navigate(R.id.findPlayersFragment)
                    true
                }
                else -> true
            }
        }


//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//
//                if (newText!!.isNotEmpty()) {
//                    viewModel.proPlayersLive.value?.clear()
//                    val search = newText.lowercase(Locale.getDefault())
//                    proPlayers.forEach {
//                        if (it.personaname.lowercase(Locale.getDefault()).contains(search)) {
//                            viewModel.proPlayersLive.value?.add(it)
//                        }
////                        else if (it.team_name?.lowercase(Locale.getDefault())!!.contains(search)){
////                            viewModel.proPlayersLive.value?.addAll(listOf(it))
////                        }
//                    }
//                    binding.listProPlayers.adapter?.notifyDataSetChanged()
//                } else {
//                    viewModel.proPlayersLive.value?.addAll(proPlayers)
//                    binding.listProPlayers.adapter?.notifyDataSetChanged()
//                }
//                return true
//            }
//
//        })


        viewModel.proPlayersLive.observe(viewLifecycleOwner, Observer {

            binding.listProPlayers.adapter?.notifyDataSetChanged()


        })
    }

    fun proPlayerInfo(position: Int) {
        viewModel.player_id = viewModel.proPlayersLive.value?.get(position)?.account_id!!
        navController.navigate(R.id.playerInfo)
    }


}