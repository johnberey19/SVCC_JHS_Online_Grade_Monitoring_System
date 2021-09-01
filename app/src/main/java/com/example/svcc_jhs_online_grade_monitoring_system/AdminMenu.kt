package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.svcc_jhs_online_grade_monitoring_system.classes.*
import com.google.firebase.database.ValueEventListener
import java.util.*

class AdminMenu : AppCompatActivity(){
    companion object{
        lateinit var fm : FragmentManager

        var addAdmin = Admin(0,0,"")
        var addPerson = Person(0,"","","","",false,"","","",false)
        var addTeacher = Teacher(0,0,"",0)
        var addStudent = Student(0,0)
        var addParent = Parent(0,0)

        var searchPerson = Person(0,"","","","",false,"","","",false)
        var searchTeacher = Teacher(0,0,"",0)
        var searchStudent = Student(0,0)
        var searchParent = Parent(0,0)
        var searchType =""

        var AddAdvisory = Advisory("","",0,0)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)
        var btnProfile : ImageButton = findViewById(R.id.btnProfile)
        var btnManAcc : ImageButton  = findViewById(R.id.btnManAcc)
        var btnCurriculum : ImageButton = findViewById(R.id.btnCurriculum)

        fm = this.supportFragmentManager

        btnProfile.setOnClickListener {
            val profile = fragProfileDialog()
            actLogin.clientPerson.retrievePerson(actLogin.clientPerson.personId)
            profile.show(fm,"Profile")
        }
        btnManAcc.setOnClickListener {
            val manAcc = fragManAccMenu(fm)
            addAdmin.generateAdminId()
            addTeacher.generateTeacherId()
            addPerson.generatePersonId()
            addStudent.generateStudentId()
            addParent.generateParentId()
            manAcc.show(fm,"manAcc")
        }
        btnCurriculum.setOnClickListener {
            AddAdvisory.generateAdvisoryId()
            val intent = Intent(this, AddAdvisory()::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        finish()
    }
}