package cn.dfordog.jokes.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import cn.dfordog.jokes.data.entity.Data

@Dao
interface JokeDao {

    @Insert
    suspend fun upsert(joke: Data)

    @Delete
    suspend fun delete(joke: Data)

    @Query("SELECT * FROM new_jokes")
    fun queryAllJokes(): LiveData<List<Data>>

}