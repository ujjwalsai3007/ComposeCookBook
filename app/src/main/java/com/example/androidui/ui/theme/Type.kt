package com.example.androidui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Compose Cookbook - Material 3 Enhanced Typography
 * 
 * Custom typography inspired by Material 3 Expressive design principles:
 * - Enhanced contrast between headers and body text for better recognition
 * - Improved readability across all device sizes
 * - Expressive typography that connects with users
 * - Varying text weights and sizes for better hierarchy
 * 
 * Key Enhanced Material 3 improvements:
 * - Bolder headlines with increased weight contrast
 * - Optimized line spacing for better flow
 * - Enhanced letter spacing for readability
 * - Dynamic sizing that adapts to content importance
 * 
 * Font recommendations for production:
 * - Headlines: Google Sans (Google's signature font) or Montserrat
 * - Body Text: Roboto Flex (variable font) or Source Sans Pro
 * - UI Elements: Google Sans Text for consistent branding
 * 
 * For now, using system defaults with Material 3 Enhanced proportions
 */

// Material 3 Enhanced Typography Scale
val Typography = Typography(
    // Display Styles - Bold, expressive headlines for maximum impact
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Display
        fontWeight = FontWeight.Bold,    // M3 Enhanced: Bolder for impact
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Display
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Increased weight
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Display
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: More emphasis
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    
    // Headline Styles - M3 Enhanced contrast
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans
        fontWeight = FontWeight.Bold,     // M3 Enhanced: Maximum contrast
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans
        fontWeight = FontWeight.Bold,     // M3 Enhanced: Stronger emphasis
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans
        fontWeight = FontWeight.Bold,     // M3 Enhanced: Clear hierarchy
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    
    // Title Styles - M3 Enhanced balanced hierarchy
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Enhanced weight
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Text
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Better contrast
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Text
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Clear distinction
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    
    // Body Styles - M3 Enhanced optimized readability
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Production: Roboto Flex
        fontWeight = FontWeight.Normal,   // M3 Enhanced: Balanced contrast
        fontSize = 16.sp,
        lineHeight = 24.sp,              // M3 Enhanced: Improved line spacing
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default, // Production: Roboto Flex
        fontWeight = FontWeight.Normal,   // M3 Enhanced: Consistent weight
        fontSize = 14.sp,
        lineHeight = 20.sp,              // M3 Enhanced: Better flow
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default, // Production: Roboto Flex
        fontWeight = FontWeight.Normal,   // M3 Enhanced: Readable small text
        fontSize = 12.sp,
        lineHeight = 16.sp,              // M3 Enhanced: Optimal spacing
        letterSpacing = 0.4.sp
    ),
    
    // Label Styles - M3 Enhanced interactive elements
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Text
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Enhanced button text
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Text
        fontWeight = FontWeight.SemiBold, // M3 Enhanced: Stronger UI labels
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default, // Production: Google Sans Text
        fontWeight = FontWeight.Medium,   // M3 Enhanced: Clear small labels
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)