package com.akivagrobman.ronatrack.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.akivagrobman.ronatrack.models.UserInfo;

@Dao
public interface UserInfoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserInfo userInfo);

    @Query("DELETE FROM user_info_table")
    void deleteUserInfo();

    @Query("SELECT * FROM user_info_table WHERE id = :id")
    UserInfo getUserInfo(int id);

}