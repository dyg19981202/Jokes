package cn.dfordog.jokes.data.entity

data class Data(
    val id: Int? = null,
    val content: String,
    val hashId: String,
    val unixtime: Int,
    val updatetime: String
)