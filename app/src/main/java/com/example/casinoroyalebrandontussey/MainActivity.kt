package com.example.casinoroyalebrandontussey

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var myPref:SharedPreferences?=null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       if(scoreCurr.text.isEmpty()){
            scoreCurr.text = "1000"
            }
        if(scoreHigh.text.isEmpty()){
            scoreHigh.text = "1000"
        }
        settingId.setOnClickListener {
            val setting = Intent(this,Settings::class.java)
            startActivity(setting)
        }


        gameId.setOnClickListener {
            val Intent = Intent(this,BlackJack::class.java)
            Intent.putExtra("highs",scoreHigh.text)
            Intent.putExtra("currents",scoreCurr.text)
            startActivity(Intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settingNav-> {
                startActivity(Intent(this,Settings::class.java))
            return super.onOptionsItemSelected(item)}

            R.id.helpNav-> {
                startActivity(Intent(this,Help::class.java))
            return super.onOptionsItemSelected(item)}

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}