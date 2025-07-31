package com.example.androidui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidui.ui.components.ButtonsScreen
import com.example.androidui.ui.theme.ComposeCookbookTheme

/**
 * MainActivity - Compose Cookbook
 * 
 * Entry point for the Compose Cookbook app showcasing Material 3 components
 * with our custom Expressive theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookbookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Showcase our first component - ButtonsScreen
                    ButtonsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposeCookbookAppPreview() {
    ComposeCookbookTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ButtonsScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}