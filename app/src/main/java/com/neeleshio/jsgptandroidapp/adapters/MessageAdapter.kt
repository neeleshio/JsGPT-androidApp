package com.neeleshio.jsgptandroidapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neeleshio.jsgptandroidapp.R

class MessageAdapter(private val messageList: MutableList<MessageArray>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderBubble: TextView = itemView.findViewById(R.id.sender_bubble)
        val catcherBubble: TextView = itemView.findViewById(R.id.catcher_bubble)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_layout, parent, false)

        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.senderBubble.text = currentItem.m1
        holder.catcherBubble.text = currentItem.m2
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}