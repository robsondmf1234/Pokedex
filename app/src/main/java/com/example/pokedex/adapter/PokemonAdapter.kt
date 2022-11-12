package com.example.pokedex.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon) {
            with(itemView) {
                val image = findViewById<ImageView>(R.id.image)
                val name = findViewById<TextView>(R.id.tvName)
                val number = findViewById<TextView>(R.id.tvNumber)
                val type1 = findViewById<TextView>(R.id.tvType1)
                val type2 = findViewById<TextView>(R.id.tvType2)

                //TODO:Load image with Glide

                number.text = "Nº ${item.formattedNumber}"
                name.text = item.name

                type1.text = item.types[0].name

                if (item.types.size > 1) {
                    type2.visibility = View.VISIBLE
                    type2.text = item.types[1].name
                } else {
                    type2.visibility = View.GONE
                }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    override fun getItemCount() = items.size
}