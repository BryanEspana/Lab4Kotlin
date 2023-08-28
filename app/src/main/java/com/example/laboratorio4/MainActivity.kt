package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.pages.ConfigPage
import com.example.laboratorio4.pages.ContactPage
import com.example.laboratorio4.pages.infoCampus
import com.example.laboratorio4.pages.perfilPage
import com.example.laboratorio4.ui.theme.Laboratorio4Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MainLayout(navController = navController) {
                NavHost(navController = navController, startDestination = routingPages.INFO_CAMPUS) {
                    composable(routingPages.INFO_CAMPUS) {
                        ScreenContent(titleId = R.string.page1)
                        infoCampus(onNavigatePerfil = {navController.navigate(routingPages.PROFILE)})
                    }

                    composable(routingPages.PROFILE) {
                        ScreenContent(titleId = R.string.page2)
                        perfilPage(navController)


                    }

                    composable(routingPages.CONFIG) {
                        ScreenContent(titleId = R.string.page2)
                        ConfigPage(navController)

                    }

                    composable(routingPages.CONTACTOS) {
                        ScreenContent(titleId = R.string.page3)
                        ContactPage(navController)
                    }
                }
                
            }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Laboratorio4Theme {
        Surface( modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)){
            infoCampus(onNavigatePerfil ={
            })
        }
    }
}}



