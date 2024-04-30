package com.kikesf.aprendiendoandroid.marvelApp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kikesf.aprendiendoandroid.R
import com.kikesf.aprendiendoandroid.databinding.ActivitySuperHeroMainBinding
import com.kikesf.aprendiendoandroid.marvelApp.models.SuperHero
import com.kikesf.aprendiendoandroid.marvelApp.services.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroMainActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySuperHeroMainBinding
    private lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuperHeroMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        retrofit = getRetrofit()
        initUI()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun initUI() {
        binding.searchViewHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // se llama cuando pulsemos el botón de buscar
                searchByHeroName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // se llama cada que pulsamos una tecla
                TODO("Not yet implemented")
                return false
            }

        })
    }

    fun searchByHeroName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val res: Response<SuperHero> = retrofit.create(ApiService::class.java).getSuperheros(query)

            if (res.isSuccessful) {
                Log.i("kikedev", "success")
            } else {
                Log.i("kikedev", "failed")
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/characters?name=thor&ts=1&apikey=1342ee46b3a8207e80b268dc4b8f97a1&hash=e7538208ae63bf14cfdf1c6e4ecded44")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}