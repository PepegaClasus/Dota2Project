package tut.example.dota2Project.UI.Players.FindPlayers

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
import kotlinx.coroutines.launch
import tut.example.dota2Project.R
import tut.example.dota2Project.RemoteModel.ApiService
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.UI.Players.FindPlayers.Model.PlayersSearch
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentFindPlayersBinding


class FindPlayersFragment : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentFindPlayersBinding
    val apiService = ApiService.create()
    val list: PlayersSearch? = null
    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_find_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentFindPlayersBinding.bind(view)



        binding.listPlayers.adapter = FindPlayersAdapter(viewModel.playersLive.value!!, this)
        binding.listPlayers.layoutManager = LinearLayoutManager(activity as MainActivity)





        binding.btnSearch.setOnClickListener { it ->

            scope.launch {


                viewModel.playersLive.value?.clear()
                val playerSearch = apiService.getPlayers(binding.etFind.text.toString())
                viewModel.playersLive.value?.addAll(playerSearch)

                binding.listPlayers.adapter?.notifyDataSetChanged()
            }



        }




        binding.bottomPlayersNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.pro_player -> {
                    navController.navigate(R.id.proPlayersFragment)
                    true
                }
                R.id.players -> {
                    navController.navigate(R.id.findPlayersFragment)
                    true
                }
                else ->true
            }
        }





        viewModel.playersLive.observe(viewLifecycleOwner, Observer {


            viewModel.playersLive.value?.sortBy { it.similarity }
            binding.listPlayers.adapter?.notifyDataSetChanged()
        })


    }

    fun showPlayerInfo(position: Int) {
        viewModel.player_id = viewModel.playersLive.value?.get(position)?.account_id!!
        navController.navigate(R.id.playerInfo)
    }


}