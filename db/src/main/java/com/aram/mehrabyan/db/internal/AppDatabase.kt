package com.aram.mehrabyan.db.internal

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aram.mehrabyan.db.api.UserItemEntity

@Database(entities = [UserItemEntity::class], version = 1)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userItemDao(): UserItemDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private const val APP_DATABASE_NAME = "app_database"

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = APP_DATABASE_NAME
                ).build().also { INSTANCE = it }
            }
        }
    }
}