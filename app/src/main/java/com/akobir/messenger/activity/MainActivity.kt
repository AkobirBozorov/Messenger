package com.akobir.messenger.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akobir.messenger.R
import com.akobir.messenger.adapter.ChatAdapter
import com.akobir.messenger.fragment.CallsFragment
import com.akobir.messenger.fragment.ChatsFragment
import com.akobir.messenger.fragment.PeopleFragment
import com.akobir.messenger.fragment.StoriesFragment
import com.akobir.messenger.model.Chat
import com.akobir.messenger.model.Message
import com.akobir.messenger.model.Room
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNavigationView.selectedItemId = R.id.menu_chats
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_chats -> {
                    replaceFragment(ChatsFragment())
                    true
                }
                R.id.menu_calls -> {
                    replaceFragment(CallsFragment())
                    true
                }
                R.id.menu_people -> {
                    replaceFragment(PeopleFragment())
                    true
                }
                R.id.menu_stories -> {
                    replaceFragment(StoriesFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(ChatsFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}