package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.Constants

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        val myName = intent.getStringExtra("myName")

        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = myName


//        val questionsList = Constants.getQuestions()      //  برای چک کردن اطلاعات داده شده به کنستانس
//        Log.i("question size","${questionsList.size}")


        val question = Constants.getQuestions()




    }
}