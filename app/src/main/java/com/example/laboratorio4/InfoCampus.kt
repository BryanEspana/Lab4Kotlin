package com.example.laboratorio4
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme

@Composable
fun infoCampus(onNavigatePerfil: () -> Unit){
    val scrollState = rememberScrollState()
    //Icons
    val iconUSer = painterResource(id = R.drawable.baseline_person_24)
    //Imagenes
    val imagefondo = painterResource(id = R.drawable.fondo)
    val imageBiolo = painterResource(id = R.drawable.alyx)
    val imageEntrada = painterResource(id = R.drawable.paradise)
    val imageDoom = painterResource(id = R.drawable.doom)
    val imageBeet = painterResource(id = R.drawable.bet )

    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Games VR", fontSize = 24.sp, fontWeight = FontWeight(600) , modifier = Modifier.padding(vertical = 15.dp))
            IconButton(onClick = onNavigatePerfil ) {
                Icon(painter = iconUSer, contentDescription = "", modifier = Modifier
                    .size(48.dp)
                    .border(
                        width = 2.dp, // Ancho del borde
                        color = Color.White, // Color del borde
                        shape = RoundedCornerShape(100.dp) // Radios para la parte superior
                    )
                    .padding(5.dp)
                )
            }

        }
        Box(modifier = Modifier
            .fillMaxSize()){
            Column( Modifier.fillMaxSize()) {
                Image(imagefondo,"", Modifier
                    .fillMaxWidth(), contentScale = ContentScale.FillWidth)
                Text(text = "DESTACADOS", fontSize = 18.sp, modifier = Modifier
                    .padding( vertical = 20.dp, horizontal = 15.dp), color = Color.Gray)

                Row {
                    Column (modifier = Modifier
                        .padding(10.dp)
                        .width(180.dp)) {
                        Image(painter = imageBiolo, contentDescription ="", modifier = Modifier
                            .size(180.dp)
                            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                            , contentScale = ContentScale.Crop )
                        Box(modifier = Modifier
                            .background(
                                Color.Black,
                                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                            )
                            .width(180.dp)
                            .height(50.dp)
                            .padding(start = 10.dp, top = 10.dp)
                            )
                        {
                            Text(text = "Half life Alyx", color = Color.White, fontSize = 20.sp)
                        }
                    }
                    Column (modifier = Modifier
                        .padding(10.dp)
                        .width(180.dp)) {
                        Image(painter = imageEntrada, contentDescription ="Biolo", modifier = Modifier
                            .size(180.dp)
                            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                            , contentScale = ContentScale.Crop )
                        Box(modifier = Modifier
                            .background(
                                Color(0x21, 0x35, 0x88),
                                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                            )
                            .width(180.dp)
                            .height(50.dp)
                            .padding(start = 10.dp, top = 10.dp)
                        )
                        {
                            Text(text = "Paradise Hotel", color = Color.White, fontSize = 20.sp)
                        }
                    }
                }
                Text(text = "SERVICIOS Y RECURSOS", fontSize = 18.sp, modifier = Modifier.padding( vertical = 20.dp, horizontal = 15.dp), color = Color.Gray)
                Row {
                    Column (modifier = Modifier.padding(10.dp)) {
                        Image(painter = imageDoom, contentDescription ="Biolo", modifier = Modifier
                            .size(180.dp), contentScale = ContentScale.Crop,  )
                        Box(modifier = Modifier
                            .background(
                                Color(0x156, 0x7, 0x19),
                                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(horizontal = 32.dp, vertical = 15.dp)
                            ,

                            )
                        {
                            Text(text = "Doom VFR", color = Color.White, fontSize = 20.sp)
                        }
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        Image(painter = imageBeet, contentDescription = "Entrada", modifier = Modifier
                            .size(180.dp)
                            , contentScale = ContentScale.Crop )
                        Box(modifier = Modifier
                            .background(
                                Color(0x0, 0x0, 0x0),
                                shape = RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(horizontal = 30.dp, vertical = 18.dp),

                            )
                        {
                            Text(text = "Beet Saber", color = Color.White, fontSize = 15.sp)
                        }
                    }
                }

            }

        }


    }
    /*
    Button(onClick = onNavigatePerfil) {
        Text("Ir a perfil")
    }
    * */

}
