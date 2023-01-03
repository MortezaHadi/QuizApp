package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.Constants
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding
import kotlin.math.sin

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
            optionNumber(convertState(ConvertEnum.CHOOSE), OptionsEnum.ONE)
        }
        binding.tvOptionTwo.setOnClickListener {
            chooseOption = 2
            defaultOption()
            optionNumber(convertState(ConvertEnum.CHOOSE), OptionsEnum.TWO)
        }
        binding.tvOptionThree.setOnClickListener {
            chooseOption = 3
            defaultOption()
            optionNumber(convertState(ConvertEnum.CHOOSE), OptionsEnum.THREE)
        }
        binding.tvOptionFour.setOnClickListener {
            chooseOption = 4
            defaultOption()
            optionNumber(convertState(ConvertEnum.CHOOSE), OptionsEnum.FOUR)
        }

        binding.btnSubmit.setOnClickListener {

            if (binding.btnSubmit.text == "SUBMIT" && chooseOption != 0) {
                clickableOptions(false)
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
                        1 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.ONE)
                        2 -> optionNumber(convertState(ConvertEnum.CORRECT),OptionsEnum.TWO)
                        3 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.THREE)
                        4 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.FOUR)
                    }
                } else {
                    when (chooseOption) {
                        1 -> optionNumber(convertState(ConvertEnum.WRONG), OptionsEnum.ONE)
                        2 -> optionNumber(convertState(ConvertEnum.WRONG), OptionsEnum.TWO)
                        3 -> optionNumber(convertState(ConvertEnum.WRONG), OptionsEnum.THREE)
                        4 -> optionNumber(convertState(ConvertEnum.WRONG), OptionsEnum.FOUR)
                    }
                    when (questionsList[currentPosition - 1].correctAnswer) {
                        1 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.ONE)
                        2 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.TWO)
                        3 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.THREE)
                        4 -> optionNumber(convertState(ConvertEnum.CORRECT), OptionsEnum.FOUR)
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
        clickableOptions(true)

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

    private fun optionNumber(status: Int, option: OptionsEnum) {
        when (option) {
            OptionsEnum.ONE -> binding.tvOptionOne.setBackgroundResource(status)
            OptionsEnum.TWO -> binding.tvOptionTwo.setBackgroundResource(status)
            OptionsEnum.THREE -> binding.tvOptionThree.setBackgroundResource(status)
            OptionsEnum.FOUR -> binding.tvOptionFour.setBackgroundResource(status)
        }
    }

    private fun convertState(status: ConvertEnum): Int {
        val sina: Int = when (status) {
            ConvertEnum.CORRECT -> R.drawable.correct_option_border_bg

            ConvertEnum.WRONG -> R.drawable.wrong_option_border_bg

            ConvertEnum.CHOOSE -> R.drawable.selected_option_border_bg
        }
        return sina
    }

    enum class ConvertEnum {
        CORRECT,
        WRONG,
        CHOOSE
    }

    enum class OptionsEnum {
        ONE,
        TWO,
        THREE,
        FOUR
    }

    private fun defaultOption() {
        binding.tvOptionOne.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionTwo.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionThree.setBackgroundResource(R.drawable.default_option_border_bg)
        binding.tvOptionFour.setBackgroundResource(R.drawable.default_option_border_bg)
    }

    private fun clickableOptions(boolean: Boolean) {
        binding.tvOptionOne.isClickable = boolean
        binding.tvOptionTwo.isClickable = boolean
        binding.tvOptionThree.isClickable = boolean
        binding.tvOptionFour.isClickable = boolean
    }
}