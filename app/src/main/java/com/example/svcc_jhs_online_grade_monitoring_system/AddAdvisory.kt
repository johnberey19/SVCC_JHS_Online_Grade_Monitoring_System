package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Advisory
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Database

class AddAdvisory : AppCompatActivity() {
    companion object{
        var AddAdvisory = AdminMenu.AddAdvisory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_advisory)

        var txtAdvisoryId : TextView = findViewById(R.id.txtAdvisoryID)

        var spnYear : Spinner = findViewById(R.id.spnYear)
        var txtSectionName : TextView = findViewById(R.id.txtSection)
        var txtAdviser : TextView = findViewById(R.id.txtAdviserId)

        var btnSet : Button = findViewById(R.id.btnSet)
        var spnChildren : Spinner = findViewById(R.id.spnChildren)

        var txtStudent : TextView = findViewById(R.id.txtSTUDid)

        var btnRemove : Button = findViewById(R.id.btnRemove)
        var btnAdd : Button = findViewById(R.id.btnAdd)

        var btnDone : Button = findViewById(R.id.btnDone)

        fun refreshChildSpinner(){
            var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,
                AddAdvisory.studentID)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spnChildren.adapter = adapter
        }

        txtAdvisoryId.isEnabled = false

        fun set(){
            txtSectionName.isEnabled = true
            txtAdviser.isEnabled = true
            btnSet.isEnabled = true
            txtStudent.isEnabled = false
            btnRemove.isEnabled = false
            btnAdd.isEnabled = false
            btnDone.isEnabled = false
        }
        fun done(){
            txtSectionName.isEnabled = false
            txtAdviser.isEnabled = false
            btnSet.isEnabled = false
            txtStudent.isEnabled = true
            btnRemove.isEnabled = true
            btnAdd.isEnabled = true
            btnDone.isEnabled = true
        }
        txtAdvisoryId.text = AddAdvisory.advisoryId.toString()

        set()

        btnSet.setOnClickListener{
            AddAdvisory.section = txtSectionName.text.toString()
            AddAdvisory.year = spnYear.selectedItem.toString()
            AddAdvisory.adviserId = txtAdviser.text.toString().toInt()
            done()
        }
        btnDone.setOnClickListener{
            val dbTeacher = Database().dbTeacher
            AddAdvisory.addAdvisory()
            dbTeacher.child("${AddAdvisory.adviserId}").child("advisoryId").setValue(AddAdvisory.advisoryId)
            val intent = Intent(this,AdminMenu()::class.java)
            startActivity(intent)
            finish()
        }
        btnAdd.setOnClickListener {
            if (txtStudent.text!!.isNotBlank()){//TEACHER
                if(txtStudent.text.length>6){
                    if(txtStudent.text.toString()!![2] == '3'){
                        AddAdvisory.studentID.add(txtStudent.text.toString().toInt())
                        refreshChildSpinner()
                        Toast.makeText(this, "Student [${txtStudent.text}] Linked Successful", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        btnRemove.setOnClickListener {
            if(txtStudent.text.isNotBlank()){
                var q = 0
                while (q < AddAdvisory.studentID.size){//remove child
                    if (txtStudent.text.toString().toInt() == AddAdvisory.studentID[q]){
                        AddAdvisory.studentID.removeAt(q)
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
    }

    override fun onBackPressed() {
        finish()
    }
}