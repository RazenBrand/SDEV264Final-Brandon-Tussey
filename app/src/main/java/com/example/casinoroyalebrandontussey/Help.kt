package com.example.casinoroyalebrandontussey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_help.*

class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)



        helpMainMId.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}