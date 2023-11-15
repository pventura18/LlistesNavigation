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
import cat.institutmontilivi.llistesnavigation.dades.Aliens
import cat.institutmontilivi.llistesnavigation.dades.Guerrers
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaAlien(id : Int){

    val alien = Aliens.dades.find { it.id == id }

    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(alien!!.foto)
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
            Text("Nom: ${alien.nom}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Origen: ${alien.origen}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Edat: ${alien.edat}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Amigable: ${alien.amigable}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Any de descobriment: ${alien.descobriment}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Intel·ligent: ${alien.inteligent}")
        }
    }
}