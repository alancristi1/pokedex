package dev.dbserver.ui.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import dev.dbserver.R
import dev.dbserver.adapter.ListPokemonsAdapter
import dev.dbserver.model.Pokemon
import dev.dbserver.model.Pokemons
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

        call.enqueue(object : Callback<Pokemons>{

            override fun onResponse(call: Call<Pokemons>, response: Response<Pokemons>) {
                response?.body()?.let {

                    val recyclerView = listaPoke
//                    Log.i("log response", response.body()!!.pokemon)
                    val lista : List<Pokemon> = response.body()!!.pokemon

                    recyclerView.adapter = ListPokemonsAdapter(lista, baseContext)
                    val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<Pokemons>, t: Throwable) {
                Log.i("log failure", t.message)
            }
        })
    }
}
