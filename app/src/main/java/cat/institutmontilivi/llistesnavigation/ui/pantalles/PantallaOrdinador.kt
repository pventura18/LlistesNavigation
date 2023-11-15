package cat.institutmontilivi.llistesnavigation.ui.pantalles

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.llistesnavigation.R
import cat.institutmontilivi.llistesnavigation.dades.Guerrers
import cat.institutmontilivi.llistesnavigation.dades.Ordinadors
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaOrdinador(id : Int){
    Log.d("POL", "Id dintre de pantalla ordinador és $id")
    val ordinador = Ordinadors.dades.find { it.id == id }
    Log.d("POL", "Guerrer details: $ordinador")
    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(ordinador!!.foto)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Alien",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
                .weight(1F)
        )
        Column(modifier = Modifier.weight(2F).padding(20.dp),
            verticalArrangement = Arrangement.Center){
            Text("Id: $id")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Marca: ${ordinador.marca}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Any de fabricacio: ${ordinador.anyFabricacio}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Processador: ${ordinador.processador}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Ram: ${ordinador.ram} GB")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Targeta Gràfica: ${ordinador.targetaGrafica}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Connexió WIFI: ${ordinador.connexioWiFi}")
        }
    }
}