package com.yousufjamil.jumaasurahs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun letsGoBtnClicked(view:View) {
        val intentSurahActivityOpen = Intent(this, SelectSurahPage::class.java)
        startActivity(intentSurahActivityOpen)
    }

}