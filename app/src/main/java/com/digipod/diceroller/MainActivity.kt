package com.digipod.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var imgDice: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btnRoll)  // initialize btn
        imgDice = findViewById(R.id.imgDice)  // initialize textDice
        btn.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice = Dice(6)
        imgDice.setImageDrawable(getDrawable(dice.roll()))
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return R.drawable.dice_6
    }
}