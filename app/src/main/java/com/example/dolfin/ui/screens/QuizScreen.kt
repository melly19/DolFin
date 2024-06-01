package com.example.dolfin.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Scam Prevention Quiz",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        // Question
        val question = remember { mutableStateOf("What is phishing?") }

        // Options
        val options = remember {
            mutableStateOf(
                listOf(
                    "A) A type of fishing technique",
                    "B) A fraudulent attempt to obtain sensitive information",
                    "C) A way to catch small aquatic creatures"
                )
            )
        }

        // Correct answer
        //val correctAnswer = remember { mutableStateOf("B") }

        // Selected answer
        val selectedAnswer = remember { mutableStateOf<String?>(null) }

        // List of questions
        val questions = remember {
            mutableStateListOf(
                "What is phishing?",
                "What is identity theft?",
                "What is a pyramid scheme?",
                "What is a common tactic used in email scams?",
                "What is the best way to protect yourself from identity theft?",
                "What should you do if you receive a suspicious phone call asking for personal information?"
            )
        }

        // Questions and their corresponding options and correct answers
        val questionOptionsAndAnswers = listOf(
            QuestionWithOptions(
                question = "What is phishing?",
                options = listOf(
                    "A) A type of fishing technique",
                    "B) A fraudulent attempt to obtain sensitive information",
                    "C) A way to catch small aquatic creatures"
                ),
                correctAnswer = "B"
            ),
            QuestionWithOptions(
                question = "What is identity theft?",
                options = listOf(
                    "A) Stealing someone's identity",
                    "B) A type of theft involving cars",
                    "C) A cyber attack on a company"
                ),
                correctAnswer = "A"
            ),
            QuestionWithOptions(
                question = "What is a pyramid scheme?",
                options = listOf(
                    "A) A type of architectural structure",
                    "B) A fraudulent investment scheme",
                    "C) A marketing strategy"
                ),
                correctAnswer = "B"
            ),
            QuestionWithOptions(
                question = "What is a common tactic used in email scams?",
                options = listOf(
                    "A) Vishing",
                    "B) Phishing",
                    "C) Smishing",
                    "D) All of the above"
                ),
                correctAnswer = "B"
            ),
            QuestionWithOptions(
                question = "What is the best way to protect yourself from identity theft?",
                options = listOf(
                    "A) Sharing personal information freely",
                    "B) Ignoring suspicious emails and messages",
                    "C) Using strong, unique passwords for each account",
                    "D) None of the above"
                ),
                correctAnswer = "C"
            ),
            QuestionWithOptions(
                question = "What should you do if you receive a suspicious phone call asking for personal information?",
                options = listOf(
                    "A) Provide the information to avoid trouble",
                    "B) Hang up and call the organization directly using a verified phone number",
                    "C) Engage in conversation to gather more information",
                    "D) None of the above"
                ),
                correctAnswer = "B"
            )
        )

        // Current question index
        var currentQuestionIndex by remember { mutableStateOf(0) }

        val currentQuestion = questionOptionsAndAnswers[currentQuestionIndex].question
        val currentOptions = questionOptionsAndAnswers[currentQuestionIndex].options
        val correctAnswer = questionOptionsAndAnswers[currentQuestionIndex].correctAnswer

        // Buttons row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            // Show answer button
            Button(
                onClick = { selectedAnswer.value = correctAnswer },
                //modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Show Answer")
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Show next question button
            Button(
                onClick = {
                    // Reset selected answer
                    selectedAnswer.value = null
                    // Go to the next question
                    currentQuestionIndex = (currentQuestionIndex + 1) % questions.size
                },
                //modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Next Question")
            }
        }

        // Question
        Text(
           //text = question.value,
            //style = MaterialTheme.typography.subtitle1
            text = currentQuestion
        )

        // Options
        currentOptions.forEach { option ->
            Text(
                text = option,
                //style = MaterialTheme.typography.body1
            )
        }

        // Show correct answer if button clicked
        selectedAnswer.value?.let {
            Text(
                text = "Correct Answer: ${correctAnswer}",
                //style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

data class QuestionWithOptions(
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

