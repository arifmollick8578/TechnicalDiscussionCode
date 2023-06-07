package com.mollick.interviewproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mollick.interviewproject.data.User

class UserListAdapter internal constructor(context: Context): RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_userdetail, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = users[position]
        holder.firstName.text = current.firstName
        holder.lastName.text = current.lastName
        holder.emailId.text = current.emailId
        holder.phoneNo.text = current.phoneNumber.toString()
    }

    internal fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName = itemView.findViewById<TextView>(R.id.first_name)
        val lastName = itemView.findViewById<TextView>(R.id.last_name)
        val emailId = itemView.findViewById<TextView>(R.id.email)
        val phoneNo = itemView.findViewById<TextView>(R.id.phone_no)
    }


    override fun getItemCount() = users.size

}
