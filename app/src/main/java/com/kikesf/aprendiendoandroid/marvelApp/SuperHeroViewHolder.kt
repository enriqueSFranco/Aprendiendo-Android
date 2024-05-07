package com.kikesf.aprendiendoandroid.marvelApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.aprendiendoandroid.databinding.ItemSuperHeroBinding
import com.kikesf.aprendiendoandroid.marvelApp.models.Result
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroBinding.bind(view)
    fun bin(superHero: Result) {
        binding.tvSuperheroName.text = superHero.name
        val thumbnail = superHero.thumbnail
        val imageUrl = "${thumbnail.path}.${thumbnail.extension}"
        Picasso.get().load(imageUrl).into(binding.ivSuperheroImage)
    }
}