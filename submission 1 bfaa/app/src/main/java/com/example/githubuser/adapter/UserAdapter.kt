package com.example.githubuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.githubuser.R
import com.example.githubuser.data.User
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero= getItem(position) as User
        viewHolder.bind(hero)
        return itemView
    }

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = users.size

    private inner class ViewHolder internal constructor(view: View) {
        private val txtUsername: TextView = view.findViewById(R.id.txt_username)
        private val txtCompany: TextView = view.findViewById(R.id.txt_company)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: User) {
            txtUsername.text = hero.name
            txtCompany.text = hero.company
            imgPhoto.setImageResource(hero.Avatar)
        }
    }

}