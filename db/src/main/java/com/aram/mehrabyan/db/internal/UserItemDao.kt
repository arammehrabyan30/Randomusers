package com.aram.mehrabyan.db.internal

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aram.mehrabyan.db.api.UserItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: UserItemEntity)

    @Delete
    suspend fun delete(item: UserItemEntity)

    @Query("SELECT * FROM user_item")
    fun getAll(): Flow<List<UserItemEntity>>
}
