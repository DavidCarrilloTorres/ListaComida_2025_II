package data

import com.example.listacomida_2025_ii.R
import model.Platillo

class DataSource {
    fun LoadPlatillos(): List<Platillo> {
        return listOf(
            Platillo(R.string.desayuno, R.drawable.desayuno, "MX $120.00", oferta = true),
            Platillo(R.string.postre, R.drawable.postre, "MX $85.00", oferta = true),
            Platillo(R.string.pozole, R.drawable.pozole, "MX $150.00", oferta = true),
            Platillo(R.string.pizza, R.drawable.pizza, "MX $200.00", oferta = false),
            Platillo(R.string.tacos, R.drawable.tacos, "MX $100.00", oferta = true),
            Platillo(R.string.hamburguer, R.drawable.hamburguer, "MX $130.00", oferta = false)
        )
    }
}
