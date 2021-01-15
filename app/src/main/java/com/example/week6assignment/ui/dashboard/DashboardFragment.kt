package com.example.week6assignment.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.week6assignment.R
import com.example.week6assignment.model.Database
import com.example.week6assignment.model.Student

class DashboardFragment : Fragment() {
    lateinit var etName: EditText
    lateinit var etAge: EditText
    lateinit var etAddress: EditText
    lateinit var btnSubmit: Button
    lateinit var rdoGroup: RadioGroup
    lateinit var rdoMale:RadioButton
    lateinit var rdoFemale:RadioButton
    lateinit var rdoOthers:RadioButton

    lateinit var root:View
    private var gender=""
    private val db = Database()
    private val studentData = db.returnStudent()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        binder()

        btnSubmit.setOnClickListener {
            val genId = rdoGroup.checkedRadioButtonId
            val selectedGender : RadioButton = root.findViewById(genId)
            gender= selectedGender.text.toString()

            validate()

            Toast.makeText(
                    context, "Student Added", Toast.LENGTH_LONG
            ).show()
            println(studentData[0].toString())
        }
        return root
    }
    private fun binder(){
        etName=root.findViewById(R.id.etName)
        etAge=root.findViewById(R.id.etAge)
        etAddress=root.findViewById(R.id.etAddress)
        btnSubmit=root.findViewById(R.id.btnSubmit)
        rdoGroup=root.findViewById(R.id.rdoGroup)
        rdoMale=root.findViewById(R.id.rdoMale)
        rdoFemale=root.findViewById(R.id.rdoFemale)
        rdoOthers=root.findViewById(R.id.rdoOthers)
    }
    fun validate(){
        if(gender=="Male"){
            db.addStudent(Student(
                    "@drawable/dp",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
            ))
        }
        else if(gender=="Female"){
            db.addStudent(Student(
                    "@drawable/delete",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
            ))

        }
        else{
            db.addStudent(Student(
                    "@drawable/del",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
            ))
        }
    }
}