package dev.dbserver.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import dev.dbserver.R
import dev.dbserver.adapter.ListPokemonsAdapter
import dev.dbserver.model.ListPokeType
import dev.dbserver.network.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_list_type.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_type)

        val nome_request = intent.getStringExtra("name_request")

        val call = RetrofitInitializer().pokeService().listType(nome_request)

        call.enqueue(object : Callback<ListPokeType>{

            override fun onResponse(call: Call<ListPokeType>, response: Response<ListPokeType>) {

                response.body()?.let {
                    val recyclerView = listaPoke

                    recyclerView.adapter = ListPokemonsAdapter(response.body()!!.pokemon, baseContext)
                    val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<ListPokeType>, t: Throwable) {
                Log.i("log failure", t.message)
            }
        })
    }
}