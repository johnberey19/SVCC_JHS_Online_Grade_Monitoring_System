package com.example.svcc_jhs_online_grade_monitoring_system.classes

import com.google.firebase.database.FirebaseDatabase

class Database(){
    val dbSVCC = FirebaseDatabase.getInstance().getReference("dbSVCC")
    val dbPerson = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Person")
    val dbParent = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Parent")
    val dbGuardian = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Guardian")
    val dbStudent = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Student")
    val dbTeacher = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Teacher")
    val dbAdmin = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Admin")
    val dbAdvisory = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Advisory")
    val dbEnrollee = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Enrollee")
    val dbYearLevel = FirebaseDatabase.getInstance().getReference("dbSVCC").child("YearLevel")
    val dbSection = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Section")
    val dbSubject = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Subject")
    val dbClassSubject = FirebaseDatabase.getInstance().getReference("dbSVCC").child("ClassSubject")
    val dbQuarter = FirebaseDatabase.getInstance().getReference("dbSVCC").child("Quarter")
    val dbAcadPeriod = FirebaseDatabase.getInstance().getReference("dbSVCC").child("AcadPeriod")
    val dbSchoolYear = FirebaseDatabase.getInstance().getReference("dbSVCC").child("SchoolYear")
    val dbQuarterGrade = FirebaseDatabase.getInstance().getReference("dbSVCC").child("QuarterGrade")
    val dbFinelGrade = FirebaseDatabase.getInstance().getReference("dbSVCC").child("FinaleGrade")
}