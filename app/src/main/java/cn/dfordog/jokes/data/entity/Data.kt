package cn.dfordog.jokes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_jokes")
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val content: String,
    val hashId: String,
    val unixtime: Int,
    val updatetime: String
)