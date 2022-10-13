package com.digipod.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var imgDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btnRoll)
        imgDice = findViewById(R.id.imgDice)
        btn.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        val imgRes = dice.roll()
        // fade in and fade out image
        imgDice.animate().apply {
            duration = 200
            // alpha(0f)
            rotationYBy(360f)
            withEndAction {
                imgDice.setImageResource(imgRes)
                // alpha(1f)
            }
        }.start()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return when ((1..numSides).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> 0
        }
    }
}