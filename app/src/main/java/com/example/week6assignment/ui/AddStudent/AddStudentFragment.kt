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
                    "data:image/png;base64,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" +
                            "7x5V7lbCz4Uhza3Nm2kvHf6Sj4Z20C2tG+k5fHSfDt9wHP0daDi/racNBbnOzLNRXp4bIU4a+/fz26cxjg+FQczUlTT9phZVkOPRi9HMi4Qd53HAobfGM0x4fOd9wzLBkfhvq04Myhw0vy+e3obF0NKwVtDgi6O0NHvuGC10z0lzo1U4YTqWps1yYDxIMJ+X321CtHTG8k97jkCvV+IDhyMf1Q3bms9+G3k9A09J4+mE4KToeBTeLL8NRkekzIY2HnaH0gopi+djzKM8SIgPridzA1xQFRE97W5MPyNqpe0MwLD/BsPz8BX0feEadii10AAAAAElFTkSuQmCC",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
            ))
        }
        else if(gender=="Female"){
            db.addStudent(Student(
                    "data:image/png;base64,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" +
                            "/+t5s0vruTHTnlfuS94qWu/QqdlATB6URqAtFCdSIqzQUqFUO3yD+dcvj30NG7LvhfyReCs1bJxU+AAAAAElFTkSuQmCC",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
            ))

        }
        else{
            db.addStudent(Student(
                    "data:image/png;base64,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" +
                            "BP31ofozunGoebvBXwM9/FT9djuQ6rjOnZW/R+jOZVBz2k2T6vM0nz/0y//RzfPOPtz425rSRUdd8P+D3kP3eunqhMvzmlb97p3rt8T9+lSHcaKrctedG94Jw+unLfEf5gd6fLlb9ugAAAAASUVORK5CYII=",
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