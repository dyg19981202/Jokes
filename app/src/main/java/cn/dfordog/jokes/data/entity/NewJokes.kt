package cn.dfordog.jokes.data.entity

data class NewJokes(
    val error_code: Int,
    val reason: String,
    val result: Result
)