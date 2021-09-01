package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Student(
        var studentId: Int,
        var personId: Int,
        var grades: Array<Array<Float>> = arrayOf(
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//ENG
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//FIL
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//MATH
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//SCI
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//TLE
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//AP
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f),//ESP
                arrayOf(0.0f, 0.0f, 0.0f, 0.0f, 0.0f)//MAPEH
        )){
    private val dbStudent = Database().dbStudent

    fun generateStudentId(){
        dbStudent.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Student.studentId = 1030001 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Student.studentId = 1030001
            }
        })
    }
    fun addStudent(){
        var sub = 0
        var quarter : Int
        var final = 0.0f
        dbStudent.child("$studentId").child("studentId").setValue(studentId)
        dbStudent.child("$studentId").child("personId").setValue(personId)
        while (sub < 8){
            quarter = 0
            while (quarter < 5){
                if (quarter > 3){
                    final /= 4.0f
                    dbStudent.child("$studentId").child("grades").child("$sub").child("$quarter").setValue(final)
                    final = 0.0f
                }
                else{
                    dbStudent.child("$studentId").child("grades").child("$sub").child("$quarter").setValue(grades[sub][quarter])
                    final += grades[sub][quarter]
                }
                quarter++
            }
            sub++
        }
    }
    fun editStudent(){
        var sub = 0
        var quarter: Int
        var final = 0.0f
        dbStudent.child("$studentId").child("studentId").setValue(studentId)
        dbStudent.child("$studentId").child("personId").setValue(personId)
        while (sub < 8){
            quarter = 0
            while (quarter < 5){
                if (quarter > 3){
                    final /= 4.0f
                    dbStudent.child("$studentId").child("grades").child("$sub").child("$quarter").setValue(final)
                    final = 0.0f
                }
                else{
                    dbStudent.child("$studentId").child("grades").child("$sub").child("$quarter").setValue(grades[sub][quarter])
                    final += grades[sub][quarter]
                }
                quarter++
            }
            sub++
        }
    }
    fun retrieveStudent(studentId: Int) {
        var sub = 0
        var quarter: Int
        dbStudent.child(studentId.toString()).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Student.studentId = snapshot.child("studentId").value.toString().toInt()
                this@Student.personId = snapshot.child("personId").value.toString().toInt()
                while (sub < 8) {
                    quarter = 0
                    while (quarter < 5) {
                        this@Student.grades[sub][quarter] = snapshot.child("grades").child("$sub").child("$quarter").value.toString().toFloat()
                        quarter++
                    }
                    sub++
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}