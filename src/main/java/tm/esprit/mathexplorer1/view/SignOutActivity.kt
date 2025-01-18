package tm.esprit.mathexplorer1.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import tm.esprit.mathexplorer1.R

class SignOutActivity : AppCompatActivity() {

    private lateinit var etUsername: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etRetypePassword: TextInputEditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_out)

        // Initialisation des vues
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etRetypePassword = findViewById(R.id.etRetypePassword)
        btnLogin = findViewById(R.id.btnLogin)


        // Définition du listener pour le bouton "Sign up"
        btnLogin.setOnClickListener {
            signUp() // Appel de la fonction signUp
        }
    }
    private fun signUp() {
        // Récupération des valeurs des champs
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val retypePassword = etRetypePassword.text.toString().trim()

        // Vérification si les champs sont vides
        if(username.isEmpty() || password.isEmpty() || retypePassword.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
            return
        }

        //Vérification si les passwords sont identiques
        if (password != retypePassword) {
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show()
            return
        }
        // Si tout va bien, on lance l'activité AuthActivity
        launchAuthActivity()
    }

    private fun launchAuthActivity() {
        // création d'un intent pour lancer la AuthActivity
        val intent = Intent(this, AuthActivity::class.java)

        startActivity(intent)// lancement de l'activité
        finish() // optionnel : on ferme la signout activity pour que la backbutton ne retourne pas sur cette activity

    }
}