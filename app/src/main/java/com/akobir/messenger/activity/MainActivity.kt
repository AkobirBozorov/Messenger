package com.akobir.messenger.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akobir.messenger.R
import com.akobir.messenger.adapter.ChatAdapter
import com.akobir.messenger.model.Chat
import com.akobir.messenger.model.Message
import com.akobir.messenger.model.Room

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>){
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat>{
        val chats: ArrayList<Chat> = ArrayList()
        val rooms: ArrayList<Room> = ArrayList()
        rooms.add(Room(R.drawable.im_user_1, "Madison Bear"))
        rooms.add(Room(R.drawable.im_user_2, "Paige Cooper"))
        rooms.add(Room(R.drawable.im_user_3, "Gwen Stacy"))
        rooms.add(Room(R.drawable.im_user_1, "Madison Bear"))
        rooms.add(Room(R.drawable.im_user_2, "Paige Cooper"))
        rooms.add(Room(R.drawable.im_user_3, "Gwen Stacy"))
        rooms.add(Room(R.drawable.im_user_1, "Madison Bear"))
        rooms.add(Room(R.drawable.im_user_2, "Paige Cooper"))
        rooms.add(Room(R.drawable.im_user_3, "Gwen Stacy"))
        chats.add(Chat(rooms))
        chats.add(Chat(Message(R.drawable.im_user_1, "Madison", true)))
        chats.add(Chat(Message(R.drawable.im_user_2, "Paige", true)))
        chats.add(Chat(Message(R.drawable.im_user_3, "Gwen", false)))
        chats.add(Chat(Message(R.drawable.im_user_1, "Madison", true)))
        chats.add(Chat(Message(R.drawable.im_user_2, "Paige", false)))
        chats.add(Chat(Message(R.drawable.im_user_3, "Gwen", false)))
        chats.add(Chat(Message(R.drawable.im_user_1, "Madison", true)))
        chats.add(Chat(Message(R.drawable.im_user_2, "Paige", false)))
        chats.add(Chat(Message(R.drawable.im_user_3, "Gwen", false)))
        return chats
    }
}