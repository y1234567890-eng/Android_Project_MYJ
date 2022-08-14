package com.yousufjamil.jumaasurahs

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_surah_kahf.*

class SurahKahf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_kahf)

        val kahfMediaPlayer = MediaPlayer.create(this,R.raw.kahf)
        testPlayKahf.setOnClickListener {
            if (!kahfMediaPlayer.isPlaying) {
                kahfMediaPlayer.start()
                testPlayKahf.setImageResource(R.drawable.ic_pause_circle_outline)
            } else {
                kahfMediaPlayer.pause()
                testPlayKahf.setImageResource(R.drawable.ic_play_circle_outline)
            }

        }
        resetPlayKahf.setOnClickListener {
            kahfMediaPlayer.seekTo(0)
        }
        backBtnKahf.setOnClickListener{
            val backSelectKahfIntent = Intent(this,SelectSurahPage::class.java)
            startActivity(backSelectKahfIntent)
        }

        forwardPageBtnKahf.setOnClickListener {
            if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image1")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_2)
                imageViewKahf.setTag("Image2")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image2")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_3)
                imageViewKahf.setTag("Image3")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image3")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_4)
                imageViewKahf.setTag("Image4")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image4")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_5)
                imageViewKahf.setTag("Image5")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image5")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_6)
                imageViewKahf.setTag("Image6")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image6")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_7)
                imageViewKahf.setTag("Image7")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image7")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_8)
                imageViewKahf.setTag("Image8")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image8")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_9)
                imageViewKahf.setTag("Image9")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image9")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_10)
                imageViewKahf.setTag("Image10")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image10")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_11)
                imageViewKahf.setTag("Image11")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image11")) {
                Toast.makeText(this,"This is the last page",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

        backPageBtnKahf.setOnClickListener {
            if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image1")) {
                Toast.makeText(this,"This is the first page",Toast.LENGTH_SHORT).show()
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image2")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_1)
                imageViewKahf.setTag("Image1")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image3")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_2)
                imageViewKahf.setTag("Image2")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image4")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_3)
                imageViewKahf.setTag("Image3")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image5")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_4)
                imageViewKahf.setTag("Image4")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image6")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_5)
                imageViewKahf.setTag("Image5")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image7")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_6)
                imageViewKahf.setTag("Image6")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image8")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_7)
                imageViewKahf.setTag("Image7")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image9")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_8)
                imageViewKahf.setTag("Image8")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image10")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_9)
                imageViewKahf.setTag("Image9")
            } else if (imageViewKahf.getTag() != null && imageViewKahf.getTag().toString().equals("Image11")) {
                imageViewKahf.setImageResource(R.drawable.ic_kahf_10)
                imageViewKahf.setTag("Image10")
            } else {
                Toast.makeText(this,"Unknown Error",Toast.LENGTH_SHORT).show()
            }
        }

    }
}