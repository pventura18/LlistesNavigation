package cat.institutmontilivi.llistesnavigation.ui.pantalles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Preview
@Composable
fun PantallaPrincipalPreview(){
    PantallaPrincipal({}, {}, {})
}


@Composable
fun PantallaPrincipal(
    onLlistaDeGuerrersClick: () -> Unit,
    onLlistaOrdinadorsClick: () -> Unit,
    onLlistaAliensClick: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ){

        Button(onClick = {onLlistaDeGuerrersClick()},
            modifier = Modifier.fillMaxWidth()){
            Text(text = "Llista Guerrers",
                style = MaterialTheme.typography.headlineLarge)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {onLlistaOrdinadorsClick()},
            modifier = Modifier.fillMaxWidth()){
            Text(text = "Llista Ordinadors",
                style = MaterialTheme.typography.headlineLarge)
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {onLlistaAliensClick()},
            modifier = Modifier.fillMaxWidth()){
            Text(text = "Llista Aliens",
                style = MaterialTheme.typography.headlineLarge)
        }
    }
}