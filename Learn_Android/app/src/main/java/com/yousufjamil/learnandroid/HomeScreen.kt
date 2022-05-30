package com.yousufjamil.learnandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, CActivity::class.java)
            startActivity(intent)
        }

    }

//    fun login(view:View) {
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        val emails = editTextTextEmailAddress.toString()
//        val passwords = editTextTextPassword.toString()
//        if (emails!="user@user.com" && passwords!="123") {
//            startActivity(intent)
//        } else {
//            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
//        }
//    }
}