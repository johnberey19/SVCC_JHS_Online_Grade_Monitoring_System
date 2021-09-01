package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList

class Parent(
        var parentId : Int,
        var personId : Int,
        var childrenId: ArrayList<Int> = ArrayList()) {
    private val dbParent = Database().dbParent

    fun generateParentId() {
        dbParent.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Parent.parentId = 1040001 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Parent.parentId = 1040001
            }
        })
    }
    fun addParent(){
        var q = 0
        dbParent.child("$parentId").child("parentId").setValue(parentId)
        dbParent.child("$parentId").child("personId").setValue(personId)
        while (q < childrenId.size){
            dbParent.child("$parentId").child("childrenID").child("$q").setValue(childrenId[q])
            q++
        }
    }
    fun updateParent(){
        var q = 0
        dbParent.child("$parentId").removeValue()

        dbParent.child("$parentId").child("parentId").setValue(parentId)
        dbParent.child("$parentId").child("personId").setValue(personId)
        while (q < childrenId.size){
            dbParent.child("$parentId").child("childrenID").child("$q").setValue(childrenId[q])
            q++
        }

    }
    fun retrieveParent(parentId: Int) {
        dbParent.child("$parentId").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Parent.parentId = snapshot.child("parentId").value.toString().toInt()
                this@Parent.personId = snapshot.child("personId").value.toString().toInt()
                var q = 0
                while (q < snapshot.child("childrenID").childrenCount){
                    this@Parent.childrenId.add(snapshot.child("childrenID").child("$q").value.toString().toInt())
                    q++
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

}