package tm.esprit.mathexplorer1.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import tm.esprit.mathexplorer1.R

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        // récupération du bouton explorer les fonctions
        val cardViewExploreFunctions = findViewById<CardView>(R.id.exploreFunctions)
        // définition du listener sur cette cardview
        cardViewExploreFunctions.setOnClickListener {
            val intent = Intent(this, FunctionAnalyzerActivity::class.java)
            startActivity(intent)
        }
        // récupération de la cardview chatbot
        val cardViewChatbot = findViewById<CardView>(R.id.educationalChatbot)
        // définition du listener sur cette cardview
        cardViewChatbot.setOnClickListener {
            //lancer ChatbotActivity
            val intent = Intent(this, ChatbotActivity::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.signOut).setOnClickListener { startActivity(Intent(this, SignOutActivity::class.java)) }
    }
}