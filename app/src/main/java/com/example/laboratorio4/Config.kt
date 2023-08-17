package com.example.laboratorio4

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun BtnIconOneText(
    //Parametros que reutliozo
    painter: Painter,
    primaryText: String,
    iconColor: Color,
    onClick: () -> Unit
){
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(Color.White)

    ) {
        Icon(painter = painter, contentDescription ="",modifier =  Modifier.size(40.dp),  iconColor, )
        Box (modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                Text(text = primaryText, fontSize = 18.sp)
        }
    }
}
@Composable
fun ConfigPage (navController: NavController){
    val scrollState = rememberScrollState()
    //Icons
    val closeIcon = painterResource(id = R.drawable.baseline_close_24)
    val editPerfileIcon = painterResource(id =R.drawable.baseline_person_24)
    val EmailIcon = painterResource(id = R.drawable.baseline_email_24)
    val NotiIcon = painterResource(id = R.drawable.baseline_notifications_24)
    val privateIcon = painterResource(id = R.drawable.baseline_privacy_tip_24)
    val helpIcon = painterResource(id = R.drawable.baseline_help_24)
    val aboutIcon = painterResource(id = R.drawable.baseline_info_24)
    Column (
        Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(Color(android.graphics.Color.parseColor("#ECECEC")))
    ){
        Column (Modifier.background(Color.White)){
            Row (Modifier.padding(top = 20.dp, bottom = 20.dp, start = 10.dp)){
                Icon(painter = closeIcon, contentDescription = "", Modifier.size(40.dp).clickable { navController.navigate(routingPages.PROFILE) })
                Box(modifier =  Modifier.padding(start = 80.dp)){
                    Text(text = "Configuración", fontSize = 22.sp)}
            }
            Divider()
            BtnIconOneText(painter = editPerfileIcon, primaryText = "Editar Perfil",
                iconColor = Color.Gray, {})
            Divider()
            BtnIconOneText(painter = EmailIcon, primaryText = "Correo Electrónico",
                iconColor = Color(android.graphics.Color.parseColor("#065612")),  {})
            Divider()
            BtnIconOneText(painter = NotiIcon, primaryText = "Notificaciones",
                iconColor = Color(android.graphics.Color.parseColor("#585406")),  {})
            Divider()
            BtnIconOneText(painter = privateIcon, primaryText = "Privacidad",
                iconColor = Color.Gray,  {})
            Divider()
        }

        Column  (
            Modifier
                .padding(vertical = 15.dp)
                .background(Color.White)){
            Divider()
            BtnIconOneText(painter = helpIcon, primaryText = "Ayuda & FeedBack",
                iconColor = Color(android.graphics.Color.parseColor("#CD0707")), {})
            Divider()
            BtnIconOneText(painter = aboutIcon, primaryText = "Acerca de",
                iconColor = Color(android.graphics.Color.parseColor("#262D73")),  {})
            Divider()
        }

        Column(Modifier.background(Color.White),
            verticalArrangement = Arrangement.Center
            ) {
            Divider()
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Cerrar Sesión",
                    color = Color.Red,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
            Divider()
        }


    }
}