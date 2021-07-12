package cn.dfordog.jokes.utils

import cn.dfordog.jokes.api.JokeApi
import cn.dfordog.jokes.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUtil {

    private fun createRetrofit(): Retrofit = retrofit
        private val logging = HttpLoggingInterceptor()
        private val client = OkHttpClient()
            .newBuilder()
            .addInterceptor(logging)
            .build()

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


    val jokeApi: JokeApi by lazy {
        createRetrofit().create(JokeApi::class.java)
    }

}