package com.kikesf.aprendiendoandroid.marvelApp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.aprendiendoandroid.databinding.ItemSuperHeroBinding
import com.kikesf.aprendiendoandroid.marvelApp.models.Result

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSuperHeroBinding.bind(view)
    fun bin(superHero: Result) {}
}