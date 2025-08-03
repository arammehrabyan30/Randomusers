package com.aram.mehrabyan.db.internal;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserItemDao _userItemDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "79a59265cc18b638c7d409f686d47a9c", "64b8ac48b1b1ef8a498b0c7b4de72a2f") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `user_item` (`id` TEXT NOT NULL, `age` INTEGER NOT NULL, `name` TEXT NOT NULL, `email` TEXT NOT NULL, `phone` TEXT NOT NULL, `birthDate` TEXT NOT NULL, `country` TEXT NOT NULL, `state` TEXT NOT NULL, `city` TEXT NOT NULL, `street` TEXT NOT NULL, `thumbnail` TEXT, `imageUrl` TEXT, PRIMARY KEY(`id`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '79a59265cc18b638c7d409f686d47a9c')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `user_item`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsUserItem = new HashMap<String, TableInfo.Column>(12);
        _columnsUserItem.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("age", new TableInfo.Column("age", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("birthDate", new TableInfo.Column("birthDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("country", new TableInfo.Column("country", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("state", new TableInfo.Column("state", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("city", new TableInfo.Column("city", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("street", new TableInfo.Column("street", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("thumbnail", new TableInfo.Column("thumbnail", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserItem.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysUserItem = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesUserItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserItem = new TableInfo("user_item", _columnsUserItem, _foreignKeysUserItem, _indicesUserItem);
        final TableInfo _existingUserItem = TableInfo.read(connection, "user_item");
        if (!_infoUserItem.equals(_existingUserItem)) {
          return new RoomOpenDelegate.ValidationResult(false, "user_item(com.aram.mehrabyan.db.api.UserItemEntity).\n"
                  + " Expected:\n" + _infoUserItem + "\n"
                  + " Found:\n" + _existingUserItem);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user_item");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "user_item");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserItemDao.class, UserItemDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserItemDao userItemDao() {
    if (_userItemDao != null) {
      return _userItemDao;
    } else {
      synchronized(this) {
        if(_userItemDao == null) {
          _userItemDao = new UserItemDao_Impl(this);
        }
        return _userItemDao;
      }
    }
  }
}
