package com.example.myapplication01

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

data class AndroidTopic(
    val id: Int,
    val moduleNumber: Int,
    val title: String,
    val subtitle: String,
    val description: String,
    val emoji: String,
    val studyNotes: String,
    val practicalTitle: String,
    val codeSnippet: String
)

val officialAndroidTopics = listOf(
    AndroidTopic(
        id = 1,
        moduleNumber = 1,
        title = "Jetpack Compose UI & Material 3",
        subtitle = "Declarative UIs, Layouts & Modifiers",
        description = "Official Guide to building modern UIs with Compose. Covers Column, Row, Box, Surface, and custom Modifiers.",
        emoji = "🎨",
        studyNotes = """
📚 Deep Study Guide: Jetpack Compose & Material 3

1. What is Jetpack Compose?
Jetpack Compose is Android's modern toolkit for native UI development. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.

2. Declarative Paradigm:
Unlike traditional XML views where you mutate views imperatively (e.g., view.setText()), Compose is declarative. You describe your UI state, and Compose updates the screen automatically when state changes.

3. Core Layout Building Blocks:
• Column: Places items vertically.
• Row: Places items horizontally.
• Box: Overlaps items on top of each other.
• Surface: Provides background color, elevation, and borders conforming to Material 3.

4. Modifiers:
Modifiers allow you to decorate or augment a composable. Common modifiers include padding(), fillMaxWidth(), background(), clip(), and clickable(). Order matters!
        """.trimIndent(),
        practicalTitle = "Compose Layout Playground",
        codeSnippet = """
@Composable
fun ComposeLayoutDemo() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Material 3 UI", style = MaterialTheme.typography.headlineSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(modifier = Modifier.weight(1f).background(MaterialTheme.colorScheme.primary))
            Box(modifier = Modifier.weight(1f).background(MaterialTheme.colorScheme.secondary))
        }
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 2,
        moduleNumber = 2,
        title = "State Management & ViewModels",
        subtitle = "remember, StateFlow & MVVM Architecture",
        description = "Official Guide to state hoisting, unidirectional data flow (UDF), and ViewModels surviving configuration changes.",
        emoji = "🧠",
        studyNotes = """
📚 Deep Study Guide: State Management & MVVM

1. Understanding State in Compose:
State is any value that can change over time. When state changes, Compose triggers a 'recomposition' to update the UI.
• remember: Stores state across recompositions.
• mutableStateOf: Creates an observable state holder.

2. State Hoisting:
A pattern where state is moved to a parent composable to make child composables stateless and reusable.

3. ViewModel & StateFlow:
ViewModels store UI-related data that survives configuration changes (like screen rotation). StateFlow is a reactive stream that exposes UI state to Composables safely.
        """.trimIndent(),
        practicalTitle = "State Hoisting & Counter Demo",
        codeSnippet = """
class MyViewModel : ViewModel() {
    private val _count = MutableStateFlow(0)
    val count: StateFlow<Int> = _count

    fun increment() { _count.value++ }
}

@Composable
fun StateDemo(viewModel: MyViewModel = viewModel()) {
    val count by viewModel.count.collectAsState()
    Button(onClick = { viewModel.increment() }) {
        Text("Count: count")
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 3,
        moduleNumber = 3,
        title = "Navigation & Screen Routing",
        subtitle = "Navigation Compose, NavController & Routes",
        description = "Official Guide to type-safe navigation between composable screens, passing arguments, and deep links.",
        emoji = "🧭",
        studyNotes = """
📚 Deep Study Guide: Navigation Compose

1. What is Navigation Compose?
Navigation Compose enables navigating between different composables in your app with built-in back stack management, argument passing, and deep linking.

2. Core Components:
• NavController: The central API that manages app navigation within a NavHost.
• NavHost: A composable container that links a NavController with a navigation graph.
• routes: String or serializable objects defining destination screens.
        """.trimIndent(),
        practicalTitle = "Tab & Screen Routing Demo",
        codeSnippet = """
@Composable
fun NavigationDemo() {
    var currentTab by remember { mutableIntStateOf(0) }
    PrimaryTabRow(selectedTabIndex = currentTab) {
        Tab(selected = currentTab == 0, onClick = { currentTab = 0 }, text = { Text("Home") })
        Tab(selected = currentTab == 1, onClick = { currentTab = 1 }, text = { Text("Profile") })
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 4,
        moduleNumber = 4,
        title = "Lazy Lists & Grids (LazyColumn)",
        subtitle = "Efficient Collections, Cards & DiffUtil",
        description = "Official Guide to rendering large lists and grids efficiently without memory overhead using LazyColumn and LazyVerticalGrid.",
        emoji = "📋",
        studyNotes = """
📚 Deep Study Guide: Lazy Lists & Grids

1. Why Lazy Components?
Unlike Column which renders all children at once, LazyColumn (like RecyclerView) only renders items currently visible on the screen, recycling views as you scroll.

2. Key Building Blocks:
• LazyColumn: Vertical scrollable list.
• LazyRow: Horizontal scrollable list.
• items(): DSL builder to iterate over collections.
• keys: Ensures item state is preserved during reordering or deletion.
        """.trimIndent(),
        practicalTitle = "Dynamic LazyColumn List",
        codeSnippet = """
@Composable
fun LazyListDemo() {
    val items = remember { mutableStateListOf("Item 1", "Item 2", "Item 3") }
    LazyColumn {
        items(items) { item ->
            Card(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                Text(text = item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 5,
        moduleNumber = 5,
        title = "Room Database & Local Storage",
        subtitle = "SQLite Abstraction, Entities, DAOs",
        description = "Official Guide to storing structured app data locally using Room persistent library with compile-time SQL verification.",
        emoji = "💾",
        studyNotes = """
📚 Deep Study Guide: Room Database

1. What is Room?
Room is an SQLite object-mapping library that provides an abstraction layer over SQLite for robust database access.

2. Key Components:
• @Entity: Represents a table in the database.
• @Dao (Data Access Object): Contains methods for querying, inserting, updating, and deleting data.
• RoomDatabase: The main database holder class that connects DAOs.
        """.trimIndent(),
        practicalTitle = "Local Database Simulation",
        codeSnippet = """
@Entity(tableName = "users")
data class UserEntity(@PrimaryKey val id: Int, val name: String)

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Insert
    suspend fun insertUser(user: UserEntity)
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 6,
        moduleNumber = 6,
        title = "Networking & Retrofit APIs",
        subtitle = "REST APIs, OkHttp, JSON & Kotlin Serialization",
        description = "Official Guide to consuming web services, handling HTTP requests, and parsing JSON responses asynchronously.",
        emoji = "🌐",
        studyNotes = """
📚 Deep Study Guide: Networking & Retrofit

1. What is Retrofit?
Retrofit is a type-safe HTTP client for Android and Java developed by Square. It turns your HTTP API into a Kotlin interface.

2. Key Concepts:
• Annotations: @GET, @POST, @Path, @Query define request types and parameters.
• Coroutines Integration: Suspend functions allow calling network endpoints asynchronously without blocking the UI thread.
        """.trimIndent(),
        practicalTitle = "REST API Request Simulation",
        codeSnippet = """
interface ApiService {
    @GET("users/profile")
    suspend fun getUserProfile(): UserProfileDto
}

// Usage with Coroutines
lifecycleScope.launch {
    val profile = apiService.getUserProfile()
    updateUi(profile)
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 7,
        moduleNumber = 7,
        title = "Coroutines & Asynchronous Flow",
        subtitle = "suspend functions, Dispatchers, StateFlow",
        description = "Official Guide to writing non-blocking asynchronous code in Kotlin using Coroutines and reactive cold/hot Flows.",
        emoji = "⚡",
        studyNotes = """
📚 Deep Study Guide: Coroutines & Flows

1. What are Coroutines?
Coroutines are Kotlin's lightweight threads for asynchronous programming. They allow writing sequential code without blocking threads.

2. Dispatchers:
• Dispatchers.IO: Optimized for disk and network I/O.
• Dispatchers.Main: UI thread for rendering UI updates.
• Dispatchers.Default: CPU-intensive work (sorting, parsing).
        """.trimIndent(),
        practicalTitle = "Coroutine Async Simulation",
        codeSnippet = """
fun loadDataAsync() {
    viewModelScope.launch(Dispatchers.IO) {
        val data = fetchFromNetwork()
        withContext(Dispatchers.Main) {
            uiState = data
        }
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 8,
        moduleNumber = 8,
        title = "Background Tasks & WorkManager",
        subtitle = "CoroutinesWorker, PeriodicWork & Constraints",
        description = "Official Guide to scheduling deferrable, guaranteed background work even if the app exits or device restarts.",
        emoji = "⚙️",
        studyNotes = """
📚 Deep Study Guide: WorkManager

1. What is WorkManager?
WorkManager is the recommended Android library for persistent, deferrable background work that needs to run even if the app restarts.

2. Key Features:
• Constraints: Set requirements like Wi-Fi connection, battery not low, or charging.
• CoroutineWorker: Integrates seamlessly with Kotlin coroutines for background tasks.
        """.trimIndent(),
        practicalTitle = "WorkManager Scheduler Demo",
        codeSnippet = """
class SyncWorker(appContext: Context, workerParams: WorkerParameters) : 
    CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        syncDataWithServer()
        return Result.success()
    }
}
        """.trimIndent()
    )
)

// Training Logo Composable used exclusively on the Splash Screen
@Composable
fun TrainingLogo(modifier: Modifier = Modifier, size: Int = 80) {
    Surface(
        modifier = modifier.size(width = (size * 1.15).dp, height = size.dp),
        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp, topStart = 10.dp, topEnd = 10.dp),
        color = Color.White,
        shadowElevation = 6.dp,
        border = BorderStroke(2.dp, Color(0xFFCFD8DC)) // Silver shield outline
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 1.dp),
                color = Color.White
            ) {
                Text(
                    text = "Towards Excellence",
                    color = Color(0xFF1A237E),
                    fontSize = (size / 10.5).sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFD32F2F)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🦩", fontSize = (size / 2.3).sp)
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF03A9F4)
            ) {
                Text(
                    text = "TRAINING",
                    color = Color.White,
                    fontSize = (size / 8.5).sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
        }
    }
}

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2200) // 2.2 seconds splash screen
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.colorScheme.surface)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            TrainingLogo(size = 140)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Android Masterclass Training",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Towards Excellence in Mobile Development",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeachingAppRoot(modifier: Modifier = Modifier) {
    var showSplash by remember { mutableStateOf(true) }
    var selectedTopic by remember { mutableStateOf<AndroidTopic?>(null) }

    if (showSplash) {
        SplashScreen(onSplashFinished = { showSplash = false })
    } else {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = if (selectedTopic == null) "Official Android Curriculum Hub" else selectedTopic!!.title,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (selectedTopic != null) {
                            IconButton(onClick = { selectedTopic = null }) {
                                Text("←", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
        ) { innerPadding ->
            if (selectedTopic == null) {
                TopicListScreen(
                    topics = officialAndroidTopics,
                    modifier = Modifier.padding(innerPadding),
                    onTopicSelected = { selectedTopic = it }
                )
            } else {
                TopicPracticalDetailScreen(
                    androidTopic = selectedTopic!!,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun TopicListScreen(
    topics: List<AndroidTopic>,
    modifier: Modifier = Modifier,
    onTopicSelected: (AndroidTopic) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "📖 Official Android Documentation Hub",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Explore all core official Android development topics covering UI, State, Architecture, Networking, Storage, and Background processing with live practicals and source code. Scroll down to view all 8 modules!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.85f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }

        items(topics) { topic ->
            TopicCard(topic = topic, onClick = { onTopicSelected(topic) })
        }
    }
}

@Composable
fun TopicCard(topic: AndroidTopic, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(56.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = topic.emoji, fontSize = 28.sp)
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Module ${topic.moduleNumber}: ${topic.title}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = topic.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = topic.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                    maxLines = 2
                )
            }

            Text("➔", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun TopicPracticalDetailScreen(androidTopic: AndroidTopic, modifier: Modifier = Modifier) {
    var viewMode by remember { mutableIntStateOf(0) } // 0 = Study Notes, 1 = Live Demo, 2 = Source Code

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Topic Info Banner
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "${androidTopic.emoji} Module ${androidTopic.moduleNumber}: ${androidTopic.title}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = androidTopic.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.9f)
                )
            }
        }

        // Segmented Switcher for Study Notes vs Demo vs Code
        SecondaryTabRow(selectedTabIndex = viewMode, modifier = Modifier.clip(RoundedCornerShape(12.dp))) {
            Tab(
                selected = viewMode == 0,
                onClick = { viewMode = 0 },
                text = { Text("📖 Study Notes", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
            )
            Tab(
                selected = viewMode == 1,
                onClick = { viewMode = 1 },
                text = { Text("🎮 Live Demo", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
            )
            Tab(
                selected = viewMode == 2,
                onClick = { viewMode = 2 },
                text = { Text("💻 Source Code", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
            )
        }

        // Content Area
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            when (viewMode) {
                0 -> StudyNotesScreen(notes = androidTopic.studyNotes)
                1 -> {
                    when (androidTopic.id) {
                        1 -> PracticalTopic1()
                        2 -> PracticalTopic2()
                        3 -> PracticalTopic3()
                        4 -> PracticalTopic4()
                        5 -> PracticalTopic5()
                        6 -> PracticalTopic6()
                        7 -> PracticalTopic7()
                        8 -> PracticalTopic8()
                    }
                }
                2 -> CodeViewerScreen(code = androidTopic.codeSnippet)
            }
        }
    }
}

@Composable
fun StudyNotesScreen(notes: String) {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = notes,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 22.sp
            )
        }
    }
}

@Composable
fun CodeViewerScreen(code: String) {
    val scrollState = rememberScrollState()
    val horizontalScrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scrollState)
                .horizontalScroll(horizontalScrollState)
        ) {
            Text(
                text = code,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// Practical 1: UI & Material 3
@Composable
fun PracticalTopic1() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Compose Layout & Material 3", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Building responsive UIs with Column, Row, and Surface.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Box(
                modifier = Modifier.weight(1f).height(90.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text("Primary Box", color = Color.White, fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier.weight(1f).height(90.dp).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center
            ) {
                Text("Secondary Box", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

// Practical 2: State & ViewModel
@Composable
fun PracticalTopic2() {
    var count by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ViewModel & State Simulation", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Simulating StateFlow and state hoisting in architecture.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("State Value: $count", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { count++ }) { Text("Emit New State (+)") }
            }
        }
    }
}

// Practical 3: Navigation
@Composable
fun PracticalTopic3() {
    var currentTab by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Navigation Compose Demo", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        PrimaryTabRow(selectedTabIndex = currentTab, modifier = Modifier.clip(RoundedCornerShape(12.dp))) {
            Tab(selected = currentTab == 0, onClick = { currentTab = 0 }, text = { Text("Home") })
            Tab(selected = currentTab == 1, onClick = { currentTab = 1 }, text = { Text("Details") })
        }
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).clip(RoundedCornerShape(12.dp)).background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Text(if (currentTab == 0) "🏠 Welcome to HomeScreen" else "📄 Welcome to DetailsScreen", fontWeight = FontWeight.Bold)
        }
    }
}

// Practical 4: Lazy Lists
@Composable
fun PracticalTopic4() {
    val items = remember { mutableStateListOf("RecyclerView Replacement", "LazyColumn Item Rendering", "Keys & State Preservation") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("LazyColumn Demo", fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(items) { item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "• $item", modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

// Practical 5: Room Database
@Composable
fun PracticalTopic5() {
    var dbStatus by remember { mutableStateOf("Database idle (0 records)") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Room Database Simulation", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(dbStatus, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
        Button(onClick = { dbStatus = "Inserted UserEntity successfully (1 record)" }) {
            Text("Insert Record (DAO)")
        }
    }
}

// Practical 6: Networking & Retrofit
@Composable
fun PracticalTopic6() {
    var apiState by remember { mutableStateOf("Press fetch to query API") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Retrofit REST API Simulation", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(apiState, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        Button(onClick = { apiState = "Response 200 OK: {\"name\": \"Android Dev\", \"status\": \"Active\"}" }) {
            Text("GET /api/v1/profile")
        }
    }
}

// Practical 7: Coroutines & Flows
@Composable
fun PracticalTopic7() {
    var progress by remember { mutableStateOf("Dispatchers.IO ready") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Coroutines & StateFlow Demo", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(progress, style = MaterialTheme.typography.bodyMedium)
        Button(onClick = { progress = "Completed background work on IO thread!" }) {
            Text("Launch Coroutine Task")
        }
    }
}

// Practical 8: WorkManager
@Composable
fun PracticalTopic8() {
    var workStatus by remember { mutableStateOf("Work idle") }
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("WorkManager Background Sync", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(workStatus, style = MaterialTheme.typography.bodyMedium)
        Button(onClick = { workStatus = "Enqueued CoroutineWorker with constraints (ENQUEUED)" }) {
            Text("Enqueue Periodic Background Work")
        }
    }
}
