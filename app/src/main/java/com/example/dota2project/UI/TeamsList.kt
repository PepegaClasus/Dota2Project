package com.example.dota2project.UI

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
import com.example.dota2project.RemoteModel.Teams
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.databinding.FragmentTeamsBinding

class TeamsList : Fragment() {
    lateinit var viewModel: DotaViewModel
    lateinit var navController: NavController
    private lateinit var binding: FragmentTeamsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(activity as MainActivity).get(DotaViewModel::class.java)



        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding = FragmentTeamsBinding.bind(view)

        val utils = Utils()


        binding.recyclerTeamView.adapter = TeamAdapter(viewModel.teamsLive.value!!, this)
        binding.recyclerTeamView.layoutManager = LinearLayoutManager(activity as MainActivity)
//        recyclerTeamView.adapter = TeamAdapter(viewModel.teamsLive.value!!, this)
//        recyclerTeamView.layoutManager = LinearLayoutManager(activity as MainActivity)

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


        viewModel.teamsLive.value!!.clear()
        viewModel.teamsLive.value?.add(Teams("PSG LGD",
            "16,804,107 $",
            1,
            R.drawable.psglgd,
            R.drawable.psgcarry,
            "Ame  (Wang Chunyu)",
            "24 года",
            "Carry",
            "2,348,768",
            R.drawable.psgmid,
            "NothingToSay  (Cheng Jin Xiang)",
            "20 лет",
            "Mid",
            "135 000 $",
            R.drawable.psgofflane,
            "Faith_bian  (Zhang Ruida)",
            "23 года",
            "Offlane",
            "2,163,078",
            R.drawable.psgsemisup,
            "XinQ  (Zhao Zixing)",
            "23 года",
            "Support",
            "260,046 $",
            R.drawable.psgsupport,
            " y`  (Zhang Yiping)",
            "22 года",
            "Support",
            "2,168,578 $",
            "11",
            utils.PSGDescription,
            R.drawable.china
        ))
        viewModel.teamsLive.value?.add(Teams("Vici Gaming",
            "8,940,105 $",
            2,
            R.drawable.vicigaming,
            R.drawable.vicicarry,
            "poyoyo  (Yang Shaohan)",
            "-",
            "Carry",
            "48,104$",
            R.drawable.vicimid,
            "Ori  (Zeng Jiaoyang)",
            "25 лет",
            "Mid",
            "869,873 $",
            R.drawable.viciofflane,
            "eLeVeN  (Ren Yangwei)",
            "25 лет",
            "Offlane",
            "1,238,580 $",
            R.drawable.vicisemisup,
            "XinQ  (Zhao Zixing)",
            "23 года",
            "Support",
            "260,046 $",
            R.drawable.vicisup,
            "Pyw  (Xiong Jiahan)",
            "-",
            "Support",
            "251,352 $",
            "9",
            utils.ViciDescription,
            R.drawable.china))
        viewModel.teamsLive.value?.add(Teams("Evil Geniuses",
            "20,269,655 $",
            3,
            R.drawable.eg,
            R.drawable.egcarry,
            "Arteezy  (\tArtour Babaev)",
            "\t25 лет",
            "Carry",
            "2,207,124 $",
            R.drawable.egmid,
            "Abed  (\tAbed Yusop)",
            "20 лет",
            "Mid",
            "503,565 $",
            R.drawable.egofflane,
            "iceiceice  (\tDaryl Koh Pei Xiang)",
            "\t31 год",
            "Offlane",
            "1,491,285 $",
            R.drawable.egsemisup,
            "Cr1t  (\tAndreas Franck Nielsen)",
            "\t25 лет",
            "Support",
            "2,014,985 $",
            R.drawable.egsupport,
            "Fly  (\tTal Aizik)",
            "\t28 лет",
            "Support",
            "2,408,964 $",
            "12",
            utils.EGDescription,
            R.drawable.usa))
        viewModel.teamsLive.value?.add(Teams("Virtus Pro",
            "9,958,499 $",
            4,
            R.drawable.virtuspro,
            R.drawable.vpcarry,
            "Nightfall  (Egor Grigorenko)",
            "19 лет",
            "Carry",
            "127,764 $",
            R.drawable.vpmid,
            "gpk~  (Danil Skutin)",
            "19 лет",
            "Mid",
            "145,764 $",
            R.drawable.vpofflane,
            "DM  (Dmitrii Dorokhin)",
            "21 год",
            "Offlane",
            "137,314 $",
            R.drawable.vpsemisup,
            "Kingslayer  (Ilyas Ganeev)",
            "19 лет",
            "Support",
            "86,400 $",
            R.drawable.vpsupport,
            "Save-  (Vitalij Mel'nik)",
            "17 лет",
            "Support",
            "127,764 $",
            "8",
            utils.VPDescription,
            R.drawable.cis))
        viewModel.teamsLive.value?.add(Teams("Invictus Gaming",
            "5,689,828 $",
            5,
            R.drawable.invictus,
            R.drawable.igcarry,
            "flyfly  (\tJin Zhiyi)",
            "\t24 года",
            "Carry",
            "245,340 $",
            R.drawable.igmid,
            "Emo  (\tZhou Yi)",
            "\t20 лет",
            "Mid",
            "172,350 $",
            R.drawable.igofflane,
            "JT-  (\tThiay Jun Wen)",
            "\t23 года",
            "Offlane",
            "182,884 $",
            R.drawable.igsemisup,
            "kaka  (Hu Liangzhi)",
            "28 лет",
            "Support",
            "1,834,613 $",
            R.drawable.igsupport,
            "Oli  (\tChan Chon Kien)",
            "\t25 лет",
            "Support",
            "187,094 $",
            "4",
            utils.IGDescription,
            R.drawable.china))
        viewModel.teamsLive.value?.add(Teams("Thunder Predator",
            "232,415 $",
            6,
            R.drawable.thunder,
            R.drawable.thundercarry,
            "MNZ  (\tAlonso Loewe)",
            "\t24 года",
            "Carry",
            "102,281 $",
            R.drawable.thundermid,
            "Leostyle-  (Leonardo David Sifuentes Garcia)",
            "\t26 лет",
            "Mid",
            "54,235 $",
            R.drawable.thunderofflane,
            "Frank  (\tFrank Arias)",
            "\t23 года",
            "Offlane",
            "33,802 $",
            R.drawable.thundersemisup,
            "Mjz  (Romel Quinteros)",
            "20 лет",
            "Support",
            "45,467 $",
            R.drawable.thundersupport,
            "MoOz  (Joel Mori Ozambela)",
            "-",
            "Support",
            "54,627 $",
            "0",
            utils.ThunderDescription,
            R.drawable.china))
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
        viewModel.teamsLive.value?.add(Teams("Team Aster",
            "388,924 $",
            9,
            R.drawable.aster,
            R.drawable.astercarry,
            "Monet (Du Peng)",
            "\t21 года",
            "Carry",
            "865K $",
            R.drawable.astermid,
            "DD斩首  (Liu Yuhao)",
            "\t26 лет",
            "Mid",
            "56K $",
            R.drawable.asterofflane,
            "Xxs  (Lin Jing)",
            "\t21 года",
            "Offlane",
            "498K $",
            R.drawable.astersemisup,
            "LaNm  (Zhang Zhicheng)",
            "30 лет",
            "Support",
            "1.3M $",
            R.drawable.astersupport,
            "Borax  (\tYe Zhibiao)",
            "\t24 лет",
            "Support",
            "498K $",
            "4",
            utils.AsterDescription,
            R.drawable.china))
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

        viewModel.teamsLive.observe(viewLifecycleOwner, Observer {

            Log.d("!!!", it.toString())

            binding.recyclerTeamView.adapter?.notifyDataSetChanged()
        })


    }

    fun showTeamInfo(position: Int) {
        viewModel.teamsForInfo = viewModel.teamsLive.value?.get(position)
        navController.navigate(R.id.teamsInfo)
    }


}