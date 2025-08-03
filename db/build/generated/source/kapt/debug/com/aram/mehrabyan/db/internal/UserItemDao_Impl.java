package com.aram.mehrabyan.db.internal;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.aram.mehrabyan.db.api.UserItemEntity;
import java.lang.Class;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class UserItemDao_Impl implements UserItemDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<UserItemEntity> __insertAdapterOfUserItemEntity;

  private final EntityDeleteOrUpdateAdapter<UserItemEntity> __deleteAdapterOfUserItemEntity;

  public UserItemDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfUserItemEntity = new EntityInsertAdapter<UserItemEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_item` (`id`,`age`,`name`,`email`,`phone`,`birthDate`,`country`,`state`,`city`,`street`,`thumbnail`,`imageUrl`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserItemEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
        statement.bindLong(2, entity.getAge());
        if (entity.getName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getName());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getEmail());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getPhone());
        }
        if (entity.getBirthDate() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getBirthDate());
        }
        if (entity.getCountry() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getCountry());
        }
        if (entity.getState() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getState());
        }
        if (entity.getCity() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getCity());
        }
        if (entity.getStreet() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getStreet());
        }
        if (entity.getThumbnail() == null) {
          statement.bindNull(11);
        } else {
          statement.bindText(11, entity.getThumbnail());
        }
        if (entity.getImageUrl() == null) {
          statement.bindNull(12);
        } else {
          statement.bindText(12, entity.getImageUrl());
        }
      }
    };
    this.__deleteAdapterOfUserItemEntity = new EntityDeleteOrUpdateAdapter<UserItemEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `user_item` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserItemEntity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insert(final UserItemEntity item, final Continuation<? super Unit> $completion) {
    if (item == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfUserItemEntity.insert(_connection, item);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object delete(final UserItemEntity item, final Continuation<? super Unit> $completion) {
    if (item == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __deleteAdapterOfUserItemEntity.handle(_connection, item);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<UserItemEntity>> getAll() {
    final String _sql = "SELECT * FROM user_item";
    return FlowUtil.createFlow(__db, false, new String[] {"user_item"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfAge = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "age");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfEmail = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "email");
        final int _columnIndexOfPhone = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "phone");
        final int _columnIndexOfBirthDate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "birthDate");
        final int _columnIndexOfCountry = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "country");
        final int _columnIndexOfState = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "state");
        final int _columnIndexOfCity = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "city");
        final int _columnIndexOfStreet = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "street");
        final int _columnIndexOfThumbnail = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "thumbnail");
        final int _columnIndexOfImageUrl = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUrl");
        final List<UserItemEntity> _result = new ArrayList<UserItemEntity>();
        while (_stmt.step()) {
          final UserItemEntity _item;
          final String _tmpId;
          if (_stmt.isNull(_columnIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _stmt.getText(_columnIndexOfId);
          }
          final int _tmpAge;
          _tmpAge = (int) (_stmt.getLong(_columnIndexOfAge));
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpEmail;
          if (_stmt.isNull(_columnIndexOfEmail)) {
            _tmpEmail = null;
          } else {
            _tmpEmail = _stmt.getText(_columnIndexOfEmail);
          }
          final String _tmpPhone;
          if (_stmt.isNull(_columnIndexOfPhone)) {
            _tmpPhone = null;
          } else {
            _tmpPhone = _stmt.getText(_columnIndexOfPhone);
          }
          final String _tmpBirthDate;
          if (_stmt.isNull(_columnIndexOfBirthDate)) {
            _tmpBirthDate = null;
          } else {
            _tmpBirthDate = _stmt.getText(_columnIndexOfBirthDate);
          }
          final String _tmpCountry;
          if (_stmt.isNull(_columnIndexOfCountry)) {
            _tmpCountry = null;
          } else {
            _tmpCountry = _stmt.getText(_columnIndexOfCountry);
          }
          final String _tmpState;
          if (_stmt.isNull(_columnIndexOfState)) {
            _tmpState = null;
          } else {
            _tmpState = _stmt.getText(_columnIndexOfState);
          }
          final String _tmpCity;
          if (_stmt.isNull(_columnIndexOfCity)) {
            _tmpCity = null;
          } else {
            _tmpCity = _stmt.getText(_columnIndexOfCity);
          }
          final String _tmpStreet;
          if (_stmt.isNull(_columnIndexOfStreet)) {
            _tmpStreet = null;
          } else {
            _tmpStreet = _stmt.getText(_columnIndexOfStreet);
          }
          final String _tmpThumbnail;
          if (_stmt.isNull(_columnIndexOfThumbnail)) {
            _tmpThumbnail = null;
          } else {
            _tmpThumbnail = _stmt.getText(_columnIndexOfThumbnail);
          }
          final String _tmpImageUrl;
          if (_stmt.isNull(_columnIndexOfImageUrl)) {
            _tmpImageUrl = null;
          } else {
            _tmpImageUrl = _stmt.getText(_columnIndexOfImageUrl);
          }
          _item = new UserItemEntity(_tmpId,_tmpAge,_tmpName,_tmpEmail,_tmpPhone,_tmpBirthDate,_tmpCountry,_tmpState,_tmpCity,_tmpStreet,_tmpThumbnail,_tmpImageUrl);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
