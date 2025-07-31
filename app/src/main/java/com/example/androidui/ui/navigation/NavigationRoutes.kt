package com.example.androidui.ui.navigation

/**
 * Navigation routes for the Compose Cookbook app
 * 
 * Centralized route definitions for type-safe navigation
 * between different screens in the component library.
 */
object NavigationRoutes {
    const val CATALOG = "catalog"
    const val BUTTONS = "buttons"
    const val CARDS = "cards"
    const val NAVIGATION = "navigation"
    const val INPUT = "input"
    const val FEEDBACK = "feedback"
    const val SELECTION = "selection"
    const val LISTS = "lists"
    const val DIALOGS = "dialogs"
}

/**
 * Screen destinations with additional metadata
 */
sealed class Screen(
    val route: String,
    val title: String,
    val description: String
) {
    object Catalog : Screen(
        route = NavigationRoutes.CATALOG,
        title = "Component Catalog",
        description = "Browse all available components"
    )
    
    object Buttons : Screen(
        route = NavigationRoutes.BUTTONS,
        title = "Buttons & Actions",
        description = "Interactive action components"
    )
    
    object Cards : Screen(
        route = NavigationRoutes.CARDS,
        title = "Cards & Surfaces",
        description = "Content containers and surfaces"
    )
    
    object Navigation : Screen(
        route = NavigationRoutes.NAVIGATION,
        title = "Navigation",
        description = "App navigation components"
    )
    
    object Input : Screen(
        route = NavigationRoutes.INPUT,
        title = "Input & Forms",
        description = "Text input and form controls"
    )
    
    object Feedback : Screen(
        route = NavigationRoutes.FEEDBACK,
        title = "Feedback & Status",
        description = "Progress and status indicators"
    )
    
    object Selection : Screen(
        route = NavigationRoutes.SELECTION,
        title = "Selection Controls",
        description = "Checkboxes, switches, and chips"
    )
    
    object Lists : Screen(
        route = NavigationRoutes.LISTS,
        title = "Lists & Data Display",
        description = "Data presentation components"
    )
    
    object Dialogs : Screen(
        route = NavigationRoutes.DIALOGS,
        title = "Dialogs & Overlays",
        description = "Modal and overlay components"
    )
    
    companion object {
        val allScreens = listOf(
            Catalog, Buttons, Cards, Navigation, Input, 
            Feedback, Selection, Lists, Dialogs
        )
        
        fun getScreenByRoute(route: String): Screen? {
            return allScreens.find { it.route == route }
        }
    }
}