package com.example.androidui.ui.theme

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

/**
 * Material 3 Expressive (May 2025) - Animation Utilities
 * 
 * Natural motion physics and springy animations that make interfaces
 * feel alive and responsive. Based on Google's research showing that
 * expressive animations improve user engagement and usability.
 * 
 * Key principles:
 * - Springy, natural feeling motion
 * - Responsive to user interaction
 * - Emotional connection through movement
 * - Performance optimized for all devices
 */

/**
 * M3 Expressive spring animation specifications
 * These create natural, bouncy motion that feels responsive
 */
object ExpressiveAnimations {
    
    /**
     * Primary spring for button presses and main interactions
     * Creates satisfying bounce without being distracting
     */
    val PrimarySpring = spring<Float>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessMediumLow
    )
    
    /**
     * Quick spring for micro-interactions and feedback
     * Faster response for immediate user feedback
     */
    val QuickSpring = spring<Float>(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessMedium
    )
    
    /**
     * Gentle spring for content transitions
     * Smooth, pleasant motion for larger interface changes
     */
    val GentleSpring = spring<Float>(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessLow
    )
    
    /**
     * Emphasized spring for important actions
     * More pronounced bounce for key user actions
     */
    val EmphasizedSpring = spring<Float>(
        dampingRatio = Spring.DampingRatioLowBouncy,
        stiffness = Spring.StiffnessMedium
    )
}

/**
 * Standard duration values for M3 Expressive animations
 */
object ExpressiveDurations {
    const val QUICK = 200
    const val MEDIUM = 300
    const val SLOW = 400
    const val EMPHASIZED = 500
}

/**
 * Easing curves optimized for M3 Expressive
 */
object ExpressiveEasing {
    /**
     * Standard easing for most transitions
     * Smooth, natural feeling curve
     */
    val Standard = CubicBezierEasing(0.2f, 0.0f, 0.0f, 1.0f)
    
    /**
     * Emphasized easing for important transitions
     * More dramatic curve for key moments
     */
    val Emphasized = CubicBezierEasing(0.05f, 0.7f, 0.1f, 1.0f)
    
    /**
     * Decelerated easing for entering content
     * Content appears smoothly into view
     */
    val Decelerated = CubicBezierEasing(0.0f, 0.0f, 0.2f, 1.0f)
    
    /**
     * Accelerated easing for exiting content
     * Content exits with natural acceleration
     */
    val Accelerated = CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f)
}

/**
 * M3 Expressive elevation changes for depth and hierarchy
 */
object ExpressiveElevation {
    val Level0 = 0.dp    // Surface level
    val Level1 = 1.dp    // Slightly raised
    val Level2 = 3.dp    // Cards and buttons
    val Level3 = 6.dp    // App bars and highlighted content  
    val Level4 = 8.dp    // Navigation drawers
    val Level5 = 12.dp   // Modal surfaces
}

/**
 * Helper function to create consistent tween animations
 * with M3 Expressive characteristics
 */
@Composable
fun expressiveTween(
    durationMillis: Int = ExpressiveDurations.MEDIUM,
    easing: Easing = ExpressiveEasing.Standard
): TweenSpec<Float> = tween(
    durationMillis = durationMillis,
    easing = easing
)

/**
 * Helper function for creating expressive scale animations
 * Perfect for button press feedback and micro-interactions
 */
fun expressiveScale(
    fromScale: Float = 1.0f,
    toScale: Float = 0.95f,
    duration: Int = ExpressiveDurations.QUICK
): TweenSpec<Float> = tween(
    durationMillis = duration,
    easing = ExpressiveEasing.Emphasized
)