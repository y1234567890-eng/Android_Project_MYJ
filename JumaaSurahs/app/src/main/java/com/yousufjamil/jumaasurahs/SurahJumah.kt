package com.yousufjamil.jumaasurahs

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_surah_jumah.*
import kotlinx.android.synthetic.main.activity_surah_kahf.*

class SurahJumah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_jumah)

        val jumahMediaPlayer = MediaPlayer.create(this,R.raw.jumah)
        testPlayJumah.setOnClickListener {
            if (!jumahMediaPlayer.isPlaying) {
                jumahMediaPlayer.start()
                testPlayJumah.setImageResource(R.drawable.ic_pause_circle_outline)
            } else {
                jumahMediaPlayer.pause()
                testPlayJumah.setImageResource(R.drawable.ic_play_circle_outline)
            }

        }
        resetPlayJumah.setOnClickListener {
            jumahMediaPlayer.seekTo(0)
        }
        backBtnJumah.setOnClickListener{
            val backSelectKahfIntent = Intent(this,SelectSurahPage::class.java)
            startActivity(backSelectKahfIntent)
        }

        forwardPageBtnJumah.setOnClickListener {
            if (imageViewJumah.getTag() != null && imageViewJumah.getTag().toString().equals("Image1")) {
                imageViewJumah.setImageResource(R.drawable.ic_jumah_2)
                imageViewJumah.setTag("Image2")
            } else if (imageViewJumah.getTag() != null && imageViewJumah.getTag().toString().equals("Image2")) {
                Toast.makeText(this,"This is the last page",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

        backPageBtnJumah.setOnClickListener {
            if (imageViewJumah.getTag() != null && imageViewJumah.getTag().toString().equals("Image1")) {
                Toast.makeText(this,"This is the first page",Toast.LENGTH_SHORT).show()
            } else if (imageViewJumah.getTag() != null && imageViewJumah.getTag().toString().equals("Image2")) {
                imageViewJumah.setImageResource(R.drawable.ic_jumah_1)
                imageViewJumah.setTag("Image1")
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

    }
}