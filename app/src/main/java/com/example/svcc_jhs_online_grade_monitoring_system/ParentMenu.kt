package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner

class ParentMenu : AppCompatActivity() {
    companion object{
        var clientParent = LoginNonEmployee.clientParent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_menu)

        var fm = this.supportFragmentManager
        var btnViewGrade : Button = findViewById(R.id.btnVG)
        var btnProfile : ImageButton = findViewById(R.id.btnProfile)
        var spnchilds : Spinner = findViewById(R.id.spnchilds)

        fun refreshStud(){
            var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,
                clientParent.childrenId)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnchilds.adapter = adapter
        }
        refreshStud()

        btnProfile.setOnClickListener {
            val profile = fragProfileDialog()
            actLogin.clientPerson.retrievePerson(actLogin.clientPerson.personId)
            profile.show(fm,"Profile")
        }
        btnViewGrade.setOnClickListener {
            LoginNonEmployee.clientStudent.retrieveStudent(spnchilds.selectedItem.toString().toInt())
            intent = Intent(this, StudentGrade::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        finish()
    }
}