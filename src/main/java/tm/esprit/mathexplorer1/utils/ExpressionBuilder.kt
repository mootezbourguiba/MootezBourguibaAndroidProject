package tm.esprit.mathexplorer1.utils

import java.util.regex.Pattern
import kotlin.math.pow

class ExpressionBuilder(private val function: String) {

    fun evaluate(x: Double): Double {
        var processedFunction = function.replace("x", "($x)")
        processedFunction = processPowerOperator(processedFunction)
        return try {
            evaluateExpression(processedFunction)
        } catch (e: Exception) {
            Double.NaN // Return Double.NaN if evaluation fails
        }
    }
    private fun processPowerOperator(expression:String) : String{
        val pattern = Pattern.compile("(\\d+(?:\\.\\d+)?)\\^(\\d+(?:\\.\\d+)?)")
        val matcher = pattern.matcher(expression)
        val sb = StringBuilder()
        var lastMatchEnd = 0
        while (matcher.find()) {
            val base = matcher.group(1).toDouble()
            val exponent = matcher.group(2).toDouble()
            sb.append(expression.substring(lastMatchEnd,matcher.start()))
            sb.append(base.pow(exponent))
            lastMatchEnd = matcher.end()
        }
        sb.append(expression.substring(lastMatchEnd))
        return sb.toString()

    }

    private fun evaluateExpression(expression: String): Double {
        // Vous devez compléter cette partie avec l'évaluation réelle de l'expression.
        // Une simple implémentation pour l'addition, soustraction, multiplication et division pour les nombres.

        var result = 0.0
        var currentNumber = ""
        var currentOperator = '+'

        for (char in expression) {
            when {
                char.isDigit() || char == '.' -> {
                    currentNumber += char
                }

                char == '+' || char == '-' || char == '*' || char == '/' -> {
                    result = applyOperator(result, currentNumber.toDoubleOrNull() ?: 0.0, currentOperator)
                    currentOperator = char
                    currentNumber = ""
                }
                else ->{ //On ignore les caractères non supportés.
                }

            }
        }
        result = applyOperator(result, currentNumber.toDoubleOrNull() ?: 0.0, currentOperator)

        return result
    }


    private fun applyOperator(result: Double, number: Double, operator: Char): Double {
        return when (operator) {
            '+' -> result + number
            '-' -> result - number
            '*' -> result * number
            '/' -> if (number != 0.0) result / number else Double.NaN
            else -> result
        }

    }
}