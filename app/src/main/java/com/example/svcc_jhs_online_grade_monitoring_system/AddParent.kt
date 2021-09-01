package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class AddParent : AppCompatActivity() {
    companion object{
        var addPerson = AdminMenu.addPerson
        var addParent = AdminMenu.addParent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_parent)

        var btnCancel : Button = findViewById(R.id.btnCancel)
        var btnCreate : Button = findViewById(R.id.btnCreate)
        var btnLink : Button = findViewById(R.id.btnLinkStudent)

        var txtID : TextView = findViewById(R.id.txtID)
        var txtSTUDID : TextView = findViewById(R.id.txtSTUDid)
        var txtLname : TextView = findViewById(R.id.txtLname)
        var txtFname : TextView = findViewById(R.id.txtSection)
        var txtMname : TextView = findViewById(R.id.txtMname)
        var txtNext : TextView = findViewById(R.id.txtNext)
        var txtBDate : TextView = findViewById(R.id.txtBDate)
        var spnSex : Spinner = findViewById(R.id.spinnerSex)
        var txtPhone : TextView = findViewById(R.id.txtPhone)
        var txtAddress : TextView = findViewById(R.id.txtAddress)

        txtID.text = addParent.parentId.toString()

        txtID.isEnabled = false

        btnCancel.setOnClickListener {
            var intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            this.finish()
        }
        btnCreate.setOnClickListener {
            addPerson.fname = txtFname.text.toString()
            addPerson.mname = txtMname.text.toString()
            addPerson.lname = txtLname.text.toString()
            if (txtNext.text.isBlank()) {
                addPerson.next = "N/A"
            } else {
                addPerson.next = txtNext.text.toString()
            }
            addPerson.bdate = txtBDate.text.toString()
            addPerson.phone = txtBDate.text.toString()
            if (spnSex.selectedItemPosition == 0) {
                addPerson.sex = true
            } else {
                addPerson.sex = false
            }
            addPerson.phone = txtPhone.text.toString()
            addPerson.address = txtAddress.text.toString()
            addPerson.status = true
            addParent.personId = addPerson.personId
            addPerson.addPerson()
            addParent.addParent()
            Toast.makeText(this, "Parent [${addParent.parentId}] added Successfully", Toast.LENGTH_SHORT).show()

            var intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            this.finish()
        }
        btnLink.setOnClickListener {
            if (txtSTUDID.text!!.isNotBlank() && txtSTUDID.text.length>6 && txtSTUDID.text.toString()!![2] == '3') {
                var index = addParent.childrenId.size
                addParent.childrenId.add(index, txtSTUDID.text.toString().toInt())
                Toast.makeText(this, "Student [${txtSTUDID.text}] linked Successfully", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Link StudentID Failed", Toast.LENGTH_SHORT).show()
                txtSTUDID.text = ""
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}