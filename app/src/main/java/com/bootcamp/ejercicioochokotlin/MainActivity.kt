package com.bootcamp.ejercicioochokotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bootcamp.ejercicioochokotlin.ui.theme.EjercicioOchoKotlinTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EjercicioOchoKotlinTheme {
                MainScreen()
            }
        }
    }
}


@Composable

fun MainScreen() {
    var isImageVisible by remember { mutableStateOf(false) }



    val imageList = listOf(
        R.drawable.mariposa_rosa,
        R.drawable.mariposa_azul,
        R.drawable.mariposa_negra,
        R.drawable.mariposa_verde,
        R.drawable.mariposas
    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)

    ) {
        Text(
            text = "¡Bienvenidos!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "CAMILA GOMEZ VERDUGUEZ",
            fontSize =20.sp,
            fontWeight = FontWeight.Normal)

        Spacer(modifier = Modifier.height(16.dp))




        Button(onClick = { isImageVisible = !isImageVisible }) {
            Text(if (isImageVisible) "Ocultar Imagenes" else "Mostrar Imagenes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isImageVisible) {
            LazyColumn (
                modifier = Modifier.fillMaxWidth() )

            {items(imageList.size) { index ->
                Image(
                    painter = painterResource(id = imageList[index]),
                    contentDescription = "Mariposa",
                    modifier = Modifier
                        .size(400.dp)
                )
            }
            }
        }
    }
}
