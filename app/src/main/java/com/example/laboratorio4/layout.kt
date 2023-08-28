package com.example.laboratorio4

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.RoutingPages.ConfigPage
import com.example.laboratorio4.RoutingPages.ContactPage
import com.example.laboratorio4.RoutingPages.infoCampus
import com.example.laboratorio4.RoutingPages.perfilPage
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(navController: NavController, content: @Composable () -> Unit, onNavigatePerfil: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Games VR")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onNavigatePerfil()             }
                    ) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },

            )
        }
    ) {
        content()
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)@Composable
fun sidebarLeft(navController: NavController){
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    data class DrawerItem(val icon: ImageVector, val route: String, val label: String)
    val items = listOf(
        DrawerItem(Icons.Default.Home, routingPages.INFO_CAMPUS, "Inicio"),
        DrawerItem(Icons.Default.Person, routingPages.PROFILE, "Perfil"),
        DrawerItem(Icons.Default.Settings, routingPages.CONFIG, "Configuración"),
        DrawerItem(Icons.Default.Email, routingPages.CONTACTOS, "Contactos")

    )
    val selectedItem = remember { mutableStateOf(items[0]) }

    //icons
    val iconList = painterResource(id = R.drawable.baseline_menu_24)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(item.label) },
                        selected = item == selectedItem.value,
                        onClick = {
                            navController.navigate(item.route)
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            //Icons
            val iconUSer = painterResource(id = R.drawable.baseline_person_24)
            val iconMenu = painterResource(id = R.drawable.baseline_menu_24)
            //Textos
            val gamesVR = stringResource(id = R.string.GamesVR)

            NavHost(navController = navController as NavHostController, startDestination = routingPages.INFO_CAMPUS) {
                composable(routingPages.INFO_CAMPUS) {
                    CommonLayout(drawerState) {
                        infoCampus(navController)
                    }
                }

                composable(routingPages.PROFILE) {
                    CommonLayout(drawerState) {
                        perfilPage(navController)
                    }
                }

                composable(routingPages.CONFIG) {
                    CommonLayout(drawerState = drawerState) {
                        ConfigPage(navController)
                    }
                }

                composable(routingPages.CONTACTOS) {
                    CommonLayout(drawerState = drawerState) {
                        ContactPage(navController)
                    }
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonLayout(drawerState: DrawerState, content: @Composable () -> Unit) {
    val coroutineScope = rememberCoroutineScope() // Obtener CoroutineScope

    Column(modifier = Modifier.fillMaxSize()) {
        // Encabezado
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val iconMenu = painterResource(id = R.drawable.baseline_menu_24)
            val gamesVR = stringResource(id = R.string.GamesVR)

            IconButton(onClick = {
                coroutineScope.launch { // Lanzar dentro del CoroutineScope
                    drawerState.open()
                }
            }) {
                Icon(painter = iconMenu, contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 10.dp))
            }
            Text(
                text = gamesVR,
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier.padding(vertical = 15.dp, horizontal = 20.dp)
            )
        }

        // Contenido
        content()
    }
}
