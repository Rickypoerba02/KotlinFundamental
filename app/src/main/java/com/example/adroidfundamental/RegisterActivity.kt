package com.example.adroidfundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etusername: EditText
   private lateinit var etpassword: EditText
   private lateinit var etconfirepassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etusername = findViewById(R.id.edt_username)
        etpassword = findViewById(R.id.edt_password)
        etconfirepassword = findViewById(R.id.edt_confire_password)

        val btnRegister:Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
       when(v.id){
           R.id.btn_register-> {
               val bundle =Bundle()
               bundle.putString("username",etusername.text.toString())
               bundle.putString("password",etpassword.text.toString())


               var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
               intent.putExtras(bundle)
               startActivity(intent)

           }
       }
    }
}