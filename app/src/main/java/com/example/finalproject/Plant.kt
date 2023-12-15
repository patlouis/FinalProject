package com.example.finalproject

import android.os.Parcel
import android.os.Parcelable

data class Plant(val image:Int, val name:String, val description:String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plant> {
        override fun createFromParcel(parcel: Parcel): Plant {
            return Plant(parcel)
        }

        override fun newArray(size: Int): Array<Plant?> {
            return arrayOfNulls(size)
        }
    }
}