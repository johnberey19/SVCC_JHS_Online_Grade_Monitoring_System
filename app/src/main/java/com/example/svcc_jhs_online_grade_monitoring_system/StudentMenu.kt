package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager

class StudentMenu : AppCompatActivity() {
    companion object{
        lateinit var fm : FragmentManager
        var clientStudent = LoginNonEmployee.clientStudent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_menu)

        fm = this.supportFragmentManager

        var btnProfile : ImageButton = findViewById(R.id.btnProfile)
        var btnGrade : ImageButton = findViewById(R.id.btnGrade)

        btnProfile.setOnClickListener {
            val profile = fragProfileDialog()
            actLogin.clientPerson.retrievePerson(actLogin.clientPerson.personId)
            profile.show(fm,"Profile")
        }

        btnGrade.setOnClickListener {
            intent = Intent(this, StudentGrade::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        this.finish()
    }
}