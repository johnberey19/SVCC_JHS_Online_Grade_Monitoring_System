package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.svcc_jhs_online_grade_monitoring_system.classes.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class fragSearch : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootview : View = inflater.inflate(R.layout.frag_search_acc, container, false)
        
        var btnSearch : Button = rootview.findViewById(R.id.btnSearch)
        var ID : TextView = rootview.findViewById(R.id.Section)
        var btnView : Button = rootview.findViewById(R.id.btnView)

        btnView.isEnabled = false

        btnSearch.setOnClickListener {
            AdminMenu.searchType = ""
            if (ID.text!!.isNotBlank()){//TEACHER
                if(ID.text.length>6){
                    if(ID.text.toString()!![2] == '2'){
                        AdminMenu.searchType = "teacher"
                        var dbTeacher = Database().dbTeacher
                        dbTeacher.child("${ID.text}").addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    AdminMenu.searchTeacher.retrieveTeacher(ID.text.toString().toInt())
                                    btnView.isEnabled = true
                                } else {
                                    Toast.makeText(context, "Teacher ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                    ID.text = ""
                                    btnView.isEnabled = false
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(context, "Teacher ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                ID.text = ""
                                btnView.isEnabled = false
                            }
                        })
                    }
                    if (ID.text.toString()!![2] == '3'){
                        AdminMenu.searchType = "student"
                        var dbStudent = Database().dbStudent
                        dbStudent.child("${ID.text}").addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    AdminMenu.searchStudent.retrieveStudent(ID.text.toString().toInt())
                                    btnView.isEnabled = true
                                } else {
                                    Toast.makeText(context, "Student ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                    ID.text = ""
                                    btnView.isEnabled = false
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(context, "Student ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                ID.text = ""
                                btnView.isEnabled = false
                            }
                        })
                    }
                    if(ID.text.toString()!![2] == '4'){
                        AdminMenu.searchType = "parent"
                        var dbParent = Database().dbParent
                        dbParent.child("${ID.text}").addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    AdminMenu.searchParent.retrieveParent(ID.text.toString().toInt())
                                    btnView.isEnabled = true
                                } else {
                                    Toast.makeText(context, "Parent ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                    ID.text = ""
                                    btnView.isEnabled = false
                                }
                            }
                            override fun onCancelled(error: DatabaseError) {
                                Toast.makeText(context, "Parent ID [${ID.text}] doesn't exist", Toast.LENGTH_SHORT).show()
                                ID.text = ""
                                btnView.isEnabled = false
                            }
                        })
                    }
                }
            }
            else{
                Toast.makeText(context, "Invalid input ID", Toast.LENGTH_SHORT).show()
                ID.text = ""
                btnView.isEnabled = false
            }
        }
        btnView.setOnClickListener {
            if (AdminMenu.searchType=="teacher"){
                AdminMenu.searchPerson.retrievePerson(AdminMenu.searchTeacher.personId)
                ID.text = ""
                btnView.isEnabled = false

                val intent = Intent(context,ViewEditProfile()::class.java)
                startActivity(intent)
                dismiss()
            }
            if (AdminMenu.searchType=="student"){
                AdminMenu.searchPerson.retrievePerson(AdminMenu.searchStudent.personId)
                ID.text = ""
                btnView.isEnabled = false

                val intent = Intent(context,ViewEditProfile()::class.java)
                startActivity(intent)
                dismiss()
            }
            if (AdminMenu.searchType=="parent"){
                AdminMenu.searchPerson.retrievePerson(AdminMenu.searchParent.personId)
                ID.text = ""
                btnView.isEnabled = false

                val intent = Intent(context,ViewEditProfileParent()::class.java)
                startActivity(intent)
                dismiss()
            }
        }
        
        return rootview
    }
}