package com.example.githubuser

import android.os.Parcel
import android.os.Parcelable

data class User(
    val name: String?,
    val username: String?,
    val photo: Int?,
    val location: String?,
    val company: String?,
    val repository: String?,
    val follower: String?,
    val following: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(username)
        parcel.writeInt(photo!!)
        parcel.writeString(location)
        parcel.writeString(company)
        parcel.writeString(repository)
        parcel.writeString(follower)
        parcel.writeString(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}