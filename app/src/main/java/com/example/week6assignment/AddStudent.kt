package com.example.week6assignment

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.week6assignment.model.Database
import com.example.week6assignment.model.Student


class AddStudent : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etAge:EditText
    lateinit var etAddress:EditText
    lateinit var btnSubmit:Button
    lateinit var rdoGroup:RadioGroup
    lateinit var rdoMale:RadioButton
    lateinit var rdoFemale:RadioButton
    lateinit var rdoOthers:RadioButton

    private var gender=""
    private val db = Database()
    private val studentData = db.returnStudent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        binder()

        Toast.makeText(
            this, "Size of student list is: ${studentData.size}\n" +
                    "${studentData[studentData.size - 1].Name} \n" +
                    "${studentData[studentData.size - 1].Gender}", Toast.LENGTH_LONG
        ).show()

        btnSubmit.setOnClickListener {
            val genId = rdoGroup.checkedRadioButtonId
            val selectedGender :RadioButton = findViewById(genId)
            gender= selectedGender.text.toString()

            validate()

            Toast.makeText(
                this, "Size of student list is: ${studentData.size}\n" +
                        "${studentData[studentData.size - 1].Name} \n" +
                        "${studentData[studentData.size - 1].Gender}", Toast.LENGTH_LONG
            ).show()
        }
    }
    private fun binder(){
        etName=findViewById(R.id.etName)
        etAge=findViewById(R.id.etAge)
        etAddress=findViewById(R.id.etAddress)
        btnSubmit=findViewById(R.id.btnSubmit)
        rdoGroup=findViewById(R.id.rdoGroup)
        rdoMale=findViewById(R.id.rdoMale)
        rdoFemale=findViewById(R.id.rdoFemale)
        rdoOthers=findViewById(R.id.rdoOthers)
    }
    fun validate(){
        if(gender=="Male"){
            studentData.add(
                Student(
                    "@drawable/dp",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
                )
            )

        }
        else if(gender=="Female"){
            studentData.add(
                Student(
                    "@drawable/del",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
                )
            )

        }
        else{
            studentData.add(
                Student(
                    "@drawable/del",
                    etName.text.toString(),
                    etAge.text.toString(),
                    etAddress.text.toString(),
                    gender
                )
            )

        }
    }


}
