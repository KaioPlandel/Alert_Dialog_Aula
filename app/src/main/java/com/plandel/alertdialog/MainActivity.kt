package com.plandel.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.plandel.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CREATE A SIMPLE DIALOG WITH ONLY TEXT AND ICON
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add this contact? ")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _,_ ->
                Toast.makeText(this,"You add the Contact", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_ ->
                Toast.makeText(this, "you didn't add", Toast.LENGTH_SHORT).show()
            }.create()
        binding.dialog1.setOnClickListener { addContactDialog.show() }

        //CREATE A SINGLE CHOICE DIALOG
        val options = arrayOf("First Item","Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { _,i ->
                Toast.makeText(this, "You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _,_ ->
                Toast.makeText(this,"You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_ ->
                Toast.makeText(this, "you declined the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()

        binding.dialog2.setOnClickListener { singleChoiceDialog.show() }

        val multiChoiceDialog= AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)) { _,i,isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "you checked ${options[i]}", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "you unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _,_ ->
                Toast.makeText(this,"You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _,_ ->
                Toast.makeText(this, "you declined the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }.create()

        binding.dialog3.setOnClickListener { multiChoiceDialog.show() }

    }
}