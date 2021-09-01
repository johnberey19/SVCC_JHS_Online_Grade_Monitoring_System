package com.example.svcc_jhs_online_grade_monitoring_system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment

class fragProfileDialog() : DialogFragment() {
    companion object{
        var clientPerson = actLogin.clientPerson

        var clientAdmin = LoginEmployee.clientAdmin
        var clientTeacher = LoginEmployee.clientTeacher

        var clientStudent = LoginNonEmployee.clientStudent
        var clientParent = LoginNonEmployee.clientParent
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootview : View = inflater.inflate(R.layout.frag_view_profile,container,false)

        var txtId : TextView = rootview.findViewById(R.id.txtID)
        var txtFname : TextView = rootview.findViewById(R.id.txtSection)
        var txtMname : TextView = rootview.findViewById(R.id.txtMname)
        var txtLname : TextView = rootview.findViewById(R.id.txtLname)
        var txtNext : TextView = rootview.findViewById(R.id.txtNext)
        var spnSex : Spinner = rootview.findViewById(R.id.spinnerSex)
        var txtBdate : TextView = rootview.findViewById(R.id.txtBDate)
        var txtPhone : TextView = rootview.findViewById(R.id.txtPhone)
        var txtAddress : TextView = rootview.findViewById(R.id.txtAddress)

        var btnEdit : Button = rootview.findViewById(R.id.btnEdit)
        var btnSave : Button = rootview.findViewById(R.id.btnSave)



        if (actLogin.studGradeView == "employee"){
            if (LoginEmployee.userType == 1){
                txtId.text = clientAdmin.adminId.toString()
            }
            else if (LoginEmployee.userType == 2){
                txtId.text = clientTeacher.teacherId.toString()
            }
        }
        else if (actLogin.studGradeView == "non-employee"){
            if (LoginNonEmployee.userType2 == 1){
                txtId.text = clientStudent.studentId.toString()
            }
            else if (LoginNonEmployee.userType2 == 2){
                txtId.text = clientParent.parentId.toString()
            }
        }


        txtFname.text = clientPerson.fname
        txtMname.text = clientPerson.mname
        txtLname.text = clientPerson.lname
        if (clientPerson.next.isBlank()|| clientPerson.next=="N/A" || clientPerson.next == ""){
            txtNext.text ="N/A"
        }
        else{
            txtNext.text = clientPerson.next
        }
        if (clientPerson.sex){
            spnSex.setSelection(0)
        }
        else{
            spnSex.setSelection(1)
        }
        txtBdate.text = clientPerson.bdate
        txtPhone.text = clientPerson.phone
        txtAddress.text = clientPerson.address

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
            clientPerson.fname = txtFname.text.toString()
            clientPerson.mname = txtMname.text.toString()
            clientPerson.lname = txtLname.text.toString()
            clientPerson.next = txtNext.text.toString()
            if (spnSex.selectedItemPosition==0)
            {
                clientPerson.sex = true
            }
            else{
                clientPerson.sex = false
            }
            clientPerson.bdate = txtBdate.text.toString()
            clientPerson.phone = txtPhone.text.toString()
            clientPerson.address = txtAddress.text.toString()

            clientPerson.updatePerson()
            clientPerson.retrievePerson(clientPerson.personId)
            Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        return rootview
    }
}