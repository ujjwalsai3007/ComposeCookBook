package com.example.androidui.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Compose Cookbook - Modern Typography Scale
 * 
 * This typography uses a combination of modern, readable fonts:
 * - Headlines: Montserrat (geometric, modern feel)
 * - Body Text: Source Sans Pro (excellent readability)
 * 
 * To add these fonts to your project:
 * 1. Download the font files from Google Fonts
 * 2. Place them in app/src/main/res/font/ directory
 * 3. Create font resources:
 *    - montserrat_regular.ttf
 *    - montserrat_medium.ttf  
 *    - montserrat_semibold.ttf
 *    - source_sans_pro_regular.ttf
 *    - source_sans_pro_medium.ttf
 * 4. Define FontFamily objects using Font() resources
 * 
 * For now, we're using FontFamily.Default as a fallback
 */

// Modern Typography Scale for Compose Cookbook
val Typography = Typography(
    // Display Styles - Used for the largest text
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    
    // Headline Styles - Used for main headings
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    
    // Title Styles - Used for smaller headings
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Montserrat when added
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    
    // Body Styles - Used for main text content
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    
    // Label Styles - Used for buttons, tabs, etc.
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default, // Replace with Source Sans Pro when added
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)