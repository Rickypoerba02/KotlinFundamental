package com.example.adroidfundamental

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class user (
    val username : String,
    val password : String
):Parcelable

