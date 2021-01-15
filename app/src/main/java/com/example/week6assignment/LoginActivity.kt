package com.example.week6assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var userName:EditText
    private lateinit var password:EditText
    private lateinit var login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userName=findViewById(R.id.etUsername)
        password=findViewById(R.id.etPassword)
        login = findViewById(R.id.btnLogin)

        login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            login.id->{
                if (isValid()){
                    if (userName.text.toString()=="softwarica" && password.text.toString()=="coventry"){
                        Intent(this, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    } else {
                        Toast.makeText(applicationContext, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }

    private fun isValid(): Boolean {
        var flag = true
        if (TextUtils.isEmpty(userName.text)) {
            userName.error = "Please enter Username"
            userName.requestFocus()
            flag = false
        } else if (TextUtils.isEmpty(password.text)){
            password.error="Please enter Paasword"
            password.requestFocus()
            flag = false
        }
        return flag
    }


}