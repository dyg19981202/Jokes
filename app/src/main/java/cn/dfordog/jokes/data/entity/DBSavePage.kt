package cn.dfordog.jokes.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "save_page")
data class DBSavePage(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    var page: Int
)