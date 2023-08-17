package com.example.laboratorio4

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color

@Composable
fun ContactPage(navController: NavController){
    val scrollState = rememberScrollState()
    //Icons
    val closeIcon = painterResource(id = R.drawable.baseline_close_24)
    val warningIcon = painterResource(id =R.drawable.baseline_warning_24)
    val phoneIcon = painterResource(id = R.drawable.baseline_local_phone_24)
    Column (
        Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ){
        Row (Modifier.padding(top = 20.dp, bottom = 20.dp, start = 10.dp)){
            Icon(painter = closeIcon, contentDescription = "",
                Modifier
                    .size(40.dp)
                    .clickable { navController.navigate(routingPages.PROFILE) })
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
            Row (Modifier.fillMaxWidth().padding(15.dp).background(Color.Black)){
                Icon(painter = phoneIcon, contentDescription ="")
                Text(text = "Call 5978-1736", color = Color.White)
            }
        }

    }
}