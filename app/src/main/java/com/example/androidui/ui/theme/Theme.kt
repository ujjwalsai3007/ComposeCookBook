package com.example.androidui.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * Compose Cookbook - Material 3 Expressive Theme
 * 
 * This theme implements a vibrant, modern color scheme that showcases
 * the full expressive potential of Material 3 design system.
 */

private val LightColorScheme = lightColorScheme(
    primary = Primary40,
    onPrimary = Color.White,
    primaryContainer = Primary80,
    onPrimaryContainer = Primary20,
    
    secondary = Secondary40,
    onSecondary = Color.White,
    secondaryContainer = Secondary80,
    onSecondaryContainer = Secondary20,
    
    tertiary = Tertiary40,
    onTertiary = Color.White,
    tertiaryContainer = Tertiary80,
    onTertiaryContainer = Tertiary20,
    
    error = Error40,
    onError = Color.White,
    errorContainer = Error80,
    onErrorContainer = Error20,
    
    background = Background,
    onBackground = Color(0xFF1A1C1E),
    
    surface = Surface,
    onSurface = Color(0xFF1A1C1E),
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = Color(0xFF49454F),
    
    outline = Outline,
    outlineVariant = Color(0xFFCAC4D0),
    
    inverseSurface = Color(0xFF2F3033),
    inverseOnSurface = Color(0xFFF1F0F4),
    inversePrimary = Primary80,
)

private val DarkColorScheme = darkColorScheme(
    primary = Primary80,
    onPrimary = Primary20,
    primaryContainer = Primary20,
    onPrimaryContainer = Primary90,
    
    secondary = Secondary80,
    onSecondary = Secondary20,
    secondaryContainer = Secondary20,
    onSecondaryContainer = Secondary90,
    
    tertiary = Tertiary80,
    onTertiary = Tertiary20,
    tertiaryContainer = Tertiary20,
    onTertiaryContainer = Tertiary90,
    
    error = Error80,
    onError = Error20,
    errorContainer = Error20,
    onErrorContainer = Error90,
    
    background = BackgroundDark,
    onBackground = Color(0xFFE3E2E6),
    
    surface = SurfaceDark,
    onSurface = Color(0xFFE3E2E6),
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = Color(0xFFCAC4D0),
    
    outline = OutlineDark,
    outlineVariant = Color(0xFF49454F),
    
    inverseSurface = Color(0xFFE3E2E6),
    inverseOnSurface = Color(0xFF2F3033),
    inversePrimary = Primary40,
)

@Composable
fun ComposeCookbookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // Set to false to use our custom expressive colors
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// Alias for backward compatibility
@Composable
fun AndroidUITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    ComposeCookbookTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor,
        content = content
    )
}