package com.example.userlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class Activity_register : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var username: EditText
    lateinit var password: EditText
lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(view.OnClickListener{
            if (binding.username.text.toString() == "user" && binding.password.text.toString() == "1234"){
                    Toast.makeText(context: this, text:"Login successful!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context: this, text:"Login Failed!", Toast.LENGTH_SHORT).show()
                }

        })
    }
}