package com.example.githubuser.home

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.example.githubuser.detail.DetailUser
import com.example.githubuser.R
import com.example.githubuser.adapter.UserAdapter
import com.example.githubuser.data.User

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository:Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataAvatar: TypedArray
    private lateinit var listView: ListView
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)

        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val detail = Intent(this@MainActivity, DetailUser::class.java)
            detail.putExtra(DetailUser.EXTRA_DETAIL, users[position])
            startActivity(detail)
        }

    }
    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataCompany = resources.getStringArray(R.array.company)
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataFollower = resources.getStringArray(R.array.followers)
        dataRepository = resources.getStringArray(R.array.repository)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataUsername.indices) {
            val user = User(
                dataAvatar.getResourceId(position, 0),
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollower[position],
                dataFollowing[position]
            )
            users.add(user)
        }
        adapter.users = users
    }
}