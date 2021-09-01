package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ViewEditProfileParent : AppCompatActivity() {
    companion object{
        var searchPerson = AdminMenu.searchPerson
        var searchParent = AdminMenu.searchParent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_edit_profile_parent)

        var txtId : TextView = findViewById(R.id.txtID)
        var txtFname : TextView = findViewById(R.id.txtSection)
        var txtMname : TextView = findViewById(R.id.txtMname)
        var txtLname : TextView = findViewById(R.id.txtLname)
        var txtNext : TextView = findViewById(R.id.txtNext)
        var spnSex : Spinner = findViewById(R.id.spinnerSex)
        var txtBdate : TextView = findViewById(R.id.txtBDate)
        var txtPhone : TextView = findViewById(R.id.txtPhone)
        var txtAddress : TextView = findViewById(R.id.txtAddress)
        var spnChildren : Spinner = findViewById(R.id.spnChildren)
        var txtStudent : TextView = findViewById(R.id.txtSTUDid)

        var btnRemove : Button = findViewById(R.id.btnRemove)
        var btnAdd : Button = findViewById(R.id.btnAdd)

        var btnEdit : Button = findViewById(R.id.btnEdit)
        var btnSave : Button = findViewById(R.id.btnSave)

        txtId.text = searchParent.parentId.toString()

        txtFname.text =  searchPerson.fname
        txtMname.text =  searchPerson.mname
        txtLname.text =  searchPerson.lname


        fun refreshChildSpinner(){
            var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,
                searchParent.childrenId)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spnChildren.adapter = adapter
        }
        refreshChildSpinner()

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
            btnRemove.isEnabled = false
            btnAdd.isEnabled = false
            txtStudent.isEnabled = false
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
            btnRemove.isEnabled = true
            btnAdd.isEnabled = true
            txtStudent.isEnabled = true
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
            searchParent.updateParent()
            Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show()

            val intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            finish()
        }
        btnRemove.setOnClickListener {
            if(txtStudent.text.isNotBlank()){
                var q = 0
                while (q < searchParent.childrenId.size){//remove child
                    if (txtStudent.text.toString().toInt() == searchParent.childrenId[q]){
                        searchParent.childrenId.removeAt(q)
                        Toast.makeText(this, "Child removed Successfully", Toast.LENGTH_SHORT).show()
                        break
                    }
                    q++
                }
                refreshChildSpinner()
            }
            else{
                Toast.makeText(this, "Invalid Remove Child Input", Toast.LENGTH_SHORT).show()
            }
        }
        btnAdd.setOnClickListener {
            if (txtStudent.text!!.isNotBlank()){//TEACHER
                if(txtStudent.text.length>6){
                    if(txtStudent.text.toString()!![2] == '3'){
                        searchParent.childrenId.add(txtStudent.text.toString().toInt())
                        refreshChildSpinner()
                        Toast.makeText(this, "Student [${txtStudent.text}] Linked Successful", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}