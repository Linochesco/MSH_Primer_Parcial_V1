package com.maestrocorona.appferia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import android.content.Intent

import androidx.compose.ui.text.TextStyle // Define el estilo del texto, incluyendo fuente, tamaño y color.
import androidx.compose.ui.text.font.FontFamily // Permite establecer la familia tipográfica, como SansSerif.
import androidx.compose.ui.text.font.FontWeight // Controla el grosor de la fuente (Bold, Light, etc.).
import androidx.compose.ui.tooling.preview.Preview // Habilita la vista previa en Android Studio para Composables.

import com.maestrocorona.appferia.ui.theme.AppFeriaTheme // Importa el tema personalizado de la app.
import com.maestrocorona.appferia.ui.theme.Purple40 // Color definido en la paleta de colores de la app.
import com.maestrocorona.appferia.ui.theme.Purple80 // Otro color definido en la paleta de la app.


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(onNavigateToSecondActivity = {
                // Iniciamos la segunda actividad cuando se presione el botón
                startActivity(Intent(this, Activity2::class.java))
            })
        }
    }
}

@Composable
fun MainScreen(onNavigateToSecondActivity: () -> Unit) {
    // Pantalla principal que contiene todos los elementos
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            // Lista de negocios con sus imágenes
            BusinessItem("Negocios de la Nave 1")
            BusinessItem("Negocios de la Nave 2")
            BusinessItem("Negocios de la Nave 3")
            BusinessItem("Atracciones y conciertos 4")


            // Botón para navegar a la segunda actividad
            Button(
                onClick = onNavigateToSecondActivity,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("Fechas importantes")
            }
        }
    }
}

@Composable
fun BusinessItem(text: String) {
    // Componente reutilizable para mostrar negocio con imagen
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        //🔹Le agregue el color de la nave a la CARD de negocio
        colors = CardDefaults.cardColors(Purple80)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del restaurante
            Image(
                painter = painterResource(id = R.drawable.logo_rest),
                contentDescription = "Logo restaurante",
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
            // 🔹 Texto del negocio dentro de la imagen, negocio de la nave
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    //🔹 Le agregue el color de la nave a la letra
                    color = Purple40
                ),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// 🔹 Vista previa en Android Studio
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    AppFeriaTheme {
        MainScreen(onNavigateToSecondActivity = {})
    }
}
