package br.com.zup.marvel.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    var name: String = "",
    var email: String = "",
    var password: String = "") : Parcelable {
}