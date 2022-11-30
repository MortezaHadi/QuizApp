package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityFinishBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myName = intent.getStringExtra("name")
        val point = intent.getStringExtra("score")

        binding.tvNameFinish.text = "Congratulation \n$myName"
        binding.scoreFinish.text = "Your Score \n$point"



    }
}