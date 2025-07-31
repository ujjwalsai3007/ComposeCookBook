package com.example.androidui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Data model representing a component category in the Compose Cookbook
 */
data class ComponentCategory(
    val id: String,
    val name: String,
    val description: String,
    val icon: ImageVector,
    val componentCount: Int,
    val completionStatus: CompletionStatus,
    val route: String,
    val components: List<ComponentItem> = emptyList()
)

/**
 * Data model for individual components within categories
 */
data class ComponentItem(
    val id: String,
    val name: String,
    val description: String,
    val status: CompletionStatus,
    val previewImageUrl: String? = null,
    val route: String,
    val complexity: ComponentComplexity
)

enum class CompletionStatus {
    COMPLETED,      // ✅ Fully implemented
    IN_PROGRESS,    // 🚧 Currently working on
    PLANNED,        // 📋 Scheduled for development
    EXPERIMENTAL    // 🧪 Testing new features
}

enum class ComponentComplexity {
    BASIC,          // Simple, single-purpose components
    INTERMEDIATE,   // Components with multiple variants
    ADVANCED        // Complex, highly customizable components
}

/**
 * Static data for all component categories
 * This acts as our component registry and navigation source
 */
object ComponentRegistry {
    
    val categories = listOf(
        ComponentCategory(
            id = "buttons",
            name = "Buttons & Actions",
            description = "Interactive elements for user actions",
            icon = Icons.Default.Star,
            componentCount = 12,
            completionStatus = CompletionStatus.COMPLETED,
            route = "buttons",
            components = listOf(
                ComponentItem(
                    id = "filled_button",
                    name = "Filled Button",
                    description = "Primary action buttons with filled background",
                    status = CompletionStatus.COMPLETED,
                    route = "buttons",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "outlined_button", 
                    name = "Outlined Button",
                    description = "Secondary action buttons with border",
                    status = CompletionStatus.COMPLETED,
                    route = "buttons",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "text_button",
                    name = "Text Button", 
                    description = "Low emphasis buttons without background",
                    status = CompletionStatus.COMPLETED,
                    route = "buttons",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "fab",
                    name = "Floating Action Button",
                    description = "Primary floating actions with multiple sizes",
                    status = CompletionStatus.COMPLETED,
                    route = "buttons", 
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "icon_button",
                    name = "Icon Button",
                    description = "Icon-only buttons for compact interfaces",
                    status = CompletionStatus.COMPLETED,
                    route = "buttons",
                    complexity = ComponentComplexity.BASIC
                )
            )
        ),
        
        ComponentCategory(
            id = "cards",
            name = "Cards & Surfaces",
            description = "Content containers with elevation and styling",
            icon = Icons.Default.Home,
            componentCount = 12,
            completionStatus = CompletionStatus.COMPLETED,
            route = "cards",
            components = listOf(
                ComponentItem(
                    id = "filled_card",
                    name = "Filled Card",
                    description = "Standard cards with filled background",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "elevated_card",
                    name = "Elevated Card", 
                    description = "Cards with shadow elevation",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "outlined_card",
                    name = "Outlined Card",
                    description = "Cards with border styling",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "interactive_card",
                    name = "Interactive Card",
                    description = "Clickable cards with state management",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "media_card",
                    name = "Media Card",
                    description = "Cards with images and media content",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "profile_card",
                    name = "Profile Card",
                    description = "User profile cards with avatar and actions",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "product_card",
                    name = "Product Card",
                    description = "E-commerce product cards with ratings and actions",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "notification_card",
                    name = "Notification Card",
                    description = "Alert and notification cards with actions",
                    status = CompletionStatus.COMPLETED,
                    route = "cards",
                    complexity = ComponentComplexity.INTERMEDIATE
                )
            )
        ),
        
        ComponentCategory(
            id = "navigation",
            name = "Navigation",
            description = "Components for app navigation and wayfinding",
            icon = Icons.Default.Menu,
            componentCount = 6,
            completionStatus = CompletionStatus.PLANNED,
            route = "navigation",
            components = listOf(
                ComponentItem(
                    id = "bottom_navigation",
                    name = "Bottom Navigation",
                    description = "Tab-based navigation at bottom of screen",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "navigation_drawer",
                    name = "Navigation Drawer",
                    description = "Side panel navigation for main sections",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation", 
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "top_app_bar",
                    name = "Top App Bar",
                    description = "Header navigation with actions",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                )
            )
        ),
        
        ComponentCategory(
            id = "input",
            name = "Input & Forms",
            description = "Text fields, dropdowns, date pickers, and form controls",
            icon = Icons.Default.Edit,
            componentCount = 15,
            completionStatus = CompletionStatus.COMPLETED,
            route = "input",
            components = listOf(
                ComponentItem(
                    id = "text_field",
                    name = "TextField",
                    description = "Standard text input with Material 3 styling",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "outlined_text_field",
                    name = "OutlinedTextField",
                    description = "Text input with outlined border styling",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "date_picker",
                    name = "DatePicker",
                    description = "Date selection with calendar interface",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "date_picker_dialog",
                    name = "DatePickerDialog",
                    description = "Modal date picker dialog",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "time_picker",
                    name = "TimePicker",
                    description = "Time selection with clock interface",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "time_input",
                    name = "TimeInput",
                    description = "Manual time input fields",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "search_bar",
                    name = "SearchBar",
                    description = "Material 3 search interface",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "checkbox",
                    name = "Checkbox",
                    description = "Binary selection checkbox",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "radio_button",
                    name = "RadioButton",
                    description = "Single selection from group",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "switch",
                    name = "Switch",
                    description = "Toggle switch for binary states",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "slider",
                    name = "Slider",
                    description = "Value selection on continuous range",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "range_slider",
                    name = "RangeSlider",
                    description = "Dual-handle range selection",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "dropdown_menu",
                    name = "DropdownMenu",
                    description = "Menu with selectable options",
                    status = CompletionStatus.COMPLETED,
                    route = "input",
                    complexity = ComponentComplexity.INTERMEDIATE
                )
            )
        ),
        
        ComponentCategory(
            id = "feedback",
            name = "Feedback & Status",
            description = "Progress indicators, snackbars, and alerts",
            icon = Icons.Default.Notifications,
            componentCount = 7,
            completionStatus = CompletionStatus.PLANNED,
            route = "feedback",
            components = listOf(
                ComponentItem(
                    id = "progress_indicator",
                    name = "Progress Indicator",
                    description = "Linear and circular progress displays",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "snackbar",
                    name = "Snackbar",
                    description = "Brief messages with optional actions",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                )
            )
        ),
        
        ComponentCategory(
            id = "selection",
            name = "Selection Controls",
            description = "Checkboxes, switches, chips, and sliders",
            icon = Icons.Default.CheckCircle,
            componentCount = 8,
            completionStatus = CompletionStatus.PLANNED,
            route = "selection"
        ),
        
        ComponentCategory(
            id = "lists",
            name = "Lists & Data Display",
            description = "Lazy lists, grids, and data presentation",
            icon = Icons.Default.List,
            componentCount = 5,
            completionStatus = CompletionStatus.PLANNED,
            route = "lists"
        ),
        
        ComponentCategory(
            id = "dialogs",
            name = "Dialogs & Overlays",
            description = "Modal dialogs, bottom sheets, and popups",
            icon = Icons.Default.Info,
            componentCount = 6,
            completionStatus = CompletionStatus.PLANNED,
            route = "dialogs"
        )
    )
    
    /**
     * Get all components across all categories
     */
    fun getAllComponents(): List<ComponentItem> {
        return categories.flatMap { it.components }
    }
    
    /**
     * Search components by name or description
     */
    fun searchComponents(query: String): List<ComponentItem> {
        if (query.isBlank()) return getAllComponents()
        
        return getAllComponents().filter { component ->
            component.name.contains(query, ignoreCase = true) ||
            component.description.contains(query, ignoreCase = true)
        }
    }
    
    /**
     * Get components by completion status
     */
    fun getComponentsByStatus(status: CompletionStatus): List<ComponentItem> {
        return getAllComponents().filter { it.status == status }
    }
    
    /**
     * Get category by ID
     */
    fun getCategoryById(id: String): ComponentCategory? {
        return categories.find { it.id == id }
    }
}