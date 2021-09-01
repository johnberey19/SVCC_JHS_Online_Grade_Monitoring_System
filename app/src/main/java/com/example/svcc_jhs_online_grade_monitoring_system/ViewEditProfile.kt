package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class ViewEditProfile : AppCompatActivity() {
    companion object{

        var searchType = AdminMenu.searchType

        var searchPerson = AdminMenu.searchPerson
        var searchTeacher = AdminMenu.searchTeacher
        var searchStudent = AdminMenu.searchStudent
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_edit_profile)
        
        var txtId : TextView = findViewById(R.id.txtID)
        var txtFname : TextView = findViewById(R.id.txtSection)
        var txtMname : TextView = findViewById(R.id.txtMname)
        var txtLname : TextView = findViewById(R.id.txtLname)
        var txtNext : TextView = findViewById(R.id.txtNext)
        var spnSex : Spinner = findViewById(R.id.spinnerSex)
        var txtBdate : TextView = findViewById(R.id.txtBDate)
        var txtPhone : TextView = findViewById(R.id.txtPhone)
        var txtAddress : TextView = findViewById(R.id.txtAddress)

        var btnEdit : Button = findViewById(R.id.btnEdit)
        var btnSave : Button = findViewById(R.id.btnSave)
        if (searchType == "teacher"){
            txtId.text = searchTeacher.teacherId.toString()
        }
        else if(searchType == "student"){
            txtId.text =  searchStudent.studentId.toString()
        }
        txtFname.text =  searchPerson.fname
        txtMname.text =  searchPerson.mname
        txtLname.text =  searchPerson.lname
        if ( searchPerson.next.isBlank()||  searchPerson.next=="N/A" ||  searchPerson.next == ""){
            txtNext.text ="N/A"
        }
        else{
            txtNext.text =  searchPerson.next
        }
        if ( searchPerson.sex){
            spnSex.setSelection(0)
        }
        else{
            spnSex.setSelection(1)
        }
        txtBdate.text =  searchPerson.bdate
        txtPhone.text =  searchPerson.phone
        txtAddress.text =  searchPerson.address

        fun disable(){
            txtId.isEnabled = false
            txtFname.isEnabled = false
            txtMname.isEnabled = false
            txtLname.isEnabled = false
            txtNext.isEnabled = false
            spnSex.isEnabled = false
            txtBdate.isEnabled = false
            txtPhone.isEnabled = false
            txtAddress.isEnabled = false
            btnSave.isEnabled = false
            btnEdit.isEnabled = true
        }
        fun enable(){
            txtFname.isEnabled = true
            txtMname.isEnabled = true
            txtLname.isEnabled = true
            txtNext.isEnabled = true
            spnSex.isEnabled = true
            txtBdate.isEnabled = true
            txtPhone.isEnabled = true
            txtAddress.isEnabled = true
            btnSave.isEnabled = true
            btnEdit.isEnabled = false
        }

        disable()

        btnEdit.setOnClickListener {
            enable()
        }
        btnSave.setOnClickListener {
            disable()
            searchPerson.fname = txtFname.text.toString()
            searchPerson.mname = txtMname.text.toString()
            searchPerson.lname = txtLname.text.toString()
            searchPerson.next = txtNext.text.toString()
            if (spnSex.selectedItemPosition==0)
            {
                searchPerson.sex = true
            }
            else{
                searchPerson.sex = false
            }
            searchPerson.bdate = txtBdate.text.toString()
            searchPerson.phone = txtPhone.text.toString()
            searchPerson.address = txtAddress.text.toString()
            searchPerson.updatePerson()
            Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show()

            val intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}