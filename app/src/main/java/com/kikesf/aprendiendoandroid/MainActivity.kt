package com.kikesf.aprendiendoandroid


import android.os.Bundle
import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
                    Conversation(messages)
                }
            }
        }
    }
}

data class Message(val author: String, val message: String)

@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
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

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
        )

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.clickable { isExpanded = !isExpanded }
            )
            Spacer(modifier = modifier.height(4.dp))
            Surface (
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.message,
                    modifier = modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if(isExpanded) Int.MAX_VALUE else 1
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
            MessageCard(msg = Message("Batman", "Hey, take a look at Jetpack Compose, it's great!"))
        }
    }
}

// LISTAS Y ANIMACIONES

@Composable
fun Conversation(messages: List<Message>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

val messages = listOf(
    Message("Batman", "¡Es hora de actuar!"),
    Message("Batman", "Necesitamos estar unidos para vencer al crimen."),
    Message("Batman", "El miedo es un arma, úsalo con sabiduría."),
    Message("Batman", "No subestimes a nuestros enemigos."),
    Message("Batman", "La justicia prevalecerá, siempre."),
    Message("Batman", "Cada uno de nosotros tiene un papel que desempeñar en esta batalla."),
    Message("Batman", "No hay lugar para la duda, confiamos en nuestras habilidades."),
    Message("Batman", "La oscuridad no es un obstáculo, es nuestro aliado."),
    Message("Batman", "Debemos estar un paso adelante de nuestros enemigos."),
    Message("Batman", "No descansaré hasta que Gotham esté segura."),
    Message("Batman", "Juntos somos más fuertes."),
    Message("Batman", "La verdad siempre se abrirá paso."),
    Message("Batman", "El precio de la libertad es la vigilancia."),
    Message("Batman", "No importa cuán difícil sea la tarea, la enfrentaremos juntos."),
    Message("Batman", "La noche es nuestra aliada, no tengas miedo de ella.")
)

@Preview(name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewConversation() {
    AprendiendoAndroidTheme {
        Surface {
            Conversation(messages)
        }
    }
}