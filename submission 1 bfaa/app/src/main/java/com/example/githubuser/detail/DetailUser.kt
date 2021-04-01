package com.example.githubuser.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.githubuser.R
import com.example.githubuser.data.User
import com.squareup.picasso.Picasso

class DetailUser : AppCompatActivity() {
    companion object {
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvUsername: TextView = findViewById(R.id.username)
        val imgPhoto : ImageView = findViewById(R.id.img_photo)
        val tvName: TextView = findViewById(R.id.name)
        val tvLocation: TextView = findViewById(R.id.location)
        val tvCompany: TextView = findViewById(R.id.company)

        val dataUser = intent.getParcelableExtra<User>(EXTRA_DETAIL)
        tvUsername.text = dataUser?.username
        tvName.text = dataUser?.name
        Picasso.get()
            .load(dataUser?.Avatar!!)
            .into(imgPhoto)
        tvCompany.text = dataUser?.company
        tvLocation.text = dataUser?.location
    }

}