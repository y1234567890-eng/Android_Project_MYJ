package com.yousufjamil.learnandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar1.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBar2.progress = 0
                seekBar3.progress = 0
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

        })

        seekBar2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBar1.progress = 0
                seekBar3.progress = 0
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

        })

        seekBar3.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekBar1.progress = 0
                seekBar2.progress = 0
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                // Do nothing
            }

        })

    }
}