package cn.dfordog.jokes.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import cn.dfordog.jokes.data.entity.DBSavePage

@Dao
interface SavePageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(dbSavePage: DBSavePage)

    @Query("SELECT * FROM save_page")
    fun queryPage(): LiveData<DBSavePage>

}