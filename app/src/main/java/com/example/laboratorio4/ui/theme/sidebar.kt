package com.example.laboratorio4.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.laboratorio4.routingPages


@Composable
fun Sidebar(navController: NavController){
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        val options = listOf(
            routingPages.INFO_CAMPUS to "Inicio",
            routingPages.PROFILE to "Perfil",
            routingPages.CONFIG to "Configuración",
            routingPages.CONTACTOS to "Contactos"
        )
        options.forEach{(route, name)->
            TextButton(onClick = {navController.navigate(route)}) {
                Text(text = name)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(navController: NavController) {
    TopAppBar(
        title = { /* Aquí tu lógica para mostrar el título según la pantalla */ },
        navigationIcon = {
            IconButton(onClick = { /* Lógica para abrir el Sidebar */ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú")
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(routingPages.PROFILE) }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Perfil")
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(navController: NavController, content: @Composable () -> Unit){
    Scaffold (topBar = { MainTopBar(navController = navController)}) {
        Row(modifier = Modifier.fillMaxSize()) {
            Sidebar(navController = navController)
            Box(modifier = Modifier.fillMaxWidth()){
                content()
            }

        }

    }
}