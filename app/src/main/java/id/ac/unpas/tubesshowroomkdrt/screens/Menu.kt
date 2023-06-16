package id.ac.unpas.tubesshowroomkdrt.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import id.ac.unpas.tubesshowroomkdrt.R

enum class Menu(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: String
) {
    PENGELOLAAN_MOBIL(R.string.pengelolaan_mobil, Icons.Default.CarRental, "pengelolaan-mobil"),
    PENGELOLAAN_MOTOR(R.string.pengelolaan_motor, Icons.Default.TwoWheeler, "pengelolaan-motor"),
    PENGELOLAAN_PROMO(R.string.pengelolaan_promo, Icons.Default.PriceCheck, "pengelolaan-promo");

    companion object {
        fun getTabFromResource(@StringRes resource: Int): Menu {
            return when (resource) {
                R.string.pengelolaan_mobil -> PENGELOLAAN_MOBIL
                R.string.pengelolaan_motor -> PENGELOLAAN_MOTOR
                else -> PENGELOLAAN_PROMO
            }
        }
    }
}