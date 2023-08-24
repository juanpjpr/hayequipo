package com.example.hayequipo.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.hayequipo.R
import com.example.hayequipo.ui.register.RegisterViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel){
    Box(
        modifier = Modifier
            .background(Color(0, 100, 0))
            .fillMaxSize()
    ){
        Carousel()
    }
}

@Composable
fun Carousel() {
    val photos = listOf(
        R.drawable.photo1,
        R.drawable.photo2,
        R.drawable.photo3,
        // Agrega más recursos de imagen aquí
    )

    val scrollState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Menú Slider
        SliderMenu()

        Spacer(modifier = Modifier.height(16.dp))

        // Carrusel de fotos
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize()
        ) {
            items(photos) { photoResId ->
                CarouselItem(photoResId)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun SliderMenu() {
    val items = listOf("Opción 1", "Opción 2", "Opción 3")

    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0, 100, 0))
            .padding(horizontal = 16.dp)
            .horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items.forEach { item ->
            Text(
                text = item,
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier
                    .background(Color.Gray, CircleShape)
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { /* Acción al hacer clic en el elemento del menú */ }
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CarouselItem(photoResId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        val painter = rememberAsyncImagePainter("https://example.com/image.jpg")
        Image(painter = painter, contentDescription = "algo" )
    }
}