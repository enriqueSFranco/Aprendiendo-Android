package com.kikesf.aprendiendoandroid.marvelApp

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.aprendiendoandroid.databinding.ItemSuperHeroBinding
import com.kikesf.aprendiendoandroid.marvelApp.models.Result
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroBinding.bind(view)
    fun bin(superHero: Result) {
        val thumbnail = superHero.thumbnail
        val imageUrl = "${thumbnail.path.replace("http", "https")}.${thumbnail.extension}"

        binding.ivSuperheroImage.loadImage(imageUrl)
        binding.tvSuperheroName.text = superHero.name
        binding.tvDescription.text = superHero.description
    }

    private fun ImageView.loadImage(url: String) {
        if (url.isNotBlank()) {
            Picasso.get().load(url).into(this)
        }
    }
}