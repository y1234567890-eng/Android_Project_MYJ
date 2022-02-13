package com.yousufjamil.jumaasurahs

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_surah_dukhan.*
import kotlinx.android.synthetic.main.activity_surah_jumah.*

class SurahDukhan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_dukhan)

        val dukhanMediaPlayer = MediaPlayer.create(this,R.raw.dukhan)
        testPlayDukhan.setOnClickListener {
            if (!dukhanMediaPlayer.isPlaying) {
                dukhanMediaPlayer.start()
                testPlayDukhan.setImageResource(R.drawable.ic_pause_circle_outline)
            } else {
                dukhanMediaPlayer.pause()
                testPlayDukhan.setImageResource(R.drawable.ic_play_circle_outline)
            }

        }
        resetPlayDukhan.setOnClickListener {
            dukhanMediaPlayer.seekTo(0)
        }
        backBtnDukhan.setOnClickListener{
            val backSelectKahfIntent = Intent(this,SelectSurahPage::class.java)
            startActivity(backSelectKahfIntent)
        }

        forwardPageBtnDukhan.setOnClickListener {
            if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image1")) {
                imageViewDukhan.setImageResource(R.drawable.ic_dukhan_2)
                imageViewDukhan.setTag("Image2")
            } else if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image2")) {
                imageViewDukhan.setImageResource(R.drawable.ic_dukhan_3)
                imageViewDukhan.setTag("Image3")
            } else if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image3")) {
                Toast.makeText(this,"This is the last page",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

        backPageBtnDukhan.setOnClickListener {
            if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image1")) {
                Toast.makeText(this,"This is the first page",Toast.LENGTH_SHORT).show()
            } else if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image2")) {
                imageViewDukhan.setImageResource(R.drawable.ic_dukhan_1)
                imageViewDukhan.setTag("Image1")
            } else if (imageViewDukhan.getTag() != null && imageViewDukhan.getTag().toString().equals("Image3")) {
                imageViewDukhan.setImageResource(R.drawable.ic_dukhan_2)
                imageViewDukhan.setTag("Image2")
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

    }
}