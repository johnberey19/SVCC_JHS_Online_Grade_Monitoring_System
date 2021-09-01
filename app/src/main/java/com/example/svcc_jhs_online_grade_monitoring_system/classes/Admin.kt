package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

open class Admin(var adminId : Int,
                 var personId : Int,
                 var pWord : String) {
    var dbAdmin = Database().dbAdmin

    fun generateAdminId(){
        dbAdmin.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Admin.adminId = 1010001 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Admin.adminId = 1010001
            }
        })
    }
    fun addAdmin(){
        dbAdmin.child("$adminId").child("personId").setValue(personId)
        dbAdmin.child("$adminId").child("adminId").setValue(adminId)
        dbAdmin.child("$adminId").child("pWord").setValue(pWord)
    }
    fun editAdmin(){
        dbAdmin.child("$adminId").child("personId").setValue(personId)
        dbAdmin.child("$adminId").child("adminId").setValue(adminId)
        dbAdmin.child("$adminId").child("pWord").setValue(pWord)
    }
    fun retrieveAdmin(adminId: Int){
        dbAdmin.child("$adminId").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Admin.adminId = snapshot.child("adminId").value.toString().toInt()
                this@Admin.personId = snapshot.child("personId").value.toString().toInt()
                this@Admin.pWord = snapshot.child("pWord").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
