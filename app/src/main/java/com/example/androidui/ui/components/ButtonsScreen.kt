package com.example.androidui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.ui.theme.ComposeCookbookTheme

/**
 * ButtonsScreen - Compose Cookbook Entry #1
 * 
 * This screen demonstrates all Material 3 button variants including:
 * - FilledButton (Primary action)
 * - OutlinedButton (Secondary action) 
 * - TextButton (Low emphasis action)
 * - ElevatedButton (Action that needs more emphasis than outlined)
 * - FilledTonalButton (Medium emphasis action)
 * - FloatingActionButton (Primary floating action)
 * - IconButton (Icon-only actions)
 * 
 * Each button type is shown in both enabled and disabled states
 * to demonstrate the full range of Material 3 button capabilities.
 */
@Composable
fun ButtonsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Header
        Text(
            text = "Material 3 Buttons",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Explore the complete range of Material 3 button components with enhanced styling",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        // Filled Buttons Section
        ButtonSection(
            title = "Filled Buttons",
            description = "High emphasis buttons for primary actions"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Enabled")
                }
                
                Button(
                    onClick = { /* Handle click */ },
                    enabled = false,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Disabled")
                }
            }
            
            // With icon
            Button(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("With Icon")
            }
        }
        
        // Outlined Buttons Section
        ButtonSection(
            title = "Outlined Buttons", 
            description = "Medium emphasis buttons for secondary actions"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Enabled")
                }
                
                OutlinedButton(
                    onClick = { /* Handle click */ },
                    enabled = false,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Disabled")
                }
            }
            
            // With icon
            OutlinedButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("With Icon")
            }
        }
        
        // Text Buttons Section
        ButtonSection(
            title = "Text Buttons",
            description = "Low emphasis buttons for tertiary actions"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Enabled")
                }
                
                TextButton(
                    onClick = { /* Handle click */ },
                    enabled = false,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Disabled")
                }
            }
        }
        
        // Elevated Buttons Section
        ButtonSection(
            title = "Elevated Buttons",
            description = "Elevated buttons for actions needing more emphasis than outlined"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                ElevatedButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Enabled")
                }
                
                ElevatedButton(
                    onClick = { /* Handle click */ },
                    enabled = false,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Disabled")
                }
            }
        }
        
        // Filled Tonal Buttons Section
        ButtonSection(
            title = "Filled Tonal Buttons",
            description = "Medium emphasis alternative to filled buttons"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                FilledTonalButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Enabled")
                }
                
                FilledTonalButton(
                    onClick = { /* Handle click */ },
                    enabled = false,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Disabled")
                }
            }
        }
        
        // Floating Action Buttons Section
        ButtonSection(
            title = "Floating Action Buttons",
            description = "Primary floating actions for key tasks"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Small FAB
                SmallFloatingActionButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
                
                // Regular FAB
                FloatingActionButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add"
                    )
                }
                
                // Large FAB
                LargeFloatingActionButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier.size(36.dp)
                    )
                }
            }
            
            // Extended FAB
            ExtendedFloatingActionButton(
                onClick = { /* Handle click */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Extended FAB")
            }
        }
        
        // Icon Buttons Section
        ButtonSection(
            title = "Icon Buttons",
            description = "Icon-only buttons for compact interfaces"
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Standard Icon Button
                IconButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite"
                    )
                }
                
                // Filled Icon Button
                FilledIconButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite"
                    )
                }
                
                // Filled Tonal Icon Button
                FilledTonalIconButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite"
                    )
                }
                
                // Outlined Icon Button
                OutlinedIconButton(
                    onClick = { /* Handle click */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite"
                    )
                }
            }
            
            // Disabled Icon Buttons
            Text(
                text = "Disabled variants:",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Handle click */ },
                    enabled = false
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings"
                    )
                }
                
                FilledIconButton(
                    onClick = { /* Handle click */ },
                    enabled = false
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings"
                    )
                }
            }
        }
        
        // Add some bottom padding for better scrolling experience
        Spacer(modifier = Modifier.height(16.dp))
    }
}

/**
 * Helper composable for organizing button sections with consistent styling
 */
@Composable
private fun ButtonSection(
    title: String,
    description: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            content()
        }
    }
}

/**
 * Preview function to visualize the ButtonsScreen in Android Studio
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonsScreenPreview() {
    ComposeCookbookTheme {
        ButtonsScreen()
    }
}

/**
 * Preview for dark theme
 */
@Preview(showBackground = true, showSystemUi = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButtonsScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        ButtonsScreen()
    }
}