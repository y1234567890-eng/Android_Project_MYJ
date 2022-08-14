package com.yousufjamil.jumaasurahs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SelectSurahPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_surah_page)



    }

    fun kahfSelectBtnClicked(view:View) {
        val openSurahKahfIntent = Intent(this,SurahKahf::class.java)
        startActivity(openSurahKahfIntent)
    }

    fun jumahSelectBtnClicked(view:View) {
        val openSurahJumahIntent = Intent(this,SurahJumah::class.java)
        startActivity(openSurahJumahIntent)
    }

    fun dukhanSelectBtnClicked(view:View) {
        val openSurahDukhanIntent = Intent(this,SurahDukhan::class.java)
        startActivity(openSurahDukhanIntent)
    }

}