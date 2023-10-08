package com.example.adroidfundamental

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  etUsername:EditText
    private lateinit var etpassword : EditText
    private lateinit var  Ricky : TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("Ricky")
            Ricky.text = returnString

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Ricky = findViewById(R.id.Ricky_tv)
        etUsername = findViewById(R.id.edt_username)
        etpassword = findViewById(R.id.edt_password)

        val bundle = intent.extras
        if (bundle !=null) {
            etUsername.setText(bundle.getString("username"))
            etpassword.setText(bundle.getString("password"))
        }
    val btnlogin: Button = findViewById(R.id.btn_login)
        btnlogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_login -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("user",user(etUsername.text.toString(),etpassword.text.toString()))
                resultLauncher.launch(intent)
            }

        }
    }
}