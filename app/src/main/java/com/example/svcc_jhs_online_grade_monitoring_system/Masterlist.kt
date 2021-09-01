package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.size

class Masterlist : AppCompatActivity() {
    companion object{
        var clientAdvisory = LoginEmployee.clientAdvisory
        var gradingStudent = LoginEmployee.gradingStudent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masterlist)

        var btnViewGrade : Button = findViewById(R.id.btnViewGrade)
        var spnStudents : Spinner = findViewById(R.id.spnStud)

        fun refreshStud(){
            var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,clientAdvisory.studentID)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnStudents.adapter = adapter
        }
        refreshStud()

        btnViewGrade.setOnClickListener {
            gradingStudent.retrieveStudent(spnStudents.selectedItem.toString().toInt())
            var intent = Intent(this, StudentGrade::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        finish()
    }
}