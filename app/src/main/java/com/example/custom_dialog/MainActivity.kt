package com.example.custom_dialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.snackbar.Snackbar
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val imageBtn: ImageButton=findViewById(R.id.image_button)
        imageBtn.setOnClickListener { view ->
            Snackbar.make(view,"You have clicked Image Button",Snackbar.LENGTH_LONG).show()
        }

        val alertBtn: Button=findViewById(R.id.btn_alert_dialog)
        alertBtn.setOnClickListener { view ->
            alertDialogFunction()
        }

        val customDialogButton: Button=findViewById(R.id.btn_custom_dialog)
        customDialogButton.setOnClickListener { view ->
            customDialog()
        }

        val customProgressButton: Button=findViewById(R.id.btn_custom_progress_dialog)
        customProgressButton.setOnClickListener { view ->
            customProgressDialogFunction()
        }




    }

    private fun alertDialogFunction(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is used to show alerts in app")
        builder.setIcon(android.R.drawable.ic_dialog_alert)



        builder.setNeutralButton("Cancel") {dialogInterface, which->
            Toast.makeText(applicationContext,"clicked cancel \n operation cancel",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setPositiveButton("Yes") {dialogInterface,which->
            Toast.makeText(applicationContext,"clicked Yes",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No") {dialogInterface, which->
            Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }


        val alertDialog: AlertDialog= builder.create()
        alertDialog.setCancelable(false)    //Cannot be cancelled by clicking outside the dialog
        alertDialog.show()


    }

    private fun customDialog(){
        val customDialog= Dialog(this)
        customDialog.setContentView(androidx.core.R.layout.custom_dialog)

        customDialog.findViewById<TextView>(R.id.tv_submit).setOnClickListener {
            Toast.makeText(applicationContext,"clicked Submit",Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }

        customDialog.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            Toast.makeText(applicationContext,"clicked Cancel",Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.show()


    }

    private fun customProgressDialogFunction(){
        val customProgressDialog=Dialog(this)

        customProgressDialog.setContentView(R.layout.custom_dialog_process)

        customProgressDialog.show()
    }


}