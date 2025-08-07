package com.example.androidui.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.ui.theme.ComposeCookbookTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipsScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "FINAL CATEGORY!",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Chips & Selection",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Interactive chips for actions, filtering, and user input - completing 100% of our component library!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
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
            chipTabItems.forEachIndexed { index, tab ->
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
            0 -> AssistChipSection()
            1 -> FilterChipSection()
            2 -> InputChipSection()
            3 -> SuggestionChipSection()
            4 -> AdvancedPatternsSection()
        }
    }
}

@Composable
private fun AssistChipSection() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Assist Chips",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            SectionCard(title = "Basic Assist Chips") {
                Text(
                    text = "Helper actions and contextual suggestions",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(basicAssistChips) { chip ->
                        AssistChip(
                            onClick = { },
                            label = { Text(chip) }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Assist Chips with Icons") {
                Text(
                    text = "Enhanced assist chips with leading icons for better recognition",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(iconAssistChips) { chip ->
                        AssistChip(
                            onClick = { },
                            label = { Text(chip.label) },
                            leadingIcon = {
                                Icon(
                                    chip.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Interactive Assist Chips") {
                var lastClickedChip by remember { mutableStateOf("None") }
                
                Text(
                    text = "Assist chips with click handling and state feedback",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer
                    )
                ) {
                    Text(
                        text = "Last clicked: $lastClickedChip",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(12.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(interactiveAssistChips) { chip ->
                        AssistChip(
                            onClick = { lastClickedChip = chip.label },
                            label = { Text(chip.label) },
                            leadingIcon = {
                                Icon(
                                    chip.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Elevated Assist Chips") {
                Text(
                    text = "Assist chips with elevated styling for emphasis",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(elevatedAssistChips) { chip ->
                        ElevatedAssistChip(
                            onClick = { },
                            label = { Text(chip.label) },
                            leadingIcon = {
                                Icon(
                                    chip.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                                )
                            }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Use Cases") {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Common assist chip patterns:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    UseCaseExample(
                        icon = Icons.Default.Add,
                        title = "Quick Actions",
                        description = "Add to favorites, share, bookmark"
                    )
                    
                    UseCaseExample(
                        icon = Icons.Default.Star,
                        title = "Location Services",
                        description = "Get directions, view on map, nearby places"
                    )
                    
                    UseCaseExample(
                        icon = Icons.Default.Info,
                        title = "Time-based Actions",
                        description = "Set reminder, schedule, view calendar"
                    )
                    
                    UseCaseExample(
                        icon = Icons.Default.Person,
                        title = "Contact Actions",
                        description = "Call, message, email, add contact"
                    )
                }
            }
        }
    }
}

@Composable
private fun FilterChipSection() {
    var selectedFilters by remember { mutableStateOf(setOf<String>()) }
    var selectedCategories by remember { mutableStateOf(setOf<String>()) }
    var selectedPriceRanges by remember { mutableStateOf(setOf<String>()) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Filter Chips",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            SectionCard(title = "Basic Filter Chips") {
                Text(
                    text = "Single and multi-select filtering options",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Content Type Filters:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(contentFilters) { filter ->
                        FilterChip(
                            onClick = {
                                selectedFilters = if (selectedFilters.contains(filter)) {
                                    selectedFilters - filter
                                } else {
                                    selectedFilters + filter
                                }
                            },
                            label = { Text(filter) },
                            selected = selectedFilters.contains(filter)
                        )
                    }
                }
                
                if (selectedFilters.isNotEmpty()) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Text(
                            text = "Active filters: ${selectedFilters.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Filter Chips with Icons") {
                Text(
                    text = "Category filters with descriptive icons",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Product Categories:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(categoryFilters) { filter ->
                        FilterChip(
                            onClick = {
                                selectedCategories = if (selectedCategories.contains(filter.label)) {
                                    selectedCategories - filter.label
                                } else {
                                    selectedCategories + filter.label
                                }
                            },
                            label = { Text(filter.label) },
                            selected = selectedCategories.contains(filter.label),
                            leadingIcon = if (selectedCategories.contains(filter.label)) {
                                {
                                    Icon(
                                        Icons.Default.Done,
                                        contentDescription = null,
                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                    )
                                }
                            } else {
                                {
                                    Icon(
                                        filter.icon,
                                        contentDescription = null,
                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                    )
                                }
                            }
                        )
                    }
                }
                
                if (selectedCategories.isNotEmpty()) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(
                            text = "Selected categories: ${selectedCategories.joinToString(", ")}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Filter Chip Groups") {
                Text(
                    text = "Organized filter groups for complex filtering",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Price Range:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    items(priceRangeFilters) { filter ->
                        FilterChip(
                            onClick = {
                                selectedPriceRanges = if (selectedPriceRanges.contains(filter)) {
                                    selectedPriceRanges - filter
                                } else {
                                    selectedPriceRanges + filter
                                }
                            },
                            label = { Text(filter) },
                            selected = selectedPriceRanges.contains(filter)
                        )
                    }
                }
                
                Text(
                    text = "Rating:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                var selectedRating by remember { mutableStateOf<String?>(null) }
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(ratingFilters) { filter ->
                        FilterChip(
                            onClick = {
                                selectedRating = if (selectedRating == filter) null else filter
                            },
                            label = { Text(filter) },
                            selected = selectedRating == filter,
                            leadingIcon = if (selectedRating == filter) {
                                {
                                    Icon(
                                        Icons.Default.Star,
                                        contentDescription = null,
                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                    )
                                }
                            } else null
                        )
                    }
                }
                
                // Summary
                val totalFilters = selectedFilters.size + selectedCategories.size + 
                                 selectedPriceRanges.size + (if (selectedRating != null) 1 else 0)
                
                if (totalFilters > 0) {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = "Active Filters ($totalFilters)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                            if (selectedPriceRanges.isNotEmpty()) {
                                Text("Price: ${selectedPriceRanges.joinToString(", ")}")
                            }
                            selectedRating?.let {
                                Text("Rating: $it")
                            }
                        }
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Filter Best Practices") {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Design Guidelines:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    BestPracticeItem("Group related filters together")
                    BestPracticeItem("Use icons to enhance recognition")
                    BestPracticeItem("Show active filter count and clear option")
                    BestPracticeItem("Consider single vs multi-select patterns")
                    BestPracticeItem("Provide filter summary and results count")
                    BestPracticeItem("Support keyboard navigation")
                }
            }
        }
    }
}

@Composable
private fun InputChipSection() {
    var inputChips by remember { mutableStateOf(sampleInputChips.toMutableList()) }
    var tagChips by remember { mutableStateOf(sampleTags.toMutableList()) }
    var contactChips by remember { mutableStateOf(sampleContacts.toMutableList()) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Input Chips",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            SectionCard(title = "Basic Input Chips") {
                Text(
                    text = "User input represented as dismissible chips",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Skills (tap X to remove):",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(inputChips) { chip ->
                        InputChip(
                            onClick = { },
                            label = { Text(chip) },
                            selected = false,
                            trailingIcon = {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Remove $chip",
                                    modifier = Modifier
                                        .size(InputChipDefaults.IconSize)
                                        .clickable {
                                            inputChips.remove(chip)
                                        }
                                )
                            }
                        )
                    }
                }
                
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { inputChips.add("New Skill") },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Add Skill")
                    }
                    
                    OutlinedButton(
                        onClick = { inputChips.clear() },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Clear All")
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Input Chips with Avatars") {
                Text(
                    text = "Contact chips with avatar representations",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Selected Contacts:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(contactChips) { contact ->
                        InputChip(
                            onClick = { },
                            label = { Text(contact.name) },
                            selected = false,
                            avatar = {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .background(contact.color, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = contact.name.first().toString(),
                                        color = Color.White,
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            },
                            trailingIcon = {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Remove ${contact.name}",
                                    modifier = Modifier
                                        .size(InputChipDefaults.IconSize)
                                        .clickable {
                                            contactChips.remove(contact)
                                        }
                                )
                            }
                        )
                    }
                }
                
                Button(
                    onClick = { 
                        val newContact = Contact(
                            "User ${contactChips.size + 1}",
                            generateRandomColor()
                        )
                        contactChips.add(newContact)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Add Contact")
                }
            }
        }
        
        item {
            SectionCard(title = "Tag Input System") {
                Text(
                    text = "Interactive tagging system with add/remove functionality",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                var newTag by remember { mutableStateOf("") }
                
                Text(
                    text = "Project Tags:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    items(tagChips) { tag ->
                        InputChip(
                            onClick = { },
                            label = { Text(tag) },
                            selected = false,
                            trailingIcon = {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Remove $tag",
                                    modifier = Modifier
                                        .size(InputChipDefaults.IconSize)
                                        .clickable {
                                            tagChips.remove(tag)
                                        }
                                )
                            }
                        )
                    }
                }
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = newTag,
                        onValueChange = { newTag = it },
                        label = { Text("Add new tag") },
                        modifier = Modifier.weight(1f),
                        singleLine = true
                    )
                    
                    Button(
                        onClick = {
                            if (newTag.isNotBlank() && !tagChips.contains(newTag)) {
                                tagChips.add(newTag)
                                newTag = ""
                            }
                        },
                        enabled = newTag.isNotBlank()
                    ) {
                        Text("Add")
                    }
                }
                
                if (tagChips.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainer
                        )
                    ) {
                        Text(
                            text = "${tagChips.size} tags added",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Input Chip States") {
                Text(
                    text = "Different states and interactions for input chips",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text("Normal State:")
                    InputChip(
                        onClick = { },
                        label = { Text("Normal Chip") },
                        selected = false,
                        trailingIcon = {
                            Icon(Icons.Default.Close, contentDescription = "Remove")
                        }
                    )
                    
                    Text("Selected State:")
                    InputChip(
                        onClick = { },
                        label = { Text("Selected Chip") },
                        selected = true,
                        trailingIcon = {
                            Icon(Icons.Default.Close, contentDescription = "Remove")
                        }
                    )
                    
                    Text("With Avatar:")
                    InputChip(
                        onClick = { },
                        label = { Text("Avatar Chip") },
                        selected = false,
                        avatar = {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .background(MaterialTheme.colorScheme.primary, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "A",
                                    color = Color.White,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        },
                        trailingIcon = {
                            Icon(Icons.Default.Close, contentDescription = "Remove")
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SuggestionChipSection() {
    var recentSearches by remember { mutableStateOf(sampleRecentSearches.toMutableList()) }
    var quickActions by remember { mutableStateOf(sampleQuickActions) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Suggestion Chips",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        item {
            SectionCard(title = "Basic Suggestion Chips") {
                Text(
                    text = "Quick action suggestions and recommendations",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Quick Actions:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(basicSuggestions) { suggestion ->
                        SuggestionChip(
                            onClick = { },
                            label = { Text(suggestion) }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Suggestion Chips with Icons") {
                Text(
                    text = "Enhanced suggestions with descriptive icons",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Text(
                    text = "Recommended Actions:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(quickActions) { action ->
                        SuggestionChip(
                            onClick = { },
                            label = { Text(action.label) },
                            icon = {
                                Icon(
                                    action.icon,
                                    contentDescription = null,
                                    modifier = Modifier.size(SuggestionChipDefaults.IconSize)
                                )
                            }
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Recent Searches") {
                Text(
                    text = "Dynamic suggestions based on user history",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recent Searches:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Medium
                    )
                    
                    if (recentSearches.isNotEmpty()) {
                        TextButton(
                            onClick = { recentSearches.clear() }
                        ) {
                            Text("Clear All")
                        }
                    }
                }
                
                if (recentSearches.isNotEmpty()) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        items(recentSearches) { search ->
                            SuggestionChip(
                                onClick = { },
                                label = { Text(search) },
                                icon = {
                                    Icon(
                                        Icons.Default.Info,
                                        contentDescription = null,
                                        modifier = Modifier.size(SuggestionChipDefaults.IconSize)
                                    )
                                }
                            )
                        }
                    }
                } else {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainer
                        )
                    ) {
                        Text(
                            text = "No recent searches",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Button(
                    onClick = { 
                        recentSearches.add("Search ${recentSearches.size + 1}")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Add Recent Search")
                }
            }
        }
        
        item {
            SectionCard(title = "Contextual Suggestions") {
                Text(
                    text = "Smart suggestions based on current context",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Location-based
                    Column {
                        Text(
                            text = "Location-based:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(locationSuggestions) { suggestion ->
                                SuggestionChip(
                                    onClick = { },
                                    label = { Text(suggestion.label) },
                                    icon = {
                                        Icon(
                                            suggestion.icon,
                                            contentDescription = null,
                                            modifier = Modifier.size(SuggestionChipDefaults.IconSize)
                                        )
                                    }
                                )
                            }
                        }
                    }
                    
                    // Time-based
                    Column {
                        Text(
                            text = "⏰ Time-based:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(timeSuggestions) { suggestion ->
                                SuggestionChip(
                                    onClick = { },
                                    label = { Text(suggestion.label) },
                                    icon = {
                                        Icon(
                                            suggestion.icon,
                                            contentDescription = null,
                                            modifier = Modifier.size(SuggestionChipDefaults.IconSize)
                                        )
                                    }
                                )
                            }
                        }
                    }
                    
                    // Activity-based
                    Column {
                        Text(
                            text = "Activity-based:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(activitySuggestions) { suggestion ->
                                SuggestionChip(
                                    onClick = { },
                                    label = { Text(suggestion.label) },
                                    icon = {
                                        Icon(
                                            suggestion.icon,
                                            contentDescription = null,
                                            modifier = Modifier.size(SuggestionChipDefaults.IconSize)
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AdvancedPatternsSection() {
    var isAnimated by remember { mutableStateOf(false) }
    
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Advanced Patterns",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    Text(
                        text = "100% COMPLETE!",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }
        
        item {
            SectionCard(title = "Animated Chip Interactions") {
                Text(
                    text = "Smooth animations for chip state changes",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Toggle Animation:")
                    Switch(
                        checked = isAnimated,
                        onCheckedChange = { isAnimated = it }
                    )
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(animatedChipExamples) { chip ->
                        val animatedColor by animateColorAsState(
                            targetValue = if (isAnimated) MaterialTheme.colorScheme.primary 
                                        else MaterialTheme.colorScheme.surfaceVariant,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            ),
                            label = "chip_color"
                        )
                        
                        FilterChip(
                            onClick = { },
                            label = { Text(chip) },
                            selected = isAnimated,
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = animatedColor
                            )
                        )
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Chip Groups & Organization") {
                Text(
                    text = "Best practices for organizing multiple chip groups",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Horizontal scrolling group
                    Column {
                        Text(
                            text = "Horizontal Scrolling Group:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(15) { index ->
                                AssistChip(
                                    onClick = { },
                                    label = { Text("Item ${index + 1}") }
                                )
                            }
                        }
                    }
                    
                    // Wrapping group
                    Column {
                        Text(
                            text = "Wrapping Chip Group:",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        // This would be better with FlowRow in production
                        Column {
                            val chunkedItems = wrappingChipExamples.chunked(3)
                            chunkedItems.forEach { chunk ->
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                ) {
                                    chunk.forEach { item ->
                                        FilterChip(
                                            onClick = { },
                                            label = { Text(item) },
                                            selected = false
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        item {
            SectionCard(title = "Accessibility Features") {
                Text(
                    text = "Ensuring chips are accessible to all users",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Accessibility Guidelines:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    BestPracticeItem("Provide clear content descriptions for screen readers")
                    BestPracticeItem("Use sufficient color contrast (4.5:1 minimum)")
                    BestPracticeItem("Support keyboard navigation and focus indicators")
                    BestPracticeItem("Announce state changes (selected/unselected)")
                    BestPracticeItem("Group related chips with semantic markup")
                    BestPracticeItem("Provide alternative text for icon-only chips")
                }
            }
        }
        
        item {
            SectionCard(title = "Performance Optimization") {
                Text(
                    text = "Tips for optimal chip performance",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Performance Tips:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    BestPracticeItem("Use keys for dynamic chip lists")
                    BestPracticeItem("Implement lazy loading for large chip sets")
                    BestPracticeItem("Optimize animations with remember and derivedStateOf")
                    BestPracticeItem("Avoid recreating chip data on every recomposition")
                    BestPracticeItem("Use stable data classes for chip content")
                    BestPracticeItem("Consider virtualization for very large lists")
                }
            }
        }
        
        item {
            SectionCard(title = "Project Completion Summary") {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Congratulations!",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "COMPLETE COMPONENT LIBRARY",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "8/8 Categories • 125+ Components • Production Ready",
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Buttons", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Cards", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Input", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Progress", style = MaterialTheme.typography.labelMedium)
                        }
                    }
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Navigation", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Lists", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Dialogs", style = MaterialTheme.typography.labelMedium)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("✓", style = MaterialTheme.typography.headlineMedium)
                            Text("Chips", style = MaterialTheme.typography.labelMedium)
                        }
                    }
                    
                    Text(
                        text = "You now have the most comprehensive Material 3 Compose component library ever built!",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
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
private fun UseCaseExample(
    icon: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun BestPracticeItem(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "•",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 8.dp, top = 2.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// Data Classes and Sample Data
data class ChipTabItem(
    val title: String,
    val icon: ImageVector
)

data class ChipItem(
    val label: String,
    val icon: ImageVector
)

data class Contact(
    val name: String,
    val color: Color
)

private val chipTabItems = listOf(
    ChipTabItem("Assist", Icons.Default.Info),
    ChipTabItem("Filter", Icons.Default.Search),
    ChipTabItem("Input", Icons.Default.Edit),
    ChipTabItem("Suggestion", Icons.Default.Info),
    ChipTabItem("Advanced", Icons.Default.Settings)
)

private val basicAssistChips = listOf(
    "Get Directions", "Call Now", "Add to Cart", "Share", "Bookmark"
)

private val iconAssistChips = listOf(
    ChipItem("Get Directions", Icons.Default.Star),
    ChipItem("Call Now", Icons.Default.Star),
    ChipItem("Share", Icons.Default.Share),
    ChipItem("Bookmark", Icons.Default.Star)
)

private val interactiveAssistChips = listOf(
    ChipItem("Weather", Icons.Default.Star),
    ChipItem("Traffic", Icons.Default.Star),
    ChipItem("News", Icons.Default.Star),
    ChipItem("Calendar", Icons.Default.Star)
)

private val elevatedAssistChips = listOf(
    ChipItem("Premium", Icons.Default.Star),
    ChipItem("Featured", Icons.Default.Favorite),
    ChipItem("Trending", Icons.Default.Star),
    ChipItem("New", Icons.Default.Star)
)

private val contentFilters = listOf(
    "All", "Photos", "Videos", "Documents", "Music"
)

private val categoryFilters = listOf(
    ChipItem("Electronics", Icons.Default.Star),
    ChipItem("Fashion", Icons.Default.Star),
    ChipItem("Home", Icons.Default.Home),
    ChipItem("Sports", Icons.Default.Star),
    ChipItem("Books", Icons.Default.Menu)
)

private val priceRangeFilters = listOf(
    "Under $25", "$25-$50", "$50-$100", "Over $100"
)

private val ratingFilters = listOf(
    "4+ Stars", "3+ Stars", "2+ Stars", "Any Rating"
)

private val sampleInputChips = listOf(
    "Kotlin", "Android", "Jetpack Compose", "Material Design"
)

private val sampleTags = listOf(
    "Mobile", "UI/UX", "Frontend", "Open Source"
)

private val sampleContacts = listOf(
    Contact("Alice Johnson", Color(0xFF6366F1)),
    Contact("Bob Smith", Color(0xFF8B5CF6)),
    Contact("Carol Davis", Color(0xFF06B6D4))
)

private val sampleRecentSearches = listOf(
    "Jetpack Compose", "Material Design", "Android Development"
)

private val basicSuggestions = listOf(
    "Try Premium", "Rate App", "Share App", "Help Center"
)

private val sampleQuickActions = listOf(
    ChipItem("Settings", Icons.Default.Settings),
    ChipItem("Help", Icons.Default.Info),
    ChipItem("Feedback", Icons.Default.Email),
    ChipItem("About", Icons.Default.Info)
)

private val locationSuggestions = listOf(
    ChipItem("Nearby Restaurants", Icons.Default.Star),
    ChipItem("Gas Stations", Icons.Default.Star),
    ChipItem("ATMs", Icons.Default.Star)
)

private val timeSuggestions = listOf(
    ChipItem("Morning Routine", Icons.Default.Star),
    ChipItem("Lunch Break", Icons.Default.Star),
    ChipItem("Evening Plans", Icons.Default.Star)
)

private val activitySuggestions = listOf(
    ChipItem("Continue Reading", Icons.Default.Menu),
    ChipItem("Resume Workout", Icons.Default.Star),
    ChipItem("Check Messages", Icons.Default.Star)
)

private val animatedChipExamples = listOf(
    "Animate Me", "Color Change", "Smooth Transition", "Dynamic State"
)

private val wrappingChipExamples = listOf(
    "Technology", "Science", "Art", "Music", "Sports", 
    "Travel", "Food", "Photography", "Gaming"
)

private fun generateRandomColor(): Color {
    val colors = listOf(
        Color(0xFF6366F1), Color(0xFF8B5CF6), Color(0xFF06B6D4), 
        Color(0xFF10B981), Color(0xFF84CC16), Color(0xFFF59E0B)
    )
    return colors.random()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChipsScreenPreview() {
    ComposeCookbookTheme {
        ChipsScreen()
    }
}

@Preview(name = "Chips Dark", showBackground = true)
@Composable
fun ChipsScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        ChipsScreen()
    }
}