package tm.esprit.mathexplorer1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tm.esprit.mathexplorer1.R
import tm.esprit.mathexplorer1.model.ChatMessage

class ChatMessageAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatMessageAdapter.MessageViewHolder>() {

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.messageTextView)
            ?: throw IllegalArgumentException("View with ID messageTextView not found in layout")
        val messageSender : TextView = itemView.findViewById(R.id.senderTextView)
            ?: throw IllegalArgumentException("View with ID senderTextView not found in layout")

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun getItemCount() = messages.size


    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messages[position]
        holder.messageText.text = currentMessage.message

        // affiche le bon sender en fonction du type de message
        if (currentMessage.isUser)
        {
            holder.messageSender.text = "Moi"
        } else
        {
            holder.messageSender.text = "Chatbot"
        }
    }
}