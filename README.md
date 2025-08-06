# Compose Cookbook

> **A comprehensive Material 3 component library built with Jetpack Compose**

An elegant collection of production-ready Material 3 components showcasing modern Android UI development with the latest design system principles.

## Features

- **Complete Component Library** - 125+ Material 3 components across 8 categories
- **Material 3 Enhanced** - Custom expressive theming with vibrant colors and improved typography
- **Production Ready** - Clean architecture with advanced state management
- **Modern Navigation** - Type-safe routing with Compose Navigation
- **Accessibility First** - WCAG compliant with inclusive design principles

## Component Categories

| Category | Components | Examples |
|----------|------------|----------|
| **Buttons & Actions** | 5 | Filled, Outlined, Text, FAB, Icon buttons |
| **Cards & Surfaces** | 8 | Elevated, Outlined, Interactive, Media cards |
| **Navigation** | 10 | NavigationBar, Rail, Drawer, TopAppBar |
| **Input & Forms** | 15 | TextField, DatePicker, Checkbox, Slider |
| **Progress & Feedback** | 12 | Progress indicators, SnackBar, Badge |
| **Chips & Selection** | 12 | Assist, Filter, Input, Suggestion chips |
| **Lists & Data Display** | 12 | LazyColumn, LazyGrid, Pull-to-refresh |
| **Dialogs & Overlays** | 15 | AlertDialog, BottomSheet, Tooltip |

## Technology Stack

- **Jetpack Compose** - Modern declarative UI toolkit
- **Material 3** - Enhanced with custom expressive theming
- **Kotlin** - 100% Kotlin implementation
- **Navigation Compose** - Type-safe navigation architecture
- **State Management** - Advanced Compose state patterns

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or newer
- Compile SDK 34+
- Min SDK 24 (Android 7.0)
- Kotlin 1.9.0+

### Installation

```bash
git clone https://github.com/ujjwalsai3007/ComposeCookBook.git
cd ComposeCookBook
```

Open in Android Studio and run the project to explore all components.

## Architecture

### Project Structure

```
app/src/main/java/com/example/androidui/
├── data/
│   └── ComponentCategory.kt      # Component registry
├── ui/
│   ├── components/               # Component screens
│   ├── navigation/               # Navigation system
│   └── theme/                    # Material 3 theme
└── MainActivity.kt               # Entry point
```

### Usage Example

```kotlin
@Composable
fun YourScreen() {
    ComposeCookbookTheme {
        ButtonsScreen()
    }
}
```

## Highlights

- **125+ Components** across 8 comprehensive categories
- **Material 3 Enhanced** with custom expressive theming
- **Production-ready** code with clean architecture
- **Professional workflow** demonstrated through structured Git branches
- **Accessibility-first** approach with inclusive design principles

---

**Built with modern Android development best practices**

