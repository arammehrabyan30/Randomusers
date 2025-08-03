package com.aram.mehrabyan.db.`internal`

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.aram.mehrabyan.db.api.UserItemEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
internal class UserItemDao_Impl(
  __db: RoomDatabase,
) : UserItemDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfUserItemEntity: EntityInsertAdapter<UserItemEntity>

  private val __deleteAdapterOfUserItemEntity: EntityDeleteOrUpdateAdapter<UserItemEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfUserItemEntity = object : EntityInsertAdapter<UserItemEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `user_item` (`id`,`age`,`name`,`email`,`phone`,`birthDate`,`country`,`state`,`city`,`street`,`thumbnail`,`imageUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: UserItemEntity) {
        statement.bindText(1, entity.id)
        statement.bindLong(2, entity.age.toLong())
        statement.bindText(3, entity.name)
        statement.bindText(4, entity.email)
        statement.bindText(5, entity.phone)
        statement.bindText(6, entity.birthDate)
        statement.bindText(7, entity.country)
        statement.bindText(8, entity.state)
        statement.bindText(9, entity.city)
        statement.bindText(10, entity.street)
        val _tmpThumbnail: String? = entity.thumbnail
        if (_tmpThumbnail == null) {
          statement.bindNull(11)
        } else {
          statement.bindText(11, _tmpThumbnail)
        }
        val _tmpImageUrl: String? = entity.imageUrl
        if (_tmpImageUrl == null) {
          statement.bindNull(12)
        } else {
          statement.bindText(12, _tmpImageUrl)
        }
      }
    }
    this.__deleteAdapterOfUserItemEntity = object : EntityDeleteOrUpdateAdapter<UserItemEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `user_item` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: UserItemEntity) {
        statement.bindText(1, entity.id)
      }
    }
  }

  public override suspend fun insert(item: UserItemEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __insertAdapterOfUserItemEntity.insert(_connection, item)
  }

  public override suspend fun delete(item: UserItemEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __deleteAdapterOfUserItemEntity.handle(_connection, item)
  }

  public override fun getAll(): Flow<List<UserItemEntity>> {
    val _sql: String = "SELECT * FROM user_item"
    return createFlow(__db, false, arrayOf("user_item")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfAge: Int = getColumnIndexOrThrow(_stmt, "age")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfPhone: Int = getColumnIndexOrThrow(_stmt, "phone")
        val _columnIndexOfBirthDate: Int = getColumnIndexOrThrow(_stmt, "birthDate")
        val _columnIndexOfCountry: Int = getColumnIndexOrThrow(_stmt, "country")
        val _columnIndexOfState: Int = getColumnIndexOrThrow(_stmt, "state")
        val _columnIndexOfCity: Int = getColumnIndexOrThrow(_stmt, "city")
        val _columnIndexOfStreet: Int = getColumnIndexOrThrow(_stmt, "street")
        val _columnIndexOfThumbnail: Int = getColumnIndexOrThrow(_stmt, "thumbnail")
        val _columnIndexOfImageUrl: Int = getColumnIndexOrThrow(_stmt, "imageUrl")
        val _result: MutableList<UserItemEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: UserItemEntity
          val _tmpId: String
          _tmpId = _stmt.getText(_columnIndexOfId)
          val _tmpAge: Int
          _tmpAge = _stmt.getLong(_columnIndexOfAge).toInt()
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpPhone: String
          _tmpPhone = _stmt.getText(_columnIndexOfPhone)
          val _tmpBirthDate: String
          _tmpBirthDate = _stmt.getText(_columnIndexOfBirthDate)
          val _tmpCountry: String
          _tmpCountry = _stmt.getText(_columnIndexOfCountry)
          val _tmpState: String
          _tmpState = _stmt.getText(_columnIndexOfState)
          val _tmpCity: String
          _tmpCity = _stmt.getText(_columnIndexOfCity)
          val _tmpStreet: String
          _tmpStreet = _stmt.getText(_columnIndexOfStreet)
          val _tmpThumbnail: String?
          if (_stmt.isNull(_columnIndexOfThumbnail)) {
            _tmpThumbnail = null
          } else {
            _tmpThumbnail = _stmt.getText(_columnIndexOfThumbnail)
          }
          val _tmpImageUrl: String?
          if (_stmt.isNull(_columnIndexOfImageUrl)) {
            _tmpImageUrl = null
          } else {
            _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl)
          }
          _item =
              UserItemEntity(_tmpId,_tmpAge,_tmpName,_tmpEmail,_tmpPhone,_tmpBirthDate,_tmpCountry,_tmpState,_tmpCity,_tmpStreet,_tmpThumbnail,_tmpImageUrl)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
