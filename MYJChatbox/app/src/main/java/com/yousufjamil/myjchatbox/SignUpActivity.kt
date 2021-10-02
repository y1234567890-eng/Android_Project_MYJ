package com.yousufjamil.myjchatbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var databasereference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            val userName = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (TextUtils.isEmpty(userName)){
                Toast.makeText(applicationContext,"Username is required",Toast.LENGTH_SHORT).show()
            }
            if (TextUtils.isEmpty(email)){
                Toast.makeText(applicationContext,"Email is required",Toast.LENGTH_SHORT).show()
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(applicationContext,"Password is required",Toast.LENGTH_SHORT).show()
            }

            if (TextUtils.isEmpty(confirmPassword)){
                Toast.makeText(applicationContext,"Confirm your password to sign up",Toast.LENGTH_SHORT).show()
            }

            if (password != confirmPassword){
                Toast.makeText(applicationContext,"Password doesn't match.", Toast.LENGTH_SHORT).show()
            }
            registerUser(userName,email,password)
        }
    }
    private fun registerUser(userName:String,email:String,password:String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    val user: FirebaseUser? =auth.currentUser
                    val userId: String = user!!.uid

                    databasereference = FirebaseDatabase.getInstance().getReference("Users").child(userId)

                    val hashMap: HashMap<String,String> = HashMap()
                    hashMap.put("userId",userId)
                    hashMap.put("userName",userName)
                    hashMap.put("profileImage","")

                    databasereference.setValue(hashMap).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            val intent = Intent(this@SignUpActivity,HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
    }
}