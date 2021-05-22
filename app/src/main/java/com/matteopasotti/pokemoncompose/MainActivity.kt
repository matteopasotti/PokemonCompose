package com.matteopasotti.pokemoncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matteopasotti.pokemoncompose.ui.theme.PokemonComposeTheme

class MainActivity : ComponentActivity() {

    private val descriptionHolder =
        "Bulbasaur (Japanese: フシギダネ Fushigidane) is a dual-type Grass/Poison Pokémon introduced in Generation I." +
                " It evolves into Ivysaur starting at level 16, which evolves into Venusaur starting at level 32."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseView {
                PokemonCard(name = "Bulbasaur", description = descriptionHolder)
            }
        }
    }
}

@Composable
fun BaseView(content: @Composable() () -> Unit) {
    PokemonComposeTheme {
        content()
    }
}

@Composable
fun PokemonCard(name: String, description: String) {
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.header),
                contentDescription = "Header",
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = name,
                style = typography.h6
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = description,
                style = typography.body2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis)
        }
    }

}

@Preview
@Composable
fun Preview() {
    PokemonCard(name = "Bulbasaur", description = "descr")
}
