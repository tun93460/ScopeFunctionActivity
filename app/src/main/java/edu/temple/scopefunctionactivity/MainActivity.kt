package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        //test
        //Log.d("function output", "test")

        Log.d("function output", "test")

        //test data array
        val testDataArray = getTestDataArray()
        Log.d("function 1 output", "Sorted Array: ${testDataArray.joinToString(", ")}")

        //average less than median result
        val testDoubleList = List(10) { Random.nextDouble(1.0, 100.0) }
        val formattedList = testDoubleList.joinToString(", ") { String.format("%.2f", it) }
        val avgLessThanMedianResult = averageLessThanMedian(testDoubleList)
        Log.d("function 2 output", "List: $formattedList, Result: $avgLessThanMedianResult")

        //get view outputs
        val testCollection = List(10) { Random.nextInt(1, 100) }
        val testView = getView(0, null, testCollection, this@MainActivity)
        Log.d("function 3 output", "TextView content: ${testView.text}, Collection value at position 0: ${testCollection[0]}")
    }

    private fun getTestDataArray() = MutableList(10) { Random.nextInt() }.apply { this.sort() }

    private fun averageLessThanMedian(listOfNumbers: List<Double>) = listOfNumbers.sorted().let {
        val median =
            if (it.size % 2 == 0)
                    (it[it.size / 2] + it[(it.size - 1) / 2]) / 2
            else
                it[it.size / 2]
        listOfNumbers.average() < median
    }

    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context) =
        (recycledView as? TextView ?: TextView(context).apply {
            setPadding(5,10,10,0)
            textSize = 22f
        }).apply {
            text = collection[position].toString()
        }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
//    private fun getTestDataArray() : List<Int> {
//        val testArray = MutableList(10){ Random.nextInt()}
//        testArray.sort()
//        return testArray
//    }


    // Return true if average value in list is greater than median value, false otherwise
//    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {
//        val avg = listOfNumbers.average()
//        val sortedList = listOfNumbers.sorted()
//        val median = if (sortedList.size % 2 == 0)
//            (sortedList[sortedList.size / 2] + sortedList[(sortedList.size - 1) / 2]) / 2
//        else
//            sortedList[sortedList.size / 2]
//
//        return avg < median
//    }


    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
//    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View {
//        val textView: TextView
//
//        if (recycledView != null) {
//            textView = recycledView as TextView
//        } else {
//            textView = TextView(context)
//            textView.setPadding(5, 10, 10, 0)
//            textView.textSize = 22f
//        }
//
//        textView.text = collection[position].toString()
//
//        return textView
//    }

}