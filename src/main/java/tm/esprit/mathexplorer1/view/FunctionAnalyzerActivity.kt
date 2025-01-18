package tm.esprit.mathexplorer1.view

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import tm.esprit.mathexplorer1.R
import tm.esprit.mathexplorer1.utils.ExpressionBuilder
import kotlin.math.log
import kotlin.math.sqrt

class FunctionAnalyzerActivity : AppCompatActivity() {

    private lateinit var etFunctionInput: EditText
    private lateinit var btnAnalyze: Button
    private lateinit var tvResult: TextView
    private lateinit var cbDomain: CheckBox
    private lateinit var cbParity: CheckBox
    private lateinit var cbContinuity: CheckBox
    private lateinit var cbDerivability: CheckBox
    private lateinit var cbLimits: CheckBox
    private lateinit var cbAsymptotes: CheckBox
    private lateinit var cbVariation: CheckBox
    private lateinit var cbPoints: CheckBox
    private lateinit var layoutGraph: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function_analyzer)

        // Initialisation des vues
        etFunctionInput = findViewById(R.id.etFunctionInput)
        btnAnalyze = findViewById(R.id.btnAnalyze)
        tvResult = findViewById(R.id.tvResult)
        cbDomain = findViewById(R.id.cbDomain)
        cbParity = findViewById(R.id.cbParity)
        cbContinuity = findViewById(R.id.cbContinuity)
        cbDerivability = findViewById(R.id.cbDerivability)
        cbLimits = findViewById(R.id.cbLimits)
        cbAsymptotes = findViewById(R.id.cbAsymptotes)
        cbVariation = findViewById(R.id.cbVariation)
        cbPoints = findViewById(R.id.cbPoints)
        layoutGraph = findViewById(R.id.layoutGraph)

        btnAnalyze.setOnClickListener {
            analyzeFunction()
        }
    }
    private fun analyzeFunction() {

        val function = etFunctionInput.text.toString().trim()
        if (function.isEmpty()) {
            tvResult.text = "Veuillez entrer une fonction"
            return
        }
        var resultText = "Fonction: $function \n"
        if (cbDomain.isChecked) {
            val domainResult =  determineDomain(function)
            resultText += "Ensemble de définition : $domainResult \n"
        }
        if (cbParity.isChecked){
            val parityResult = determineParity(function)
            resultText += "Parité : $parityResult \n"
        }
        if (cbContinuity.isChecked) {
            val continuityResult =  determineContinuity(function)
            resultText += "Continuité: $continuityResult\n"
        }
        if(cbDerivability.isChecked){
            val derivabilityResult = determineDerivability(function)
            resultText += "Dérivabilité: $derivabilityResult \n"
        }
        if(cbLimits.isChecked){
            resultText += "Limite: à étudier\n"
        }
        if(cbAsymptotes.isChecked){
            resultText += "Asymptotes : à étudier \n"
        }
        if(cbVariation.isChecked){
            resultText += "Tableau de Variation : à étudier\n"
        }
        if(cbPoints.isChecked){
            resultText += "Points particuliers : à étudier \n"
        }

        tvResult.text = resultText

        layoutGraph.removeAllViews()
        for (x in 0..10){
            val y = calculateFunctionValue(x.toDouble(), function)
            val newTextView = TextView(this)
            newTextView.text = "*"
            newTextView.x = (10*x).toFloat()
            newTextView.y = (10 * y).toFloat()

            layoutGraph.addView(newTextView)
        }

    }

    private fun calculateFunctionValue(x: Double, function: String): Double {
        try {
            val expression = tm.esprit.mathexplorer1.utils.ExpressionBuilder(function)
                .evaluate(x)

            return expression
        } catch (e: Exception) {
            // Afficher l'erreur dans la console ou dans un TextView
            println("Error parsing function: ${e.message}") // Pour le débogage
            return Double.NaN // Retourner Double.NaN si la fonction ne peut pas être évaluée.
        }
    }
    private fun determineDomain(function: String): String {
        var domain = "ℝ"
        val trimmedFunction = function.trim()

        // Gestion de la division par zéro :
        if (trimmedFunction.contains("/0")) {
            return "ℝ\\{0}"
        }

        // Gestion des puissances qui sont des racines carrées: (exemple: x^(1/2))
        val powerPattern = Regex("""x\^\(([^)]*)\)""")
        val powerMatch = powerPattern.find(trimmedFunction)
        if(powerMatch != null){
            val exponent = powerMatch.groupValues[1]
            if(exponent.startsWith("1/")){
                try {
                    val expression =  tm.esprit.mathexplorer1.utils.ExpressionBuilder(exponent)
                    val result = expression.evaluate(0.0)
                    if (result < 0){
                        return "[0, +∞["
                    }
                }catch (e:Exception){
                    return "[0, +∞["
                }
            }


        }

        // Gestion des racines carrées : (ici seulement sqrt)
        val sqrtPattern = Regex("""sqrt\(([^)]*)\)""")
        val sqrtMatch = sqrtPattern.find(trimmedFunction)
        if(sqrtMatch != null){
            try {
                val expression =  tm.esprit.mathexplorer1.utils.ExpressionBuilder(sqrtMatch.groupValues[1])
                expression.evaluate(-1.0)

            }catch(e:Exception){
                return "[0, +∞["
            }

        }

        // Gestion des logarithmes (ici seulement log) :
        val logPattern = Regex("""log\(([^)]*)\)""")
        val logMatch = logPattern.find(trimmedFunction)
        if(logMatch != null){
            val content = logMatch.groupValues[1]
            try{
                val expression =  tm.esprit.mathexplorer1.utils.ExpressionBuilder(content)
                expression.evaluate(-1.0)

            }catch(e:Exception){
                return  "]0, +∞["
            }

        }
        return domain
    }
    private fun determineParity(function: String): String {
        try {
            val expression =  tm.esprit.mathexplorer1.utils.ExpressionBuilder(function)
            val fX = expression.evaluate(1.0)
            val fNegativeX = expression.evaluate(-1.0)

            if(fX == fNegativeX) return "Paire"
            if(fX == -fNegativeX) return "Impaire"
            return "Ni paire, ni impaire"


        }
        catch (e: Exception) {
            return "Non analysable"
        }
    }
    private fun determineContinuity(function: String): String {
        if (function.contains("/0") || function.contains("sqrt(")){
            return "Non continue"
        }
        return "Continue"
    }
    private fun determineDerivability(function: String): String {
        // Vous devez implémenter la logique de dérivation.
        if (function.contains("abs(")){
            return "Non dérivable en 0"
        }
        return "Dérivable"
    }
}