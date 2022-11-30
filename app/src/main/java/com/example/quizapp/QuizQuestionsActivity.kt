package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.Constants
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding
    private val questionsList = Constants.getQuestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myName = intent.getStringExtra("myName")
        binding.textView2.text = myName

        setQuestion(1)
        var currentPosition = 1
        var chooseOption = 0
        var point = 0

        binding.tvOptionOne.setOnClickListener {
            chooseOption = 1
            defaultOption()
            optionOneColor("choose")
        }
        binding.tvOptionTwo.setOnClickListener {
            chooseOption = 2
            defaultOption()
            optionTwoColor("choose")
        }
        binding.tvOptionThree.setOnClickListener {
            chooseOption = 3
            defaultOption()
            optionThreeColor("choose")
        }
        binding.tvOptionFour.setOnClickListener {
            chooseOption = 4
            defaultOption()
            optionFourColor("choose")
        }

        binding.btnSubmit.setOnClickListener {

            if (binding.btnSubmit.text == "SUBMIT" && chooseOption != 0) {
                nonClickableOptions()
                if (currentPosition == 9) {
                    binding.btnSubmit.text = "Finish"
                } else {
                    binding.btnSubmit.text = "To Next Question"
                }
//                Log.e("abcd",chooseOption.toString())
//                Log.e("abcd2",questionsList[currentPosition-1].correctAnswer.toString())
                if (chooseOption == questionsList[currentPosition - 1].correctAnswer) {
                    point++
                    when (chooseOption) {
                        1 -> optionOneColor("correct")
                        2 -> optionTwoColor("correct")
                        3 -> optionThreeColor("correct")
                        4 -> optionFourColor("correct")
                    }
                } else {
                    when (chooseOption) {
                        1 -> optionOneColor("wrong")
                        2 -> optionTwoColor("wrong")
                        3 -> optionThreeColor("wrong")
                        4 -> optionFourColor("wrong")
                    }
                    when (questionsList[currentPosition - 1].correctAnswer) {
                        1 -> optionOneColor("correct")
                        2 -> optionTwoColor("correct")
                        3 -> optionThreeColor("correct")
                        4 -> optionFourColor("correct")
                    }
                }

            } else if (chooseOption == 0) {
                Toast.makeText(this, "Choose option", Toast.LENGTH_SHORT).show()
            } else {
                chooseOption = 0
                if (currentPosition == 10) {
                    val intent2 = Intent(this, FinishActivity::class.java)
                    intent2.putExtra("name", myName)
                    intent2.putExtra("score", point.toString())
                    startActivity(intent2)
                } else {
                    currentPosition++
                    setQuestion(currentPosition)
                    binding.btnSubmit.text = "SUBMIT"
                }
            }
        }
    }

    private fun setQuestion(currentPosition: Int) {
        defaultOption()
        clickableOptions()

        val question: Question = questionsList[currentPosition - 1]

        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition" + "/" + binding.progressBar.max
        binding.tvQuestion.text = question.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun optionOneColor(status: String) {
        when (status) {
            "correct" -> binding.tvOptionOne.setBackgroundResource(R.drawable.correct_option_border_bg)

            "wrong" -> binding.tvOptionOne.setBackgroundResource(R.drawable.wrong_option_border_bg)

            "choose" -> binding.tvOptionOne.setBackgroundResource(R.drawable.selected_option_border_bg)
        }
    }

    private fun optionTwoColor(status: String) {
        when (status) {
            "correct" -> binding.tvOptionTwo.setBackgroundResource(R.drawable.correct_option_border_bg)

            "wrong" -> binding.tvOptionTwo.setBackgroundResource(R.drawable.wrong_option_border_bg)

            "choose" -> binding.tvOptionTwo.setBackgroundResource(R.drawable.selected_option_border_bg)
        }
    }

    private fun optionThreeColor(status: String) {
        when (status) {
            "correct" -> binding.tvOptionThree.setBackgroundResource(R.drawable.correct_option_border_bg)

            "wrong" -> binding.tvOptionThree.setBackgroundResource(R.drawable.wrong_option_border_bg)

            "choose" -> binding.tvOptionThree.setBackgroundResource(R.drawable.selected_option_border_bg)
        }
    }

    private fun optionFourColor(status: String) {
        when (status) {
            "correct" -> binding.tvOptionFour.setBackgroundResource(R.drawable.correct_option_border_bg)

            "wrong" -> binding.tvOptionFour.setBackgroundResource(R.drawable.wrong_option_border_bg)

            "choose" -> binding.tvOptionFour.setBackgroundResource(R.drawable.selected_option_border_bg)
        }
    }

    private fun defaultOption() {
        binding.tvOptionOne.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionTwo.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionThree.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionFour.setBackgroundResource(R.drawable.default_option_border_bg)
    }

    private fun clickableOptions() {
        binding.tvOptionOne.isClickable = true
        binding.tvOptionTwo.isClickable = true
        binding.tvOptionThree.isClickable = true
        binding.tvOptionFour.isClickable = true

    }

    private fun nonClickableOptions() {
        binding.tvOptionOne.isClickable = false
        binding.tvOptionTwo.isClickable = false
        binding.tvOptionThree.isClickable = false
        binding.tvOptionFour.isClickable = false
    }
}