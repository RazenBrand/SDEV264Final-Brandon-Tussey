package com.example.casinoroyalebrandontussey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.text.isDigitsOnly
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_black_jack.*
import kotlin.random.Random

class BlackJack : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_black_jack)
        scoreHig.text = intent.getStringExtra("highs")
        scoreCur.text = intent.getStringExtra("currents")
        house1Id.setImageResource(R.drawable.card0)
        house2Id.setImageResource(R.drawable.card0)
        house3Id.setImageResource(R.drawable.card0)
        player1Id.setImageResource(R.drawable.card0)
        player2Id.setImageResource(R.drawable.card0)
        player3Id.setImageResource(R.drawable.card0)
        var playr = 0
        var houes = 0
        var bet = 0
        doubleId.isEnabled = false
        hitId.isEnabled = false
        stayId.isEnabled = false

        stayId.setOnClickListener {
            var hes = scoreHig.text
            var curt = scoreCur.text
            val b = Random.nextInt(1, 13)
            playCards(house2Id, b)
            houes += b
            if (houes < 16) {
                var c = Random.nextInt(1, 13)
                playCards(house3Id, c)
                if (c > 10) {
                    c = 10
                }
                houes += c
            }
            plCount.text = playr.toString()
            hCount.text = houes.toString()
            if (playr > 21) {
                val x = AlertDialog.Builder(this)
                x.setTitle("You Lose")
                x.setMessage("Bet Lost!!")
                x.show()
                var score = scoreCur.text.toString()
                score = (score.toInt() - bet).toString()
                scoreCur.text = score
            } else if (playr == houes) {
                val x = AlertDialog.Builder(this)
                x.setTitle("Tie!")
                x.setMessage("No Bet Lost")
                x.show()

            } else if(houes > 21) {
                val x = AlertDialog.Builder(this)
                x.setTitle("You Win!!")
                x.setMessage("Bet Doubled!!")
                x.show()
                var score = scoreCur.text.toString()
                score = (score.toInt() + bet * 2).toString()
                scoreCur.text = score
            }else if(houes > playr){
                val x = AlertDialog.Builder(this)
                x.setTitle("House Wins")
                x.setMessage("Bet Lost!!")
                x.show()
                var score = scoreCur.text.toString()
                score = (score.toInt() - bet).toString()
                scoreCur.text = score
            }else{
                val x = AlertDialog.Builder(this)
                x.setTitle("You Win!!")
                x.setMessage("Bet Doubled!!")
                x.show()
                var score = scoreCur.text.toString()
                score = (score.toInt() + bet * 2).toString()
                scoreCur.text = score
            }
            var h  = scoreHig.text.toString()
            var s = scoreCur.text.toString()
            if( s.toInt() > h.toInt()){
                scoreHig.text = s
            }
            bet = 0
            houes = 0
            playr = 0
            dealId.isEnabled = true
            doubleId.isEnabled = false
            hitId.isEnabled = false
            stayId.isEnabled = false
        }

        hitId.setOnClickListener{
            var f = Random.nextInt(1,13)
            playCards(player3Id,f)
            if (f > 10){f = 10}
            playr += f
            doubleId.isEnabled = false
            hitId.isEnabled = false
            plCount.text = playr.toString()
            hCount.text = houes.toString()
        }

        doubleId.setOnClickListener{
            val temp = betId.text.toString()
            bet += temp.toInt() * 2
            var f = Random.nextInt(1,13)
            playCards(player3Id,f)
            if (f > 10){f = 10}
            playr += f
            doubleId.isEnabled = false
            hitId.isEnabled = false
            plCount.text = playr.toString()
            hCount.text = houes.toString()
        }
        dealId.setOnClickListener {
            house1Id.setImageResource(R.drawable.card0)
            house2Id.setImageResource(R.drawable.card0)
            house3Id.setImageResource(R.drawable.card0)
            player1Id.setImageResource(R.drawable.card0)
            player2Id.setImageResource(R.drawable.card0)
            player3Id.setImageResource(R.drawable.card0)
            if (betId.text.isDigitsOnly() and betId.text.isNotEmpty()) {
                val temp = betId.text.toString()
                bet += temp.toInt()
                var a = Random.nextInt(1, 13)
                playCards(house1Id, a)
                if (a > 10){a = 10}
                houes += a
                var d = Random.nextInt(1, 13)
                playCards(player1Id, d)
                var e = Random.nextInt(1, 13)
                playCards(player2Id, e)
                if (d > 10){d = 10}
                if (e > 10){e = 10}
                playr += d + e
                plCount.text = playr.toString()
                hCount.text = houes.toString()
                doubleId.isEnabled = true
                hitId.isEnabled = true
                stayId.isEnabled = true
                dealId.isEnabled = false
            } else {
                Snackbar.make(
                    findViewById(R.id.dealId),
                    "Type in Your Bet",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }

        mainId.setOnClickListener{
            val menuMain= Intent(this,MainActivity::class.java)
            startActivity(menuMain)
        }

    }

    private fun playCards(caVard: ImageView, r: Int) {
        val cardImage: ImageView = caVard
            val cardFace = when (r) {
                1 -> R.drawable.card11
                2 -> R.drawable.card12
                3 -> R.drawable.card13
                4 -> R.drawable.card14
                5 -> R.drawable.card15
                6 -> R.drawable.card16
                7 -> R.drawable.card17
                8 -> R.drawable.card18
                9 -> R.drawable.card19
                10 -> R.drawable.card110
                11 -> R.drawable.card111
                12 -> R.drawable.card112
                else -> R.drawable.card113
            }
            cardImage.setImageResource(cardFace)
        }

    }




