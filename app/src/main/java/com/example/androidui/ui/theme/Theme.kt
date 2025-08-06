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
 * Compose Cookbook - Material 3 Enhanced Theme
 * 
 * Custom Material 3 theming inspired by expressive design principles:
 * - Enhanced dynamic color engine with improved vibrancy
 * - Better contrast ratios for improved UI element recognition  
 * - Emotional design connections for user engagement
 * - Modern theming patterns and best practices
 * - Surface tinting and improved depth perception
 * 
 * This theme showcases enhanced Material 3 theming capabilities
 * with modern design principles and accessibility improvements.
 */

private val LightColorScheme = lightColorScheme(
    // Primary colors - Enhanced M3 vibrancy
    primary = Primary40,
    onPrimary = Color.White,
    primaryContainer = Primary80,
    onPrimaryContainer = Primary20,
    
    // Secondary colors - Warmer, more emotional
    secondary = Secondary40,
    onSecondary = Color.White,
    secondaryContainer = Secondary80,
    onSecondaryContainer = Secondary20,
    
    // Tertiary colors - Richer, more expressive
    tertiary = Tertiary40,
    onTertiary = Color.White,
    tertiaryContainer = Tertiary80,
    onTertiaryContainer = Tertiary20,
    
    // Error colors - Clear, accessible
    error = Error40,
    onError = Color.White,
    errorContainer = Error80,
    onErrorContainer = Error20,
    
    // Background - M3 Expressive warmer neutrals
    background = Background,
    onBackground = OnContainer,
    
    // Surface - Enhanced with better contrast
    surface = Surface,
    onSurface = OnContainer,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = Color(0xFF49454E),
    
    // Outline - Improved contrast for M3 Enhanced
    outline = Outline,
    outlineVariant = OutlineVariant,
    
    // Inverse colors for dynamic theming
    inverseSurface = Color(0xFF2F3033),
    inverseOnSurface = Color(0xFFF1F0F4),
    inversePrimary = Primary80,
    
    // Surface tint - Enhanced M3 feature
    surfaceTint = Primary40,
)

private val DarkColorScheme = darkColorScheme(
    // Primary colors - M3 Enhanced dark mode
    primary = Primary80,
    onPrimary = Primary20,
    primaryContainer = Primary20,
    onPrimaryContainer = Primary90,
    
    // Secondary colors - Warmer dark mode palette
    secondary = Secondary80,
    onSecondary = Secondary20,
    secondaryContainer = Secondary20,
    onSecondaryContainer = Secondary90,
    
    // Tertiary colors - Richer dark mode expression
    tertiary = Tertiary80,
    onTertiary = Tertiary20,
    tertiaryContainer = Tertiary20,
    onTertiaryContainer = Tertiary90,
    
    // Error colors - Clear dark mode errors
    error = Error80,
    onError = Error20,
    errorContainer = Error20,
    onErrorContainer = Error90,
    
    // Background - Deeper, more expressive dark
    background = BackgroundDark,
    onBackground = OnContainerDark,
    
    // Surface - Enhanced dark mode surfaces
    surface = SurfaceDark,
    onSurface = OnContainerDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = Color(0xFFCAC4D0),
    
    // Outline - Better dark mode contrast
    outline = OutlineDark,
    outlineVariant = Color(0xFF49454F),
    
    // Inverse colors for dark mode dynamics
    inverseSurface = Color(0xFFE3E2E6),
    inverseOnSurface = Color(0xFF2F3033),
    inversePrimary = Primary40,
    
    // Surface tint - M3 Expressive dark mode feature
    surfaceTint = Primary80,
)

@Composable
fun ComposeCookbookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // M3 Enhanced: Dynamic color engine
    // Set to false to showcase our custom enhanced colors
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
            // M3 Enhanced: Enhanced system bar styling
            window.statusBarColor = colorScheme.surface.toArgb()
            window.navigationBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        // M3 Enhanced: Future shapes and animation curves can be added here
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