package com.na_ram.aos_recyclerview_example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.na_ram.aos_recyclerview_example.R
import com.na_ram.aos_recyclerview_example.model.User

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var datas = mutableListOf<User>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvUserAge: TextView = itemView.findViewById(R.id.tvUserAge)

        fun bind(item: User) {
            tvUserName.text = item.userName
            tvUserAge.text = item.userAge.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount() = datas.size

}