package tut.example.dota2Project.UI.Heroes.AllHeroes

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.heroes_item.view.*
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Heroes.Model.Heroes

class HeroesAdapter(
    val list: MutableList<Heroes>,
    val fragment: HeroesList,
) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var img: ImageView
//        var base_health: TextView
//        var base_mana: TextView
//        var base_armor: TextView
//        var base_str: TextView
//        var base_agi: TextView
//        var base_int: TextView
//        var attack_range: TextView
//        var herald_pick: TextView
//        var herald_win: TextView
//        var guardian_pick: TextView
//        var guardian_win: TextView
//        var crusader_pick: TextView
//        var crusader_win: TextView
//        var archor_pick: TextView
//        var archor_win: TextView
//        var legend_pick: TextView
//        var legend_win: TextView
//        var divine_pick: TextView
//        var divine_win: TextView
//        var ancient_pick: TextView
//        var ancient_win: TextView
//        var immortal_pick: TextView
//        var immortal_win: TextView
//        var base_health_regen: TextView
//        var base_mana_regen: TextView
//        var str_gain: TextView
//        var agi_gain: TextView
//        var int_gain: TextView
//        var layout: ConstraintLayout
//        var move_speed: TextView


        init {
//            base_health = itemView.findViewById(R.id.base_health)
//            base_mana = itemView.findViewById(R.id.base_mana)
//            base_armor = itemView.findViewById(R.id.base_armor)
//            base_str = itemView.findViewById(R.id.base_str)
//            base_agi = itemView.findViewById(R.id.base_agi)
//            base_int = itemView.findViewById(R.id.base_int)
//            attack_range = itemView.findViewById(R.id.attack_range)
//            base_health_regen = itemView.findViewById(R.id.base_health_regen)
//            base_mana_regen = itemView.findViewById(R.id.base_mana_regen)
//            str_gain = itemView.findViewById(R.id.str_gain)
//            agi_gain = itemView.findViewById(R.id.agi_gain)
//            int_gain = itemView.findViewById(R.id.int_gain)
//            move_speed = itemView.findViewById(R.id.move_speed)
            name = itemView.findViewById(R.id.hero_name)
            img = itemView.findViewById(R.id.hero_image)
//            herald_pick = itemView.findViewById(R.id.Herald_pick)
//            herald_win = itemView.findViewById(R.id.herald_win)
//            guardian_pick = itemView.findViewById(R.id.guardian_pick)
//            guardian_win = itemView.findViewById(R.id.guardian_win)
//            crusader_pick = itemView.findViewById(R.id.crusader_pick)
//            crusader_win = itemView.findViewById(R.id.crusader_win)
//            archor_pick = itemView.findViewById(R.id.archon_pick)
//            archor_win = itemView.findViewById(R.id.archon_win)
//            legend_pick = itemView.findViewById(R.id.legend_pick)
//            legend_win = itemView.findViewById(R.id.legend_win)
//            divine_pick = itemView.findViewById(R.id.divine_pick)
//            divine_win = itemView.findViewById(R.id.divine_win)
//            ancient_pick = itemView.findViewById(R.id.ancient_pick)
//            ancient_win = itemView.findViewById(R.id.ancient_win)
//            immortal_pick = itemView.findViewById(R.id.immortal_pick)
//            immortal_win = itemView.findViewById(R.id.immortal_win)
//            layout = itemView.findViewById(R.id.layout_hero_info)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.heroes_item, parent, false)
        val holder = ViewHolder(itemView)

        holder.itemView.setOnClickListener {
            fragment.showHero(holder.adapterPosition)
        }
        return holder
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val heroes: Heroes = list[position]


        holder.name.text = list[position].localized_name

        Glide.with(holder.itemView).load("http://cdn.dota2.com" + heroes.img)
            .into(holder.itemView.hero_image)


//        holder.itemView.setOnClickListener {
//            if (holder.layout.visibility == View.GONE) {
//                holder.layout.visibility = View.VISIBLE
//            } else {
//                holder.layout.visibility = View.GONE
//            }
//        }


    }


    override fun getItemCount(): Int {
        return list.size
    }




}
