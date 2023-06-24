package com.akobir.messenger.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akobir.messenger.R
import com.akobir.messenger.model.Room
import com.google.android.material.imageview.ShapeableImageView

class RoomAdapter(var context: Context, var items: ArrayList<Room>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val HEADER_VIEW_TYPE = 0
    private val ROOM_VIEW_TYPE = 1

    override fun getItemCount(): Int {
        return items.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            HEADER_VIEW_TYPE
        } else {
            ROOM_VIEW_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == HEADER_VIEW_TYPE) {
            val headerView = LayoutInflater.from(context).inflate(R.layout.header_layout, parent, false)
            HeaderViewHolder(headerView)
        } else {
            val roomView = LayoutInflater.from(context).inflate(R.layout.item_room_view, parent, false)
            RoomViewHolder(roomView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HeaderViewHolder) {
            // bind header view data here
        } else if (holder is RoomViewHolder) {
            val room = items[position - 1]
            holder.bind(room)
        }
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // declare header view widgets here
    }

    inner class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = itemView.findViewById(R.id.iv_profile)
            tv_fullname = itemView.findViewById(R.id.tv_fullname)
        }

        fun bind(room: Room) {
            iv_profile.setImageResource(room.profile)
            tv_fullname.text = room.fullname
        }
    }
}