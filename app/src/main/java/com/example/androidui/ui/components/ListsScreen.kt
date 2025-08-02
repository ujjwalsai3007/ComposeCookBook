package com.example.androidui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.ui.theme.ComposeCookbookTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ListsScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var searchText by remember { mutableStateOf("") }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header with search
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Lists & Data Display",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Efficient data display patterns with lazy loading and interactive features",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Search Bar
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    label = { Text("Search lists...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = { searchText = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
        
        // Tab Row
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            edgePadding = 16.dp
        ) {
            listTabItems.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(tab.title) },
                    icon = { Icon(tab.icon, contentDescription = null) }
                )
            }
        }
        
        // Content
        when (selectedTabIndex) {
            0 -> LazyColumnSection(searchText)
            1 -> LazyGridSection(searchText)
            2 -> LazyRowSection()
            3 -> ListItemSection()
            4 -> InteractiveSection()
            5 -> PerformanceSection()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LazyColumnSection(searchText: String) {
    val items = remember { generateSampleItems(50) }
    val filteredItems = remember(items, searchText) {
        if (searchText.isBlank()) items
        else items.filter { it.title.contains(searchText, ignoreCase = true) }
    }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Section header
        stickyHeader {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "LazyColumn Examples",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        
        // Basic List Items
        item {
            SectionCard(title = "Basic List Items") {
                Column {
                    repeat(3) { index ->
                        ListItem(
                            headlineContent = { Text("List Item ${index + 1}") },
                            supportingContent = { Text("Supporting text for item ${index + 1}") },
                            leadingContent = {
                                Icon(
                                    Icons.Default.Star,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            },
                            trailingContent = {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Default.MoreVert, contentDescription = "More")
                                }
                            }
                        )
                        if (index < 2) HorizontalDivider()
                    }
                }
            }
        }
        
        // Grouped Items with Sticky Headers
        item {
            SectionCard(title = "Grouped Items") {
                Text(
                    text = "Items grouped by categories with sticky headers",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        // Group headers and items
        val groupedItems = filteredItems.groupBy { it.category }
        groupedItems.forEach { (category, categoryItems) ->
            stickyHeader {
                Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            
            items(categoryItems, key = { it.id }) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItemPlacement(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    ListItem(
                        headlineContent = { Text(item.title) },
                        supportingContent = { Text(item.description) },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(item.color, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = item.title.first().toString(),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        },
                        trailingContent = {
                            Text(
                                text = "$${item.price}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                }
            }
        }
        
        // Load more indicator
        item {
            if (filteredItems.isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Showing ${filteredItems.size} items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun LazyGridSection(searchText: String) {
    val items = remember { generateSampleItems(20) }
    val filteredItems = remember(items, searchText) {
        if (searchText.isBlank()) items
        else items.filter { it.title.contains(searchText, ignoreCase = true) }
    }
    
    var gridType by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Grid type selector
        Surface(
            color = MaterialTheme.colorScheme.surfaceContainer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Fixed Grid", "Adaptive Grid", "Staggered Grid").forEachIndexed { index, title ->
                    FilterChip(
                        onClick = { gridType = index },
                        label = { Text(title) },
                        selected = gridType == index
                    )
                }
            }
        }
        
        when (gridType) {
            0 -> {
                // Fixed Grid (2 columns)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredItems, key = { it.id }) { item ->
                        ProductCard(item = item)
                    }
                }
            }
            1 -> {
                // Adaptive Grid (minimum 150dp width)
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredItems, key = { it.id }) { item ->
                        ProductCard(item = item)
                    }
                }
            }
            2 -> {
                // Staggered Grid
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredItems, key = { it.id }) { item ->
                        ProductCard(
                            item = item,
                            randomHeight = true
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun LazyRowSection() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Text(
                text = "LazyRow Examples",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        // Horizontal Categories
        item {
            SectionCard(title = "Category Pills") {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(categories) { category ->
                        AssistChip(
                            onClick = { },
                            label = { Text(category) },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Category,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        )
                    }
                }
            }
        }
        
        // Horizontal Product Carousel
        item {
            SectionCard(title = "Product Carousel") {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(10) { index ->
                        Card(
                            modifier = Modifier
                                .width(200.dp)
                                .height(140.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                        .background(
                                            MaterialTheme.colorScheme.primaryContainer,
                                            RoundedCornerShape(8.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Product ${index + 1}",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Starting at $${(index + 1) * 10}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "⭐ ${4.0 + (index % 10) * 0.1}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
        
        // User Avatars Row
        item {
            SectionCard(title = "Active Users") {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(15) { index ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(
                                        generateUserColor(index),
                                        CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = generateUserInitials(index),
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "User ${index + 1}",
                                style = MaterialTheme.typography.labelSmall,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ListItemSection() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Material 3 ListItem Components",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        // One-line items
        item {
            SectionCard(title = "One-line Items") {
                Column {
                    ListItem(
                        headlineContent = { Text("One line list item") }
                    )
                    HorizontalDivider()
                    ListItem(
                        headlineContent = { Text("With leading icon") },
                        leadingContent = { Icon(Icons.Default.Home, contentDescription = null) }
                    )
                    HorizontalDivider()
                    ListItem(
                        headlineContent = { Text("With trailing icon") },
                        trailingContent = { Icon(Icons.Default.ChevronRight, contentDescription = null) }
                    )
                }
            }
        }
        
        // Two-line items
        item {
            SectionCard(title = "Two-line Items") {
                Column {
                    ListItem(
                        headlineContent = { Text("Two line list item") },
                        supportingContent = { Text("Supporting text") }
                    )
                    HorizontalDivider()
                    ListItem(
                        headlineContent = { Text("With avatar") },
                        supportingContent = { Text("Secondary text goes here") },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(MaterialTheme.colorScheme.primary, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "A",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    )
                    HorizontalDivider()
                    ListItem(
                        headlineContent = { Text("With controls") },
                        supportingContent = { Text("Toggle this setting") },
                        trailingContent = {
                            var checked by remember { mutableStateOf(false) }
                            Switch(
                                checked = checked,
                                onCheckedChange = { checked = it }
                            )
                        }
                    )
                }
            }
        }
        
        // Three-line items
        item {
            SectionCard(title = "Three-line Items") {
                Column {
                    ListItem(
                        headlineContent = { Text("Three line list item") },
                        supportingContent = { 
                            Text("This is a longer supporting text that spans multiple lines and provides more detailed information about the item")
                        }
                    )
                    HorizontalDivider()
                    ListItem(
                        headlineContent = { Text("Message from John") },
                        supportingContent = { 
                            Text("Hey! I wanted to follow up on our meeting yesterday. Can we schedule another call to discuss the project details?")
                        },
                        leadingContent = {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .background(MaterialTheme.colorScheme.tertiary, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "J",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleLarge
                                )
                            }
                        },
                        trailingContent = {
                            Column {
                                Text(
                                    text = "2:30 PM",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Badge {
                                    Text("2")
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun InteractiveSection() {
    var expandedItems by remember { mutableStateOf(setOf<Int>()) }
    var selectedItems by remember { mutableStateOf(setOf<Int>()) }
    var pullRefreshLoading by remember { mutableStateOf(false) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Interactive Lists",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        // Pull to Refresh Demo
        item {
            SectionCard(title = "Pull to Refresh") {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Simulate pull to refresh")
                        Button(
                            onClick = {
                                pullRefreshLoading = true
                                // Simulate network delay
                            }
                        ) {
                            if (pullRefreshLoading) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(16.dp),
                                    strokeWidth = 2.dp,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            } else {
                                Text("Refresh")
                            }
                        }
                    }
                    
                    LaunchedEffect(pullRefreshLoading) {
                        if (pullRefreshLoading) {
                            delay(2000)
                            pullRefreshLoading = false
                        }
                    }
                }
            }
        }
        
        // Expandable List Items
        item {
            SectionCard(title = "Expandable Items") {
                Column {
                    repeat(3) { index ->
                        val isExpanded = expandedItems.contains(index)
                        
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize(
                                    animationSpec = spring(
                                        dampingRatio = Spring.DampingRatioMediumBouncy,
                                        stiffness = Spring.StiffnessLow
                                    )
                                ),
                            onClick = {
                                expandedItems = if (isExpanded) {
                                    expandedItems - index
                                } else {
                                    expandedItems + index
                                }
                            }
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Expandable Item ${index + 1}",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Icon(
                                        imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                        contentDescription = if (isExpanded) "Collapse" else "Expand"
                                    )
                                }
                                
                                AnimatedVisibility(
                                    visible = isExpanded,
                                    enter = fadeIn() + expandVertically(),
                                    exit = fadeOut() + shrinkVertically()
                                ) {
                                    Column {
                                        Spacer(modifier = Modifier.height(12.dp))
                                        Text(
                                            text = "This is the expanded content for item ${index + 1}. You can put any content here including more complex layouts, images, or interactive elements.",
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            TextButton(onClick = { }) {
                                                Text("Action 1")
                                            }
                                            TextButton(onClick = { }) {
                                                Text("Action 2")
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                        if (index < 2) Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
        
        // Multi-Select List
        item {
            SectionCard(title = "Multi-Select List") {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${selectedItems.size} items selected",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        if (selectedItems.isNotEmpty()) {
                            TextButton(
                                onClick = { selectedItems = emptySet() }
                            ) {
                                Text("Clear All")
                            }
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    repeat(5) { index ->
                        val isSelected = selectedItems.contains(index)
                        
                        ListItem(
                            headlineContent = { Text("Selectable Item ${index + 1}") },
                            supportingContent = { Text("Tap to select/deselect") },
                            leadingContent = {
                                Checkbox(
                                    checked = isSelected,
                                    onCheckedChange = { checked ->
                                        selectedItems = if (checked) {
                                            selectedItems + index
                                        } else {
                                            selectedItems - index
                                        }
                                    }
                                )
                            },
                            modifier = Modifier.clickable {
                                selectedItems = if (isSelected) {
                                    selectedItems - index
                                } else {
                                    selectedItems + index
                                }
                            }
                        )
                        if (index < 4) HorizontalDivider()
                    }
                }
            }
        }
    }
}

@Composable
private fun PerformanceSection() {
    var loadingMore by remember { mutableStateOf(false) }
    var items by remember { mutableStateOf(generateSampleItems(20)) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Performance Patterns",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            SectionCard(title = "Large Dataset Handling") {
                Text(
                    text = "Demonstrating lazy loading with ${items.size} items",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        // Items with key for performance
        items(items, key = { it.id }) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                ListItem(
                    headlineContent = { Text(item.title) },
                    supportingContent = { Text(item.description) },
                    leadingContent = {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(item.color, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.title.first().toString(),
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    trailingContent = {
                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = "$${item.price}",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = item.category,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                )
            }
        }
        
        // Load More Button
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        loadingMore = true
                    },
                    enabled = !loadingMore
                ) {
                    if (loadingMore) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(16.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Loading...")
                    } else {
                        Text("Load More Items")
                    }
                }
            }
        }
        
        // Performance tips
        item {
            SectionCard(title = "Performance Tips") {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "• Use keys for items that can be reordered",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "• Implement lazy loading for large datasets",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "• Use contentPadding instead of wrapper padding",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "• Avoid nested scrollable components",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "• Use animateItemPlacement() for smooth reordering",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
    
    LaunchedEffect(loadingMore) {
        if (loadingMore) {
            delay(1500) // Simulate network delay
            items = items + generateSampleItems(10, startIndex = items.size)
            loadingMore = false
        }
    }
}

// Helper Composables
@Composable
private fun SectionCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            content()
        }
    }
}

@Composable
private fun ProductCard(
    item: SampleItem,
    randomHeight: Boolean = false
) {
    val height = if (randomHeight) {
        remember { Random.nextInt(160, 240).dp }
    } else {
        180.dp
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(item.color, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item.title.first().toString(),
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Medium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$${item.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// Data Classes and Sample Data
data class SampleItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val category: String,
    val color: Color
)

data class TabItem(
    val title: String,
    val icon: ImageVector
)

private val listTabItems = listOf(
    TabItem("LazyColumn", Icons.Default.ViewList),
    TabItem("LazyGrid", Icons.Default.GridView),
    TabItem("LazyRow", Icons.Default.ViewCarousel),
    TabItem("ListItem", Icons.Default.List),
    TabItem("Interactive", Icons.Default.TouchApp),
    TabItem("Performance", Icons.Default.Speed)
)

private val categories = listOf(
    "Electronics", "Fashion", "Home", "Sports", "Books", 
    "Beauty", "Toys", "Automotive", "Garden", "Health"
)

private fun generateSampleItems(count: Int, startIndex: Int = 0): List<SampleItem> {
    val colors = listOf(
        Color(0xFF6366F1), Color(0xFF8B5CF6), Color(0xFF06B6D4), 
        Color(0xFF10B981), Color(0xFF84CC16), Color(0xFFF59E0B),
        Color(0xFFEF4444), Color(0xFFEC4899), Color(0xFF6366F1),
        Color(0xFF8B5CF6)
    )
    
    return (startIndex until startIndex + count).map { index ->
        SampleItem(
            id = index,
            title = "Product ${index + 1}",
            description = "This is a detailed description for product ${index + 1}",
            price = Random.nextInt(10, 500),
            category = categories[index % categories.size],
            color = colors[index % colors.size]
        )
    }
}

private fun generateUserColor(index: Int): Color {
    val colors = listOf(
        Color(0xFF6366F1), Color(0xFF8B5CF6), Color(0xFF06B6D4), 
        Color(0xFF10B981), Color(0xFF84CC16), Color(0xFFF59E0B)
    )
    return colors[index % colors.size]
}

private fun generateUserInitials(index: Int): String {
    val names = listOf("AB", "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR", "ST")
    return names[index % names.size]
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListsScreenPreview() {
    ComposeCookbookTheme {
        ListsScreen()
    }
}

@Preview(name = "Lists Dark", showBackground = true)
@Composable
fun ListsScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        ListsScreen()
    }
}