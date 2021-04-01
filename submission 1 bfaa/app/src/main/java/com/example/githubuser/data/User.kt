package com.example.githubuser.data


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var Avatar: Int,
    var username: String,
    var name: String,
    var location: String,
    var repository: String,
    var company: String,
    var follower: String,
    var following: String
): Parcelable