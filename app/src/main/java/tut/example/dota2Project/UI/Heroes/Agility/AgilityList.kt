package tut.example.dota2Project.UI.Heroes.Agility

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
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.MainActivity
import tut.example.dota2Project.ViewModel.DotaViewModel
import tut.example.dota2Project.databinding.FragmentAgilityListBinding

class AgilityList : Fragment() {
    lateinit var navController: NavController
    val viewModel: DotaViewModel by activityViewModels()
    private lateinit var binding: FragmentAgilityListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agility_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentAgilityListBinding.bind(view)

        binding.recyclerAgilityView.adapter = AgilityAdapter(viewModel.heroesLive.value!!, this)
        binding.recyclerAgilityView.layoutManager = LinearLayoutManager(activity as MainActivity)
        viewModel.getHeroes()
        viewModel.heroesLive.value?.clear()


        binding.bottomAgiNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_heroesList -> {
                    navController.navigate(R.id.heroesList)
                    true
                }
                R.id.menu_strength -> {
                    navController.navigate(R.id.strengthList)
                    true
                }
                R.id.menu_agility -> {
                    navController.navigate(R.id.agility_list)
                    true
                }
                R.id.menu_intelligence -> {
                    navController.navigate(R.id.int_list)
                    true
                }
                else -> false
            }
        }

        viewModel.heroesLive.observe(viewLifecycleOwner, Observer {
            viewModel.heroesLive.value!!.sortBy { it.localized_name }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("int") }
            viewModel.heroesLive.value!!.removeIf { it.primary_attr.contains("str") }
            binding.recyclerAgilityView.adapter?.notifyDataSetChanged()
        })
    }

    fun showHero(position:Int){
        viewModel.hero_id = viewModel.heroesLive.value?.get(position)?.id!!
        navController.navigate(R.id.heroMatchupFragment)
    }


}