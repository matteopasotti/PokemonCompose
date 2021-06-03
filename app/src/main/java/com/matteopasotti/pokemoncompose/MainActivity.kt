package com.matteopasotti.pokemoncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.matteopasotti.pokemoncompose.model.Pokemon
import com.matteopasotti.pokemoncompose.ui.theme.PokemonComposeTheme
import com.matteopasotti.pokemoncompose.view.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.livedata.observeAsState


class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseView {
                PokemonListScreen(viewModel = viewModel)
            }
        }

        viewModel.getPokemonList()
    }
}

@Composable
fun BaseView(content: @Composable() () -> Unit) {
    PokemonComposeTheme {
        Surface {
            content()
        }
    }
}

@Composable
fun PokemonListScreen(viewModel: MainViewModel) {
    val items: List<Pokemon> by viewModel.pokemonList.observeAsState(initial = listOf())
    PokemonList(pokemonList = items)
}

@Composable
fun PokemonList(pokemonList: List<Pokemon>) {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items = pokemonList) {
                PokemonCard(
                    name = it.name!!,
                    description = it.xdescription!!,
                    imageUrl = it.imageurl!!
                )
            }
        }
    }
}

@Composable
fun PokemonCard(name: String, description: String, imageUrl: String) {
    MaterialTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberCoilPainter(imageUrl),
                contentDescription = name,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(4.dp)),
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
