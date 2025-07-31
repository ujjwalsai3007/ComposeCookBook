package com.example.androidui.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidui.ui.components.ButtonsScreen
import com.example.androidui.ui.components.CardsScreen
import com.example.androidui.ui.components.ComponentCatalogScreen

/**
 * Main navigation composable for the Compose Cookbook app
 * 
 * This handles the navigation between the component catalog and
 * individual component demonstration screens.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeCookbookNavigation(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentScreen = Screen.getScreenByRoute(currentRoute ?: "")
    
    Scaffold(
        topBar = {
            ComposeCookbookTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.CATALOG,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Main catalog screen
            composable(NavigationRoutes.CATALOG) {
                ComponentCatalogScreen(
                    onCategoryClick = { route ->
                        navController.navigate(route)
                    }
                )
            }
            
            // Individual component screens
            composable(NavigationRoutes.BUTTONS) {
                ButtonsScreen()
            }
            
            composable(NavigationRoutes.CARDS) {
                CardsScreen()
            }
            
            composable(NavigationRoutes.NAVIGATION) {
                PlaceholderScreen(
                    title = "Navigation Components",
                    description = "Coming soon! Bottom navigation, navigation drawer, top app bar, and tab components."
                )
            }
            
            composable(NavigationRoutes.INPUT) {
                PlaceholderScreen(
                    title = "Input & Forms",
                    description = "Coming soon! Text fields, dropdowns, autocomplete, and form validation components."
                )
            }
            
            composable(NavigationRoutes.FEEDBACK) {
                PlaceholderScreen(
                    title = "Feedback & Status",
                    description = "Coming soon! Progress indicators, snackbars, alerts, and status components."
                )
            }
            
            composable(NavigationRoutes.SELECTION) {
                PlaceholderScreen(
                    title = "Selection Controls",
                    description = "Coming soon! Checkboxes, radio buttons, switches, chips, and sliders."
                )
            }
            
            composable(NavigationRoutes.LISTS) {
                PlaceholderScreen(
                    title = "Lists & Data Display",
                    description = "Coming soon! Lazy lists, grids, data tables, and collection components."
                )
            }
            
            composable(NavigationRoutes.DIALOGS) {
                PlaceholderScreen(
                    title = "Dialogs & Overlays",
                    description = "Coming soon! Alert dialogs, bottom sheets, tooltips, and overlay components."
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ComposeCookbookTopBar(
    currentScreen: Screen?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = {
            currentScreen?.let { screen ->
                Text(
                    text = screen.title,
                    fontWeight = FontWeight.SemiBold
                )
            }
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Navigate back"
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

/**
 * Placeholder screen for components that haven't been implemented yet
 */
@Composable
private fun PlaceholderScreen(
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "🚧 $title",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Text(
                text = "This component is in development and will be available soon with comprehensive examples and copy-paste ready code.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}