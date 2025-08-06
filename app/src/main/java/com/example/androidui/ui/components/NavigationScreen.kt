package com.example.androidui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidui.ui.theme.ComposeCookbookTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var selectedNavItem by remember { mutableIntStateOf(0) }
    var selectedRailItem by remember { mutableIntStateOf(0) }
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item {
            Text(
                text = "Navigation Components",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }

        item {
            Text(
                text = "Material 3 Enhanced navigation patterns for seamless user journeys",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Navigation Bar Section
        item {
            NavigationBarSection(
                selectedNavItem = selectedNavItem,
                onNavItemSelected = { selectedNavItem = it }
            )
        }

        // Top App Bar Section
        item {
            TopAppBarSection()
        }

        // Tab Section
        item {
            TabSection(
                selectedTabIndex = selectedTabIndex,
                onTabSelected = { selectedTabIndex = it }
            )
        }

        // Navigation Rail Section
        item {
            NavigationRailSection(
                selectedRailItem = selectedRailItem,
                onRailItemSelected = { selectedRailItem = it }
            )
        }

        // Navigation Drawer Section
        item {
            NavigationDrawerSection()
        }
    }
}

@Composable
private fun NavigationBarSection(
    selectedNavItem: Int,
    onNavItemSelected: (Int) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Navigation Bar",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Bottom navigation with badges and state management",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Standard Navigation Bar
            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surfaceContainer
            ) {
                navItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.hasBadge) {
                                        Badge(
                                            containerColor = MaterialTheme.colorScheme.error
                                        ) {
                                            if (item.badgeCount != null) {
                                                Text(item.badgeCount.toString())
                                            }
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (selectedNavItem == index) item.selectedIcon else item.unselectedIcon,
                                    contentDescription = item.title
                                )
                            }
                        },
                        label = { Text(item.title) },
                        selected = selectedNavItem == index,
                        onClick = { onNavItemSelected(index) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Compact Navigation Bar
            Text(
                text = "Compact variant (labels only when selected)",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            NavigationBar(
                modifier = Modifier.fillMaxWidth(),
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
            ) {
                navItems.take(3).forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (selectedNavItem == index) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        label = if (selectedNavItem == index) {
                            { Text(item.title) }
                        } else null,
                        selected = selectedNavItem == index,
                        onClick = { onNavItemSelected(index) },
                        alwaysShowLabel = false
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarSection() {
    var showMenu by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Top App Bar",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "App bars with actions, overflow menus, and search functionality",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Standard Top App Bar
            TopAppBar(
                title = { Text("Standard App Bar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Settings") },
                            onClick = { showMenu = false },
                            leadingIcon = { Icon(Icons.Default.Settings, contentDescription = null) }
                        )
                        DropdownMenuItem(
                            text = { Text("Help") },
                            onClick = { showMenu = false },
                            leadingIcon = { Icon(Icons.Default.Star, contentDescription = null) }
                        )
                        DropdownMenuItem(
                            text = { Text("About") },
                            onClick = { showMenu = false },
                            leadingIcon = { Icon(Icons.Default.Info, contentDescription = null) }
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Medium Top App Bar
            MediumTopAppBar(
                title = { Text("Medium App Bar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorite")
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Large Top App Bar
            LargeTopAppBar(
                title = { Text("Large App Bar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit")
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onTertiaryContainer
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar
            Text(
                text = "Search Bar Integration",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            SearchBar(
                query = searchText,
                onQueryChange = { searchText = it },
                onSearch = { isSearchActive = false },
                active = isSearchActive,
                onActiveChange = { isSearchActive = it },
                placeholder = { Text("Search components...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        IconButton(onClick = { searchText = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                // Search suggestions/results
                repeat(3) { index ->
                    ListItem(
                        headlineContent = { Text("Search result ${index + 1}") },
                        supportingContent = { Text("Matching component for '$searchText'") },
                        leadingContent = { Icon(Icons.Default.Star, contentDescription = null) },
                        modifier = Modifier.clickableNoRipple { 
                            searchText = "Search result ${index + 1}"
                            isSearchActive = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun TabSection(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Tab Components",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Horizontal navigation with icons and text labels",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Primary Tab Row
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                tabItems.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { onTabSelected(index) },
                        text = { Text(tab.title) },
                        icon = { Icon(tab.icon, contentDescription = null) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Secondary Tab Row (text only)
            Text(
                text = "Text-only tabs",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {
                listOf("Overview", "Details", "Reviews").forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { onTabSelected(index) },
                        text = { Text(title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Scrollable Tab Row
            Text(
                text = "Scrollable tabs (many options)",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                edgePadding = 16.dp
            ) {
                longTabList.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { onTabSelected(index) },
                        text = { Text(title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tab content preview
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = if (selectedTabIndex < tabItems.size) {
                                tabItems[selectedTabIndex].icon
                            } else {
                                Icons.Default.Info
                            },
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (selectedTabIndex < tabItems.size) {
                                "${tabItems[selectedTabIndex].title} Content"
                            } else {
                                "Tab ${selectedTabIndex + 1} Content"
                            },
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun NavigationRailSection(
    selectedRailItem: Int,
    onRailItemSelected: (Int) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Navigation Rail",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Vertical navigation for tablets and wide screens",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Navigation Rail
                NavigationRail(
                    modifier = Modifier.width(80.dp),
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    header = {
                        FloatingActionButton(
                            onClick = { },
                            modifier = Modifier.padding(bottom = 16.dp),
                            containerColor = MaterialTheme.colorScheme.primary
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }
                ) {
                    navItems.take(4).forEachIndexed { index, item ->
                        NavigationRailItem(
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (item.hasBadge) {
                                            Badge(
                                                containerColor = MaterialTheme.colorScheme.error
                                            ) {
                                                if (item.badgeCount != null) {
                                                    Text(item.badgeCount.toString())
                                                }
                                            }
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (selectedRailItem == index) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            },
                            label = { Text(item.title) },
                            selected = selectedRailItem == index,
                            onClick = { onRailItemSelected(index) }
                        )
                    }
                }

                // Content area
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = navItems[selectedRailItem].selectedIcon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "${navItems[selectedRailItem].title} Screen",
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Content for the ${navItems[selectedRailItem].title.lowercase()} section",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NavigationDrawerSection() {
    var isDrawerOpen by remember { mutableStateOf(false) }
    var selectedDrawerItem by remember { mutableIntStateOf(0) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Navigation Drawer",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Side navigation with hierarchical menu structure",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Drawer Demo Button
            Button(
                onClick = { isDrawerOpen = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.Menu, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Open Navigation Drawer")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Modal Navigation Drawer Preview (simulated)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHigh
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Drawer Content (always visible for demo)
                    ModalDrawerSheet(
                        modifier = Modifier.width(280.dp),
                        drawerContainerColor = MaterialTheme.colorScheme.surface
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))
                        
                        // Header
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "John Doe",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "john@example.com",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                        Spacer(modifier = Modifier.height(8.dp))

                        // Navigation Items
                        drawerItems.forEachIndexed { index, item ->
                            NavigationDrawerItem(
                                icon = { Icon(item.icon, contentDescription = null) },
                                label = { Text(item.title) },
                                selected = selectedDrawerItem == index,
                                onClick = { selectedDrawerItem = index },
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                            )
                        }
                    }

                    // Main content area
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Main Content Area",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }

    // Actual Modal Drawer (for demo)
    if (isDrawerOpen) {
        val modalDrawerState = rememberDrawerState(DrawerValue.Open)
        LaunchedEffect(modalDrawerState.isClosed) {
            if (modalDrawerState.isClosed) {
                isDrawerOpen = false
            }
        }
        ModalNavigationDrawer(
            drawerState = modalDrawerState,
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = MaterialTheme.colorScheme.surface
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    // Header
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "John Doe",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "john@example.com",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
                    Spacer(modifier = Modifier.height(16.dp))

                    // Navigation Items
                    drawerItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            icon = { Icon(item.icon, contentDescription = null) },
                            label = { Text(item.title) },
                            selected = selectedDrawerItem == index,
                            onClick = { 
                                selectedDrawerItem = index
                                isDrawerOpen = false
                            },
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }

                    HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp))

                    // Settings and Help
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.Settings, contentDescription = null) },
                        label = { Text("Settings") },
                        selected = false,
                        onClick = { isDrawerOpen = false },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )
                    NavigationDrawerItem(
                        icon = { Icon(Icons.Default.Star, contentDescription = null) },
                        label = { Text("Help & Feedback") },
                        selected = false,
                        onClick = { isDrawerOpen = false },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
                    )
                }
            }
        ) {
            // Empty content for demo
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = { isDrawerOpen = false }) {
                    Text("Close Drawer")
                }
            }
        }
    }
}

// Helper composable for clickable without ripple
@Composable
private fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier {
    return this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}

// Data Classes and Sample Data
data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean = false,
    val badgeCount: Int? = null
)

data class TabItem(
    val title: String,
    val icon: ImageVector
)

data class DrawerItem(
    val title: String,
    val icon: ImageVector
)

private val navItems = listOf(
    NavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Default.Home
    ),
    NavigationItem(
        title = "Messages",
        selectedIcon = Icons.Filled.Email,
        unselectedIcon = Icons.Default.Email,
        hasBadge = true,
        badgeCount = 5
    ),
    NavigationItem(
        title = "Notifications",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Default.Notifications,
        hasBadge = true
    ),
    NavigationItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Default.Person
    )
)

private val tabItems = listOf(
    TabItem("Photos", Icons.Default.Star),
    TabItem("Videos", Icons.Default.PlayArrow),
    TabItem("Music", Icons.Default.Star),
    TabItem("Files", Icons.Default.Star)
)

private val longTabList = listOf(
    "Overview", "Features", "Specifications", "Reviews", "Comparisons", 
    "Gallery", "Videos", "Support", "Downloads", "Community"
)

private val drawerItems = listOf(
    DrawerItem("Dashboard", Icons.Default.Star),
    DrawerItem("Projects", Icons.Default.Star),
    DrawerItem("Tasks", Icons.Default.Star),
    DrawerItem("Calendar", Icons.Default.Star),
    DrawerItem("Analytics", Icons.Default.Star),
    DrawerItem("Team", Icons.Default.Star),
    DrawerItem("Reports", Icons.Default.Star)
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationScreenPreview() {
    ComposeCookbookTheme {
        NavigationScreen()
    }
}

@Preview(name = "Navigation Dark", showBackground = true)
@Composable
fun NavigationScreenDarkPreview() {
    ComposeCookbookTheme(darkTheme = true) {
        NavigationScreen()
    }
}