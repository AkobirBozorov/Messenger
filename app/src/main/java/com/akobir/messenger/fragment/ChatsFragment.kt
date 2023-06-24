package com.akobir.messenger.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akobir.messenger.R
import com.akobir.messenger.adapter.ChatAdapter
import com.akobir.messenger.model.Chat
import com.akobir.messenger.model.Message
import com.akobir.messenger.model.Room

class ChatsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>){
        val adapter = context?.let { ChatAdapter(it, chats) }
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