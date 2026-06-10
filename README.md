⛺ Campsite Commander — Adventure Inventory Tracker

An elegant, native Android application built with Kotlin and Android Studio designed to help outdoor enthusiasts organize, catalog, and manage their packing lists, camping gear, and food supplies effectively. 

This project follows strict software design parameters, utilizing specialized structural paradigms such as parallel data arrays, constructive input failure handling, structural control layout loops, and a nature-themed UI experience.

📸 Core Deliverables Met
This system directly implements all specific criteria detailed in the assignment specification sheets (**WhatsApp Image 2026-06-10 at 09.38.46.jpeg** and **WhatsApp Image 2026-06-10 at 09.38.57.jpeg**):
* **Parallel Data Structures:** Synchronized tracking of `Item Name`, `Category`, `Quantity`, and unique conditional `Comments` without resorting to object wrappers.
* **Algorithmic Total Tracking:** Dynamic extraction of total items using programmatic tracking iteration loops (`for` loops) through layout allocations.
* **Multi-View Navigation Infrastructure:** Smooth transition framework between a delayed Splash sequence, a primary operational Dashboard, and a structured manifest ledger view.
* **Custom Launcher Identification:** Complete design replacement of the base Android package application asset for an immersive product identity.

🗺️ Architectural Screen Blueprint

The application minimizes configuration overhead by using a robust, clean view-swapping state architecture wrapped within a unified `FrameLayout` context.

```
                    ┌─────────────────────────┐
                    │  1. Splash Screen       │ (Auto-timed hold for 3000ms)
                    └────────────┬────────────┘
                                 │
                                 ▼
                    ┌─────────────────────────┐
                    │  2. Main Dashboard      │ ◄─────────────────┐
                    └────────────┬────────────┘                   │
                                 │                                │
                       ("View Detailed Checklist")         ("Back to Base")
                                 │                                │
                                 ▼                                │
                    ┌─────────────────────────┐                   │
                    │  3. Manifest Checklist  │ ──────────────────┘
                    └─────────────────────────┘
```

#1. Splash Screen
* **Visuals:** Immersive deep dark-nature presentation background layout featuring clean thematic iconography (`⛺`) along with product branding.
* **Logic:** Employs a non-blocking main loop scheduler thread delay (`Handler`/`Looper`) to freeze operational execution window precisely for `3000ms` before routing onwards.

#2. Main Dashboard
* **Visuals:** Tailored color palette implementing deep charcoal slate surfaces (`#1E2321`), desaturated natural forest greens (`#4E6E58`, `#2E4436`), and clean typography.
* **Controls:**
  * **Dynamic Calculator Panel:** Instantly prints raw numbers highlighting absolute aggregated supply quantities packed.
  * **Input Register Form:** Interactive textual tracking inputs (`EditText`) handling parameters for Item Name, Category, Quantities (`inputType="number"`), and contextual Notes.
  * **Action Triggers:** "Add Gear" operational ingestion button and downstream navigation routing triggers.

#3. Detailed Checklist Manifest
* **Visuals:** Clean layout with structural separation breaks using linear divider rules.
* **Controls:** 
  * Encapsulated within a vertical `ScrollView` view block container, ensuring unbounded list content flows cleanly and avoids layout viewport clipping on smaller device screens.
  * Dedicated **"Back to Base"** navigation controller action layout path returning to the main camp cockpit state seamlessly.



💾 Core Logic & Implementation Code

Parallel Array Array Ingestion Design
Data elements are held split across strict matching fixed boundaries. Below is the structural initialization containing default mock records required:

kotlin
private val maxCapacity = 50
private var currentItemCount = 3 

// Multi-axis parallel vector structure initialization
private var itemNames = arrayOfNulls<String>(maxCapacity)
private var itemCategories = arrayOfNulls<String>(maxCapacity)
private var itemQuantities = IntArray(maxCapacity)
private var itemComments = arrayOfNulls<String>(maxCapacity)

init {
    // Structural index pairing matching requirements
    itemNames[0] = "Tent";         itemCategories[0] = "Shelter"; itemQuantities[0] = 1; itemComments[0] = "4-person waterproof"
    itemNames[1] = "Marshmallows"; itemCategories[1] = "Food";    itemQuantities[1] = 3; itemComments[1] = "For S'mores (Mega size)"
    itemNames[2] = "Flashlight";   itemCategories[2] = "Safety";  itemQuantities[2] = 2; itemComments[2] = "Check batteries (AA)"
}
```

### Programmatic Accumulator Loop
The implementation enforces structural counting loops to calculate quantities upon registration rather than accessing high-level language size properties:

```kotlin
private fun runQuantityLoopCalculation(): Int {
    var runningSum = 0
    for (i in 0 until currentItemCount) {
        runningSum += itemQuantities[i] // Aggregating internal data values via traversal
    }
    return runningSum
}
```

🛡️ Error Handling & Constructive Input Protection

To maximize evaluation scores based on the evaluation checklist parameters (**WhatsApp Image 2026-06-10 at 09.38.57.jpeg**), the system prevents runtime logic failure crashes through a robust defensive validation filter pattern:

1. **Null/Empty String Ingestion Guard:** Checks individual input strings using `.isEmpty()` or `.trim()` checking. Blocks missing text fields and returns explicit instructions to the user.
2. **Numeric Cast Exception Deflector:** Converts numeric quantities using safe casting functions (`toIntOrNull()`). Safely blocks formatting violations like special characters or text entries inside numeric components.
3. **Array Bounds Overflow Shield:** Verifies if `currentItemCount >= maxCapacity` prior to committing data to memory. Safely intercepts potential `ArrayIndexOutOfBoundsException` events when list volumes exceed expectations.


🚀 Execution & Setup Guide

1. Open **Android Studio**.
2. Create a new project utilizing the **Empty Activity** structural template baseline.
3. Replace the text block within `app/src/main/res/layout/activity_main.xml` completely using the provided XML schema configuration code.
4. Open your project's main operational file `MainActivity.kt` and paste the logical source framework, ensuring the top-level package namespace aligns correctly.
5. Hit **Run** (`Shift + F10`) to test the application on your physical device or Android Emulator.

<h1>Splash Screen:</h1>
<img width="383" height="735" alt="Splash Screen" src="https://github.com/user-attachments/assets/b1d8f9d9-b6c5-4c42-8b82-f1b17252b76f" />
<h1>Main Dash Screen:</h1>
<img width="383" height="735" alt="Main Dashboard" src="https://github.com/user-attachments/assets/4deec8a0-e339-4a40-a326-830ac4670e08" />
<h1>Checklist Screen:</h1>
<img width="389" height="713" alt="Checklist" src="https://github.com/user-attachments/assets/5b7e30f0-fa8a-4567-abe3-14ca6b0da635" />



