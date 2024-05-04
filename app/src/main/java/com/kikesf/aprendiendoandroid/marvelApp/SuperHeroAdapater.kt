package com.kikesf.aprendiendoandroid.marvelApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kikesf.aprendiendoandroid.R
import com.kikesf.aprendiendoandroid.marvelApp.models.Result

class SuperHeroAdapater(val results: List<Result> = emptyList()): RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_super_hero, parent, false)

        return SuperHeroViewHolder(view)
    }

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bin(results[position])
    }

}