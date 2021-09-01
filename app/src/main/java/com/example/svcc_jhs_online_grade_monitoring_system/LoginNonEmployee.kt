package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Database
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Parent
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Person
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Student
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LoginNonEmployee : AppCompatActivity() {
    companion object{
        var userType2 = 0
        var clientParent = Parent(0,0)
        var clientStudent = Student(0,0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_non_employee)

        var dbStudent = Database().dbStudent
        var dbPerson = Database().dbPerson
        var dbParent = Database().dbParent

        var btnSignIn : Button = findViewById(R.id.btnSignInEmp3)
        var txtId : TextView = findViewById(R.id.txtnonEmpId)
        var txtbd : TextView = findViewById(R.id.txtLogBdate)

        btnSignIn.setOnClickListener {
            if (txtId.text!!.isNotBlank()) {
                if (txtId.text!![2] == '3') {
                    userType2 = 1
                    clientStudent.studentId = txtId.text.toString().toInt()
                    actLogin.clientPerson.bdate = txtbd.text.toString()
                    dbStudent.child("${clientStudent.studentId}").addValueEventListener(object :
                        ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                clientStudent.retrieveStudent(clientStudent.studentId)
                                dbPerson.child("${clientStudent.personId}").addValueEventListener(
                                    object : ValueEventListener {
                                        override fun onDataChange(snapshot: DataSnapshot) {
                                            if (snapshot.child("bdate").value == txtbd.text.toString()){
                                                Toast.makeText(
                                                    this@LoginNonEmployee,
                                                    "login successful",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                actLogin.clientPerson.retrievePerson(clientStudent.personId)
                                                var intent = Intent(this@LoginNonEmployee,StudentMenu::class.java)
                                                startActivity(intent)
                                            }
                                            else{
                                                Toast.makeText(
                                                    this@LoginNonEmployee,
                                                    "Invalid Credentials",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }

                                        override fun onCancelled(error: DatabaseError) {
                                            TODO("Not yet implemented")
                                        }
                                    })

                            } else {
                                Toast.makeText(
                                    this@LoginNonEmployee,
                                    "Student doesn't exist",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }


                    })

                }
                if (txtId.text!![2] == '4') {
                    userType2 = 2
                    clientParent.parentId = txtId.text.toString().toInt()
                    actLogin.clientPerson.bdate = txtbd.text.toString()
                    dbParent.child("${clientParent.parentId}").addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()){
                                clientParent.retrieveParent(clientParent.parentId)
                                dbPerson.child("${clientParent.personId}").addValueEventListener(object : ValueEventListener {
                                    override fun onDataChange(snapshot: DataSnapshot) {
                                        if (snapshot.child("bdate").value == txtbd.text.toString()) {
                                            Toast.makeText(
                                                this@LoginNonEmployee,
                                                "login successful",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                            actLogin.clientPerson.retrievePerson(clientParent.personId)
                                            var intent = Intent(this@LoginNonEmployee, ParentMenu::class.java)
                                            startActivity(intent)
                                        }
                                        else {
                                            Toast.makeText(
                                                this@LoginNonEmployee,
                                                "Invalid Credentials",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    }
                                    override fun onCancelled(error: DatabaseError) {
                                        TODO("Not yet implemented")
                                    }
                                })
                            }
                            else {
                                Toast.makeText(
                                    this@LoginNonEmployee,
                                    "Parent doesn't exist",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })
                }
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}