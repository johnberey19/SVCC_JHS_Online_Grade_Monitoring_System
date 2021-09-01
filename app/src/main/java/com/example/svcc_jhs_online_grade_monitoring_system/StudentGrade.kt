package com.example.svcc_jhs_online_grade_monitoring_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.svcc_jhs_online_grade_monitoring_system.classes.Student

class StudentGrade : AppCompatActivity() {
    companion object{
        var gradingStudent1 = Masterlist.gradingStudent
        var gradingStudent2 = LoginNonEmployee.clientStudent
        var studGradeView = actLogin.studGradeView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_grade)

        var txtID : TextView = findViewById(R.id.txtGradeViewID)
        var btnEdit : Button = findViewById(R.id.btnedit)
        var btnSave : Button = findViewById(R.id.btnsave)

        var txtENG1 : TextView = findViewById(R.id.txtENG1)
        var txtENG2 : TextView = findViewById(R.id.txtENG2)
        var txtENG3 : TextView = findViewById(R.id.txtENG3)
        var txtENG4 : TextView = findViewById(R.id.txtENG4)
        var txtENG5 : TextView = findViewById(R.id.txtENG5)

        var txtFIL1 : TextView = findViewById(R.id.txtFIL1)
        var txtFIL2 : TextView = findViewById(R.id.txtFIL2)
        var txtFIL3 : TextView = findViewById(R.id.txtFIL3)
        var txtFIL4 : TextView = findViewById(R.id.txtFIL4)
        var txtFIL5 : TextView = findViewById(R.id.txtFIL5)

        var txtMATH1 : TextView = findViewById(R.id.txtMATH1)
        var txtMATH2 : TextView = findViewById(R.id.txtMATH2)
        var txtMATH3 : TextView = findViewById(R.id.txtMATH3)
        var txtMATH4 : TextView = findViewById(R.id.txtMATH4)
        var txtMATH5 : TextView = findViewById(R.id.txtMATH5)

        var txtSCI1 : TextView = findViewById(R.id.txtSCI1)
        var txtSCI2 : TextView = findViewById(R.id.txtSCI2)
        var txtSCI3 : TextView = findViewById(R.id.txtSCI3)
        var txtSCI4 : TextView = findViewById(R.id.txtSCI4)
        var txtSCI5 : TextView = findViewById(R.id.txtSCI5)

        var txtTLE1 : TextView = findViewById(R.id.txtTLE1)
        var txtTLE2 : TextView = findViewById(R.id.txtTLE2)
        var txtTLE3 : TextView = findViewById(R.id.txtTLE3)
        var txtTLE4 : TextView = findViewById(R.id.txtTLE4)
        var txtTLE5 : TextView = findViewById(R.id.txtTLE5)

        var txtAP1 : TextView = findViewById(R.id.txtAP1)
        var txtAP2 : TextView = findViewById(R.id.txtAP2)
        var txtAP3 : TextView = findViewById(R.id.txtAP3)
        var txtAP4 : TextView = findViewById(R.id.txtAP4)
        var txtAP5 : TextView = findViewById(R.id.txtAP5)

        var txtESP1 : TextView = findViewById(R.id.txtESP1)
        var txtESP2 : TextView = findViewById(R.id.txtESP2)
        var txtESP3 : TextView = findViewById(R.id.txtESP3)
        var txtESP4 : TextView = findViewById(R.id.txtESP4)
        var txtESP5 : TextView = findViewById(R.id.txtESP5)

        var txtMAPEH1 : TextView = findViewById(R.id.txtMAPEH1)
        var txtMAPEH2 : TextView = findViewById(R.id.txtMAPEH2)
        var txtMAPEH3 : TextView = findViewById(R.id.txtMAPEH3)
        var txtMAPEH4 : TextView = findViewById(R.id.txtMAPEH4)
        var txtMAPEH5 : TextView = findViewById(R.id.txtMAPEH5)
        
