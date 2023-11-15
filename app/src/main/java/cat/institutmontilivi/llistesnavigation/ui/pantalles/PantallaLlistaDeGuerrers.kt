package cat.institutmontilivi.llistesnavigation.ui.pantalles

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.llistesnavigation.R
import cat.institutmontilivi.llistesnavigation.dades.Guerrers
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLlistaDeGuerrers(
    onClickGuerrer: (Int) ->  Unit
){
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item { Text(text = "Llista de guerrers", textAlign = TextAlign.Center, fontSize = 40.sp) }
        items(Guerrers.dades){guerrer ->
            val id = guerrer.id
            ListItem(
                modifier = Modifier.clickable { onClickGuerrer(guerrer.id) },
                colors = ListItemDefaults.colors(Color.Gray, Color.White, Color.White),
                headlineText = {Text(guerrer.nom, fontWeight = FontWeight.Bold, fontSize = 20.sp)},
                supportingText = {Text(guerrer.tipus)},
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(guerrer.foto)
                            .crossfade(true)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        contentDescription = "SuperGuerrer",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clip(CircleShape)
                    )
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
                
            }
        }

    }
