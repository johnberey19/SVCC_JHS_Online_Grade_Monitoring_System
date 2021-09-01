package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment

class fragAddAcc : DialogFragment() {
    companion object{
        var addType = ""

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootview : View = inflater.inflate(R.layout.frag_add, container, false)

        var btnAdmin : Button = rootview.findViewById(R.id.btnAdmin)
        var btnTeacher : Button = rootview.findViewById(R.id.btnTeacher)
        var btnStudent : Button = rootview.findViewById(R.id.btnStudent)
        var btnParent : Button = rootview.findViewById(R.id.btnParent)
        var btnGuardian : Button = rootview.findViewById(R.id.btnGuardian)

        btnGuardian.isVisible = false

        btnAdmin.setOnClickListener {
            addType ="admin"
            var intent = Intent(context,AddEmployee()::class.java)
            startActivity(intent)
            AdminMenu().finish()
        }
        btnTeacher.setOnClickListener {
            addType = "teacher"
            var intent = Intent(context,AddEmployee()::class.java)
            startActivity(intent)
            AdminMenu().finish()
        }
        btnStudent.setOnClickListener {
            var intent = Intent(context,AddStudent()::class.java)
            startActivity(intent)
            AdminMenu().finish()
        }
        btnParent.setOnClickListener {
            var intent = Intent(context,AddParent()::class.java)
            startActivity(intent)
            AdminMenu().finish()
        }
        return rootview
    }
}