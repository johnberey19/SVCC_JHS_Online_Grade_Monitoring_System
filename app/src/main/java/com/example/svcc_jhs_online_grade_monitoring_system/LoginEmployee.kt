package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.svcc_jhs_online_grade_monitoring_system.classes.*
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LoginEmployee : AppCompatActivity() {
    companion object{
        var userType = 0
        var clientAdmin = Admin(0,0,"")
        var clientTeacher = Teacher(0,0,"",0)
        var clientAdvisory = Advisory("","",0,0)
        var gradingStudent = Student(0,0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_employee)

        var dbAdmin = Database().dbAdmin
        var dbTeacher = Database().dbTeacher
        var dbPerson = Database().dbPerson

        val btnSignin: Button = findViewById(R.id.btnSignInEmp)
        val btnForgot: Button = findViewById(R.id.btnForgotPass)
        val txtUserId: TextInputEditText = findViewById(R.id.txtIdnumber)
        val txtPass: TextInputEditText = findViewById(R.id.txtPass)

        btnForgot.isEnabled = false
        btnForgot.visibility = View.GONE

        btnSignin.setOnClickListener {
            if (txtUserId.text!!.isNotBlank()) {
                if (txtUserId.text!![2] == '1') {
                    userType = 1
                    clientAdmin.adminId = txtUserId.text.toString().toInt()
                    clientAdmin.pWord = txtPass.text.toString()
                    dbAdmin.child(clientAdmin.adminId.toString()).addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                clientAdmin.personId = snapshot.child("personId").value.toString().toInt()
                                if (snapshot.child("pWord").value == clientAdmin.pWord) {
                                    Toast.makeText(
                                            this@LoginEmployee,
                                            "login successful",
                                            Toast.LENGTH_SHORT
                                    ).show()
                                    dbPerson.child(clientAdmin.personId.toString()).addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(snapshot: DataSnapshot) {
                                            actLogin.clientPerson.retrievePerson(clientAdmin.personId)
                                            intent = Intent(this@LoginEmployee, AdminMenu::class.java)
                                            startActivity(intent)
                                        }

                                        override fun onCancelled(error: DatabaseError) {
                                            TODO("Not yet implemented")
                                        }
                                    })
                                } else {
                                    Toast.makeText(
                                            this@LoginEmployee,
                                            "Invalid Password",
                                            Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                        this@LoginEmployee,
                                        "Admin doesn't exist",
                                        Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(this@LoginEmployee, "$error", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
                if (txtUserId.text!![2] == '2') {
                    userType = 2
                    clientTeacher.teacherId = txtUserId.text.toString().toInt()
                    clientTeacher.pWord = txtPass.text.toString()
                    dbTeacher.child("${clientTeacher.teacherId}").addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                clientTeacher.personId = snapshot.child("personId").value.toString().toInt()
                                if (snapshot.child("pWord").value == clientTeacher.pWord) {
                                    clientTeacher.AdvisoryId = snapshot.child("advisoryId").value.toString().toInt()
                                    Toast.makeText(
                                        this@LoginEmployee,
                                        "login successful",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    dbPerson.child("${clientTeacher.personId}").addValueEventListener(object : ValueEventListener {
                                        override fun onDataChange(snapshot: DataSnapshot) {
                                            actLogin.clientPerson.retrievePerson(clientTeacher.personId)
                                            intent = Intent(this@LoginEmployee, TeacherMenu::class.java)
                                            startActivity(intent)
                                        }

                                        override fun onCancelled(error: DatabaseError) {
                                            TODO("Not yet implemented")
                                        }
                                    })
                                } else {
                                    Toast.makeText(
                                        this@LoginEmployee,
                                        "Invalid Password",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    this@LoginEmployee,
                                    "Teacher doesn't exist",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            Toast.makeText(this@LoginEmployee, "$error", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            } else {
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}
