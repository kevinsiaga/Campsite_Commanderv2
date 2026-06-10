package com.example.campsitecommander // Kevin Siaga ST10532380

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val maxCapacity = 50
    private var currentItemCount = 3 // Starting elements assigned below

    // Parallel Array Structures
    private var itemNames = arrayOfNulls<String>(maxCapacity)
    private var itemCategories = arrayOfNulls<String>(maxCapacity)
    private var itemQuantities = IntArray(maxCapacity)
    private var itemComments = arrayOfNulls<String>(maxCapacity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Parallel Arrays with Assignment Sample Data
        itemNames[0] = "Tent"; itemCategories[0] = "Shelter"; itemQuantities[0] = 1; itemComments[0] = "4-person waterproof"
        itemNames[1] = "Marshmallows"; itemCategories[1] = "Food"; itemQuantities[1] = 3; itemComments[1] = "For S'mores (Mega size)"
        itemNames[2] = "Flashlight"; itemCategories[2] = "Safety"; itemQuantities[2] = 2; itemComments[2] = "Check batteries (AA)"

        // UI Element References
        val splashScreen = findViewById<LinearLayout>(R.id.splashScreen)
        val mainScreen = findViewById<LinearLayout>(R.id.mainScreen)
        val detailedScreen = findViewById<LinearLayout>(R.id.detailedScreen)

        val tvTotalCount = findViewById<TextView>(R.id.tvTotalCount)
        val tvDisplayList = findViewById<TextView>(R.id.tvDisplayList)

        val etItemName = findViewById<EditText>(R.id.etItemName)
        val etCategory = findViewById<EditText>(R.id.etCategory)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComments = findViewById<EditText>(R.id.etComments)

        val btnApplyAddGear = findViewById<Button>(R.id.btnApplyAddGear)
        val btnViewDetailedList = findViewById<Button>(R.id.btnViewDetailedList)
        val btnBackToBase = findViewById<Button>(R.id.btnBackToBase)

        // Calculate and refresh initial items counter loop
        tvTotalCount.text = runQuantityLoopCalculation().toString()

        // SPLASH SCREEN TIMEOUT HANDLER (3000ms delay)

        Handler(Looper.getMainLooper()).postDelayed({
            splashScreen.visibility = View.GONE
            mainScreen.visibility = View.VISIBLE
        }, 3000)

        // OPERATION: ADD GEAR BUTTON LOGIC (Error Handling Included)

        btnApplyAddGear.setOnClickListener {
            val inputName = etItemName.text.toString().trim()
            val inputCategory = etCategory.text.toString().trim()
            val inputQtyString = etQuantity.text.toString().trim()
            val inputComment = etComments.text.toString().trim()

            // Constructive Error Feedback Validation
            if (inputName.isEmpty() || inputCategory.isEmpty() || inputQtyString.isEmpty() || inputComment.isEmpty()) {
                Toast.makeText(this, "Error: Please fill in all fields to register gear!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val parsedQty = inputQtyString.toIntOrNull()
            if (parsedQty == null || parsedQty <= 0) {
                Toast.makeText(this, "Error: Quantity must be a valid positive integer!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (currentItemCount >= maxCapacity) {
                Toast.makeText(this, "Storage Full! Cannot hold more items.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Write items directly into parallel indices

            itemNames[currentItemCount] = inputName
            itemCategories[currentItemCount] = inputCategory
            itemQuantities[currentItemCount] = parsedQty
            itemComments[currentItemCount] = inputComment
            currentItemCount++ // Advance tracking index position

            // Recalculate Dashboard Value using Loop

            tvTotalCount.text = runQuantityLoopCalculation().toString()

            // Clear Input Layout Controls for next usage

            etItemName.text.clear()
            etCategory.text.clear()
            etQuantity.text.clear()
            etComments.text.clear()

            Toast.makeText(this, "$inputName packed successfully!", Toast.LENGTH_SHORT).show()
        }


        // NAVIGATION: MAIN TO DETAILED LIST SCREEN

        btnViewDetailedList.setOnClickListener {
            // Build text output dynamically by looping across all items inside arrays
            val manifestBuilder = StringBuilder()

            for (i in 0 until currentItemCount) {
                manifestBuilder.append("📍 ITEM ${i + 1}:\n")
                manifestBuilder.append("• Name: ${itemNames[i]}\n")
                manifestBuilder.append("• Category: ${itemCategories[i]}\n")
                manifestBuilder.append("• Quantity: ${itemQuantities[i]}\n")
                manifestBuilder.append("• Notes: ${itemComments[i]}\n")
                manifestBuilder.append("-------------------------------------------\n\n")
            }

            tvDisplayList.text = manifestBuilder.toString()

            // Switch Screen State Layouts
            mainScreen.visibility = View.GONE
            detailedScreen.visibility = View.VISIBLE
        }

        // NAVIGATION: DETAILED SCREEN "BACK TO BASE" BUTTON

        btnBackToBase.setOnClickListener {
            detailedScreen.visibility = View.GONE
            mainScreen.visibility = View.VISIBLE
        }
    }

    /**
     * Requirement Criterion: Iterates through the parallel array elements
     * to accurately tally up total physical items using a programmatic loop.
     */
    private fun runQuantityLoopCalculation(): Int {
        var runningSum = 0
        for (i in 0 until currentItemCount) {
            runningSum += itemQuantities[i]
        }
        return runningSum
    }
}