package com.example.dota2project.UI

import android.os.Bundle
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
import com.example.dota2project.RemoteModel.Teams
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsEuropeBinding

class TeamsEurope : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsEuropeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)
        return inflater.inflate(R.layout.fragment_teams_europe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsEuropeBinding.bind(view)
        val utils = Utils()

        binding.recyclerTeamView.adapter = TeamEuropeAdapter(viewModel.teamsLive.value!!, this)
        binding.recyclerTeamView.layoutManager = LinearLayoutManager(activity as MainActivity)

        viewModel.teamsLive.value?.clear()
        viewModel.teamsLive.value?.add(Teams("OG",
            "33,896,610 $",
            7,
            R.drawable.og,
            R.drawable.ogcarry,
            "Sumail  (Syed Sumail Hassan)",
            "\t22 года",
            "Carry",
            "3.5M $",
            R.drawable.ogmid,
            "Topson  (Topics Taavitsainen)",
            "\t23 лет",
            "Mid",
            "5.5M $",
            R.drawable.ogofflane,
            "Ceb  (Sebastien Debs)",
            "\t29 года",
            "Offlane",
            "5.6M $",
            R.drawable.ogsemisup,
            "N0tail  (Johan Sundstein)",
            "27 лет",
            "Support",
            "6.9M $",
            R.drawable.ogsup,
            "Saksa  (Martin Sazdov)",
            "\t26 лет",
            "Support",
            "1.1M $",
            "14",
            utils.OGDescription,
            R.drawable.es))
        viewModel.teamsLive.value?.add(Teams("Secret", "11,601,009 $", 2,
            R.drawable.secret,
            R.drawable.secretcarry,
            "MATUMBAMAN  (Lasse Urpalainen)",
            "\t26 года",
            "Carry",
            "3.8M $",
            R.drawable.secretmid,
            "Nisha  (Michał Jankowski)",
            "20 лет",
            "Mid",
            "1.0M $",
            R.drawable.secretofflane,
            "Zai  (\tLudwig Wåhlberg)",
            "\t23 года",
            "Offlane",
            "2.5M $",
            R.drawable.secretsemisup,
            "Puppey  (Clement Ivanov)",
            "31 год",
            "Support",
            "2.6M $",
            R.drawable.secretsupport,
            "YapzOr  (\tYazied Jaradat)",
            "\t26 лет",
            "Support",
            "1.6M $",
            "14",
            utils.SecretDescription,
            R.drawable.es))
        viewModel.teamsLive.value?.add(Teams("Liquid", "22,949,112 $", 3,
            R.drawable.liquid,
            R.drawable.liquidcarry,
            "miCKe  (Micke Nguyen)",
            "\t21 года",
            "Carry",
            "272K $",
            R.drawable.liquidmid,
            "qojqva  (Max Broecker)",
            "25 лет",
            "Mid",
            "342K $",
            R.drawable.liquidofflane,
            "boxi  (\tSamuel Svahn)",
            "31 год",
            "Offlane",
            "279K $",
            R.drawable.liquidsemisup,
            "iNSaNiA  (Aydin Sarkohi)",
            "27 лет",
            "Support",
            "281K $",
            R.drawable.liquidsupport,
            "Tommy Lea  (Martin Sazdov)",
            "22 года",
            "Support",
            "279K $",
            "14",
            utils.liquidDescription,
            R.drawable.usa))
        viewModel.teamsLive.value?.add(Teams("Vikin.GG", "352,232", 4,
            R.drawable.vikings,
            R.drawable. nothing,
            "Shad  (\tIndji Lub)",
            "\t21 года",
            "Carry",
            "69K $",
            R.drawable.vikingmid,
            "BOOM  (\tMiroslav Bičan)",
            "\t20 лет",
            "Mid",
            "70K $",
            R.drawable.vikingofflane,
            "KheZu  (Maurice Gutmann",
            "\t26 года",
            "Offlane",
            "242K $",
            R.drawable.vikingsemisup,
            "Seleri  (Melchior Hillenkamp)",
            "22 лет",
            "Support",
            "73K $",
            R.drawable.vikingsupport,
            "Aramis  (\tAdam Moroz)",
            "\t21 лет",
            "Support",
            "69K $",
            "14",
            utils.VikingDescription,
            R.drawable.es))
        viewModel.teamsLive.value?.add(Teams("Team Nigma",
            "586,614 $",
            8,
            R.drawable.nigma,
            R.drawable.nigmacarry,
            "iLTW  (Igor Filatov)",
            "\t21 года",
            "Carry",
            "287K $",
            R.drawable.nigmamid,
            "Miracle-  (Amer Al-barqawi)",
            "\t24 лет",
            "Mid",
            "4.8M $",
            R.drawable.nigmaofflane,
            "MinD_ContRoL  (\tIvan Borislavov)",
            "\t26 года",
            "Offlane",
            "4.6M $",
            R.drawable.nigmasemisup,
            "KuroKy  (\tKuro Salehi Takhasomi)",
            "28 лет",
            "Support",
            "5.1M $",
            R.drawable.nigmagh,
            "GH  (\tMaroun Merhej)",
            "\t26 лет",
            "Support",
            "4.2M $",
            "0",
            utils.NigmaDescription,
            R.drawable.es))
        viewModel.teamsLive.value?.add(Teams("Alliance",
            "4,943,855 $",
            10,
            R.drawable.aliiance,
            R.drawable.alliancecarry,
            "Nikobaby (\tNikolay Nikolov)",
            "-",
            "Carry",
            "278K $",
            R.drawable.alliancemid,
            "Limmp  (Linus Blomdin)",
            "\t26 лет",
            "Mid",
            "341K $",
            R.drawable.allianceofflane,
            "s4  (Gustav Magnusson)",
            "\t29 лет",
            "Offlane",
            "2.5M $",
            R.drawable.alliancesemisup,
            "Fng  (Artem Barshack)",
            "25  лет",
            "Support",
            "592K $",
            R.drawable.alliancesupport,
            "Handsken  (Simon Haag)",
            "27 лет",
            "Support",
            "313K $",
            "4",
            utils.AllianceDescription,
            R.drawable.sweden))


        binding.bottomTeamNavigation.setOnNavigationItemSelectedListener { item ->
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
                R.id.ChinaTeams -> {
                    navController.navigate(R.id.teamsChina)
                    true
                }
                else -> false
            }

        }
        viewModel.heroesLive.observe(viewLifecycleOwner, Observer {
            binding.recyclerTeamView.adapter?.notifyDataSetChanged()
        })
    }


    fun showTeamInfo(position: Int) {
        viewModel.teamsForInfo = viewModel.teamsLive.value?.get(position)
        navController.navigate(R.id.teamsInfo)
    }


}