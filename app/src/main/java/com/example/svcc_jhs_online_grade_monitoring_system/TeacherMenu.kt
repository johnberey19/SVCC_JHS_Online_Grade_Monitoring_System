package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Advisory
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Student

class TeacherMenu : AppCompatActivity() {
    companion object{
        lateinit var fm : FragmentManager
        var clientTeacher = LoginEmployee.clientTeacher
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_menu)

        var btnProfile : ImageButton = findViewById(R.id.btnProfile)
        var btnAdvisory : ImageButton = findViewById(R.id.btnAdvisory)

        fm = this.supportFragmentManager

        btnProfile.setOnClickListener {
            val profile = fragProfileDialog()
            actLogin.clientPerson.retrievePerson(actLogin.clientPerson.personId)
            profile.show(fm,"Profile")
        }
        btnAdvisory.setOnClickListener {
            LoginEmployee.clientAdvisory.retrieveAdvisory(clientTeacher.AdvisoryId)
            intent = Intent(this, Masterlist::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        this.finish()
    }
}