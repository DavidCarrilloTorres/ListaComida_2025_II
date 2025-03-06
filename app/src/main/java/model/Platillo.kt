package model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val stringResourseId: Int,
    @DrawableRes val drawableResId: Int,
    val precio: String,
    val oferta: Boolean
)