        fun disable(){
            txtENG1.isEnabled = false
            txtENG2.isEnabled = false
            txtENG3.isEnabled = false
            txtENG4.isEnabled = false
            txtENG5.isEnabled = false
            txtFIL1.isEnabled = false
            txtFIL2.isEnabled = false
            txtFIL3.isEnabled = false
            txtFIL4.isEnabled = false
            txtFIL5.isEnabled = false
            txtMATH1.isEnabled = false
            txtMATH2.isEnabled = false
            txtMATH3.isEnabled = false
            txtMATH4.isEnabled = false
            txtMATH5.isEnabled = false
            txtSCI1.isEnabled = false
            txtSCI2.isEnabled = false
            txtSCI3.isEnabled = false
            txtSCI4.isEnabled = false
            txtSCI5.isEnabled = false
            txtTLE1.isEnabled = false
            txtTLE2.isEnabled = false
            txtTLE3.isEnabled = false
            txtTLE4.isEnabled = false
            txtTLE5.isEnabled = false
            txtAP1.isEnabled = false
            txtAP2.isEnabled = false
            txtAP3.isEnabled = false
            txtAP4.isEnabled = false
            txtAP5.isEnabled = false
            txtESP1.isEnabled = false
            txtESP2.isEnabled = false
            txtESP3.isEnabled = false
            txtESP4.isEnabled = false
            txtESP5.isEnabled = false
            txtMAPEH1.isEnabled = false
            txtMAPEH2.isEnabled = false
            txtMAPEH3.isEnabled = false
            txtMAPEH4.isEnabled = false
            txtMAPEH5.isEnabled = false
            btnEdit.isEnabled = true
            btnSave.isEnabled = false

        }
        fun enable(){
            txtENG1.isEnabled = true
            txtENG2.isEnabled = true
            txtENG3.isEnabled = true
            txtENG4.isEnabled = true
            txtENG5.isEnabled = false
            txtFIL1.isEnabled = true
            txtFIL2.isEnabled = true
            txtFIL3.isEnabled = true
            txtFIL4.isEnabled = true
            txtFIL5.isEnabled = false
            txtMATH1.isEnabled = true
            txtMATH2.isEnabled = true
            txtMATH3.isEnabled = true
            txtMATH4.isEnabled = true
            txtMATH5.isEnabled = false
            txtSCI1.isEnabled = true
            txtSCI2.isEnabled = true
            txtSCI3.isEnabled = true
            txtSCI4.isEnabled = true
            txtSCI5.isEnabled = false
            txtTLE1.isEnabled = true
            txtTLE2.isEnabled = true
            txtTLE3.isEnabled = true
            txtTLE4.isEnabled = true
            txtTLE5.isEnabled = false
            txtAP1.isEnabled = true
            txtAP2.isEnabled = true
            txtAP3.isEnabled = true
            txtAP4.isEnabled = true
            txtAP5.isEnabled = false
            txtESP1.isEnabled = true
            txtESP2.isEnabled = true
            txtESP3.isEnabled = true
            txtESP4.isEnabled = true
            txtESP5.isEnabled = false
            txtMAPEH1.isEnabled = true
            txtMAPEH2.isEnabled = true
            txtMAPEH3.isEnabled = true
            txtMAPEH4.isEnabled = true
            txtMAPEH5.isEnabled = false
            btnEdit.isEnabled = false
            btnSave.isEnabled = true
        }
        if (studGradeView == "employee"){
            disable()
            txtID.text = gradingStudent1.studentId.toString()

            txtENG1.text = gradingStudent1.grades[0][0].toString()
            txtENG2.text = gradingStudent1.grades[0][1].toString()
            txtENG3.text = gradingStudent1.grades[0][2].toString()
            txtENG4.text = gradingStudent1.grades[0][3].toString()
            txtENG5.text = gradingStudent1.grades[0][4].toString()

            txtFIL1.text = gradingStudent1.grades[1][0].toString()
            txtFIL2.text = gradingStudent1.grades[1][1].toString()
            txtFIL3.text = gradingStudent1.grades[1][2].toString()
            txtFIL4.text = gradingStudent1.grades[1][3].toString()
            txtFIL5.text = gradingStudent1.grades[1][4].toString()

            txtMATH1.text = gradingStudent1.grades[2][0].toString()
            txtMATH2.text = gradingStudent1.grades[2][1].toString()
            txtMATH3.text = gradingStudent1.grades[2][2].toString()
            txtMATH4.text = gradingStudent1.grades[2][3].toString()
            txtMATH5.text = gradingStudent1.grades[2][4].toString()

            txtSCI1.text = gradingStudent1.grades[3][0].toString()
            txtSCI2.text = gradingStudent1.grades[3][1].toString()
            txtSCI3.text = gradingStudent1.grades[3][2].toString()
            txtSCI4.text = gradingStudent1.grades[3][3].toString()
            txtSCI5.text = gradingStudent1.grades[3][4].toString()

            txtTLE1.text = gradingStudent1.grades[4][0].toString()
            txtTLE2.text = gradingStudent1.grades[4][1].toString()
            txtTLE3.text = gradingStudent1.grades[4][2].toString()
            txtTLE4.text = gradingStudent1.grades[4][3].toString()
            txtTLE5.text = gradingStudent1.grades[4][4].toString()

            txtAP1.text = gradingStudent1.grades[5][0].toString()
            txtAP2.text = gradingStudent1.grades[5][1].toString()
            txtAP3.text = gradingStudent1.grades[5][2].toString()
            txtAP4.text = gradingStudent1.grades[5][3].toString()
            txtAP5.text = gradingStudent1.grades[5][4].toString()

            txtESP1.text = gradingStudent1.grades[6][0].toString()
            txtESP2.text = gradingStudent1.grades[6][1].toString()
            txtESP3.text = gradingStudent1.grades[6][2].toString()
            txtESP4.text = gradingStudent1.grades[6][3].toString()
            txtESP5.text = gradingStudent1.grades[6][4].toString()

            txtMAPEH1.text = gradingStudent1.grades[7][0].toString()
            txtMAPEH2.text = gradingStudent1.grades[7][1].toString()
            txtMAPEH3.text = gradingStudent1.grades[7][2].toString()
            txtMAPEH4.text = gradingStudent1.grades[7][3].toString()
            txtMAPEH5.text = gradingStudent1.grades[7][4].toString()
        }
        else if (studGradeView == "non-employee"){
            disable()
            txtID.text = gradingStudent2.studentId.toString()

            txtENG1.text = gradingStudent2.grades[0][0].toString()
            txtENG2.text = gradingStudent2.grades[0][1].toString()
            txtENG3.text = gradingStudent2.grades[0][2].toString()
            txtENG4.text = gradingStudent2.grades[0][3].toString()
            txtENG5.text = gradingStudent2.grades[0][4].toString()

            txtFIL1.text = gradingStudent2.grades[1][0].toString()
            txtFIL2.text = gradingStudent2.grades[1][1].toString()
            txtFIL3.text = gradingStudent2.grades[1][2].toString()
            txtFIL4.text = gradingStudent2.grades[1][3].toString()
            txtFIL5.text = gradingStudent2.grades[1][4].toString()

            txtMATH1.text = gradingStudent2.grades[2][0].toString()
            txtMATH2.text = gradingStudent2.grades[2][1].toString()
            txtMATH3.text = gradingStudent2.grades[2][2].toString()
            txtMATH4.text = gradingStudent2.grades[2][3].toString()
            txtMATH5.text = gradingStudent2.grades[2][4].toString()

            txtSCI1.text = gradingStudent2.grades[3][0].toString()
            txtSCI2.text = gradingStudent2.grades[3][1].toString()
            txtSCI3.text = gradingStudent2.grades[3][2].toString()
            txtSCI4.text = gradingStudent2.grades[3][3].toString()
            txtSCI5.text = gradingStudent2.grades[3][4].toString()

            txtTLE1.text = gradingStudent2.grades[4][0].toString()
            txtTLE2.text = gradingStudent2.grades[4][1].toString()
            txtTLE3.text = gradingStudent2.grades[4][2].toString()
            txtTLE4.text = gradingStudent2.grades[4][3].toString()
            txtTLE5.text = gradingStudent2.grades[4][4].toString()

            txtAP1.text = gradingStudent2.grades[5][0].toString()
            txtAP2.text = gradingStudent2.grades[5][1].toString()
            txtAP3.text = gradingStudent2.grades[5][2].toString()
            txtAP4.text = gradingStudent2.grades[5][3].toString()
            txtAP5.text = gradingStudent2.grades[5][4].toString()

            txtESP1.text = gradingStudent2.grades[6][0].toString()
            txtESP2.text = gradingStudent2.grades[6][1].toString()
            txtESP3.text = gradingStudent2.grades[6][2].toString()
            txtESP4.text = gradingStudent2.grades[6][3].toString()
            txtESP5.text = gradingStudent2.grades[6][4].toString()

            txtMAPEH1.text = gradingStudent2.grades[7][0].toString()
            txtMAPEH2.text = gradingStudent2.grades[7][1].toString()
            txtMAPEH3.text = gradingStudent2.grades[7][2].toString()
            txtMAPEH4.text = gradingStudent2.grades[7][3].toString()
            txtMAPEH5.text = gradingStudent2.grades[7][4].toString()
            btnEdit.isEnabled = false
            btnSave.isEnabled = false
            btnEdit.visibility = View.GONE
            btnSave.visibility = View.GONE
        }

