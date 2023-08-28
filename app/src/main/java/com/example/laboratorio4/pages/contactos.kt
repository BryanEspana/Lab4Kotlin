package com.example.laboratorio4.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.example.laboratorio4.R
import com.example.laboratorio4.routingPages


@Composable
fun BtnCustom(
    //Parametros
    painter: Painter,
    textInfo : String
){


    Box ( Modifier.padding(horizontal = 20.dp)
    ){
        Surface (shape = RoundedCornerShape(20.dp),) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .height(50.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(Color(android.graphics.Color.parseColor("#0C064B"))),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painter, contentDescription = "" , Modifier.padding(start = 20.dp, end = 15.dp), tint = Color.White)
                Text(text = textInfo, color = Color.White   )
            }
        }
    }
}

@Composable
fun ContactPage(navController: NavController){
    val scrollState = rememberScrollState()
    //Icons
    val phoneIcon = painterResource(id = R.drawable.baseline_local_phone_24)

    val closeIcon = painterResource(id = R.drawable.baseline_close_24)
    val warningIcon = painterResource(id = R.drawable.baseline_warning_24)
    val controlIcon = painterResource(id = R.drawable.baseline_gamepad_24)
    val infoIcon = painterResource(id = R.drawable.baseline_help_24)
    Column (
        Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ){
        Row (Modifier.padding(top = 20.dp, bottom = 20.dp, start = 10.dp).clickable {  navController.navigate(
            routingPages.PROFILE
        )  }, ){
            Icon(painter = closeIcon, contentDescription = "",
                Modifier
                    .size(40.dp)
                    //.clickable { navController.navigate(routingPages.PROFILE) })
            )
            Box(modifier =  Modifier.padding(start = 50.dp)) {
                Text(text = "Contactos de Emergencia", fontSize = 20.sp)
            }
        }
        Divider()

        Column {
            Row (Modifier.padding(20.dp)){
                Icon(painter = warningIcon, contentDescription = "",
                    Modifier
                        .size(50.dp)
                        .border(
                            width = 1.dp,
                            color = Color(android.graphics.Color.parseColor("#DCDCDC")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    Color.Red
                )
                Column (Modifier.padding(start = 15.dp)) {
                    Text(text = "Devolución", fontWeight = FontWeight(500))
                    Text(text = "Si tienes algun inconveniente con alguna compra," +
                            " o problemas de rendimiento con la aplicación " +
                            "contactanos", fontSize = 15.sp)

                }
            }
            BtnCustom(painter = phoneIcon, textInfo = "Call 5978-1736")
            Row (Modifier.padding(20.dp)){
                Icon(painter = controlIcon, contentDescription = "",
                    Modifier
                        .size(50.dp)
                        .border(
                            width = 1.dp,
                            color = Color(android.graphics.Color.parseColor("#DCDCDC")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(10.dp),
                    Color(android.graphics.Color.parseColor("#328D25"))
                )
                Column (Modifier.padding(start = 15.dp)) {
                    Text(text = "Reseña de videojuegos", fontWeight = FontWeight(500))
                    Text(text = "¿Quieres realizar alguna reseña sobre algun " +
                            "videojuego que te haya gustado o no? ", fontSize = 15.sp)

                }
            }
            BtnCustom(painter = infoIcon, textInfo = "Manda una reseña")


        }

    }
}