package com.example.myapplication01

data class AndroidTopic(
    val id: Int,
    val moduleCode: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val emoji: String,
    val studyNotes: String,
    val practicalTitle: String,
    val codeSnippet: String
)

val syllabusTopics = listOf(
    AndroidTopic(
        id = 1,
        moduleCode = "a",
        title = "Introduction to Mobile App Development",
        subtitle = "Ecosystems, Native vs Hybrid & PWAs",
        description = "Overview of mobile ecosystems (Android vs iOS), native vs cross-platform approaches (Flutter, React Native, SwiftUI), and PWAs.",
        emoji = "📱",
        studyNotes = """
📚 Module III - Section (a): Introduction to Mobile App Development

1. Mobile Ecosystems:
• Android (Google): Open-source, diverse hardware devices, Google Play Store.
• iOS (Apple): Closed ecosystem, tight hardware-software integration, Apple App Store.

2. App Development Approaches:
• Native Apps: Built specifically for the OS (Kotlin for Android, Swift for iOS) providing highest performance and full hardware access.
• Cross-Platform Apps: Built with frameworks like Flutter or React Native to share code between Android and iOS.
• Progressive Web Apps (PWAs): Web applications running in browsers with offline support and push notifications.

3. Current Trends:
• Declarative UI frameworks (Jetpack Compose & SwiftUI).
• Multiplatform development and On-Device AI.
        """.trimIndent(),
        practicalTitle = "Platform Comparison Explorer",
        codeSnippet = """
// Beginner Concept: Native vs Cross-Platform
// Native Android uses Kotlin & Jetpack Compose for UI.
@Composable
fun NativeAppScreen() {
    Text("Built with Kotlin & Jetpack Compose")
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 2,
        moduleCode = "b",
        title = "Android Architecture Overview",
        subtitle = "Linux Kernel, ART, Components & Gradle",
        description = "Android platform layers (Kernel, HAL, ART, Framework), app components (Activities, Services, Receivers), lifecycle, and tools (Studio, ADB, Gradle).",
        emoji = "🤖",
        studyNotes = """
📚 Module III - Section (b): Android Architecture Overview

1. Android Stack Layers:
• Linux Kernel: Core drivers, security, and memory management.
• Hardware Abstraction Layer (HAL): Connects hardware to Java APIs.
• Android Runtime (ART): Executes app bytecode (DEX).
• Java API Framework: Standard libraries used by developers.
• System Apps: Pre-installed apps (Camera, Contacts, Browser).

2. Core App Components:
• Activities: Represent individual screens with a user interface.
• Services: Background tasks running without UI.
• Broadcast Receivers: System event listeners.
• Content Providers: Secure data sharing across apps.

3. Development Tools:
• Android Studio (IDE), ADB (Debugging Bridge), and Gradle (Build system).
        """.trimIndent(),
        practicalTitle = "Android Layers & Components Explorer",
        codeSnippet = """
// Beginner Concept: Activity Component Entry Point
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Welcome to Android Architecture")
        }
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 3,
        moduleCode = "c",
        title = "iOS Architecture Overview",
        subtitle = "Cocoa Touch, Core OS, Swift & Xcode",
        description = "iOS architecture layers (Cocoa Touch, Media, Core Services, Core OS), UIViewController, App Delegate, Xcode, and Swift basics.",
        emoji = "🍏",
        studyNotes = """
📚 Module III - Section (c): iOS Architecture Overview

1. iOS Architecture Layers:
• Cocoa Touch: UIKit, SwiftUI, and user interface frameworks.
• Media Layer: Graphics, audio, and video rendering.
• Core Services: Foundation, Core Data, and data management.
• Core OS: Low-level kernel (XNU) and system security.

2. Key iOS Components:
• UIViewController: Manages a single screen and user interactions.
• App Delegate & Scene Delegate: Manage app lifecycle events and window states.

3. Development Tools:
• Xcode IDE, Interface Builder, Swift Package Manager, and Swift language.
        """.trimIndent(),
        practicalTitle = "iOS Architecture Inspector",
        codeSnippet = """
// Beginner Concept: Swift SwiftUI View
import SwiftUI

struct WelcomeView: View {
    var body: some View {
        Text("Hello from iOS SwiftUI!")
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 4,
        moduleCode = "d",
        title = "UI/UX Design Fundamentals",
        subtitle = "Material Design vs HIG, Accessibility & Layouts",
        description = "Material Design (Google) vs Human Interface Guidelines (Apple), responsive layouts, navigation patterns, accessibility, localization, and input handling.",
        emoji = "🎨",
        studyNotes = """
📚 Module III - Section (d): UI/UX Design Fundamentals

1. Design Systems:
• Material Design (Google): Focuses on physical surfaces, bold colors, and motion elevation.
• Human Interface Guidelines (Apple): Focuses on clarity, deference, and Cupertino design standards.

2. Responsive Design & Layouts:
• Adapting UI for phones, foldables, and tablets using constraints and flexible layouts.
• Navigation patterns: Bottom navigation bars, drawers, and tab rows.

3. Accessibility & Inputs:
• Screen readers (TalkBack), minimum touch target sizes (48dp), and gesture recognition.
        """.trimIndent(),
        practicalTitle = "Responsive Layout & Theme Demo",
        codeSnippet = """
// Beginner Concept: Responsive Column Layout
@Composable
fun ResponsiveLayout() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Material 3 Responsive Layout")
        Button(onClick = { /* Action */ }) {
            Text("Clickable Touch Target")
        }
    }
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 5,
        moduleCode = "e",
        title = "Data Management in Mobile Apps",
        subtitle = "Room, SQLite, SharedPreferences & Retrofit",
        description = "Local storage (Shared Preferences, SQLite, Room), cloud storage (Firebase), network communication (REST APIs, JSON parsing, Retrofit).",
        emoji = "💾",
        studyNotes = """
📚 Module III - Section (e): Data Management in Mobile Apps

1. Local Data Storage:
• SharedPreferences / DataStore: Simple key-value pairs for settings.
• SQLite & Room Database: Structured relational database storage with object mapping.

2. Cloud Storage:
• Firebase Firestore / Realtime Database for cloud synchronization and offline caching.

3. Network Communication:
• REST APIs over HTTP/HTTPS, JSON parsing, and Retrofit HTTP client in Android.
        """.trimIndent(),
        practicalTitle = "Room DB & Retrofit Simulation",
        codeSnippet = """
// Beginner Concept: Room Entity & DAO
@Entity(tableName = "users")
data class User(@PrimaryKey val id: Int, val name: String)

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): Flow<List<User>>
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 6,
        moduleCode = "f",
        title = "Security Considerations in Mobile Apps",
        subtitle = "Encryption, SSL Pinning, Biometrics & ProGuard",
        description = "Secure data storage, encrypted databases, SSL pinning, app sandboxing, permissions management, OAuth2, biometrics, and code obfuscation (ProGuard).",
        emoji = "🔒",
        studyNotes = """
