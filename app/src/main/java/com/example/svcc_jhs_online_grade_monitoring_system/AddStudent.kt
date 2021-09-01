package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class AddStudent : AppCompatActivity() {
    companion object{
        var addPerson = AdminMenu.addPerson
        var addStudent = AdminMenu.addStudent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        var btnCancel : Button = findViewById(R.id.btnCancel)
        var btnCreate : Button = findViewById(R.id.btnCreate)

        var txtID : TextView = findViewById(R.id.txtID)
        var txtLname : TextView = findViewById(R.id.txtLname)
        var txtFname : TextView = findViewById(R.id.txtSection)
        var txtMname : TextView = findViewById(R.id.txtMname)
        var txtNext : TextView = findViewById(R.id.txtNext)
        var txtBDate : TextView = findViewById(R.id.txtBDate)
        var spnSex : Spinner = findViewById(R.id.spinnerSex)
        var txtPhone : TextView = findViewById(R.id.txtPhone)
        var txtAddress : TextView = findViewById(R.id.txtAddress)

        txtID.text = addStudent.studentId.toString()

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
            addStudent.personId = addPerson.personId
            addPerson.addPerson()
            addStudent.addStudent()
            Toast.makeText(this, "Student [${addStudent.studentId}] added Successfully", Toast.LENGTH_SHORT).show()

            var intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}