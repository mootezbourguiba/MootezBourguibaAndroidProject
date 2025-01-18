package tm.esprit.mathexplorer1.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tm.esprit.mathexplorer1.R

class AuthActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var tilUsername: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var btnLogin: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Initialisation des vues
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        tilUsername = findViewById(R.id.tilUsername)
        tilPassword = findViewById(R.id.tilPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // Définition du listener sur le bouton "Connexion"
        btnLogin.setOnClickListener {
            login() // Appel de la fonction login
        }
    }

    private fun login() {
        // Récupération des valeurs des champs
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // Validation des champs et affichage des erreurs
        if (username.isEmpty()) {
            tilUsername.error = "Veuillez entrer un nom d'utilisateur"
            return
        } else {
            tilUsername.error = null // Suppression de l'erreur si le champ est correct
        }
        if (password.isEmpty()) {
            tilPassword.error = "Veuillez entrer un mot de passe"
            return
        } else {
            tilPassword.error = null // Suppression de l'erreur si le champ est correct
        }

        // Ici on lance l'activity suivante après la validation des champs
        launchMainMenuActivity()
    }

    private fun launchMainMenuActivity() {
        startActivity(Intent(this, MainMenuActivity::class.java))
        finish() // Fermer l'activité d'authentification
    }
}