package dev.dbserver.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dbserver.R
import dev.dbserver.model.Ability
import kotlinx.android.synthetic.main.ability_item.view.*

class DetailsPokemonAdapter(private val lista : List<Ability>) :
    RecyclerView.Adapter<DetailsPokemonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ability_item, parent, false)
        return DetailsPokemonAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val poke = lista.get(position)
        holder.bindView(poke)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(poke: Ability){
            val nome = itemView.ability_name
            nome.text = poke.ability.name
        }
    }
}