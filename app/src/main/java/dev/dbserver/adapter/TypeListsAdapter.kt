package dev.dbserver.adapter

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.dbserver.R
import dev.dbserver.model.Result
import dev.dbserver.ui.list.ListTypeActivity
import kotlinx.android.synthetic.main.type_item.view.*

class TypeListsAdapter(private val types : List<Result>,
                       private val context : Context) : Adapter<TypeListsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.type_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return types.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val type = types[position]
        holder?.let{
            it.bindView(type, context)
        }
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(results: Result, context: Context){
            val nome = itemView.type_name
            nome.text = results.name

            itemView.setOnClickListener {
                val intent = Intent(context, ListTypeActivity::class.java)
                intent.putExtra("name_request", results.name)
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(intent)
            }
        }
    }
}