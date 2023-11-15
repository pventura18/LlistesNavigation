package cat.institutmontilivi.llistesnavigation.navegacio

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaAlien
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaGuerrer
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaLlistaAliens
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaLlistaDeGuerrers
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaLlistaOrdinadors
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaOrdinador
import cat.institutmontilivi.llistesnavigation.ui.pantalles.PantallaPrincipal

@Composable
fun GrafDeNavegacio() {
    val controladorDeNavegacio = rememberNavController()
    NavHost(
        navController = controladorDeNavegacio,
        startDestination = Destinacio.Principal.rutaGenerica
    ) {
        composable(
            route = Destinacio.Principal.rutaGenerica
        ) {
            PantallaPrincipal(
                onLlistaDeGuerrersClick = { controladorDeNavegacio.navigate(Destinacio.LlistaDeGuerrers.rutaGenerica) },
                onLlistaOrdinadorsClick = { controladorDeNavegacio.navigate(Destinacio.LlistaOrdinadors.rutaGenerica)},
                onLlistaAliensClick = { controladorDeNavegacio.navigate(Destinacio.LlistaAliens.rutaGenerica)}
            )
        }

        composable(
            Destinacio.LlistaDeGuerrers.rutaGenerica
        ) {
            PantallaLlistaDeGuerrers(onClickGuerrer = {id : Int ->
                controladorDeNavegacio.navigate(Destinacio.Guerrer.creaRutaEspecifica(id))
            })
        }

        composable(
            Destinacio.LlistaOrdinadors.rutaGenerica
        ) {
            PantallaLlistaOrdinadors(
                onClickOrdinador = {id : Int ->
                    controladorDeNavegacio.navigate(Destinacio.Ordinador.creaRutaEspecifica(id))
                }
            )
        }

        composable(
            Destinacio.LlistaAliens.rutaGenerica
        ) {
            PantallaLlistaAliens(
                onClickAlien = {id : Int ->
                    controladorDeNavegacio.navigate(Destinacio.Alien.creaRutaEspecifica(id))
                }
            )
        }

        composable(
            route = Destinacio.Guerrer.rutaGenerica,
            arguments = Destinacio.Guerrer.navArgs
        ){navBackStackEntry->
            val id = navBackStackEntry.arguments?.getString(ArgumentDeNavegacio.Id.clau)

            Log.d("POL", "Aqui id val: $id")

            requireNotNull(id, {"L'id no pot ser null!"})

            PantallaGuerrer(id.toInt())
        }

        composable(
            route = Destinacio.Ordinador.rutaGenerica,
            arguments = Destinacio.Ordinador.navArgs
        ){
            val id = it.arguments?.getString(ArgumentDeNavegacio.Id.clau)

            requireNotNull(id, {"L'id no pot ser null!"})

            PantallaOrdinador(id.toInt())
        }

        composable(
            route = Destinacio.Alien.rutaGenerica,
            arguments = Destinacio.Alien.navArgs
        ){
            val id = it.arguments?.getString(ArgumentDeNavegacio.Id.clau)

            requireNotNull(id, {"L'id no pot ser null!"})

            PantallaAlien(id.toInt())
        }

    }
}