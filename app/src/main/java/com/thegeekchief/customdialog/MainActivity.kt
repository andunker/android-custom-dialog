package com.thegeekchief.customdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    var imageButton: ImageButton? = null
    var alertBtn: Button?= null
    var customBtn: Button?= null
    var customProgressBtn: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButton = findViewById(R.id.imageButton)
        alertBtn = findViewById(R.id.button1)
        customBtn = findViewById(R.id.button2)
        customProgressBtn = findViewById(R.id.button3)

        imageButton?.setOnClickListener{
            Snackbar.make(it, "You have clicked image button ", Snackbar.LENGTH_LONG).show()
        }

        alertBtn?.setOnClickListener{
            alertDialogFunction()
        }

        customBtn?.setOnClickListener{
            customDialogFunction()
        }

        customProgressBtn?.setOnClickListener{

        }

    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        builder.setPositiveButton("Yes"){dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNeutralButton("Cancel"){dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked cancel\n operation cancel", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked no", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()


    }
}