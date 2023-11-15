package cat.institutmontilivi.llistesnavigation.navegacio

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destinacio(
    val rutaBase : String,
    val argumentsDeNavegacio : List<ArgumentDeNavegacio> = emptyList(),

    ) {
    val rutaGenerica = run {
        val claus = argumentsDeNavegacio.map{
            "{${it.clau}}"
        }
        listOf(rutaBase)
            .plus(claus)
            .joinToString(separator = "/")
    }

    val navArgs = argumentsDeNavegacio.map { it.toNavArgument() }

    object Principal : Destinacio(rutaBase = "Principal")

    object LlistaDeGuerrers : Destinacio(rutaBase = "LlistaDeGuerrers")

    object LlistaOrdinadors : Destinacio(rutaBase = "LlistaOrdinadors")

    object LlistaAliens : Destinacio(rutaBase = "LlistaAliens")

    object Guerrer : Destinacio(rutaBase = "Guerrer",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Id)
    ){
        fun creaRutaEspecifica(id : Int) = "$rutaBase/${id.toString()}"
    }

    object Ordinador : Destinacio(rutaBase = "Ordinador",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Id)
    ){
        fun creaRutaEspecifica(id : Int) = "$rutaBase/${id.toString()}"
    }

    object Alien : Destinacio(rutaBase = "Alien",
        argumentsDeNavegacio = listOf(ArgumentDeNavegacio.Id)
    ){
        fun creaRutaEspecifica(id : Int) = "$rutaBase/${id.toString()}"
    }
}

enum class ArgumentDeNavegacio(
    val clau : String,
    val tipus : NavType<*>
) {
    Id(clau = "Id", tipus = NavType.StringType);

    fun toNavArgument() : NamedNavArgument {
        return navArgument(clau){tipus}
    }
}