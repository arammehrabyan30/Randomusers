package com.aram.mehrabyan.db.`internal`

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
internal class AppDatabase_Impl : AppDatabase() {
  private val _userItemDao: Lazy<UserItemDao> = lazy {
    UserItemDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1,
        "79a59265cc18b638c7d409f686d47a9c", "64b8ac48b1b1ef8a498b0c7b4de72a2f") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `user_item` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `birthDate` TEXT NOT NULL, `country` TEXT NOT NULL, `state` TEXT NOT NULL, `city` TEXT NOT NULL, `street` TEXT NOT NULL, `thumbnail` TEXT, `imageUrl` TEXT, PRIMARY KEY(`id`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '79a59265cc18b638c7d409f686d47a9c')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `user_item`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsUserItem: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsUserItem.put("id", TableInfo.Column("id", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("age", TableInfo.Column("age", "INTEGER", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("email", TableInfo.Column("email", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("phone", TableInfo.Column("phone", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("birthDate", TableInfo.Column("birthDate", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("country", TableInfo.Column("country", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("state", TableInfo.Column("state", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("city", TableInfo.Column("city", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("street", TableInfo.Column("street", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("thumbnail", TableInfo.Column("thumbnail", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsUserItem.put("imageUrl", TableInfo.Column("imageUrl", "TEXT", false, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysUserItem: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesUserItem: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoUserItem: TableInfo = TableInfo("user_item", _columnsUserItem,
            _foreignKeysUserItem, _indicesUserItem)
        val _existingUserItem: TableInfo = read(connection, "user_item")
        if (!_infoUserItem.equals(_existingUserItem)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |user_item(com.aram.mehrabyan.db.api.UserItemEntity).
              | Expected:
              |""".trimMargin() + _infoUserItem + """
              |
              | Found:
              |""".trimMargin() + _existingUserItem)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_item")
  }

  public override fun clearAllTables() {
    super.performClear(false, "user_item")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(UserItemDao::class, UserItemDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun userItemDao(): UserItemDao = _userItemDao.value
}
