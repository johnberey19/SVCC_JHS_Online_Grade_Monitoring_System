package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Teacher(
        var teacherId : Int = 0,
        var personId : Int = 0,
        var pWord : String,
        var AdvisoryId : Int = 0){

    var dbTeacher = Database().dbTeacher

    fun generateTeacherId(){
        dbTeacher.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Teacher.teacherId = 1020001 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Teacher.teacherId = 1020001
            }
        })
    }
    fun addTeacher(){
        dbTeacher.child("$teacherId").child("teacherId").setValue(teacherId)
        dbTeacher.child("$teacherId").child("personId").setValue(personId)
        dbTeacher.child("$teacherId").child("pWord").setValue(pWord)
    }
    fun editTeacher(){
        dbTeacher.child("$teacherId").child("teacherId").setValue(teacherId)
        dbTeacher.child("$teacherId").child("personId").setValue(personId)
        dbTeacher.child("$teacherId").child("pWord").setValue(pWord)
    }
    fun retrieveTeacher(teacherId: Int) {
        dbTeacher.child("${teacherId}").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Teacher.teacherId = snapshot.child("teacherId").value.toString().toInt()
                this@Teacher.personId = snapshot.child("personId").value.toString().toInt()
                this@Teacher.pWord = snapshot.child("pWord").value.toString()
                this@Teacher.AdvisoryId = snapshot.child("advisoryId").value.toString().toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}