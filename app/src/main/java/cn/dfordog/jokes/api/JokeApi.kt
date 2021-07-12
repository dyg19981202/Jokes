package cn.dfordog.jokes.api

import cn.dfordog.jokes.data.entity.NewJokes
import cn.dfordog.jokes.utils.Constants.Companion.JOKE_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeApi {

    @GET("joke/content/text.php")
    suspend fun getNewJoke(
        @Query("page") page: Int = 1,
        @Query("pagesize") pagesize: Int = 20,
        @Query("key") key: String = JOKE_KEY
    ): Response<NewJokes>
}