📚 Module III - Section (f): Security Considerations in Mobile Apps

1. Secure Data Storage:
• EncryptedSharedPreferences and SQLCipher for local database encryption.
• HTTPS and SSL Pinning to prevent Man-in-the-Middle network attacks.

2. Permissions & Authentication:
• OS-level app sandboxing and runtime permissions for sensitive hardware.
• Biometric authentication (Fingerprint / Face ID) and OAuth2 security tokens.

3. Code Protection:
• ProGuard / R8 code obfuscation to prevent reverse engineering.
        """.trimIndent(),
        practicalTitle = "Security & Encryption Simulator",
        codeSnippet = """
// Beginner Concept: Secure Storage Check
val isEncrypted = true
if (isEncrypted) {
    // Data stored securely using AES-256 encryption
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 7,
        moduleCode = "g",
        title = "Testing and Debugging Mobile Applications",
        subtitle = "Unit Testing, UI Testing, Espresso & Crashlytics",
        description = "Unit testing, UI testing, instrumentation testing, Espresso (Android), XCTest (iOS), emulators vs physical devices, and Firebase Crashlytics.",
        emoji = "🧪",
        studyNotes = """
📚 Module III - Section (g): Testing and Debugging Mobile Apps

1. Testing Types:
• Unit Testing: Tests individual functions and business logic (JUnit).
• UI / Instrumentation Testing: Tests user interactions and screen flows (Espresso, XCTest).

2. Debugging & Crash Reporting:
• Logcat for debugging logs.
• Firebase Crashlytics for real-time crash reporting and ANR tracking.
        """.trimIndent(),
        practicalTitle = "Unit Testing & Crashlytics Simulator",
        codeSnippet = """
// Beginner Concept: JUnit Unit Test
@Test
fun testAddition() {
    val sum = 2 + 3
    assertEquals(5, sum)
}
        """.trimIndent()
    ),
    AndroidTopic(
        id = 8,
        moduleCode = "h",
        title = "Publishing and Deployment",
        subtitle = "Google Play Store, App Signing & Policies",
        description = "Preparing apps for Google Play Store and Apple App Store, app signing, provisioning profiles, Play Store policies, and update strategies.",
        emoji = "🚀",
        studyNotes = """
📚 Module III - Section (h): Publishing and Deployment

1. App Bundles & Signing:
• Generating Android App Bundles (.aab) and signing with a secure release keystore.
• iOS provisioning profiles and certificates for App Store submission.

2. Store Compliance:
• Google Play Data Safety policies, target SDK requirements, and permission declarations.
• Phased rollouts and version management (versionCode & versionName).
        """.trimIndent(),
        practicalTitle = "Deployment & Keystore Checklist",
        codeSnippet = """
// Beginner Concept: Gradle Versioning
android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"
    }
}
        """.trimIndent()
    )
)
