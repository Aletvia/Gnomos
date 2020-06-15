package com.aall.gnomos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_basic_profile.view.*

class AdapterBrastlewarkBasic(private val brastlewarkList: ArrayList<BrastlewarkSerialized>, private val listener : Listener):
RecyclerView.Adapter<AdapterBrastlewarkBasic.ViewHolder>(){

    interface Listener {
        fun onItemClick(retroBrastlewarkList: BrastlewarkSerialized)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(brastlewarkList[position], listener, position)

    }
    override fun getItemCount(): Int = brastlewarkList.count()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_profile, parent, false)
        return ViewHolder(view)

    }


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

//Assign values from the data model, to their corresponding Views//

        fun bind(brastlewark: BrastlewarkSerialized, listener: Listener, position: Int) {
            val convert = UnitConverter()
            itemView.setOnClickListener{ listener.onItemClick(brastlewark) }
            itemView.txt_name_b.text = brastlewark.name
            itemView.txt_age_b.text = brastlewark.age.toString()
            itemView.txt_weight_b.text = convert.Converter(brastlewark.weight,"weight")
            itemView.txt_height_b.text = convert.Converter(brastlewark.height,"cmTOm")
            itemView.txt_hair_b.text = brastlewark.hair_color
            Picasso
                .get() // give it the context
                .load(brastlewark.thumbnail)//("https://i.imgur.com/H981AN7.jpg") // load the image
                .error(R.drawable.user)
                .into(itemView.img_profile_picture_b) // select the ImageView to load it into*/

        }

    }

}