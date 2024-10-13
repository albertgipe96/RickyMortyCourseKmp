@file:OptIn(KoinExperimentalAPI::class)

package com.example.rickymortycoursekmp.ui.home.tabs.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.example.rickymortycoursekmp.domain.model.CharacterModel
import com.example.rickymortycoursekmp.ui.core.ext.vertical
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
fun CharactersScreen() {
    val characterViewModel = koinViewModel<CharacterViewModel>()
    val state by characterViewModel.state.collectAsState()
    val characters = state.characters.collectAsLazyPagingItems()

    CharactersGridList(
        characterOfTheDay = state.characterOfTheDay,
        characters = characters
    )
}

@Composable
fun CharacterOfTheDay(characterModel: CharacterModel? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        shape = RoundedCornerShape(12)
    ) {
        characterModel?.let {
            Box(contentAlignment = Alignment.BottomStart) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green.copy(alpha = 0.5F))
                )
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = characterModel.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.horizontalGradient(
                            0F to Color.Black.copy(alpha = 0.9F),
                            0.4F to Color.White.copy(alpha = 0F)
                        ))
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 16.dp)
                        .fillMaxHeight()
                        .vertical()
                        .rotate(-90F),
                    text = characterModel.name,
                    fontSize = 40.sp,
                    maxLines = 1,
                    minLines = 1,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis
                )
            }
        } ?: Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { CircularProgressIndicator(color = Color.Green) }
    }
}

@Composable
fun CharactersGridList(
    characterOfTheDay: CharacterModel?,
    characters: LazyPagingItems<CharacterModel>
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item(span = { GridItemSpan(2) }) {
            CharacterOfTheDay(characterModel = characterOfTheDay)
        }

        when {
            characters.loadState.refresh is LoadState.Loading && characters.itemCount == 0 -> { // Initial loading
                item(span = { GridItemSpan(2) }) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(modifier = Modifier.size(60.dp), color = Color.Red)
                    }
                }
            }
            characters.loadState.refresh is LoadState.NotLoading && characters.itemCount == 0 -> { // Empty response
                item {
                    Text("No hay personajes :(")
                }
            }
            else -> { // Data is loaded
                items(characters.itemCount) { position ->
                    characters[position]?.let { characterModel ->
                        CharacterItemList(characterModel = characterModel)
                    }
                }
                if (characters.loadState.append is LoadState.Loading) {
                    item(span = { GridItemSpan(2) }) {
                        Box(modifier = Modifier.fillMaxWidth().height(100.dp), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(modifier = Modifier.size(60.dp), color = Color.Red)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterItemList(characterModel: CharacterModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(24))
            .border(2.dp, Color.Green, RoundedCornerShape(0, 24, 0 ,24))
            .fillMaxSize()
            .clickable { /*navigate to detail*/ },
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = characterModel.image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Brush.verticalGradient(listOf(
                    Color.Black.copy(alpha = 0F),
                    Color.Black.copy(alpha = 0.6F),
                    Color.Black.copy(alpha = 1F)
                ))),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = characterModel.name,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
