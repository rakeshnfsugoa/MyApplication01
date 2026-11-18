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

// Training Logo Composable
@Composable
fun TrainingLogo(modifier: Modifier = Modifier, size: Int = 80) {
    Surface(
        modifier = modifier.size(width = (size * 1.15).dp, height = size.dp),
        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp, topStart = 10.dp, topEnd = 10.dp),
        color = Color.White,
        shadowElevation = 6.dp,
        border = BorderStroke(2.dp, Color(0xFFCFD8DC))
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
        delay(2200)
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
                text = "Module-III: Mobile App Development",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Towards Excellence Training Curriculum",
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
                            text = if (selectedTopic == null) "Module-III: Mobile App Development" else "Section (${selectedTopic!!.moduleCode}): ${selectedTopic!!.title}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
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
                    topics = syllabusTopics,
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
                        text = "📖 Module-III Official Syllabus (a to h)",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Explore all 8 official syllabus sections covering Android/iOS architecture, UI/UX, data management, security, testing, and deployment with deep study notes, live practicals, and source code.",
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
                    text = "Section (${topic.moduleCode}): ${topic.title}",
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
                    text = "${androidTopic.emoji} Section (${androidTopic.moduleCode}): ${androidTopic.title}",
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
                        1 -> PracticalModuleA()
                        2 -> PracticalModuleB()
                        3 -> PracticalModuleC()
                        4 -> PracticalModuleD()
                        5 -> PracticalModuleE()
                        6 -> PracticalModuleF()
                        7 -> PracticalModuleG()
                        8 -> PracticalModuleH()
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

// ==========================================
// SEPARATE, EASY-TO-UNDERSTAND PRACTICAL SCREENS FOR EACH MODULE (A to H)
// ==========================================

// Module A: Introduction to Mobile App Development (Native vs Hybrid)
@Composable
fun PracticalModuleA() {
    var selectedAppType by remember { mutableStateOf("Native Android") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("📱 Ecosystem & App Types", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Tap buttons to see how Native and Hybrid apps differ.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { selectedAppType = "Native Android" }, modifier = Modifier.weight(1f)) { Text("Native") }
            Button(onClick = { selectedAppType = "Cross-Platform (Flutter)" }, modifier = Modifier.weight(1f)) { Text("Hybrid") }
            Button(onClick = { selectedAppType = "Progressive Web App" }, modifier = Modifier.weight(1f)) { Text("PWA") }
        }

        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Selected Approach: $selectedAppType", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    when(selectedAppType) {
                        "Native Android" -> "• Written in Kotlin using Jetpack Compose.\n• Highest performance and direct access to device camera, sensors, and GPS."
                        "Cross-Platform (Flutter)" -> "• Written once in Dart and compiled for both Android and iOS.\n• Saves development time with single codebase."
                        else -> "• Web apps installed directly from browsers with offline support."
                    },
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// Module B: Android Architecture Overview
@Composable
fun PracticalModuleB() {
    var selectedLayer by remember { mutableStateOf("Java API Framework") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🤖 Android Architecture Layers", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Tap each layer to understand its function.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            listOf("System Apps", "Java API Framework", "Native C/C++ Libraries", "Android Runtime (ART)", "Hardware Abstraction Layer (HAL)", "Linux Kernel").forEach { layer ->
                Button(
                    onClick = { selectedLayer = layer },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = if (selectedLayer == layer) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Text(layer, color = if (selectedLayer == layer) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
        }
    }
}

// Module C: iOS Architecture Overview
@Composable
fun PracticalModuleC() {
    var selectedLayer by remember { mutableStateOf("Cocoa Touch") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🍏 iOS Architecture Stack", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Explore Apple iOS layers.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Cocoa Touch", "Media Layer", "Core Services", "Core OS").forEach { layer ->
                Button(
                    onClick = { selectedLayer = layer },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = if (selectedLayer == layer) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Text(layer, color = if (selectedLayer == layer) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
        }
    }
}

// Module D: UI/UX Design Fundamentals
@Composable
fun PracticalModuleD() {
    var isDarkTheme by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎨 UI/UX Design Guidelines", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Toggle theme to test Material Design colors.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(if (isDarkTheme) "🌙 Dark Theme Active" else "☀️ Light Theme Active", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { isDarkTheme = !isDarkTheme }) {
                    Text("Toggle Theme")
                }
            }
        }
    }
}

// Module E: Data Management in Mobile Apps
@Composable
fun PracticalModuleE() {
    var recordCount by remember { mutableIntStateOf(3) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("💾 Local Database & Room", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Insert and delete records in SQLite.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Stored Records: $recordCount", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(onClick = { recordCount++ }) { Text("Insert Record") }
                    OutlinedButton(onClick = { if (recordCount > 0) recordCount-- }) { Text("Delete Record") }
                }
            }
        }
    }
}

// Module F: Security Considerations in Mobile Apps
@Composable
fun PracticalModuleF() {
    var isEncrypted by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🔒 App Security & Encryption", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Test encrypted storage protection.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = if (isEncrypted) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer)
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(if (isEncrypted) "🛡️ AES-256 Storage Encrypted" else "⚠️ Unencrypted Vulnerability", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { isEncrypted = !isEncrypted }) {
                    Text(if (isEncrypted) "Simulate Breach" else "Secure Storage")
                }
            }
        }
    }
}

// Module G: Testing and Debugging Mobile Applications
@Composable
fun PracticalModuleG() {
    val testStatus = remember { mutableStateOf("All Unit Tests Passed (12/12)") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🧪 Testing & Crashlytics", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Run tests and simulate crash reporting.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(testStatus.value, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { testStatus.value = "Crashlytics Report Sent: NullPointerException logged successfully" }) {
                    Text("Simulate Crash")
                }
            }
        }
    }
}

// Module H: Publishing and Deployment
@Composable
fun PracticalModuleH() {
    var isSigned by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🚀 Publishing & Deployment", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text("Easy Beginner Guide: Sign release app bundle for Google Play.", style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(if (isSigned) "📦 App Bundle (.aab) Signed & Ready" else "⏳ Unsigned Build", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { isSigned = !isSigned }) {
                    Text(if (isSigned) "Revoke Keystore" else "Sign with Release Keystore")
                }
            }
        }
    }
}
