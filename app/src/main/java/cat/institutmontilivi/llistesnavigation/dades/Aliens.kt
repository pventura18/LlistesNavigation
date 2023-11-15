package cat.institutmontilivi.llistesnavigation.dades

import kotlin.random.Random

data class Alien(
    val id: Int,
    val nom: String,
    val foto: String,
    val origen: String,
    val edat: Int,
    val amigable: String,
    val descobriment: Int,
    val inteligent: String
)

class Aliens {
    companion object{
        val dades = CreaAliens()

        fun CreaAliens() : List<Alien>{
            val llista = mutableListOf<Alien>()
            val llistaNoms = listOf("Josep", "Ferran", "Pol", "Xevi", "Marx", "Alex", "Antoni", "Carles", "Nayara", "Laura", "Sílvia")
            val llistaOrigen = listOf("Mart", "Júpiter", "Saturn", "Venus", "Mercuri", "La Lluna", "Plutó", "Neptú")

            for(i in 1..100){
                llista.add(
                    Alien(i, "Alien ${llistaNoms[Random.nextInt(0,11)]}",
                        "https://loremflickr.com/300/300/alien/?lock=${i+300}",
                        llistaOrigen[Random.nextInt(0,8)],
                        Random.nextInt(0, 10000),
                        if(Random.nextInt(0,2)==1) "Sí" else "No",
                        Random.nextInt(2050, 3000),
                        if(Random.nextInt(0,2)==1) "Sí" else "No"
                    )
                )
            }

            return llista
        }
    }



}