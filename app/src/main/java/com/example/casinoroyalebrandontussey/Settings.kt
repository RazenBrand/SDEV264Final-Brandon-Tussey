package com.example.casinoroyalebrandontussey

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preferences.*
import kotlinx.android.synthetic.main.activity_preferences.view.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        val PREF_color = "myPrefs"
        var myPref:SharedPreferences?=null

        mmSId.setOnClickListener {
            var color = 0
            when{
                colorGroup.bcardId.isChecked -> color = 0
                colorGroup.rcardId.isChecked -> color = 1
            }
            myPref=getSharedPreferences(PREF_color,0)
            var edit:SharedPreferences.Editor=(myPref as SharedPreferences).edit()
            edit.putString("color",color.toString())
            edit.commit()


            var menuMain= Intent(this,MainActivity::class.java)
            startActivity(menuMain)
        }
    }
}
