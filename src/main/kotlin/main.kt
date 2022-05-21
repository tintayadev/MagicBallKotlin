//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)


fun main(args: Array<String>){
    println("Hey, I'm your magic ball created using Kotlin. Which of these options would you like to do?")
    println("1. Make a question")
    println("2. Check all the answers")
    println("3. Exit")

    val inputValue = readLine()

    when(inputValue){
        "1" -> makeQuestion()
        "2" -> showAnswers()
        "3" -> exitProgram()
        else -> showError()

    }
}

fun exitProgram() {
    println("See you ;D")
}

fun showError() {
    println("Vaya... parece que has elegido una opcion no valida")
}

fun showAnswers() {
    println("Select an option: ")
    println("1. Check all the answers")
    println("2. Check just affirmative answers")
    println("3. Check just doubtful asnwers")
    println("4. Check just negative asnwers")
    val inputOption = readLine()
    when(inputOption){
        "1" -> showAnswersByType()
        "2" -> showAnswersByType(answerType = AFFIRMATIVE_ANSWER)
        "3" -> showAnswersByType(answerType = NEGATIVE_ANSWER)
        "4" -> showAnswersByType(answerType = DOUBTFUL_ANSWER)
        else -> println("No valid answer, bye.")
    }
}
fun showAnswersByType(answerType: String = "TODOS"){
    val printAnswers: (Map<String, String>) -> Unit = {
        it.keys.forEach { answer -> println(answer) }
    }
    when(answerType){
        "TODOS" -> answers.keys.forEach{ answer -> println(answer)}

        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }.also {printAnswers(it)}
        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }.also {printAnswers(it)}
        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }.also {printAnswers(it)}
    }
}

fun makeQuestion(){
    println("Waht question would you like to ask?")
    readLine()
    println("So, that's your question... The answer for that is: ")
    val generatedAnswer = answers.keys.random()
    println(generatedAnswer)

}
