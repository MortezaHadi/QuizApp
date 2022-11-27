package com.example

import com.example.quizapp.Question
import com.example.quizapp.R

object Constants {
    fun getQuestions(): ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "what country does this flag belong to?", R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia", "Armenia", "Austria", 1
        )
        // 2
        val que2 = Question(
            2, "what country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium", "Barbados", "Belize", 2
        )
        // 3
        val que3 = Question(
            3, "what country does this flag belong to?", R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize", "Brunei", "Brazil", 4
        )
        // 4
        val que4 = Question(
            4, "what country does this flag belong to?", R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium", "Barbados", "Belize", 2
        )
        // 5
        val que5 = Question(
            5, "what country does this flag belong to?", R.drawable.ic_flag_of_fiji,
            "Gabon", "France", "Fiji", "Finland", 3
        )
        // 6
        val que6 = Question(
            6, "what country does this flag belong to?", R.drawable.ic_flag_of_germany,
            "Germany", "Georgia", "Greece", "none of these", 1
        )
        // 7
        val que7 = Question(
            7, "what country does this flag belong to?", R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt", "Denmark", "Ethiopia", 3
        )
        // 8
        val que8 = Question(
            8, "what country does this flag belong to?", R.drawable.ic_flag_of_india,
            "Ireland", "Iran", "Hungary", "India", 4
        )
        // 9
        val que9 = Question(
            9, "what country does this flag belong to?", R.drawable.ic_flag_of_australia,
            "Australia", "new zealand", "tuvalu", "United States of America", 1
        )
        // 10
        val que10 = Question(
            10, "what country does this flag belong to?", R.drawable.ic_flag_of_kuwait,
            "kowait", "jordan", "sudan", "palestine", 1
        )


        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList
    }

}