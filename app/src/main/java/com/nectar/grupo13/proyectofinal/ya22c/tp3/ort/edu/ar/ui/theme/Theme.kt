package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)
//
//@Composable
//fun NectarTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//        val context = LocalContext.current
//        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//      }
//      darkTheme -> DarkColorScheme
//      else -> LightColorScheme
//    }
//
//    MaterialTheme(
//      colorScheme = colorScheme,
//      typography = Typography,
//      content = content
//    )
//}

// Light theme color scheme
private val LightColors = lightColorScheme(
    primary = Color(0xFF4CAF50), // Green background color
    onPrimary = Color.Black
)

// Dark theme color scheme
private val DarkColors = darkColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White
)

// The custom fonts are set at a top level, so it can be reused throughout the entire project
val gilroyFontFamily = FontFamily(
    Font(R.font.gilroy_light, FontWeight.W100, FontStyle.Normal),
    Font(R.font.gilroy_thin, FontWeight.W200, FontStyle.Normal),
    Font(R.font.gilroy_regular, FontWeight.W300, FontStyle.Normal),
    Font(R.font.gilroy_medium, FontWeight.W400, FontStyle.Normal),
    Font(R.font.gilroy_semi_bold, FontWeight.W500, FontStyle.Normal),
    Font(R.font.gilroy_black, FontWeight.W600, FontStyle.Normal),
    Font(R.font.gilroy_bold, FontWeight.W700, FontStyle.Normal),
    Font(R.font.gilroy_bold_italic, FontWeight.W700, FontStyle.Italic),
    Font(R.font.gilroy_extra_bold, FontWeight.W800, FontStyle.Normal),
    Font(R.font.gilroy_heavy, FontWeight.W800, FontStyle.Normal),
)

@Composable
fun NectarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
//        colorScheme = colors,
        typography = Typography,
        content = content
    )
}