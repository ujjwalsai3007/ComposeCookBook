package com.example.androidui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.data.ComponentCategory
import com.example.androidui.data.ComponentItem
import com.example.androidui.data.ComponentRegistry
import com.example.androidui.data.CompletionStatus
import com.example.androidui.ui.theme.ComposeCookbookTheme

/**
 * ComponentCatalogScreen - Main screen of the Compose Cookbook
 * 
 * This is the central hub where developers can explore all available
 * Material 3 components organized by category. Features include:
 * - Searchable component library
 * - Category-based organization
 * - Progress tracking for implementation status
 * - Quick access to individual component screens
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentCatalogScreen(
    onCategoryClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf<CompletionStatus?>(null) }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header Section
        CatalogHeader()
        
        // Search and Filter Section
        SearchAndFilterSection(
            searchQuery = searchQuery,
            onSearchQueryChange = { searchQuery = it },
            selectedFilter = selectedFilter,
            onFilterChange = { selectedFilter = it }
        )
        
        // Statistics Section
        CatalogStatistics()
        
        // Component Categories Grid
        CategoriesGrid(
            searchQuery = searchQuery,
            statusFilter = selectedFilter,
            onCategoryClick = onCategoryClick
        )
    }
}

@Composable
private fun CatalogHeader() {
    Column {
        Text(
            text = "Compose Cookbook",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "Material 3 Components Library",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Comprehensive collection of production-ready Jetpack Compose components following Material 3 design guidelines.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchAndFilterSection(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    selectedFilter: CompletionStatus?,
    onFilterChange: (CompletionStatus?) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            placeholder = { Text("Search components...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        
        // Filter Chips
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            FilterChip(
                selected = selectedFilter == null,
                onClick = { onFilterChange(null) },
                label = { Text("All") }
            )
            
            FilterChip(
                selected = selectedFilter == CompletionStatus.COMPLETED,
                onClick = { 
                    onFilterChange(
                        if (selectedFilter == CompletionStatus.COMPLETED) null 
                        else CompletionStatus.COMPLETED
                    )
                },
                label = { Text("Complete") }
            )
            
            FilterChip(
                selected = selectedFilter == CompletionStatus.IN_PROGRESS,
                onClick = { 
                    onFilterChange(
                        if (selectedFilter == CompletionStatus.IN_PROGRESS) null 
                        else CompletionStatus.IN_PROGRESS
                    )
                },
                label = { Text("🚧 In Progress") }
            )
            
            FilterChip(
                selected = selectedFilter == CompletionStatus.PLANNED,
                onClick = { 
                    onFilterChange(
                        if (selectedFilter == CompletionStatus.PLANNED) null 
                        else CompletionStatus.PLANNED
                    )
                },
                label = { Text("Planned") }
            )
        }
    }
}

@Composable
private fun CatalogStatistics() {
    val totalCategories = ComponentRegistry.categories.size
    val completedComponents = ComponentRegistry.getComponentsByStatus(CompletionStatus.COMPLETED).size
    val totalComponents = ComponentRegistry.getAllComponents().size
    val progressPercentage = if (totalComponents > 0) (completedComponents * 100) / totalComponents else 0
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatisticItem(
                label = "Categories",
                value = totalCategories.toString(),
                color = MaterialTheme.colorScheme.primary
            )
            
            StatisticItem(
                label = "Components",
                value = "$completedComponents/$totalComponents",
                color = MaterialTheme.colorScheme.secondary
            )
            
            StatisticItem(
                label = "Progress",
                value = "$progressPercentage%",
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
private fun StatisticItem(
    label: String,
    value: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineMedium,
            color = color,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun CategoriesGrid(
    searchQuery: String,
    statusFilter: CompletionStatus?,
    onCategoryClick: (String) -> Unit
) {
    val filteredCategories = remember(searchQuery, statusFilter) {
        ComponentRegistry.categories.filter { category ->
            val matchesSearch = if (searchQuery.isBlank()) {
                true
            } else {
                category.name.contains(searchQuery, ignoreCase = true) ||
                category.description.contains(searchQuery, ignoreCase = true) ||
                category.components.any { component ->
                    component.name.contains(searchQuery, ignoreCase = true) ||
                    component.description.contains(searchQuery, ignoreCase = true)
                }
            }
            
            val matchesFilter = statusFilter?.let { filter ->
                category.completionStatus == filter || 
                category.components.any { it.status == filter }
            } ?: true
            
            matchesSearch && matchesFilter
        }
    }
    
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(300.dp),
        verticalItemSpacing = 12.dp,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(filteredCategories) { category ->
            CategoryCard(
                category = category,
                onClick = { onCategoryClick(category.route) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryCard(
    category: ComponentCategory,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = category.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
                
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    
                    Text(
                        text = "${category.componentCount} components",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                // Status Badge
                StatusBadge(status = category.completionStatus)
            }
            
            // Description
            Text(
                text = category.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            // Progress Indicator (if applicable)
            if (category.components.isNotEmpty()) {
                CategoryProgress(category = category)
            }
        }
    }
}

@Composable
private fun StatusBadge(status: CompletionStatus) {
    val (emoji, color) = when (status) {
        CompletionStatus.COMPLETED -> "✓" to MaterialTheme.colorScheme.primary
        CompletionStatus.IN_PROGRESS -> "◐" to MaterialTheme.colorScheme.secondary
        CompletionStatus.PLANNED -> "◐" to MaterialTheme.colorScheme.outline
        CompletionStatus.EXPERIMENTAL -> "◌" to MaterialTheme.colorScheme.tertiary
    }
    
    Text(
        text = emoji,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun CategoryProgress(category: ComponentCategory) {
    val completedCount = category.components.count { it.status == CompletionStatus.COMPLETED }
    val totalCount = category.components.size
    val progress = if (totalCount > 0) completedCount.toFloat() / totalCount else 0f
    
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Progress",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "$completedCount/$totalCount",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentCatalogScreenPreview() {
    ComposeCookbookTheme {
        ComponentCatalogScreen()
    }
}

@Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ComponentCatalogScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        ComponentCatalogScreen()
    }
}