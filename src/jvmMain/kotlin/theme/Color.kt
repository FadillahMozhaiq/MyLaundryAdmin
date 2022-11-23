package theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Blue50 = Color(0xFF782BC5)
val Blue20 = Color(0xFF541790)
val PurpleGrey80 = Color(0x88782BC5)
val Purple50 = Color(0xFFEBDBFB)
val Pink80 = Color(0xFFA8A4A4)
val Grey50 = Color(0xFF7B7777)
val Black50 = Color(0xFF585858)
val GreyBackground = Color(0xFFF9F9F9)

// ...

private val DarkColors = darkColors(
    primary = Blue50,
    primaryVariant = PurpleGrey80,
)
val LightColors = lightColors(
    primary = Blue50,
    primaryVariant = PurpleGrey80,
    secondary = Purple50,
    background = GreyBackground,
    // ...
)