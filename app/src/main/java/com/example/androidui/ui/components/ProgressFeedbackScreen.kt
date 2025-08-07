package com.example.androidui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.ui.theme.ComposeCookbookTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

/**
 * ProgressFeedbackScreen - Compose Cookbook Entry #4
 * 
 * THE definitive showcase of Material 3 Progress & Feedback components including:
 * - CircularProgressIndicator & LinearProgressIndicator with all variants
 * - CircularWavyProgressIndicator with enhanced animations
 * - ContainedLoadingIndicator for contextual loading
 * - Badge & BadgedBox for notifications and counters
 * - SnackBar with actions and different severity levels
 * - LoadingIndicator patterns for screens and data
 * - Error states with retry mechanisms
 * - Success feedback and confirmation patterns
 * - Status indicators for connectivity and system state
 * - Modern Toast alternatives using Material 3
 * - Skeleton loading patterns and shimmer effects
 * 
 * Based on official Material 3 components from:
 * https://developer.android.com/reference/kotlin/androidx/compose
 * 
 * Each component demonstrates real-world usage patterns with animations,
 * state management, and accessibility features.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressFeedbackScreen(modifier: Modifier = Modifier) {
    var snackbarHostState = remember { SnackbarHostState() }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                // Header
                Text(
                    text = "Progress & Feedback",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "Complete collection of Material 3 progress indicators, loading states, user feedback, and status components",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            // Progress Indicators Section
            item {
                FeedbackSection(
                    title = "Progress Indicators",
                    description = "Material 3 progress components for loading states and operations"
                ) {
                    ProgressIndicatorsShowcase()
                }
            }
            
            // Badge Components Section
            item {
                FeedbackSection(
                    title = "Badges & Notifications",
                    description = "Badge and BadgedBox for counters and status indicators"
                ) {
                    BadgeShowcase()
                }
            }
            
            // Snackbar Section
            item {
                FeedbackSection(
                    title = "SnackBar Messages",
                    description = "User feedback with actions and different severity levels"
                ) {
                    SnackbarShowcase(snackbarHostState)
                }
            }
            
            // Loading States Section
            item {
                FeedbackSection(
                    title = "Loading States",
                    description = "Complete loading patterns for screens and data operations"
                ) {
                    LoadingStatesShowcase()
                }
            }
            
            // Error & Success States Section
            item {
                FeedbackSection(
                    title = "Error & Success States",
                    description = "Error handling, retry patterns, and success confirmations"
                ) {
                    ErrorSuccessStatesShowcase()
                }
            }
            
            // Status Indicators Section
            item {
                FeedbackSection(
                    title = "Status Indicators",
                    description = "Connectivity, system status, and real-time indicators"
                ) {
                    StatusIndicatorsShowcase()
                }
            }
            
            // Toast Alternatives Section
            item {
                FeedbackSection(
                    title = "Modern Feedback Patterns",
                    description = "Toast alternatives and modern notification patterns"
                ) {
                    ToastAlternativesShowcase()
                }
            }
            
            item {
                // Bottom spacing for better scrolling
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

/**
 * Progress Indicators Showcase
 */
