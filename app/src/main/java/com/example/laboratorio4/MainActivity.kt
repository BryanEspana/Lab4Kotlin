package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isInfoCampusShown = remember { mutableStateOf(true) }
            Laboratorio4Theme {
                Surface {
                    if (isInfoCampusShown.value) {
                        infoCampus(onNavigatePerfil = {
                            isInfoCampusShown.value = false
                        })
                    } else {
                        perfilPage() // Asegúrate de tener un Composable llamado 'Perfil' en tu archivo perfil.kt
                    }
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Laboratorio4Theme {
        Surface( modifier = Modifier.fillMaxSize().background(Color.Black)){
            /*infoCampus(onNavigatePerfil ={
            })*/
            perfilPage()
        }
    }
}