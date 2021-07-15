package cn.dfordog.jokes.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cn.dfordog.jokes.data.entity.DBSavePage

@Database(entities = [DBSavePage::class],version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun savePageDap() : SavePageDao

    companion object{
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDB(context).also { instance = it }
        }

        private fun createDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "new_joke"
            ).build()
    }

}