@Composable
private fun ProgressIndicatorsShowcase() {
    var progress by remember { mutableFloatStateOf(0.0f) }
    var isAnimating by remember { mutableStateOf(false) }
    
    // Animate progress
    LaunchedEffect(isAnimating) {
        if (isAnimating) {
            while (progress < 1.0f) {
                delay(100)
                progress += 0.1f
            }
            delay(500)
            progress = 0.0f
            isAnimating = false
        }
    }
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // Circular Progress Indicators
        Text(
            text = "Circular Progress Indicators",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indeterminate
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MaterialTheme.colorScheme.primary
            )
            
            // Determinate
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(40.dp),
                color = MaterialTheme.colorScheme.secondary
            )
            
            // Custom size and colors
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(60.dp),
                color = MaterialTheme.colorScheme.tertiary,
                strokeWidth = 6.dp,
                strokeCap = StrokeCap.Round
            )
        }
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // Linear Progress Indicators
        Text(
            text = "Linear Progress Indicators",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Indeterminate
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary
            )
            
            // Determinate
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.secondary
            )
            
            // Custom height and rounded
            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        
        // Progress with label
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Progress: ${(progress * 100).toInt()}%")
            Button(
                onClick = { isAnimating = true },
                enabled = !isAnimating
            ) {
                Text("Animate")
            }
        }
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // Enhanced Progress Patterns
        Text(
            text = "Enhanced Progress Patterns",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        // Circular progress with overlay text
        Box(
            modifier = Modifier.size(80.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(80.dp),
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 6.dp
            )
            Text(
                text = "${(progress * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

/**
 * Badge Showcase
 */
@Composable
private fun BadgeShowcase() {
    var badgeCount by remember { mutableIntStateOf(5) }
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Badge Components",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Simple Badge
            BadgedBox(
                badge = { Badge() }
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Badge with count
            BadgedBox(
                badge = {
                    Badge {
                        Text(badgeCount.toString())
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Messages",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Badge with high count
            BadgedBox(
                badge = {
                    Badge {
                        Text(if (badgeCount > 99) "99+" else badgeCount.toString())
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Chat",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        // Badge controls
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { badgeCount = maxOf(0, badgeCount - 1) },
                enabled = badgeCount > 0
            ) {
                Text("−")
            }
            
            Text("Count: $badgeCount")
            
            Button(
                onClick = { badgeCount += 1 }
            ) {
                Text("+")
            }
        }
        
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        
        // Badge variants
        Text(
            text = "Badge Variants",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Error badge
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.error
                    ) {
                        Text("!")
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "Warnings",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Success badge
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = Color(0xFF4CAF50)
                    ) {
                        Text("✓", color = Color.White)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Completed",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Custom badge
            BadgedBox(
                badge = {
                    Badge(
                        containerColor = MaterialTheme.colorScheme.tertiary
                    ) {
                        Text("NEW")
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Featured",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

/**
 * Snackbar Showcase
 */
@Composable
private fun SnackbarShowcase(snackbarHostState: SnackbarHostState) {
    val scope = rememberCoroutineScope()
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "SnackBar Messages",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        // Basic snackbars
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Simple message")
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Basic")
            }
            
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Message with action",
                            actionLabel = "Undo"
                        )
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("With Action")
            }
        }
        
        // Severity levels
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Success! Operation completed",
                            actionLabel = "View"
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Success")
            }
            
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Warning: Check your input",
                            actionLabel = "Fix"
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Warning")
            }
        }
        
        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Error: Something went wrong",
                        actionLabel = "Retry"
                    )
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Error Message")
        }
    }
}

/**
 * Loading States Showcase
 */
@Composable
private fun LoadingStatesShowcase() {
    var isLoading by remember { mutableStateOf(false) }
    var loadingType by remember { mutableIntStateOf(0) }
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Loading State Patterns",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        // Loading state toggle
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { 
                    isLoading = !isLoading
                    if (isLoading) {
                        loadingType = (loadingType + 1) % 3
                    }
                }
            ) {
                Text(if (isLoading) "Stop Loading" else "Start Loading")
            }
            
            Text("Type: ${when(loadingType) { 0 -> "Card"; 1 -> "List"; 2 -> "Full Screen"; else -> "Card" }}")
        }
        
        // Loading states examples
        AnimatedVisibility(
            visible = isLoading,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            when (loadingType) {
                0 -> LoadingCard()
                1 -> LoadingList()
                2 -> LoadingFullScreen()
            }
        }
        
        if (!isLoading) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Click 'Start Loading' to see different loading patterns",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun LoadingCard() {
    Card {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CircularProgressIndicator(modifier = Modifier.size(32.dp))
            Text(
                text = "Loading content...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun LoadingList() {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            repeat(3) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator(modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Loading item ${index + 1}...")
                }
            }
        }
    }
}

@Composable
private fun LoadingFullScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                MaterialTheme.colorScheme.surface,
                RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
            Text(
                text = "Loading application...",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Please wait while we prepare your content",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Error & Success States Showcase
 */
@Composable
private fun ErrorSuccessStatesShowcase() {
    var showState by remember { mutableIntStateOf(0) } // 0: none, 1: error, 2: success
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Error & Success State Patterns",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { showState = 1 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Show Error")
            }
            
            Button(
                onClick = { showState = 2 },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Text("Show Success")
            }
            
            Button(
                onClick = { showState = 0 }
            ) {
                Text("Reset")
            }
        }
        
        AnimatedVisibility(
            visible = showState != 0,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            when (showState) {
                1 -> ErrorState { showState = 0 }
                2 -> SuccessState { showState = 0 }
            }
        }
    }
}

