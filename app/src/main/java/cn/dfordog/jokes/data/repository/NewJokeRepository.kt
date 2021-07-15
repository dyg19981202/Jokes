package cn.dfordog.jokes.data.repository

import cn.dfordog.jokes.data.db.AppDatabase
import cn.dfordog.jokes.data.entity.DBSavePage
import cn.dfordog.jokes.data.entity.Data
import cn.dfordog.jokes.utils.RetrofitUtil

class NewJokeRepository(private val db: AppDatabase) {

    /**
     * 将页数存入数据库
     */
    suspend fun savePage(dbSavePage: DBSavePage) = db.savePageDap().upsert(dbSavePage)

    /**
     * 将页数从数据库取出
     */
    fun queryPage() = db.savePageDap().queryPage()

    /**
     * 从接口获取笑话数据
     */
    suspend fun getNewJokeFromNet(page: Int,pagesize: Int,key: String) =
        RetrofitUtil.jokeApi.getNewJoke(page, pagesize,key)

}