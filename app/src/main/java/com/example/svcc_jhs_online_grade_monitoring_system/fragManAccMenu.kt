package com.example.svcc_jhs_online_grade_monitoring_system

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

class fragManAccMenu(fragmentManager: FragmentManager) : DialogFragment(){
    companion object{
        var fm = AdminMenu.fm


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var rootview : View = inflater.inflate(R.layout.frag_man_acc, container, false)

        var btnAddAcc : Button = rootview.findViewById(R.id.btnAddAcc)
        var btnViewAcc : Button = rootview.findViewById(R.id.btnMasterlist)

        btnAddAcc.setOnClickListener {
            var addAcc = fragAddAcc()
            addAcc.show(fm,"addAcc")
            dismiss()
        }
        btnViewAcc.setOnClickListener {
            var viewAcc = fragSearch()
            viewAcc.show(fm,"viewAcc")
            dismiss()
        }
        return rootview
    }
}