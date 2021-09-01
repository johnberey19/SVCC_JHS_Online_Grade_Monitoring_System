package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class AddEmployee : AppCompatActivity() {
    companion object{
        var addType = fragAddAcc.addType
        var addAdmin = AdminMenu.addAdmin
        var addPerson = AdminMenu.addPerson
        var addTeacher = AdminMenu.addTeacher
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_employee)

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
        var txtPass1 : TextView = findViewById(R.id.txtPass1)
        var txtPass2 : TextView = findViewById(R.id.txtPass2)

        addType = fragAddAcc.addType

        if (addType == "admin"){
            txtID.text = addAdmin.adminId.toString()
        }
        if (addType == "teacher"){
            txtID.text = addTeacher.teacherId.toString()
        }
        txtID.isEnabled = false

        btnCancel.setOnClickListener {
            var intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            this.finish()
        }
        btnCreate.setOnClickListener {
            if (addType=="admin"){
                if ((txtPass1.text.isNotBlank()&&txtPass2.text.isNotBlank())&&(txtPass2.text.toString()==txtPass1.text.toString())) {
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
                    addAdmin.pWord = txtPass1.text.toString()
                    addAdmin.personId = addPerson.personId
                    addPerson.addPerson()
                    addAdmin.addAdmin()
                    Toast.makeText(this, "Admin [${addAdmin.adminId}] added Successfully", Toast.LENGTH_SHORT).show()

                    var intent = Intent(this,AdminMenu()::class.java)
                    startActivity(intent)
                    this.finish()
                }
                else{
                    Toast.makeText(this, "Password Empty/Mismatch", Toast.LENGTH_SHORT).show()
                }

            }
            if (addType=="teacher"){
                if ((txtPass1.text.isNotBlank()&&txtPass2.text.isNotBlank())&&(txtPass2.text.toString()==txtPass1.text.toString())) {
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
                    addTeacher.pWord = txtPass1.text.toString()
                    addTeacher.personId = addPerson.personId
                    addPerson.addPerson()
                    addTeacher.addTeacher()
                    Toast.makeText(this, "Teacher [${addTeacher.teacherId}] added Successfully", Toast.LENGTH_SHORT).show()

                    var intent = Intent(this,AdminMenu()::class.java)
                    startActivity(intent)
                    this.finish()
                }
                else{
                    Toast.makeText(this, "Password Empty/Mismatch", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}