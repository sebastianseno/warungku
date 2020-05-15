package com.seno.bukawarungtest.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDb (
    @PrimaryKey
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val avatar: String
)