package dev.dbserver.ui.details

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import com.squareup.picasso.Picasso
import dev.dbserver.R
import dev.dbserver.adapter.DetailsPokemonAdapter
import dev.dbserver.adapter.TypeListsAdapter
import dev.dbserver.model.DetailsPoke
import dev.dbserver.network.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_details_poke.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsPokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_poke)

        val nome_request = intent.getStringExtra("name_request")

        val call = RetrofitInitializer().pokeService().getInfoPoke(nome_request)
        call.enqueue(object : Callback<DetailsPoke> {

            override fun onResponse(call: Call<DetailsPoke>, response: Response<DetailsPoke>) {

                Picasso.get().load(response.body()!!.sprites.frontDefault)
                    .resize(300,300).into(imgPokemon)

                txtName.append(nome_request)

                txtAltura.append("Altura: ")
                txtAltura.append(response.body()!!.height.toString())

                txtPeso.append("Peso: ")
                txtPeso.append(response.body()!!.weight.toString())

                val recyclerView = listaAbilities
                recyclerView.adapter = DetailsPokemonAdapter(response.body()!!.abilities)
                val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                recyclerView.layoutManager = layoutManager

                btnShare.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.setType("text/plain")
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)

                    intent.putExtra(Intent.EXTRA_SUBJECT, "Informações do Pokemon")

                    var allAbilities = ""
                    val sizeAbilities : Int = response.body()!!.abilities.size
                    for (i in 0 until sizeAbilities){
                        allAbilities += response.body()!!.abilities.get(i).ability.name + " "
                    }

                    val shareString = "" +
                            "Nome: " + nome_request + "\n" +
                            txtAltura.text + "\n" +
                            txtPeso.text + "\n" +
                            "Habilidades: " + allAbilities

                    intent.putExtra(Intent.EXTRA_TEXT, shareString)
                    startActivity(Intent.createChooser(intent, "Compartilhar"))
                }
            }

            override fun onFailure(call: Call<DetailsPoke>, t: Throwable) {
                Log.i("log failure", t.message)
            }
        })
    }
}
