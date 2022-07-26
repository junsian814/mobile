package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //lateinit var diceImg : ImageView
    //lateinit var numberText : TextView
    //lateinit var nameText : EditText
    //lateinit var playerNameText : TextView
    private val playerName: GameInfo = GameInfo(playerName = "Player One")
    private val score: GameInfo = GameInfo(score = "Roll Dice!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.gameDetails = playerName
        binding.gameDetails = score
        //diceImg = findViewById(R.id.diceImage)
        //numberText = findViewById(R.id.numbTxt)
        //nameText = findViewById(R.id.EditPlayerName)
        //playerNameText = findViewById(R.id.playerName)

        //val rollBtn:Button = findViewById(R.id.rollButton)
        //rollBtn.setOnClickListener{rollDice()}

        //val updateBtn:Button = findViewById(R.id.updateButton)
        //updateBtn.setOnClickListener{updateName(it)}

        binding.rollButton.setOnClickListener{ rollDice() }
        binding.updateButton.setOnClickListener{ updateName(it) }
    }

    private fun updateName(view: View){
        binding.playerName.text = binding.EditPlayerName.text
        //playerNameText.text = nameText.text

        binding.playerName.clearComposingText()
        binding.EditPlayerName.text.clear()
        //nameText.text.clear()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun rollDice(){
        val randNum = (1..6).random()
        binding.numberText.text = randNum.toString()
        //numberText.text = randNum.toString()

        val imgSrc = when (randNum){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        binding.diceImage.setImageResource(imgSrc)
        //diceImg.setImageResource(imgSrc)
    }
}
