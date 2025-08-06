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
            componentCount = 10,
            completionStatus = CompletionStatus.COMPLETED,
            route = "navigation",
            components = listOf(
                ComponentItem(
                    id = "navigation_bar",
                    name = "Navigation Bar",
                    description = "Bottom navigation with badges and state management",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "navigation_rail",
                    name = "Navigation Rail",
                    description = "Vertical navigation for tablets and wide screens",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "navigation_drawer",
                    name = "Navigation Drawer",
                    description = "Modal and permanent side navigation panels",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation", 
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "top_app_bar",
                    name = "Top App Bar",
                    description = "Standard, medium, and large app bars with actions",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "search_bar",
                    name = "Search Bar",
                    description = "Expandable search with suggestions and history",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "tab_row",
                    name = "Tab Components",
                    description = "Fixed and scrollable tabs with icons and labels",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "navigation_bar_item",
                    name = "Navigation Bar Item",
                    description = "Individual bottom navigation items with badges",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "navigation_rail_item",
                    name = "Navigation Rail Item",
                    description = "Vertical navigation items for rail component",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "navigation_drawer_item",
                    name = "Navigation Drawer Item",
                    description = "Drawer menu items with selection states",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "tab",
                    name = "Tab",
                    description = "Individual tab components with text and icons",
                    status = CompletionStatus.COMPLETED,
                    route = "navigation",
                    complexity = ComponentComplexity.BASIC
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
            name = "Progress & Feedback",
            description = "Progress indicators, loading states, snackbars, and user feedback",
            icon = Icons.Default.Notifications,
            componentCount = 12,
            completionStatus = CompletionStatus.COMPLETED,
            route = "feedback",
            components = listOf(
                ComponentItem(
                    id = "circular_progress",
                    name = "CircularProgressIndicator",
                    description = "Circular progress for loading operations",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "linear_progress",
                    name = "LinearProgressIndicator",
                    description = "Linear progress bars for file uploads and downloads",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "circular_wavy_progress",
                    name = "CircularWavyProgressIndicator",
                    description = "Enhanced circular progress with wavy animation",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "contained_loading",
                    name = "ContainedLoadingIndicator",
                    description = "Loading indicator within containers",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "snackbar",
                    name = "SnackBar",
                    description = "Brief messages with optional actions",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "badge",
                    name = "Badge",
                    description = "Small status indicators and counters",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "badged_box",
                    name = "BadgedBox",
                    description = "Container with badge overlay for notifications",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "loading_states",
                    name = "Loading States",
                    description = "Complete loading state patterns for screens",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "error_states",
                    name = "Error States",
                    description = "Error handling and retry patterns",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "success_feedback",
                    name = "Success Feedback",
                    description = "Success states and confirmation patterns",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "status_indicators",
                    name = "Status Indicators",
                    description = "Online/offline and connection status indicators",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "toast_alternatives",
                    name = "Toast Alternatives",
                    description = "Modern alternatives to Android Toast messages",
                    status = CompletionStatus.COMPLETED,
                    route = "feedback",
                    complexity = ComponentComplexity.ADVANCED
                )
            )
        ),
        
        ComponentCategory(
            id = "selection",
            name = "Chips & Selection",
            description = "Interactive chips for actions, filtering, and user input",
            icon = Icons.Default.Star,
            componentCount = 12,
            completionStatus = CompletionStatus.COMPLETED,
            route = "selection",
            components = listOf(
                ComponentItem(
                    id = "assist_chip",
                    name = "Assist Chip",
                    description = "Helper actions and contextual suggestions with optional icons",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "elevated_assist_chip",
                    name = "Elevated Assist Chip",
                    description = "Elevated assist chips for enhanced visual prominence",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "filter_chip",
                    name = "Filter Chip",
                    description = "Multi-select filtering with selection states and icons",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "filter_chip_groups",
                    name = "Filter Chip Groups",
                    description = "Organized filter groups for complex filtering scenarios",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "input_chip",
                    name = "Input Chip",
                    description = "User input representation with avatars and dismissal",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "input_chip_avatars",
                    name = "Input Chip with Avatars",
                    description = "Contact chips with avatar representations and removal",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "suggestion_chip",
                    name = "Suggestion Chip",
                    description = "Quick action recommendations and contextual suggestions",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "suggestion_chip_contextual",
                    name = "Contextual Suggestions",
                    description = "Smart suggestions based on location, time, and activity",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "chip_animations",
                    name = "Animated Chips",
                    description = "Smooth animations for chip state changes and interactions",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "chip_groups",
                    name = "Chip Groups",
                    description = "Organization patterns for multiple chip collections",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "tag_input_system",
                    name = "Tag Input System",
                    description = "Interactive tagging system with add/remove functionality",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "chip_accessibility",
                    name = "Chip Accessibility",
                    description = "Accessibility features and performance optimization patterns",
                    status = CompletionStatus.COMPLETED,
                    route = "selection",
                    complexity = ComponentComplexity.ADVANCED
                )
            )
        ),
        
        ComponentCategory(
            id = "lists",
            name = "Lists & Data Display",
            description = "Lazy lists, grids, and data presentation",
            icon = Icons.Default.List,
            componentCount = 12,
            completionStatus = CompletionStatus.COMPLETED,
            route = "lists",
            components = listOf(
                ComponentItem(
                    id = "lazy_column",
                    name = "LazyColumn",
                    description = "Vertical scrolling list with lazy loading and performance optimizations",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "lazy_grid",
                    name = "LazyGrid",
                    description = "Grid layouts with fixed, adaptive, and staggered grid configurations",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "lazy_row",
                    name = "LazyRow",
                    description = "Horizontal scrolling lists for carousels and categories",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "list_item",
                    name = "ListItem",
                    description = "Material 3 list items with 1-line, 2-line, and 3-line variants",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "sticky_header",
                    name = "Sticky Header",
                    description = "Section headers that stick to top during scrolling",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "expandable_list",
                    name = "Expandable List",
                    description = "Collapsible list items with smooth animations",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "multi_select_list",
                    name = "Multi-Select List",
                    description = "Lists with checkbox selection and bulk operations",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "pull_to_refresh",
                    name = "Pull to Refresh",
                    description = "Refresh functionality for updating list content",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "infinite_scroll",
                    name = "Infinite Scroll",
                    description = "Pagination patterns for large datasets",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "grouped_lists",
                    name = "Grouped Lists",
                    description = "Lists organized by categories with section headers",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "search_filter",
                    name = "Search & Filter",
                    description = "Real-time search and filtering capabilities",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "performance_patterns",
                    name = "Performance Patterns",
                    description = "Optimization techniques for large datasets and smooth scrolling",
                    status = CompletionStatus.COMPLETED,
                    route = "lists",
                    complexity = ComponentComplexity.ADVANCED
                )
            )
        ),
        
        ComponentCategory(
            id = "dialogs",
            name = "Dialogs & Overlays",
            description = "Modal dialogs, bottom sheets, and popups",
            icon = Icons.Default.Info,
            componentCount = 15,
            completionStatus = CompletionStatus.COMPLETED,
            route = "dialogs",
            components = listOf(
                ComponentItem(
                    id = "alert_dialog",
                    name = "Alert Dialog",
                    description = "Basic, confirmation, and destructive action dialogs",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "custom_dialog",
                    name = "Custom Dialog",
                    description = "Branded dialogs with custom styling and layouts",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "fullscreen_dialog",
                    name = "Full-Screen Dialog",
                    description = "Full-screen overlays for complex forms and workflows",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "modal_bottom_sheet",
                    name = "Modal Bottom Sheet",
                    description = "Temporary overlays that slide up from bottom",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "date_picker_dialog",
                    name = "Date Picker Dialog",
                    description = "Material 3 date selection with calendar view",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "time_picker_dialog",
                    name = "Time Picker Dialog",
                    description = "Material 3 time selection with clock interface",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "tooltip",
                    name = "Tooltip",
                    description = "Plain and rich tooltips for UI element explanation",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "dropdown_menu",
                    name = "Dropdown Menu",
                    description = "Context menus with actions and hierarchical options",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "loading_overlay",
                    name = "Loading Overlay",
                    description = "Full-screen loading states with progress indication",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "error_dialog",
                    name = "Error Dialog",
                    description = "User-friendly error handling with recovery options",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "success_dialog",
                    name = "Success Dialog",
                    description = "Positive feedback dialogs for completed actions",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.BASIC
                ),
                ComponentItem(
                    id = "confirmation_flow",
                    name = "Confirmation Flow",
                    description = "Multi-step confirmation patterns for critical actions",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "contextual_overlay",
                    name = "Contextual Overlay",
                    description = "Search suggestions, notifications, and popup patterns",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                ),
                ComponentItem(
                    id = "multi_step_dialog",
                    name = "Multi-Step Dialog",
                    description = "Complex workflows like onboarding and checkout",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.ADVANCED
                ),
                ComponentItem(
                    id = "bottom_sheet_patterns",
                    name = "Bottom Sheet Patterns",
                    description = "Share dialogs, action menus, and filter options",
                    status = CompletionStatus.COMPLETED,
                    route = "dialogs",
                    complexity = ComponentComplexity.INTERMEDIATE
                )
            )
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