package com.yousufjamil.myjchatbox.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.yousufjamil.myjchatbox.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.etEmail
import kotlinx.android.synthetic.main.activity_sign_up.etPassword
import java.util.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

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
                Toast.makeText(applicationContext,"Confirm Your password To Sign Up",Toast.LENGTH_SHORT).show()
            }

            if (!password.equals(confirmPassword)){
                Toast.makeText(applicationContext,"Password Don't Match",Toast.LENGTH_SHORT).show()
            }
            registerUser(userName,email,password)

        }

        btnLogin.setOnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun registerUser(userName:String,email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){
                    if (it.isSuccessful){
                        val user: FirebaseUser? = auth.currentUser
                        val userId:String = user!!.uid

                        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId)

                        val hashMap:HashMap<String,String> = HashMap()
                        hashMap.put("userId",userId)
                        hashMap.put("userName",userName)
                        hashMap.put("profileImage","")

                        databaseReference.setValue(hashMap).addOnCompleteListener(this){
                            if (it.isSuccessful){
                                //open home activity
                                etName.setText("")
                                etEmail.setText("")
                                etPassword.setText("")
                                etConfirmPassword.setText("")
                                val intent = Intent(this@SignUpActivity, UsersActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                }
    }
}