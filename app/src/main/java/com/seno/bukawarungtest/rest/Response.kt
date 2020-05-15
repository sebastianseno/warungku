package com.seno.bukawarungtest.rest
import com.google.gson.annotations.SerializedName


data class UserData(
    @SerializedName("ad")
    val ad: Ad?,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)

data class Ad(
    @SerializedName("company")
    val company: String?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("url")
    val url: String?
)

data class Data(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String
)