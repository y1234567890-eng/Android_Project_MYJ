package com.yousufjamil.myjsweetfeetzltd

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class SockActivity : AppCompatActivity() {

    var sockStyles = Player("", "")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, sockStyles)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sock)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            sockStyles = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }

    fun backHome (view: View) {
        MaterialAlertDialogBuilder(this)
                .setTitle("Warning!")
                .setMessage("Are you sure you want to continue to home? Your selected data might be deleted.")
                .setPositiveButton("Yes") { dialog, which ->
                    val intenthome = Intent(this, MainActivity::class.java)
                    startActivity(intenthome)
                }
                .setNegativeButton("No") { dialog, which ->
                    Toast.makeText(this, "Operation cancelled succesfully", Toast.LENGTH_SHORT).show()
                }
                .show()
    }

    fun normalBtnClicked(view: View) {
        sockStyles.type = "Striped"
    }

    fun black_white_clicked(view: View) {
        sockStyles.colour = "Black or White"
    }

}