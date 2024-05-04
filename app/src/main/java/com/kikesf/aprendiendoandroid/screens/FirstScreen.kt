package com.kikesf.aprendiendoandroid.screens

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kikesf.aprendiendoandroid.marvelApp.SuperHeroMainActivity

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            val intent = Intent(ctx, SuperHeroMainActivity::class.java)
            ctx.startActivity(intent)
        }) {
            Text(text = "marvel app")
        }
    }
}