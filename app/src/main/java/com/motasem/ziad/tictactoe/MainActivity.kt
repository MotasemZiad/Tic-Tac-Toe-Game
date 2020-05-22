package com.motasem.ziad.tictactoe


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSinglePlayer.setOnClickListener {
            startActivity(Intent(this, SinglePlayerActivity::class.java))
        }
        btnMultiPlayer.setOnClickListener {
            startActivity(Intent(this, MultiPlayerActivity::class.java))
        }
    }

    /*

    fun btnSelect(view: View) {
        val btnChoice = view as Button
        var cellId = 0
        when (btnChoice.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }
        playGame1(cellId, btnChoice)
    }

    fun btnSelect2(view: View) {
        val btnChoice = view as Button
        var cellId = 0
        when (btnChoice.id) {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }
        playGame2(cellId, btnChoice)
    }

    // Single Player
    val sPlayer1 = ArrayList<Int>()
    val sPlayer2 = ArrayList<Int>()
    var sActivePlayer = 1

    // Multi Player
    val mPlayer1 = ArrayList<Int>()
    val mPlayer2 = ArrayList<Int>()
    var mActivePlayer = 1

    fun playGame1(cellId: Int, btnChoice: Button) {
        if (sActivePlayer == 1) {
            btnChoice.setBackgroundResource(R.drawable.x_shape)
            btnChoice.text = "X"
            sPlayer1.add(cellId)
            sActivePlayer = 2
            autoPlay()
        } else {
            btnChoice.setBackgroundResource(R.drawable.o_shape)
            btnChoice.text = "O"
            sPlayer2.add(cellId)
            sActivePlayer = 1
            autoPlay()
        }
        btnChoice.isEnabled = false
    }

    fun playGame2(cellId: Int, btnChoice: Button) {

        if (mActivePlayer == 1) {
            btnChoice.setBackgroundResource(R.drawable.x_shape)
            btnChoice.text = "X"
            mPlayer1.add(cellId)
            mActivePlayer = 2
        } else {
            btnChoice.setBackgroundResource(R.drawable.o_shape)
            btnChoice.text = "O"
            mPlayer2.add(cellId)
            mActivePlayer = 1
        }
        btnChoice.isEnabled = false
        findWinner()
    }

    // MultiPlayer
    fun findWinner() {
        var winner = -1
        // row 1
        if (mPlayer1.contains(1) && mPlayer1.contains(2) && mPlayer1.contains(3)) {
            winner = 1
        }
        if (mPlayer2.contains(1) && mPlayer2.contains(2) && mPlayer2.contains(3)) {
            winner = 2
        }

        // row 2
        if (mPlayer1.contains(4) && mPlayer1.contains(5) && mPlayer1.contains(6)) {
            winner = 1
        }
        if (mPlayer2.contains(5) && mPlayer2.contains(5) && mPlayer2.contains(6)) {
            winner = 2
        }
        // row 3
        if (mPlayer1.contains(7) && mPlayer1.contains(8) && mPlayer1.contains(9)) {
            winner = 1
        }
        if (mPlayer2.contains(7) && mPlayer2.contains(8) && mPlayer2.contains(9)) {
            winner = 2
        }
        // col 1
        if (mPlayer1.contains(1) && mPlayer1.contains(4) && mPlayer1.contains(7)) {
            winner = 1
        }
        if (mPlayer2.contains(1) && mPlayer2.contains(4) && mPlayer2.contains(7)) {
            winner = 2
        }
        // col 2
        if (mPlayer1.contains(2) && mPlayer1.contains(5) && mPlayer1.contains(8)) {
            winner = 1
        }
        if (mPlayer2.contains(2) && mPlayer2.contains(5) && mPlayer2.contains(8)) {
            winner = 2
        }
        // col 3
        if (mPlayer1.contains(3) && mPlayer1.contains(6) && mPlayer1.contains(9)) {
            winner = 1
        }
        if (mPlayer2.contains(3) && mPlayer2.contains(6) && mPlayer2.contains(9)) {
            winner = 2
        }
        // x 1
        if (mPlayer1.contains(1) && mPlayer1.contains(5) && mPlayer1.contains(9)) {
            winner = 1
        }
        if (mPlayer2.contains(1) && mPlayer2.contains(5) && mPlayer2.contains(9)) {
            winner = 2
        }
        // x 2
        if (mPlayer1.contains(3) && mPlayer1.contains(5) && mPlayer1.contains(7)) {
            winner = 1
        }
        if (mPlayer2.contains(3) && mPlayer2.contains(5) && mPlayer2.contains(7)) {
            winner = 2
        }

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)
        val txtScore = dialog.findViewById(R.id.tvScore) as TextView
        val imgScore = dialog.findViewById(R.id.imgScore) as ImageView
        val imgHome = dialog.findViewById(R.id.imgHome) as ImageView
        val imgRepeat = dialog.findViewById(R.id.imgRepeat) as ImageView

        imgHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        /* imgRepeat.setOnClickListener {
             supportFragmentManager.beginTransaction()
                 .replace(R.id.mainContainer, MultiPlayerFragment()).commit()
             if (dialog.isShowing)
                 dialog.dismiss()
         }
         */



        if (winner != -1) {
            when (winner) {
                1 -> {
                    txtScore.text = "player one won"
                    imgScore.setImageResource(R.drawable.ic_clapping)
                    dialog.setCancelable(false)
                    dialog.show()
                }
                2 -> {
                    txtScore.text = "Player two won"
                    imgScore.setImageResource(R.drawable.ic_clapping)
                    dialog.setCancelable(false)
                    dialog.show()
                }
                else -> {
                    txtScore.text = "Draw"
                    imgScore.setImageResource(R.drawable.ic_draw)
                    dialog.setCancelable(false)
                    dialog.show()
                }
            }
        }

    }

    fun findWinner1() {
        var winner = -1
        // row 1
        if (sPlayer1.contains(1) && sPlayer1.contains(2) && sPlayer1.contains(3)) {
            winner = 1
        }
        if (sPlayer2.contains(1) && sPlayer2.contains(2) && sPlayer2.contains(3)) {
            winner = 2
        }

        // row 2
        if (sPlayer1.contains(4) && sPlayer1.contains(5) && sPlayer1.contains(6)) {
            winner = 1
        }
        if (sPlayer2.contains(5) && sPlayer2.contains(5) && sPlayer2.contains(6)) {
            winner = 2
        }
        // row 3
        if (sPlayer1.contains(7) && sPlayer1.contains(8) && sPlayer1.contains(9)) {
            winner = 1
        }
        if (sPlayer2.contains(7) && sPlayer2.contains(8) && sPlayer2.contains(9)) {
            winner = 2
        }
        // col 1
        if (sPlayer1.contains(1) && sPlayer1.contains(4) && sPlayer1.contains(7)) {
            winner = 1
        }
        if (sPlayer2.contains(1) && sPlayer2.contains(4) && sPlayer2.contains(7)) {
            winner = 2
        }
        // col 2
        if (sPlayer1.contains(2) && sPlayer1.contains(5) && sPlayer1.contains(8)) {
            winner = 1
        }
        if (sPlayer2.contains(2) && sPlayer2.contains(5) && sPlayer2.contains(8)) {
            winner = 2
        }
        // col 3
        if (sPlayer1.contains(3) && sPlayer1.contains(6) && sPlayer1.contains(9)) {
            winner = 1
        }
        if (sPlayer2.contains(3) && sPlayer2.contains(6) && sPlayer2.contains(9)) {
            winner = 2
        }
        // x 1
        if (sPlayer1.contains(1) && sPlayer1.contains(5) && sPlayer1.contains(9)) {
            winner = 1
        }
        if (sPlayer2.contains(1) && sPlayer2.contains(5) && sPlayer2.contains(9)) {
            winner = 2
        }
        // x 2
        if (sPlayer1.contains(3) && sPlayer1.contains(5) && sPlayer1.contains(7)) {
            winner = 1
        }
        if (sPlayer2.contains(3) && sPlayer2.contains(5) && sPlayer2.contains(7)) {
            winner = 2
        }

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)
        val txtScore = dialog.findViewById(R.id.tvScore) as TextView
        val imgScore = dialog.findViewById(R.id.imgScore) as ImageView
        val imgHome = dialog.findViewById(R.id.imgHome) as ImageView
        //val imgRepeat = dialog.findViewById(R.id.imgRepeat) as ImageView

        imgHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        /* imgRepeat.setOnClickListener {
             supportFragmentManager.beginTransaction()
                 .replace(R.id.mainContainer, MultiPlayerFragment()).commit()
             if (dialog.isShowing)
                 dialog.dismiss()
         }
         */



        if (winner != -1) {
            when (winner) {
                1 -> {
                    txtScore.text = "You Won"
                    imgScore.setImageResource(R.drawable.ic_clapping)
                    dialog.setCancelable(false)
                    dialog.show()
                    endGame()
                }
                2 -> {
                    txtScore.text = "You lose"
                    imgScore.setImageResource(R.drawable.ic_lose)
                    dialog.setCancelable(false)
                    dialog.show()
                    endGame()
                }
                else -> {
                    txtScore.text = "Draw"
                    imgScore.setImageResource(R.drawable.ic_draw)
                    dialog.setCancelable(false)
                    dialog.show()
                    endGame()
                }
            }
        }
    }


    fun autoPlay() {
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(sPlayer1.contains(cellID) || sPlayer2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }
        val random = java.util.Random()
        val randIndex = random.nextInt(emptyCells.size - 0) + 0
        val cellID = emptyCells[randIndex]

        var btnSelect: Button? = null
        when (cellID) {
            1 -> btnSelect = sbtn1
            2 -> btnSelect = sbtn2
            3 -> btnSelect = sbtn3
            4 -> btnSelect = sbtn4
            5 -> btnSelect = sbtn5
            6 -> btnSelect = sbtn6
            7 -> btnSelect = sbtn7
            8 -> btnSelect = sbtn8
            9 -> btnSelect = sbtn9
            else -> {
                btnSelect = sbtn1
            }
        }

        playGame1(cellID, btnSelect)
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog)
        val txtScore = dialog.findViewById(R.id.tvScore) as TextView
        val imgScore = dialog.findViewById(R.id.imgScore) as ImageView
        val imgHome = dialog.findViewById(R.id.imgHome) as ImageView
        if (emptyCells.isNotEmpty()) {
            txtScore.text = "Draw"
            imgScore.setImageResource(R.drawable.ic_draw)
            dialog.setCancelable(false)
            dialog.show()
        }
    }

    fun endGame() {

        sbtn1.isEnabled = false
        sbtn2.isEnabled = false
        sbtn3.isEnabled = false
        sbtn4.isEnabled = false
        sbtn5.isEnabled = false
        sbtn6.isEnabled = false
        sbtn7.isEnabled = false
        sbtn8.isEnabled = false
        sbtn9.isEnabled = false
    }
     */


}
