package dev.dbserver.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import dev.dbserver.R
import dev.dbserver.adapter.TypeListsAdapter
import dev.dbserver.model.Type
import dev.dbserver.network.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val call = RetrofitInitializer().pokeService().list()

        call.enqueue(object : Callback<Type> {

            override fun onResponse(call: Call<Type>, response: Response<Type>) {
                response?.body()?.let {
                    val recyclerView = lista
                    recyclerView.adapter = TypeListsAdapter(response.body()!!.results, baseContext)
                    val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    recyclerView.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<Type>, t: Throwable) {
                Log.i("log faillure", t.message)
            }
        })
    }
}