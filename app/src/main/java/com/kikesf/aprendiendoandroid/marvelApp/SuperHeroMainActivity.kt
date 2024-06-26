package com.kikesf.aprendiendoandroid.marvelApp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.kikesf.aprendiendoandroid.R
import com.kikesf.aprendiendoandroid.databinding.ActivitySuperHeroMainBinding
import com.kikesf.aprendiendoandroid.marvelApp.models.SuperHero
import com.kikesf.aprendiendoandroid.marvelApp.services.ApiService
import com.kikesf.aprendiendoandroid.marvelApp.services.RetrofitServiceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class SuperHeroMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySuperHeroMainBinding
    private lateinit var retrofit: Retrofit
    private lateinit var superHeroAdapater: SuperHeroAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        retrofit = RetrofitServiceFactory.makeRetrofitService()
        initUI()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun initUI() {
        binding.searchHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // se llama cuando pulsemos el botón de buscar
                searchByHeroName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // se llama cada que pulsamos una tecla
                return false
            }

        })

        superHeroAdapater = SuperHeroAdapater()
        binding.rvSuperheroList.setHasFixedSize(true)
        binding.rvSuperheroList.layoutManager = LinearLayoutManager(this)
        binding.rvSuperheroList.adapter = superHeroAdapater
    }

    fun searchByHeroName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val res: Response<SuperHero> = retrofit.create(ApiService::class.java).getSuperheros(name = query)
                if (res.isSuccessful) {
                    var superHeroRes: SuperHero? = res.body()
                    if (superHeroRes != null) {
                        println(superHeroRes.toString())

                        runOnUiThread { // ejecuta en el hilo principal ya que estamos dentro de una coroutineScope
                            superHeroAdapater.updateList(superHeroRes.data.results)
                            binding.progressBar.isVisible = false
                        }
                    }
                } else {
                    Log.i("kikedev", "failed")
                }
            } catch (e: Exception) {
                Log.i("kikedev", "Exception: ${e.message}", e)
            }

        }
    }
}