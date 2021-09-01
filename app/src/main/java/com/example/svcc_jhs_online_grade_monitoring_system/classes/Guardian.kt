package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class Guardian(
        var guardianId : Int = 0,
        var personId : Int = 0) {
    private val dbGuardian = Database().dbGuardian

    fun generateGuardianId(){
        dbGuardian.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Guardian.guardianId = 1050001 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Guardian.guardianId = 1050001
            }
        })
    }
    fun addGuardian(){
        dbGuardian.child("$guardianId").child("guardianId").setValue(guardianId)
        dbGuardian.child("$guardianId").child("personId").setValue(personId)
        Toast.makeText(null, "Added Successfully", Toast.LENGTH_SHORT).show()
    }
    fun editGuardian(){
        dbGuardian.child("$guardianId").child("guardianId").setValue(guardianId)
        dbGuardian.child("$guardianId").child("personId").setValue(personId)
        Toast.makeText(null, "Edited Successfully", Toast.LENGTH_SHORT).show()
    }
    fun retrieveGuardian(guardianId : Int) {
        dbGuardian.child(guardianId.toString()).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Guardian.guardianId = snapshot.child("guardianId").value.toString().toInt()
                this@Guardian.personId = snapshot.child("personId").value.toString().toInt()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}