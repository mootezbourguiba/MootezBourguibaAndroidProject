package tm.esprit.mathexplorer1.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tm.esprit.mathexplorer1.R
import tm.esprit.mathexplorer1.adapters.ChatMessageAdapter
import tm.esprit.mathexplorer1.model.ChatMessage

class ChatbotActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var chatAdapter: ChatMessageAdapter
    private val chatMessages = mutableListOf<ChatMessage>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        // Initialisation des vues
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageEditText = findViewById(R.id.etMessage)
        sendButton = findViewById(R.id.btnSend)

        // Initialisation du RecyclerView
        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatAdapter = ChatMessageAdapter(chatMessages)
        chatRecyclerView.adapter = chatAdapter

        //Définition du listener sur le bouton d'envoie
        sendButton.setOnClickListener {
            sendMessage()
        }

    }
    private fun sendMessage() {
        val message = messageEditText.text.toString().trim()
        if (message.isNotEmpty()) {
            // On ajoute le message de l'utilisateur
            addMessageToConversation(message, true)

            // Traitement du message et génération de la réponse du chatbot
            val response = processMessage(message)

            // On ajoute la réponse du chatbot à la conversation
            addMessageToConversation(response, false)

            // On vide le textfield
            messageEditText.text.clear()
        }

    }
    private fun addMessageToConversation(message: String, isUser: Boolean) {
        val chatMessage = ChatMessage(message, isUser)
        chatMessages.add(chatMessage)
        chatAdapter.notifyItemInserted(chatMessages.size - 1)
        chatRecyclerView.scrollToPosition(chatMessages.size - 1)// On scroll pour suivre la conversation
    }
    private fun processMessage(message: String): String {
        // Ici on va implémenter la logique de réponse du chatbot
        // Pour l'instant, on fait une réponse simple et générique
        return "Le chatbot a reçu votre message : $message"
    }
}