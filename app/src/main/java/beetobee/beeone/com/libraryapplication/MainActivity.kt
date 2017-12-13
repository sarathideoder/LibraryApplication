package beetobee.beeone.com.libraryapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.widget.TextView
import beetobee.beeone.com.mylibrary.CentralTendency
import beetobee.beeone.com.mylibrary.SplashScreenActivity
import java.util.Random
import java.util.ArrayList
import java.util.Collections


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var textView: TextView = findViewById<TextView>(R.id.tv) as TextView

        val numbers = ArrayList<Int>()
        val r = Random()

        for (i in 0..14) {
            numbers.add(r.nextInt(7) + 1)
        }

        val mean = CentralTendency.arithmeticMean(numbers).toDouble()
        val median = CentralTendency.arithmeticMean(numbers)
        val mode = CentralTendency.arithmeticMean(numbers)

        Collections.sort(numbers)

        val res = String.format("Numbers:\n\n%s\nMean: %.1f\nMedian: %.1f\nMode: %s\n",
                numbers, mean, median, mode)

        textView.text = res

        val intent = Intent(this, SplashScreenActivity::class.java)
        startActivity(intent)
        finish()
    }
}
