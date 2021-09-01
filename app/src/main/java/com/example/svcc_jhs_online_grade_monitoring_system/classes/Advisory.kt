package com.example.svcc_jhs_online_grade_monitoring_system.classes

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class Advisory(
    var year: String,
    var section: String,
    var adviserId: Int,
    var advisoryId: Int,
    var studentID : ArrayList<Int> = ArrayList()) {

    private val dbAdvisory = Database().dbAdvisory

    fun generateAdvisoryId(){
        dbAdvisory.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Advisory.advisoryId = 1 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Advisory.advisoryId = 1
            }
        })
    }
    fun addAdvisory(){
        var q = 0
        dbAdvisory.child("$advisoryId").child("advisoryId").setValue(advisoryId)
        dbAdvisory.child("$advisoryId").child("adviserId").setValue(adviserId)
        dbAdvisory.child("$advisoryId").child("section").setValue(section)
        dbAdvisory.child("$advisoryId").child("year").setValue(year)
        while (q < studentID.size){
            dbAdvisory.child("$advisoryId").child("studentID").child("$q").setValue(studentID[q])
            q++
        }
    }
    fun updateAdvisory(){
        var q = 0
        dbAdvisory.child("$advisoryId").removeValue()

        dbAdvisory.child("$advisoryId").child("advisoryId").setValue(advisoryId)
        dbAdvisory.child("$advisoryId").child("adviserId").setValue(adviserId)
        dbAdvisory.child("$advisoryId").child("section").setValue(section)
        dbAdvisory.child("$advisoryId").child("year").setValue(year)
        while (q < studentID.size){
            dbAdvisory.child("$advisoryId").child("studentID").child("$q").setValue(studentID[q])
            q++
        }
    }
    fun retrieveAdvisory( id : Int){
        dbAdvisory.child("$id").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Advisory.advisoryId = snapshot.child("advisoryId").value.toString().toInt()
                this@Advisory.adviserId = snapshot.child("adviserId").value.toString().toInt()
                this@Advisory.section = snapshot.child("section").value.toString()
                this@Advisory.year = snapshot.child("year").value.toString()
                var q = 0
                while (q < snapshot.child("studentID").childrenCount){
                    this@Advisory.studentID.add(snapshot.child("studentID").child("$q").value.toString().toInt())
                    q++
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}