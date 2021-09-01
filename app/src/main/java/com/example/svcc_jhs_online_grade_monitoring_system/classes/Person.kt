package com.example.svcc_jhs_online_grade_monitoring_system.classes

import android.widget.TextView
import android.widget.Toast
import com.example.svcc_jhs_online_grade_monitoring_system.fragProfileDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

open class Person(
        var personId: Int,
        var fname: String,
        var mname: String,
        var lname: String,
        var next: String,
        var sex: Boolean,
        var bdate: String,
        var phone: String,
        var address: String,
        var status: Boolean) {
    val dbPerson = Database().dbPerson

    open fun generatePersonId(){
        dbPerson.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Person.personId = 1 + snapshot.childrenCount.toInt()
            }
            override fun onCancelled(error: DatabaseError) {
                this@Person.personId = 1
            }
        })
    }
    open fun addPerson(){
        dbPerson.child("$personId").child("personId").setValue(personId)
        dbPerson.child("$personId").child("fname").setValue(fname.toUpperCase())
        dbPerson.child("$personId").child("mname").setValue(mname.toUpperCase())
        dbPerson.child("$personId").child("lname").setValue(lname.toUpperCase())
        dbPerson.child("$personId").child("next").setValue(next.toUpperCase())
        dbPerson.child("$personId").child("sex").setValue(sex)
        dbPerson.child("$personId").child("bdate").setValue(bdate.toUpperCase())
        dbPerson.child("$personId").child("phone").setValue(phone.toUpperCase())
        dbPerson.child("$personId").child("address").setValue(address.toUpperCase())
        dbPerson.child("$personId").child("status").setValue(status)
    }
    open fun updatePerson(){
        dbPerson.child("$personId").child("personId").setValue(personId)
        dbPerson.child("$personId").child("fname").setValue(fname.toUpperCase())
        dbPerson.child("$personId").child("mname").setValue(mname.toUpperCase())
        dbPerson.child("$personId").child("lname").setValue(lname.toUpperCase())
        dbPerson.child("$personId").child("next").setValue(next.toUpperCase())
        dbPerson.child("$personId").child("sex").setValue(sex)
        dbPerson.child("$personId").child("bdate").setValue(bdate.toUpperCase())
        dbPerson.child("$personId").child("phone").setValue(phone.toUpperCase())
        dbPerson.child("$personId").child("address").setValue(address.toUpperCase())
        dbPerson.child("$personId").child("status").setValue(status)
    }
    fun retrievePerson(personId : Int){
        dbPerson.child("$personId").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                this@Person.personId = snapshot.child("personId").value.toString().toInt()
                this@Person.fname = snapshot.child("fname").value.toString()
                this@Person.mname = snapshot.child("mname").value.toString()
                this@Person.lname = snapshot.child("lname").value.toString()
                this@Person.next = snapshot.child("next").value.toString()
                this@Person.sex = snapshot.child("sex").value.toString().toBoolean()
                this@Person.bdate = snapshot.child("bdate").value.toString()
                this@Person.phone = snapshot.child("phone").value.toString()
                this@Person.address = snapshot.child("address").value.toString()
                this@Person.status = snapshot.child("status").value.toString().toBoolean()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}