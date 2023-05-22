package br.com.igorbag.githubapp.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    val name: String,
    @SerializedName(value = "avatar_url")
    val avatarUrl: String
)
