package com.neeleshio.jsgptandroidapp.activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neeleshio.jsgptandroidapp.R
import com.neeleshio.jsgptandroidapp.adapters.MessageAdapter
import com.neeleshio.jsgptandroidapp.adapters.MessageArray


class MainActivity : AppCompatActivity() {
    private lateinit var menuBtn : ImageView
    private lateinit var githubBtn : ImageView
    private lateinit var sendBtn : ImageView
    lateinit var questionInputField : EditText
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuBtn = findViewById(R.id.menu_btn)
        githubBtn = findViewById(R.id.github_btn)
        sendBtn = findViewById(R.id.send_btn)
        questionInputField = findViewById(R.id.question_input)
        recyclerView = findViewById(R.id.recycler_view)

        menuBtn.setOnClickListener {
            showPopupMenu(menuBtn)
        }

        val items = mutableListOf<MessageArray>()

        sendBtn.setOnClickListener {
            val newItem = MessageArray(questionInputField.text.toString(), questionInputField.text.toString())
            items.add(newItem)

            recyclerView.adapter = MessageAdapter(items)
            recyclerView.layoutManager = LinearLayoutManager(this)

        }

        githubBtn.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/neeleshio/JsGPT"))
            startActivity(browserIntent)
        }
    }

    private fun showPopupMenu(view: View) {
        val popup = PopupMenu(this, view)

        popup.inflate(R.menu.main_menu)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popup.setForceShowIcon(true)
        }

        popup.show()
    }
}