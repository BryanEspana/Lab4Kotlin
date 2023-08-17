package com.example.laboratorio4
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun perfilPage (){
    val scrollState = rememberScrollState()
    //icons
    val iconSettings = painterResource( R.drawable.baseline_settings_24)
    val index = painterResource(id = R.drawable.baseline_all_inbox_24)
    //Imagenes
    val fondoPerfil = painterResource( R.drawable.fondoperfil)
    val vrPerfil = painterResource(R.drawable.vr)

    //Pagina
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Row (modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Mi perfíl", fontSize = 24.sp, fontWeight = FontWeight(600), modifier = Modifier.padding(start = 130.dp))
            Icon(painter = iconSettings, contentDescription = "")
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
        Row (
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(painter = index, contentDescription ="",modifier =  Modifier.size(50.dp) )
            Column {
                Text(text = "Juegos Favoritos", fontSize = 22.sp)
                Text(text = "Lista de juegos", fontSize = 15.sp)
            }
        }

    }
}
