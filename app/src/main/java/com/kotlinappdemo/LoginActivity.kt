package com.kotlinappdemo

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val mobileNo = "8888888888"  // Immutable Variable
    private val password: String = "123456"   // Mutable Variable

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
        setListeners()
    }

    private fun initComponents() {
        etMobileNumber.setText(mobileNo)
        etPassword.setText(password)

    }

    private fun setListeners() {

        btnLogin.setOnClickListener {

            // store mobileno and paasword in SharedPreferences
            val mobileno:String = etMobileNumber.text.toString()
            val passWord:String = etPassword.text.toString()
            val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
            sharedPreferences.edit().apply {
                putString("mobile_no",mobileno)
                putString("password",passWord)
            }.apply()


            println("Mobile No : $mobileNo")
            println("Password : $password")

            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage(getString(R.string.msg_login_success))
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                        dialog, id -> startActivity(Intent(this@LoginActivity, SecondActivity::class.java))
                })

            // create dialog box
            val alert = dialogBuilder.create()
            alert.show()
        }
    }
}
