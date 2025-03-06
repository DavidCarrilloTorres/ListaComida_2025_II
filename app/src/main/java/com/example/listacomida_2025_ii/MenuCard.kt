package com.example.listacomida_2025_ii

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.DataSource
import model.Platillo

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Imagen circular
            Image(
                painter = painterResource(id = platillo.drawableResId),
                contentDescription = stringResource(id = platillo.stringResourseId),
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                // Nombre del platillo (Título)
                Text(
                    text = stringResource(id = platillo.stringResourseId),
                    style = MaterialTheme.typography.headlineMedium
                )

                // Precio del platillo (Texto normal)
                Text(
                    text = "Precio: ${platillo.precio}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp
                )

                // Oferta (resaltada si aplica)
                if (platillo.oferta) {
                    Text(
                        text = "¡Oferta del 20%!",
                        color = Color.Red,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Composable
fun MenuCardList(platillos: List<Platillo>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(platillos) { platillo ->
            MenuCard(platillo = platillo)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCard_Preview() {
    val dataSource = DataSource()
    val platillos = dataSource.LoadPlatillos()

    MenuCard(platillo = platillos[0])
}
