package com.example.dota2project.UI.Players.ProPlayers.Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dota2project.R
import com.example.dota2project.UI.Matches.RecentMatches
import com.example.dota2project.UI.Players.ProPlayers.PlayerInfo
import kotlinx.android.synthetic.main.recent_matches_item.view.*

class PlayerInfoAdapter(val list: List<RecentMatches>, val fragment: PlayerInfo) :
    RecyclerView.Adapter<PlayerInfoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var game_mode: TextView? = null
        var time_match: TextView? = null
        var kills: TextView? = null
        var death: TextView? = null
        var assists: TextView? = null
        var hero_image: ImageView? = null

        init {
            game_mode = itemView.findViewById(R.id.game_mode)
            time_match = itemView.findViewById(R.id.time)
            kills = itemView.findViewById(R.id.kills)
            death = itemView.findViewById(R.id.death)
            assists = itemView.findViewById(R.id.assists)
            hero_image = itemView.findViewById(R.id.hero_image)

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlayerInfoAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.recent_matches_item, parent, false)
        val holder = ViewHolder(itemView)
        return holder
    }

    override fun onBindViewHolder(holder: PlayerInfoAdapter.ViewHolder, position: Int) {
        val matches: RecentMatches = list[position]
        holder.kills?.text = list[position].kills.toString()
        holder.death?.text = list[position].deaths.toString()
        holder.assists?.text = list[position].assists.toString()


        var time = list[position].duration
        val minutes = time / 60
        time %= 60
        val seconds = time
        if (seconds >= 10) {
            val timeString = "$minutes:$seconds"
            holder.time_match?.text = timeString
        } else {
            val timeString = "$minutes:0$seconds"
            holder.time_match?.text = timeString
        }

        holder.itemView.setOnClickListener {
            fragment.showMatchDetails(holder.adapterPosition)
        }



        when (matches.hero_id) {
            1 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/antimage_full.png?")
                .into(holder.itemView.hero_matches_image)
            2 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/axe_full.png?")
                .into(holder.itemView.hero_matches_image)
            3 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bane_full.png?")
                .into(holder.itemView.hero_matches_image)
            4 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bloodseeker_full.png?")
                .into(holder.itemView.hero_matches_image)
            5 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/crystal_maiden_full.png?")
                .into(holder.itemView.hero_matches_image)
            6 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/drow_ranger_full.png?")
                .into(holder.itemView.hero_matches_image)
            7 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/earthshaker_full.png?")
                .into(holder.itemView.hero_matches_image)
            8 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/juggernaut_full.png?")
                .into(holder.itemView.hero_matches_image)
            9 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/mirana_full.png?")
                .into(holder.itemView.hero_matches_image)
            10 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/morphling_full.png?")
                .into(holder.itemView.hero_matches_image)
            11 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/nevermore_full.png?")
                .into(holder.itemView.hero_matches_image)
            12 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phantom_lancer_full.png?")
                .into(holder.itemView.hero_matches_image)
            13 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/puck_full.png?")
                .into(holder.itemView.hero_matches_image)
            14 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/pudge _full.png?")
                .into(holder.itemView.hero_matches_image)
            15 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/razor_full.png?")
                .into(holder.itemView.hero_matches_image)
            16 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sand_king_full.png?")
                .into(holder.itemView.hero_matches_image)
            17 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/storm_spirit_full.png?")
                .into(holder.itemView.hero_matches_image)
            18 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sven_full.png?")
                .into(holder.itemView.hero_matches_image)
            19 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tiny_full.png?")
                .into(holder.itemView.hero_matches_image)
            20 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/vengefulspirit_full.png?")
                .into(holder.itemView.hero_matches_image)
            21 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/windrunner_full.png?")
                .into(holder.itemView.hero_matches_image)
            22 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/zuus_full.png?")
                .into(holder.itemView.hero_matches_image)
            23 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/kunkka_full.png?")
                .into(holder.itemView.hero_matches_image)
            25 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lina_full.png?")
                .into(holder.itemView.hero_matches_image)
            26 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lion_full.png?")
                .into(holder.itemView.hero_matches_image)
            27 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shadow_shaman_full.png?")
                .into(holder.itemView.hero_matches_image)
            28 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/slardar_full.png?")
                .into(holder.itemView.hero_matches_image)
            29 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tidehunter_full.png?")
                .into(holder.itemView.hero_matches_image)
            30 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/witch_doctor_full.png?")
                .into(holder.itemView.hero_matches_image)
            31 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lich_full.png?")
                .into(holder.itemView.hero_matches_image)
            32 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/riki_full.png?")
                .into(holder.itemView.hero_matches_image)
            33 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/enigma_full.png?")
                .into(holder.itemView.hero_matches_image)
            34 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tinker_full.png?")
                .into(holder.itemView.hero_matches_image)
            35 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sniper_full.png?")
                .into(holder.itemView.hero_matches_image)
            36 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/necrolyte_full.png?")
                .into(holder.itemView.hero_matches_image)
            37 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/warlock_full.png?")
                .into(holder.itemView.hero_matches_image)
            38 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/beastmaster_full.png?")
                .into(holder.itemView.hero_matches_image)
            39 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/queenofpain_full.png?")
                .into(holder.itemView.hero_matches_image)
            40 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/venomancer_full.png?")
                .into(holder.itemView.hero_matches_image)
            41 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/faceless_void_full.png?")
                .into(holder.itemView.hero_matches_image)
            42 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/skeleton_king_full.png?")
                .into(holder.itemView.hero_matches_image)
            43 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/death_prophet_full.png?")
                .into(holder.itemView.hero_matches_image)
            44 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phantom_assassin_full.png?")
                .into(holder.itemView.hero_matches_image)
            45 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/pugna_full.png?")
                .into(holder.itemView.hero_matches_image)
            46 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/templar_assassin_full.png?")
                .into(holder.itemView.hero_matches_image)
            47 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/viper_full.png?")
                .into(holder.itemView.hero_matches_image)
            48 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/luna_full.png?")
                .into(holder.itemView.hero_matches_image)
            49 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dragon_knight_full.png?")
                .into(holder.itemView.hero_matches_image)

            50 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dazzle_full.png?")
                .into(holder.itemView.hero_matches_image)
            51 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/rattletrap_full.png?")
                .into(holder.itemView.hero_matches_image)
            52 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/leshrac_full.png?")
                .into(holder.itemView.hero_matches_image)
            53 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/furion_full.png?")
                .into(holder.itemView.hero_matches_image)
            54 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/life_stealer_full.png?")
                .into(holder.itemView.hero_matches_image)
            55 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dark_seer_full.png?")
                .into(holder.itemView.hero_matches_image)
            56 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/clinkz_full.png?")
                .into(holder.itemView.hero_matches_image)
            57 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/omniknight_full.png?")
                .into(holder.itemView.hero_matches_image)
            58 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/enchantress_full.png?")
                .into(holder.itemView.hero_matches_image)
            59 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/huskar_full.png?")
                .into(holder.itemView.hero_matches_image)
            60 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/night_stalker_full.png?")
                .into(holder.itemView.hero_matches_image)
            61 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/broodmother_full.png?")
                .into(holder.itemView.hero_matches_image)
            62 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bounty_hunter_full.png?")
                .into(holder.itemView.hero_matches_image)
            63 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/weaver_full.png?")
                .into(holder.itemView.hero_matches_image)
            64 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/jakiro_full.png?")
                .into(holder.itemView.hero_matches_image)
            65 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/batrider_full.png?")
                .into(holder.itemView.hero_matches_image)
            66 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/chen_full.png?")
                .into(holder.itemView.hero_matches_image)
            67 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/spectre_full.png?")
                .into(holder.itemView.hero_matches_image)
            68 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ancient_apparition_full.png?")
                .into(holder.itemView.hero_matches_image)
            69 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/doom_bringer_full.png?")
                .into(holder.itemView.hero_matches_image)
            70 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ursa_full.png?")
                .into(holder.itemView.hero_matches_image)
            71 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/spirit_breaker_full.png?")
                .into(holder.itemView.hero_matches_image)
            72 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/gyrocopter_full.png?")
                .into(holder.itemView.hero_matches_image)
            73 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/alchemist_full.png?")
                .into(holder.itemView.hero_matches_image)
            74 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/invoker_full.png?")
                .into(holder.itemView.hero_matches_image)
            75 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/silencer_full.png?")
                .into(holder.itemView.hero_matches_image)
            76 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/obsidian_destroyer_full.png?")
                .into(holder.itemView.hero_matches_image)
            77 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lycan_full.png?")
                .into(holder.itemView.hero_matches_image)
            78 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/brewmaster_full.png?")
                .into(holder.itemView.hero_matches_image)
            79 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shadow_demon_full.png?")
                .into(holder.itemView.hero_matches_image)
            80 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lone_druid_full.png?")
                .into(holder.itemView.hero_matches_image)
            81 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/chaos_knight_full.png?")
                .into(holder.itemView.hero_matches_image)
            82 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/meepo_full.png?")
                .into(holder.itemView.hero_matches_image)
            83 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/treant_full.png?")
                .into(holder.itemView.hero_matches_image)
            84 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ogre_magi_full.png?")
                .into(holder.itemView.hero_matches_image)
            85 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/undying_full.png?")
                .into(holder.itemView.hero_matches_image)
            86 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/rubick_full.png?")
                .into(holder.itemView.hero_matches_image)
            87 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/disruptor_full.png?")
                .into(holder.itemView.hero_matches_image)
            88 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/nyx_assassin_full.png?")
                .into(holder.itemView.hero_matches_image)
            89 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/naga_siren_full.png?")
                .into(holder.itemView.hero_matches_image)
            90 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/keeper_of_the_light_full.png?")
                .into(holder.itemView.hero_matches_image)
            91 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/wisp_full.png?")
                .into(holder.itemView.hero_matches_image)
            92 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/visage_full.png?")
                .into(holder.itemView.hero_matches_image)
            93 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/slark_full.png?")
                .into(holder.itemView.hero_matches_image)
            94 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/medusa_full.png?")
                .into(holder.itemView.hero_matches_image)
            95 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/troll_warlord_full.png?")
                .into(holder.itemView.hero_matches_image)
            96 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/centaur_full.png?")
                .into(holder.itemView.hero_matches_image)
            97 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/magnataur_full.png?")
                .into(holder.itemView.hero_matches_image)

            98 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shredder_full.png?")
                .into(holder.itemView.hero_matches_image)
            99 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bristleback_full.png?")
                .into(holder.itemView.hero_matches_image)
            100 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tusk_full.png?")
                .into(holder.itemView.hero_matches_image)
            101 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/skywrath_mage_full.png?")
                .into(holder.itemView.hero_matches_image)
            102 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/abaddon_full.png?")
                .into(holder.itemView.hero_matches_image)
            103 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/elder_titan_full.png?")
                .into(holder.itemView.hero_matches_image)
            104 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/legion_commander_full.png?")
                .into(holder.itemView.hero_matches_image)
            105 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/techies_full.png?")
                .into(holder.itemView.hero_matches_image)
            106 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ember_spirit_full.png?")
                .into(holder.itemView.hero_matches_image)
            107 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/earth_spirit_full.png?")
                .into(holder.itemView.hero_matches_image)
            108 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/abyssal_underlord_full.png?")
                .into(holder.itemView.hero_matches_image)
            109 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/terrorblade_full.png?")
                .into(holder.itemView.hero_matches_image)
            110 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phoenix_full.png?")
                .into(holder.itemView.hero_matches_image)
            111 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/oracle_full.png?")
                .into(holder.itemView.hero_matches_image)
            112 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/winter_wyvern_full.png?")
                .into(holder.itemView.hero_matches_image)
            113 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/arc_warden_full.png?")
                .into(holder.itemView.hero_matches_image)
            114 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/monkey_king_full.png?")
                .into(holder.itemView.hero_matches_image)

            119 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dark_willow_full.png?")
                .into(holder.itemView.hero_matches_image)
            120 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/pangolier_full.png?")
                .into(holder.itemView.hero_matches_image)
            121 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/grimstroke_full.png?")
                .into(holder.itemView.hero_matches_image)
            123 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/hoodwink_full.png?")
                .into(holder.itemView.hero_matches_image)
            128 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/snapfire_full.png?")
                .into(holder.itemView.hero_matches_image)
            129 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/mars_full.png?")
                .into(holder.itemView.hero_matches_image)
            135 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dawnbreaker_full.png?")
                .into(holder.itemView.hero_matches_image)
        }


        val gameMode = list[position].game_mode
        when (gameMode) {
            0 -> holder.game_mode?.text = "Unknown"
            1 -> holder.game_mode?.text = "All Pick"
            2 -> holder.game_mode?.text = "Captains Mode"
            3 -> holder.game_mode?.text = "Random Draft"
            4 -> holder.game_mode?.text = "Single Draft"
            5 -> holder.game_mode?.text = "All Random"
            6 -> holder.game_mode?.text = "Intro"
            7 -> holder.game_mode?.text = "Diretide"
            8 -> holder.game_mode?.text = "Reverse CM"
            9 -> holder.game_mode?.text = "Greeviling"
            10 -> holder.game_mode?.text = "Tutorial"
            11 -> holder.game_mode?.text = "Mid Only"
            12 -> holder.game_mode?.text = "Least Played"
            13 -> holder.game_mode?.text = "Limited Heroes"
            14 -> holder.game_mode?.text = "Compendium Match"
            15 -> holder.game_mode?.text = "Custom"
            16 -> holder.game_mode?.text = "Captains Draft"
            17 -> holder.game_mode?.text = "Balanced Draft"
            18 -> holder.game_mode?.text = "Ability Draft"
            19 -> holder.game_mode?.text = "Event"
            20 -> holder.game_mode?.text = "AR DeathMatch"
            21 -> holder.game_mode?.text = "1vs1 Mid"
            22 -> holder.game_mode?.text = "All Pick"
            23 -> holder.game_mode?.text = "Turbo"
            24 -> holder.game_mode?.text = "Mutation"

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}