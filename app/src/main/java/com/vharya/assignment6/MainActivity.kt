package com.vharya.assignment6

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = resources.getString(R.string.app_name)

        val showDialogButton = findViewById<Button>(R.id.show_dialog)
        val showDialog2Button = findViewById<Button>(R.id.show_dialog_2_button)
        val showDialog3Button = findViewById<Button>(R.id.show_dialog_3_button)
        val showCustomDialogButton = findViewById<Button>(R.id.show_custom_dialog)

        showDialogButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setTitle("New Update!")
            alertDialog.setMessage("There's a new update to our EULA.")
            alertDialog.setNeutralButton(
                "Ok"
            ) { dialog, which ->
                Toast.makeText(applicationContext, "Tombol \"Ok\" Ditekan", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            alertDialog.show()
        }

        showDialog2Button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setTitle("Delete Confirmation")
            alertDialog.setMessage("Are you sure? The deleted data won't be recoverable!")
            alertDialog.setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(applicationContext, "Data Deleted!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("No, Nevermind") { dialog, which ->
                Toast.makeText(applicationContext, "Deletion Cancelled", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            alertDialog.show()
        }

        showDialog3Button.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)

            alertDialog.setTitle("Save File")
            alertDialog.setMessage("Do you want to save here?")
            alertDialog.setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(applicationContext, "File Saved!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            alertDialog.setNegativeButton("No") { dialog, which ->
                Toast.makeText(applicationContext, "File not saved...", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            alertDialog.setNeutralButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "Cancelled Save", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            alertDialog.show()
        }

        showCustomDialogButton.setOnClickListener {
            val dialog = Dialog(this)

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_dialog)

            val dialogButton = dialog.findViewById<Button>(R.id.close_dialog_button)
            dialogButton.setOnClickListener { dialog.dismiss() }

            dialog.show()
        }
    }
}