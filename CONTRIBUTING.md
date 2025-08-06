# Contributing to Compose Cookbook

Thank you for your interest in contributing to Compose Cookbook! This document provides guidelines and instructions for contributing to this project.

## 🎯 How to Contribute

### Reporting Issues

Before creating an issue, please:

1. **Search existing issues** to avoid duplicates
2. **Use the issue template** provided
3. **Provide detailed information** including:
   - Android version and device
   - Steps to reproduce
   - Expected vs actual behavior
   - Screenshots if applicable

### Suggesting Components

We're always looking for new Material 3 components to add! When suggesting:

1. **Check if it exists** in our current component list
2. **Provide Material 3 documentation** links
3. **Explain the use case** and importance
4. **Include design specifications** if available

### Code Contributions

#### Prerequisites

- Android Studio Arctic Fox or newer
- Knowledge of Kotlin and Jetpack Compose
- Familiarity with Material 3 design principles
- Understanding of Android architecture patterns

#### Development Setup

1. **Fork the repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/ComposeCookBook.git
   cd ComposeCookBook
   ```

2. **Create a branch**
   ```bash
   git checkout -b feature/component-name
   # or
   git checkout -b fix/issue-description
   ```

3. **Set up development environment**
   - Open project in Android Studio
   - Sync Gradle files
   - Run the app to ensure everything works

#### Component Development Guidelines

When adding new components:

##### 1. Component Structure
```kotlin
@Composable
fun YourComponent(
    // Required parameters first
    text: String,
    // Optional parameters with defaults
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    // Callbacks last
    onClick: () -> Unit = {}
) {
    // Component implementation
}
```

##### 2. Documentation Requirements
- **KDoc comments** for all public functions
- **Parameter descriptions** for complex components
- **Usage examples** in comments
- **@Preview annotations** for all variants

##### 3. Code Quality Standards
- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use meaningful variable and function names
- Keep functions focused and single-purpose
- Implement proper error handling
- Follow Material 3 design guidelines

##### 4. Testing Requirements
- Add `@Preview` annotations for different states
- Test light and dark themes
- Ensure accessibility compliance
- Test on different screen sizes

#### Adding a New Component Category

1. **Update ComponentCategory.kt**
   ```kotlin
   ComponentCategory(
       id = "your_category",
       name = "Your Category",
       description = "Description of the category",
       icon = Icons.Default.YourIcon,
       componentCount = X,
       completionStatus = CompletionStatus.COMPLETED,
       route = "your_category",
       components = listOf(/* your components */)
   )
   ```

2. **Create the screen file**
   ```kotlin
   // YourCategoryScreen.kt
   @Composable
   fun YourCategoryScreen() {
       // Implementation
   }
   ```

3. **Update navigation**
   - Add route to `NavigationRoutes.kt`
   - Update `ComposeCookbookNavigation.kt`

#### Pull Request Process

1. **Ensure code quality**
   - Run linting: `./gradlew lint`
   - Fix any warnings or errors
   - Test thoroughly on different devices

2. **Update documentation**
   - Update README.md if needed
   - Add component to the appropriate category
   - Update component count

3. **Create pull request**
   - Use descriptive title and description
   - Reference related issues
   - Include screenshots/GIFs for UI changes
   - Fill out the pull request template

4. **Code review process**
   - Address reviewer feedback promptly
   - Make requested changes
   - Maintain clean commit history

## 📋 Code Style Guidelines

### Kotlin Style
- Use 4 spaces for indentation
- Line length: 120 characters maximum
- Use trailing commas in multi-line declarations
- Prefer `val` over `var` when possible

### Compose Specific
- Use `remember` for state that should survive recomposition
- Hoist state when needed for reusability
- Use `Modifier` parameter consistently
- Follow Material 3 component patterns

### Naming Conventions
- **Composables**: PascalCase (e.g., `ButtonExample`)
- **Parameters**: camelCase (e.g., `onClick`)
- **Constants**: SCREAMING_SNAKE_CASE
- **Files**: PascalCase matching the main composable

## 🎨 Design Guidelines

### Material 3 Compliance
- Follow [Material 3 design principles](https://m3.material.io/)
- Use appropriate color tokens
- Implement proper accessibility features
- Support both light and dark themes

### Component Variants
When creating components, include:
- **Basic variant** - Minimal implementation
- **Enhanced variant** - With additional features
- **Interactive variant** - With state management
- **Accessibility variant** - With proper semantics

## 🧪 Testing

### Preview Testing
```kotlin
@Preview(name = "Light Theme")
@Preview(name = "Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ComponentPreview() {
    ComposeCookbookTheme {
        YourComponent()
    }
}
```

### Accessibility Testing
- Use semantic descriptions
- Ensure proper touch target sizes (48dp minimum)
- Test with TalkBack enabled
- Verify color contrast ratios

## 📚 Resources

### Material 3 Resources
- [Material 3 Design System](https://m3.material.io/)
- [Compose Material 3](https://developer.android.com/jetpack/compose/designsystems/material3)
- [Accessibility in Compose](https://developer.android.com/jetpack/compose/accessibility)

### Development Resources
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose Samples](https://github.com/android/compose-samples)
- [Android Architecture Guidelines](https://developer.android.com/topic/architecture)

## 🤝 Community

### Communication Channels
- **Issues**: For bug reports and feature requests
- **Discussions**: For questions and general discussion
- **Pull Requests**: For code contributions

### Code of Conduct
Please note that this project is governed by our Code of Conduct. By participating, you agree to uphold this code.

## 🎉 Recognition

Contributors will be recognized in:
- README.md contributors section
- Release notes for significant contributions
- Special thanks in documentation

Thank you for contributing to Compose Cookbook! Your efforts help make Material 3 development easier for the entire Android community. 🚀