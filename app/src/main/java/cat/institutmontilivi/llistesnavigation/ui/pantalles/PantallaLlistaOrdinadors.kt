package cat.institutmontilivi.llistesnavigation.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.llistesnavigation.R
import cat.institutmontilivi.llistesnavigation.dades.Guerrers
import cat.institutmontilivi.llistesnavigation.dades.Ordinadors
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaLlistaOrdinadors(
    onClickOrdinador: (Int) ->  Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item { Text(text = "Llista d'ordinadors", fontSize = 45.sp) }
        items(Ordinadors.dades) {
            ListItem(
                modifier = Modifier.clickable { onClickOrdinador(it.id) },
                colors = ListItemDefaults.colors(Color.Gray, Color.White, Color.White),
                headlineText = { Text(it.nom, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                supportingText = { Text(it.marca) },
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.foto)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "Ordinador",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape)
                    )
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

        }
    }


}