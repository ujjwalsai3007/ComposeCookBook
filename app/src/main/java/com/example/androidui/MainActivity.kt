package com.example.androidui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidui.ui.navigation.ComposeCookbookNavigation
import com.example.androidui.ui.theme.ComposeCookbookTheme

/**
 * MainActivity - Compose Cookbook
 * 
 * Entry point for the Compose Cookbook app - the ultimate Material 3 
 * components library with production-ready code examples.
 * 
 * Features:
 * - Component catalog with search and filtering
 * - Navigation between component categories  
 * - Copy-paste ready code examples
 * - Dark/Light theme support
 * - Material 3 Enhanced design system
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookbookTheme {
                ComposeCookbookNavigation()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeCookbookAppPreview() {
    ComposeCookbookTheme {
        ComposeCookbookNavigation()
    }
}