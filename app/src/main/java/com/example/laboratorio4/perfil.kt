package com.example.laboratorio4
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun BtnIconText(
    //Parametros que reutliozo
    painter: Painter,
    primaryText: String,
    secondaryText: String,
    iconColor: Color,
    onClick: () -> Unit
){
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)

    ) {
        Icon(painter = painter, contentDescription ="",modifier =  Modifier.size(50.dp),  iconColor, )
        Column (modifier = Modifier.padding(start = 10.dp)) {
            if(secondaryText.isNotBlank() || secondaryText != " " || secondaryText != ""){
                Text(text = primaryText, fontSize = 22.sp)
                Text(text = secondaryText, fontSize = 15.sp)
            }else{
                Text(text = primaryText, fontSize = 22.sp)

            }
        }
    }
}

@Composable

fun perfilPage (navController: NavController){
    val scrollState = rememberScrollState()
    //icons
    val iconSettings = painterResource( R.drawable.baseline_settings_24)
    val index = painterResource(id = R.drawable.baseline_all_inbox_24)
    val personIcon = painterResource(id = R.drawable.baseline_people_24)
    val shopIcon = painterResource(id = R.drawable.baseline_shopping_bag_24)
    val phoneIcon = painterResource(id = R.drawable.baseline_phone_android_24)
    //Imagenes
    val fondoPerfil = painterResource( R.drawable.fondoperfil)
    val vrPerfil = painterResource(R.drawable.vr)


    //Pagina
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Perfil", fontSize = 24.sp, fontWeight = FontWeight(600) , modifier = Modifier.padding(vertical = 15.dp))
            Icon(painter = iconSettings, contentDescription ="", modifier =  Modifier.size(50.dp).clickable { navController.navigate(routingPages.CONFIG) } )

        }

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = fondoPerfil,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 150.dp)
                    .border(
                        width = 5.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(100.dp)
                    )
            ) {
                Image(
                    painter = vrPerfil,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }
        }

        Text(text = "Bryan Carlos España Machorro" , fontSize = 22.sp, fontWeight = FontWeight(500),modifier =  Modifier.padding(top = 60.dp, start = 30.dp, bottom = 30.dp))

        Divider()
        //----------------------------------Juegos Favoritos----------------------------------------

        BtnIconText( index,"Juegos Favoritos",  "Revisa tus juegos favoritos",
            Color(android.graphics.Color.parseColor("#05021E")), onClick =  { })
        Divider()
        //----------------------------------Lista de deseos----------------------------------------
        BtnIconText(shopIcon, "Lista de deseos","¿Que juegos deseas comprar?",
            Color(0x162, 0x31, 0x5) , onClick =  { })
        Divider()
        //----------------------------------Mis Amigos-------------------------------------------------
        BtnIconText(personIcon,  "Mis Amigos", "Comparte tus gustos con tus amigos",
            Color(0x6, 0x2, 0x28), onClick =  { })
        Divider()
        //----------------------------------Configuración-------------------------------------------------
        BtnIconText(iconSettings,  "Configuración",  "Accede a tus configuraciones",
            Color.Gray, onClick =  { navController.navigate(routingPages.CONFIG) })
        Divider()
        //----------------------------------Contactanos-------------------------------------------------
        BtnIconText(phoneIcon,"Contactos", "Si necesitas servicio, contactanos",
            Color(0x185, 0x103, 0x14), onClick =  { navController.navigate(routingPages.CONTACTOS) })
        Divider()


    }
}
