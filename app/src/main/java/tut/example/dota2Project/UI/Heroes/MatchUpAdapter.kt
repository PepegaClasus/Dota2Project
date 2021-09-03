package tut.example.dota2Project.UI.Heroes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.matchup_item.view.*
import tut.example.dota2Project.R

class MatchUpAdapter(val list: MutableList<MatchUps>, val fragment: HeroMatchupFragment) :
    RecyclerView.Adapter<MatchUpAdapter.ViewHolder>() {
        class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            var hero_image:ImageView? = null
            var wins: TextView? = null
            var games:TextView? = null
            init {
                hero_image = itemView.findViewById(R.id.hero_image_matchup)
                wins = itemView.findViewById(R.id.hero_matchup_wins)
                games = itemView.findViewById(R.id.hero_games_played)
            }
            
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.matchup_item, parent, false)
        val holder = ViewHolder(itemView)
        
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val matchups:MatchUps = list[position]
        
        holder.games?.text = list[position].games_played.toString()
        holder.wins?.text = list[position].wins.toString()
        
        when (matchups.hero_id) {
            1 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/antimage_full.png?")
                .into(holder.itemView.hero_image_matchup)
            2 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/axe_full.png?")
                .into(holder.itemView.hero_image_matchup)
            3 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bane_full.png?")
                .into(holder.itemView.hero_image_matchup)
            4 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bloodseeker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            5 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/crystal_maiden_full.png?")
                .into(holder.itemView.hero_image_matchup)
            6 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/drow_ranger_full.png?")
                .into(holder.itemView.hero_image_matchup)
            7 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/earthshaker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            8 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/juggernaut_full.png?")
                .into(holder.itemView.hero_image_matchup)
            9 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/mirana_full.png?")
                .into(holder.itemView.hero_image_matchup)
            10 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/morphling_full.png?")
                .into(holder.itemView.hero_image_matchup)
            11 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/nevermore_full.png?")
                .into(holder.itemView.hero_image_matchup)
            12 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phantom_lancer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            13 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/puck_full.png?")
                .into(holder.itemView.hero_image_matchup)
            14 -> Glide.with(holder.itemView)
                .load("https://cdn.dota2.com/apps/dota2/images/heroes/pudge_full.png?")
                .into(holder.itemView.hero_image_matchup)
            15 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/razor_full.png?")
                .into(holder.itemView.hero_image_matchup)
            16 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sand_king_full.png?")
                .into(holder.itemView.hero_image_matchup)
            17 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/storm_spirit_full.png?")
                .into(holder.itemView.hero_image_matchup)
            18 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sven_full.png?")
                .into(holder.itemView.hero_image_matchup)
            19 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tiny_full.png?")
                .into(holder.itemView.hero_image_matchup)
            20 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/vengefulspirit_full.png?")
                .into(holder.itemView.hero_image_matchup)
            21 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/windrunner_full.png?")
                .into(holder.itemView.hero_image_matchup)
            22 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/zuus_full.png?")
                .into(holder.itemView.hero_image_matchup)
            23 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/kunkka_full.png?")
                .into(holder.itemView.hero_image_matchup)
            25 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lina_full.png?")
                .into(holder.itemView.hero_image_matchup)
            26 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lion_full.png?")
                .into(holder.itemView.hero_image_matchup)
            27 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shadow_shaman_full.png?")
                .into(holder.itemView.hero_image_matchup)
            28 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/slardar_full.png?")
                .into(holder.itemView.hero_image_matchup)
            29 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tidehunter_full.png?")
                .into(holder.itemView.hero_image_matchup)
            30 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/witch_doctor_full.png?")
                .into(holder.itemView.hero_image_matchup)
            31 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lich_full.png?")
                .into(holder.itemView.hero_image_matchup)
            32 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/riki_full.png?")
                .into(holder.itemView.hero_image_matchup)
            33 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/enigma_full.png?")
                .into(holder.itemView.hero_image_matchup)
            34 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tinker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            35 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/sniper_full.png?")
                .into(holder.itemView.hero_image_matchup)
            36 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/necrolyte_full.png?")
                .into(holder.itemView.hero_image_matchup)
            37 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/warlock_full.png?")
                .into(holder.itemView.hero_image_matchup)
            38 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/beastmaster_full.png?")
                .into(holder.itemView.hero_image_matchup)
            39 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/queenofpain_full.png?")
                .into(holder.itemView.hero_image_matchup)
            40 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/venomancer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            41 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/faceless_void_full.png?")
                .into(holder.itemView.hero_image_matchup)
            42 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/skeleton_king_full.png?")
                .into(holder.itemView.hero_image_matchup)
            43 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/death_prophet_full.png?")
                .into(holder.itemView.hero_image_matchup)
            44 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phantom_assassin_full.png?")
                .into(holder.itemView.hero_image_matchup)
            45 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/pugna_full.png?")
                .into(holder.itemView.hero_image_matchup)
            46 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/templar_assassin_full.png?")
                .into(holder.itemView.hero_image_matchup)
            47 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/viper_full.png?")
                .into(holder.itemView.hero_image_matchup)
            48 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/luna_full.png?")
                .into(holder.itemView.hero_image_matchup)
            49 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dragon_knight_full.png?")
                .into(holder.itemView.hero_image_matchup)

            50 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dazzle_full.png?")
                .into(holder.itemView.hero_image_matchup)
            51 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/rattletrap_full.png?")
                .into(holder.itemView.hero_image_matchup)
            52 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/leshrac_full.png?")
                .into(holder.itemView.hero_image_matchup)
            53 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/furion_full.png?")
                .into(holder.itemView.hero_image_matchup)
            54 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/life_stealer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            55 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dark_seer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            56 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/clinkz_full.png?")
                .into(holder.itemView.hero_image_matchup)
            57 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/omniknight_full.png?")
                .into(holder.itemView.hero_image_matchup)
            58 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/enchantress_full.png?")
                .into(holder.itemView.hero_image_matchup)
            59 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/huskar_full.png?")
                .into(holder.itemView.hero_image_matchup)
            60 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/night_stalker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            61 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/broodmother_full.png?")
                .into(holder.itemView.hero_image_matchup)
            62 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bounty_hunter_full.png?")
                .into(holder.itemView.hero_image_matchup)
            63 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/weaver_full.png?")
                .into(holder.itemView.hero_image_matchup)
            64 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/jakiro_full.png?")
                .into(holder.itemView.hero_image_matchup)
            65 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/batrider_full.png?")
                .into(holder.itemView.hero_image_matchup)
            66 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/chen_full.png?")
                .into(holder.itemView.hero_image_matchup)
            67 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/spectre_full.png?")
                .into(holder.itemView.hero_image_matchup)
            68 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ancient_apparition_full.png?")
                .into(holder.itemView.hero_image_matchup)
            69 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/doom_bringer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            70 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ursa_full.png?")
                .into(holder.itemView.hero_image_matchup)
            71 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/spirit_breaker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            72 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/gyrocopter_full.png?")
                .into(holder.itemView.hero_image_matchup)
            73 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/alchemist_full.png?")
                .into(holder.itemView.hero_image_matchup)
            74 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/invoker_full.png?")
                .into(holder.itemView.hero_image_matchup)
            75 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/silencer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            76 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/obsidian_destroyer_full.png?")
                .into(holder.itemView.hero_image_matchup)
            77 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lycan_full.png?")
                .into(holder.itemView.hero_image_matchup)
            78 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/brewmaster_full.png?")
                .into(holder.itemView.hero_image_matchup)
            79 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shadow_demon_full.png?")
                .into(holder.itemView.hero_image_matchup)
            80 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/lone_druid_full.png?")
                .into(holder.itemView.hero_image_matchup)
            81 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/chaos_knight_full.png?")
                .into(holder.itemView.hero_image_matchup)
            82 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/meepo_full.png?")
                .into(holder.itemView.hero_image_matchup)
            83 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/treant_full.png?")
                .into(holder.itemView.hero_image_matchup)
            84 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ogre_magi_full.png?")
                .into(holder.itemView.hero_image_matchup)
            85 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/undying_full.png?")
                .into(holder.itemView.hero_image_matchup)
            86 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/rubick_full.png?")
                .into(holder.itemView.hero_image_matchup)
            87 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/disruptor_full.png?")
                .into(holder.itemView.hero_image_matchup)
            88 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/nyx_assassin_full.png?")
                .into(holder.itemView.hero_image_matchup)
            89 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/naga_siren_full.png?")
                .into(holder.itemView.hero_image_matchup)
            90 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/keeper_of_the_light_full.png?")
                .into(holder.itemView.hero_image_matchup)
            91 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/wisp_full.png?")
                .into(holder.itemView.hero_image_matchup)
            92 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/visage_full.png?")
                .into(holder.itemView.hero_image_matchup)
            93 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/slark_full.png?")
                .into(holder.itemView.hero_image_matchup)
            94 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/medusa_full.png?")
                .into(holder.itemView.hero_image_matchup)
            95 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/troll_warlord_full.png?")
                .into(holder.itemView.hero_image_matchup)
            96 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/centaur_full.png?")
                .into(holder.itemView.hero_image_matchup)
            97 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/magnataur_full.png?")
                .into(holder.itemView.hero_image_matchup)

            98 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/shredder_full.png?")
                .into(holder.itemView.hero_image_matchup)
            99 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/bristleback_full.png?")
                .into(holder.itemView.hero_image_matchup)
            100 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/tusk_full.png?")
                .into(holder.itemView.hero_image_matchup)
            101 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/skywrath_mage_full.png?")
                .into(holder.itemView.hero_image_matchup)
            102 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/abaddon_full.png?")
                .into(holder.itemView.hero_image_matchup)
            103 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/elder_titan_full.png?")
                .into(holder.itemView.hero_image_matchup)
            104 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/legion_commander_full.png?")
                .into(holder.itemView.hero_image_matchup)
            105 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/techies_full.png?")
                .into(holder.itemView.hero_image_matchup)
            106 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/ember_spirit_full.png?")
                .into(holder.itemView.hero_image_matchup)
            107 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/earth_spirit_full.png?")
                .into(holder.itemView.hero_image_matchup)
            108 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/abyssal_underlord_full.png?")
                .into(holder.itemView.hero_image_matchup)
            109 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/terrorblade_full.png?")
                .into(holder.itemView.hero_image_matchup)
            110 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/phoenix_full.png?")
                .into(holder.itemView.hero_image_matchup)
            111 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/oracle_full.png?")
                .into(holder.itemView.hero_image_matchup)
            112 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/winter_wyvern_full.png?")
                .into(holder.itemView.hero_image_matchup)
            113 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/arc_warden_full.png?")
                .into(holder.itemView.hero_image_matchup)
            114 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/monkey_king_full.png?")
                .into(holder.itemView.hero_image_matchup)

            119 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dark_willow_full.png?")
                .into(holder.itemView.hero_image_matchup)
            120 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/pangolier_full.png?")
                .into(holder.itemView.hero_image_matchup)
            121 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/grimstroke_full.png?")
                .into(holder.itemView.hero_image_matchup)
            123 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/hoodwink_full.png?")
                .into(holder.itemView.hero_image_matchup)
            128 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/snapfire_full.png?")
                .into(holder.itemView.hero_image_matchup)
            129 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/mars_full.png?")
                .into(holder.itemView.hero_image_matchup)
            135 -> Glide.with(holder.itemView)
                .load("http://cdn.dota2.com/apps/dota2/images/heroes/dawnbreaker_full.png?")
                .into(holder.itemView.hero_image_matchup)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}