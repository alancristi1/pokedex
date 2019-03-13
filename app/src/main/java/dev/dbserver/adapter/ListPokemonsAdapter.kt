package dev.dbserver.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dbserver.R
import dev.dbserver.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class ListPokemonsAdapter(private val pokemon: List<Pokemon>,
                          private val context: Context) : RecyclerView.Adapter<ListPokemonsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return ListPokemonsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val poke = pokemon[position]

        holder?.let{
            it.bindView(pokemon.get(position), context)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(poke: Pokemon, context: Context){
            val nome = itemView.pokemon_name
            Log.i("log adapter name", poke.name)
            nome.text = poke.name

            itemView.setOnClickListener {
//                val intent = Intent(context, ListTypeActivity::class.java)
//                intent.putExtra("name_request", poke.name)
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                context.startActivity(intent)
            }
        }
    }
}