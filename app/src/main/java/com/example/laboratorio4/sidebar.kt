package com.example.laboratorio4

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

data class MenuItem(
    val id: ScreensRoute,
    val textId: Int
)
val drawerScreens = listOf(
    MenuItem(ScreensRoute.PROFILE, R.string.page1),
    MenuItem(ScreensRoute.CONFIG, R.string.page2),
    MenuItem(ScreensRoute.INFO_CAMPUS, R.string.page3),
    MenuItem(ScreensRoute.CONTACTOS, R.string.page4),

    )

enum class ScreensRoute {
    PROFILE, CONFIG, INFO_CAMPUS, CONTACTOS
}

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
    Scaffold (topBar = { MainTopBar(navController = navController) }) {
        Row(modifier = Modifier.fillMaxSize()) {
            Sidebar(navController = navController)
            Box(modifier = Modifier.fillMaxWidth()){
                content()
            }

        }

    }
}

@Composable
fun DrawerItem(menuItem: MenuItem, modifier: Modifier = Modifier, onItemClick: (MenuItem) -> Unit) {
    Column(
        modifier = Modifier.clickable {
            onItemClick(menuItem)
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(8.dp)
        ) {
            Text(
                text = stringResource(id = menuItem.textId),
                fontSize = 25.sp,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
        Divider()
    }
}

@Composable
fun DrawerBody(
    menuItems: List<MenuItem>,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(menuItems) { item ->
            DrawerItem(
                item,
                modifier = modifier
            ) {
                scope.launch {
                   //scaffoldState.drawerState.close()
                }
                onItemClick(item)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    titleResId: Int,
    modifier: Modifier = Modifier,
    openDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = titleResId))
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        openDrawer()
                    },
                contentDescription = null
            )
        },
        modifier = modifier
    )
}

@Composable
fun ScreenContent(titleId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = titleId))
    }
}

@Composable
fun DrawerNavigationScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                titleResId = R.string.app_name,
                openDrawer =
                {
                    scope.launch {
                        // Open the drawer with animation
                        // and suspend until it is fully
                        // opened or animation has been canceled
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = true,
        drawerContent = {
            DrawerBody(
                menuItems = drawerScreens,
                scaffoldState,
                scope
            ) {
                navController.navigate(it.id.name) {
                    popUpTo = navController.graph.startDestinationId
                    launchSingleTop = true
                }
            }
        }
    ) {
        NavHost(navController = navController)
    }
}