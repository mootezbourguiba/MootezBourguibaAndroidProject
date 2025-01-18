package tm.esprit.mathexplorer1.controller

import tm.esprit.mathexplorer1.model.Function

class FunctionController {

    fun analyzeFunction(function: Function): String {
        // Logique d'analyse de la fonction
        return "Analysis results for ${function.expression}"
    }
}
