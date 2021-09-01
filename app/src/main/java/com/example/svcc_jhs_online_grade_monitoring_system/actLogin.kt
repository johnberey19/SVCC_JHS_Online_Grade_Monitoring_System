package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Person

class actLogin : AppCompatActivity() {
    companion object{
        var studGradeView = ""
        var clientPerson = Person(0,"","","","",false,"","","",false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_login)
        val btnEmp : Button = findViewById(R.id.btnEmployee)
        val btnNonEmployee : Button = findViewById(R.id.btnNonEmployee)

        btnEmp.setOnClickListener {
            studGradeView = "employee"
            loginEmployee()
        }
        btnNonEmployee.setOnClickListener{
            studGradeView = "non-employee"
            loginNonEmployee()
        }
    }
    fun loginEmployee(){
        val intent = Intent(this,LoginEmployee()::class.java)
        startActivity(intent)
    }
    fun loginNonEmployee(){
        val intent = Intent(this,LoginNonEmployee()::class.java)
        startActivity(intent)
    }
}