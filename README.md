# 📱 Compose Cookbook

[![GitHub stars](https://img.shields.io/github/stars/ujjwalsai3007/ComposeCookBook?style=social)](https://github.com/ujjwalsai3007/ComposeCookBook/stargazers)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)
[![Kotlin](https://img.shields.io/badge/kotlin-2.0.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.09.00-blue)](https://developer.android.com/jetpack/compose)
[![Material3](https://img.shields.io/badge/Material%203-Enhanced-purple)](https://m3.material.io/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)

> **The definitive Material 3 component library for Jetpack Compose developers**

A comprehensive collection of **125+ production-ready Material 3 components** showcasing modern Android UI development with **Material 3 Enhanced** theming, accessibility, and performance optimization.



## ✨ Why Compose Cookbook?

**Tired of searching for Material 3 component examples?** This repository solves that problem by providing:

- 🎯 **Copy-paste ready components** - No more reinventing the wheel
- 📚 **Complete component coverage** - Every Material 3 component in one place  
- 🎨 **Enhanced theming** - Beautiful custom Material 3 implementation
- ⚡ **Performance optimized** - Lazy loading, state management, and best practices
- 🌐 **Accessibility first** - WCAG compliant with inclusive design

## 🚀 Quick Start

```bash
git clone https://github.com/ujjwalsai3007/ComposeCookBook.git
cd ComposeCookBook
```

Open in Android Studio and run the project. Browse components by category and copy the code you need!

## 📋 Component Library

| Category | Components | Key Examples |
|----------|------------|--------------|
| **🔴 Buttons & Actions** | 5 | `FilledButton`, `OutlinedButton`, `FloatingActionButton` |
| **🏠 Cards & Surfaces** | 8 | `ElevatedCard`, `OutlinedCard`, `InteractiveCard` |
| **🎯 Navigation** | 10 | `NavigationBar`, `NavigationRail`, `TopAppBar` |
| **📝 Input & Forms** | 15 | `TextField`, `DatePicker`, `Checkbox`, `Slider` |
| **📊 Progress & Feedback** | 12 | `CircularProgressIndicator`, `SnackBar`, `Badge` |
| **🏷️ Chips & Selection** | 12 | `AssistChip`, `FilterChip`, `InputChip` |
| **📋 Lists & Data Display** | 12 | `LazyColumn`, `LazyGrid`, `Pull-to-refresh` |
| **💬 Dialogs & Overlays** | 15 | `AlertDialog`, `BottomSheet`, `Tooltip` |

**Total: 125+ Components** across 8 comprehensive categories

## 🛠️ Technology Stack

- **Jetpack Compose** - Modern declarative UI toolkit
- **Material 3 Enhanced** - Custom implementation inspired by expressive design principles
- **Kotlin** - 100% Kotlin implementation
- **Navigation Compose** - Type-safe navigation architecture
- **State Management** - Advanced Compose state patterns

## 💡 Usage Examples

### DatePicker Component
```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerExample() {
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    
    OutlinedButton(onClick = { showDatePicker = true }) {
        Text(
            text = selectedDate?.let {
                SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(it))
            } ?: "Select Date"
        )
    }
    
    if (showDatePicker) {
        DatePickerDialog(
            onDateSelected = { selectedDate = it },
            onDismiss = { showDatePicker = false }
        )
    }
}
```

### Navigation Bar
```kotlin
@Composable
fun BottomNavigationExample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Profile")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)
    
    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}
```

### Custom Theme Usage
```kotlin
@Composable
fun YourApp() {
    ComposeCookbookTheme {
        // Your app content with enhanced Material 3 theming
        ButtonsScreen()
    }
}
```

## 📁 Project Structure

```
app/src/main/java/com/example/androidui/
├── data/
│   └── ComponentCategory.kt      # Component registry
├── ui/
│   ├── components/               # Component screens
│   │   ├── ButtonsScreen.kt      # Button examples
│   │   ├── CardsScreen.kt        # Card layouts  
│   │   ├── InputFormsScreen.kt   # Form components
│   │   └── ...                   # All other categories
│   ├── navigation/               # Navigation system
│   └── theme/                    # Material 3 theme
│       ├── Color.kt              # Enhanced color palette
│       ├── Type.kt               # Typography system
│       └── Theme.kt              # Theme implementation
└── MainActivity.kt               # Entry point
```

## 🎨 Enhanced Material 3 Features

- **Dynamic Colors** - Vibrant, emotionally resonant color palettes
- **Advanced Typography** - Improved contrast and readability  
- **Accessibility Excellence** - Screen reader support and inclusive design
- **Performance Optimization** - Lazy loading and efficient state management
- **Dark/Light Themes** - Beautiful theming for all preferences

## 🏗️ Architecture

Built with modern Android architecture patterns:

- **MVVM Architecture** - Clean separation of concerns
- **Repository Pattern** - Centralized data management  
- **Unidirectional Data Flow** - Predictable state management
- **Compose Navigation** - Type-safe navigation
- **Material 3 Guidelines** - Following latest design principles

## 📱 Requirements

- Android Studio Arctic Fox or newer
- Compile SDK 34+
- Min SDK 24 (Android 7.0)
- Kotlin 1.9.0+

## 📚 Reference Library

This is a **comprehensive reference library** for Material 3 Compose development. All components are production-ready and copy-paste friendly for your projects.

> **Note**: This repository serves as a curated reference collection. For questions or suggestions, please use the repository's discussion features.

## 📄 License

```
MIT License

Copyright (c) 2024 Ujjwal Sai

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## ⭐ Support

If this project helps you, please consider:
- ⭐ **Starring** this repository
- 🐛 **Reporting** bugs and issues  
- 💡 **Suggesting** new components or improvements
- 🔄 **Sharing** with other developers

---

**Built with ❤️ for the Android developer community**

*Making Material 3 component development effortless, one component at a time.*