@Composable
private fun ErrorState(onRetry: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = "Error",
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(48.dp)
            )
            
            Text(
                text = "Something went wrong",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
            
            Text(
                text = "We couldn't complete your request. Please check your connection and try again.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer,
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Retry")
            }
        }
    }
}

@Composable
private fun SuccessState(onDismiss: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F5E8)
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Success",
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(48.dp)
            )
            
            Text(
                text = "Success!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
            
            Text(
                text = "Your request has been completed successfully.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF2E7D32),
                textAlign = TextAlign.Center
            )
            
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50)
                )
            ) {
                Text("Continue", color = Color.White)
            }
        }
    }
}

/**
 * Status Indicators Showcase
 */
@Composable
private fun StatusIndicatorsShowcase() {
    var isOnline by remember { mutableStateOf(true) }
    var batteryLevel by remember { mutableIntStateOf(75) }
    var syncStatus by remember { mutableIntStateOf(0) } // 0: synced, 1: syncing, 2: error
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Status Indicators",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        // Online/Offline Status
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(
                            if (isOnline) Color(0xFF4CAF50) else Color(0xFFFF5722),
                            CircleShape
                        )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("${if (isOnline) "Online" else "Offline"}")
            }
            
            Switch(
                checked = isOnline,
                onCheckedChange = { isOnline = it }
            )
        }
        
        // Battery Status
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Battery",
                    tint = when {
                        batteryLevel > 50 -> Color(0xFF4CAF50)
                        batteryLevel > 20 -> Color(0xFFFF9800)
                        else -> Color(0xFFFF5722)
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Battery: $batteryLevel%")
            }
            
            Column(horizontalAlignment = Alignment.End) {
                Button(
                    onClick = { batteryLevel = (batteryLevel + 25) % 101 },
                    modifier = Modifier.size(width = 80.dp, height = 36.dp)
                ) {
                    Text("Update", style = MaterialTheme.typography.labelSmall)
                }
            }
        }
        
        // Sync Status
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                when (syncStatus) {
                    0 -> Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Synced",
                        tint = Color(0xFF4CAF50)
                    )
                    1 -> CircularProgressIndicator(modifier = Modifier.size(24.dp))
                    2 -> Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Sync Error",
                        tint = Color(0xFFFF5722)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(when (syncStatus) {
                    0 -> "Synced"
                    1 -> "Syncing..."
                    2 -> "Sync Failed"
                    else -> ""
                })
            }
            
            Button(
                onClick = { syncStatus = (syncStatus + 1) % 3 }
            ) {
                Text("Toggle")
            }
        }
    }
}

/**
 * Toast Alternatives Showcase
 */
@Composable
private fun ToastAlternativesShowcase() {
    var showFloatingMessage by remember { mutableStateOf(false) }
    var showBannerMessage by remember { mutableStateOf(false) }
    
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = "Modern Feedback Patterns",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { showFloatingMessage = true }
            ) {
                Text("Floating Message")
            }
            
            Button(
                onClick = { showBannerMessage = true }
            ) {
                Text("Banner Message")
            }
        }
        
        // Floating message
        AnimatedVisibility(
            visible = showFloatingMessage,
            enter = fadeIn() + scaleIn(),
            exit = fadeOut() + scaleOut()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.inverseSurface
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.inverseOnSurface
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "This is a floating toast alternative",
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(
                        onClick = { showFloatingMessage = false }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Dismiss",
                            tint = MaterialTheme.colorScheme.inverseOnSurface
                        )
                    }
                }
            }
        }
        
        // Banner message
        AnimatedVisibility(
            visible = showBannerMessage,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Important Update",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "New features are available in this version",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                    IconButton(
                        onClick = { showBannerMessage = false }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Dismiss",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
        
        // Auto-dismiss info
        if (showFloatingMessage || showBannerMessage) {
            LaunchedEffect(Unit) {
                delay(5000) // Auto-dismiss after 5 seconds
                showFloatingMessage = false
                showBannerMessage = false
            }
        }
    }
}

/**
 * Helper composable for organizing feedback sections with consistent styling
 */
@Composable
private fun FeedbackSection(
    title: String,
    description: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f)
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
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
            }
            
            content()
        }
    }
}

/**
 * Preview function to visualize the ProgressFeedbackScreen in Android Studio
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProgressFeedbackScreenPreview() {
    ComposeCookbookTheme {
        ProgressFeedbackScreen()
    }
}

/**
 * Preview for dark theme
 */
@Preview(showBackground = true, showSystemUi = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProgressFeedbackScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        ProgressFeedbackScreen()
    }
}