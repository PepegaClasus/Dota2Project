package tut.example.dota2Project.UI.Items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dota_items.view.*
import tut.example.dota2Project.R
import tut.example.dota2Project.UI.Items.Model.Items

class ItemAdapter(val list: MutableList<Items>, val fragment: ItemsFragment) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item_name: TextView
        var item_image: ImageView


        init {
            item_name = itemView.findViewById(R.id.item_name)
            item_image = itemView.findViewById(R.id.item_image)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.dota_items, parent, false)
        val holder = ViewHolder(itemView)

        return holder
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val items: Items = list[position]
        holder.item_name.text = items.name.replace("_", " ")




        Glide.with(holder.itemView).load(items.image_url).into(holder.itemView.item_image)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}