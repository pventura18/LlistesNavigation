package cat.institutmontilivi.llistesnavigation.ui.pantalles

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.llistesnavigation.R
import cat.institutmontilivi.llistesnavigation.dades.Guerrers
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PantallaGuerrer(id : Int){
    Log.d("POL", "Id dintre de pantalla guerrers és $id")
    val guerrer = Guerrers.dades.find { it.id == id }
    Log.d("POL", "Guerrer details: $guerrer")
    Column(){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(guerrer!!.foto)
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
            Text("Nom: ${guerrer.nom}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Edat: ${guerrer.edat}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Força: ${guerrer.forca}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Resistencia: ${guerrer.resistencia}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Atac: ${guerrer.atac}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Defensa: ${guerrer.defensa}")
        }
    }
}