        btnEdit.setOnClickListener {
            enable()
        }
        btnSave.setOnClickListener {
            disable()
            gradingStudent1.grades[0][0] = txtENG1.text.toString().toFloat()
            gradingStudent1.grades[0][1] = txtENG2.text.toString().toFloat()
            gradingStudent1.grades[0][2] = txtENG3.text.toString().toFloat()
            gradingStudent1.grades[0][3] = txtENG4.text.toString().toFloat()

            gradingStudent1.grades[1][0] = txtFIL1.text.toString().toFloat()
            gradingStudent1.grades[1][1] = txtFIL2.text.toString().toFloat()
            gradingStudent1.grades[1][2] = txtFIL3.text.toString().toFloat()
            gradingStudent1.grades[1][3] = txtFIL4.text.toString().toFloat()

            gradingStudent1.grades[2][0] = txtMATH1.text.toString().toFloat()
            gradingStudent1.grades[2][1] = txtMATH2.text.toString().toFloat()
            gradingStudent1.grades[2][2] = txtMATH3.text.toString().toFloat()
            gradingStudent1.grades[2][3] = txtMATH4.text.toString().toFloat()

            gradingStudent1.grades[3][0] = txtSCI1.text.toString().toFloat()
            gradingStudent1.grades[3][1] = txtSCI2.text.toString().toFloat()
            gradingStudent1.grades[3][2] = txtSCI3.text.toString().toFloat()
            gradingStudent1.grades[3][3] = txtSCI4.text.toString().toFloat()

            gradingStudent1.grades[4][0] = txtTLE1.text.toString().toFloat()
            gradingStudent1.grades[4][1] = txtTLE2.text.toString().toFloat()
            gradingStudent1.grades[4][2] = txtTLE3.text.toString().toFloat()
            gradingStudent1.grades[4][3] = txtTLE4.text.toString().toFloat()
            
            gradingStudent1.grades[5][0] = txtAP1.text.toString().toFloat()
            gradingStudent1.grades[5][1] = txtAP2.text.toString().toFloat()
            gradingStudent1.grades[5][2] = txtAP3.text.toString().toFloat()
            gradingStudent1.grades[5][3] = txtAP4.text.toString().toFloat()

            gradingStudent1.grades[6][0] = txtESP1.text.toString().toFloat()
            gradingStudent1.grades[6][1] = txtESP2.text.toString().toFloat()
            gradingStudent1.grades[6][2] = txtESP3.text.toString().toFloat()
            gradingStudent1.grades[6][3] = txtESP4.text.toString().toFloat()

            gradingStudent1.grades[7][0] = txtMAPEH1.text.toString().toFloat()
            gradingStudent1.grades[7][1] = txtMAPEH2.text.toString().toFloat()
            gradingStudent1.grades[7][2] = txtMAPEH3.text.toString().toFloat()
            gradingStudent1.grades[7][3] = txtMAPEH4.text.toString().toFloat()

            gradingStudent1.editStudent()
            Toast.makeText(this, "[${gradingStudent1.studentId}] grade updated successfully", Toast.LENGTH_SHORT).show()
            disable()
            finish()
        }
    }

    override fun onBackPressed() {
        finish()
    }
}