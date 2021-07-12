package cn.dfordog.jokes.data.repository

import cn.dfordog.jokes.data.db.AppDatabase
import cn.dfordog.jokes.data.entity.Data
import cn.dfordog.jokes.utils.RetrofitUtil

class NewJokeRepository(private val db: AppDatabase) {

    suspend fun upsert(joke: Data) = db.jokeDao().upsert(joke)
    suspend fun delete(joke: Data) = db.jokeDao().delete(joke)

    fun queryJokes() = db.jokeDao().queryAllJokes()

    /**
     * 从接口获取笑话数据
     */
    suspend fun getNewJokeFromNet(page: Int,pagesize: Int,key: String) =
        RetrofitUtil.jokeApi.getNewJoke(page, pagesize,key)

}