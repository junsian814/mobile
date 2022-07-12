package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var diceImg : ImageView
    lateinit var numberText : TextView
    lateinit var nameText : TextView
    lateinit var playerNameText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImg = findViewById(R.id.diceImage)
        numberText = findViewById(R.id.numbTxt)
        nameText = findViewById(R.id.EditPlayerName)
        playerNameText = findViewById(R.id.playerName)

        val rollBtn:Button = findViewById(R.id.rollButton)
        rollBtn.setOnClickListener{rollDice()}

        val updateBtn:Button = findViewById(R.id.updateButton)
        updateBtn.setOnClickListener{updateName(it)}
    }

    private fun updateName(view: View){
        playerNameText.text = nameText.text
    }

    private fun rollDice(){
        val randNum = (1..6).random()

        numberText.text = randNum.toString()

        val imgSrc = when (randNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImg.setImageResource(imgSrc)
    }
}
