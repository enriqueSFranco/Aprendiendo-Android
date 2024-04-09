package com.kikesf.aprendiendoandroid


import android.os.Bundle
import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kikesf.aprendiendoandroid.ui.theme.AprendiendoAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AprendiendoAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(msg = Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun Greeting(msg: Message, modifier: Modifier = Modifier) {
    Row(modifier = modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.batman),
            contentDescription = "superhero",
            modifier = modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
            ,
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = modifier.width(4.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = modifier.height(4.dp))
            Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.message,
                    modifier = modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

}


@Preview(name = "Light Mode") // 1.- PREVIEW LIGHT MODE
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
) // 2.- PREVIEW DARK MODE
@Composable
fun GreetingPreview() {
    AprendiendoAndroidTheme {
        Surface {
            Greeting(msg = Message("Lexi", "Hey, take a look at Jetpack Compose, it's great!"))
        }
    }
}