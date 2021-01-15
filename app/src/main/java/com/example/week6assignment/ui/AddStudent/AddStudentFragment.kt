package com.example.week6assignment.ui.AddStudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.week6assignment.R
import com.example.week6assignment.model.Database
import com.example.week6assignment.model.Student

class AddStudentFragment : Fragment() {
    lateinit var etName: EditText
    lateinit var etAge: EditText
    lateinit var etAddress: EditText
    lateinit var btnSubmit: Button
    lateinit var rdoGroup: RadioGroup
    lateinit var rdoMale:RadioButton
    lateinit var rdoFemale:RadioButton
    lateinit var rdoOthers:RadioButton
    var flag = false



    lateinit var root:View
    private var gender=""
    private val db = Database()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_addstudent, container, false)
        binder()

        btnSubmit.setOnClickListener {


       validateInput()

        if(!flag) {
            validate()
            Toast.makeText(
                    context, "Student Added", Toast.LENGTH_LONG
            ).show()
        }



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
    fun validateInput() {

        val genId = rdoGroup.checkedRadioButtonId
        if (genId != -1) {
            val selectedGender: RadioButton = root.findViewById(genId)
            gender = selectedGender.text.toString()
        }

        flag=false
        when {
            etName.text.toString() == "" -> {
                etName.error = "This field is Mandatory"
                etName.requestFocus()
                flag = true

            }
            etAddress.text.toString() == "" -> {
                etAddress.error = "This field is Mandatory"
                etAddress.requestFocus()
                flag = true
            }
            etAge.text.toString() == "" -> {
                etAge.error = "This field is Mandatory"
                flag =true
            }
            genId == -1 -> {
                Toast.makeText(context, "Please select gender", Toast.LENGTH_SHORT).show()
                flag = true
            }
            else->{
                flag=false
            }

        }

    }
}