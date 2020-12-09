package com.akivagrobman.ronatrack.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.akivagrobman.ronatrack.database.UserInfoDatabase;
import com.akivagrobman.ronatrack.database.UserInfo;
import com.akivagrobman.ronatrack.database.UserInfoDAO;

public class Repository {

    public static final int ID = 314159265;
    private final UserInfoDAO userInfoDAO;

    public Repository(Application application) {
        UserInfoDatabase database = UserInfoDatabase.getDatabase(application);
        userInfoDAO = database.userInfoDAO();
    }

    public UserInfo getUserInfo(int id) {
        return userInfoDAO.getUserInfo(id);
    }

    public UserInfo getUserInfo() {
        return getUserInfo(ID);
    }

    public void insert(UserInfo userInfo) {
        UserInfoDatabase.databaseWriteExecutor.execute(() -> userInfoDAO.insert(userInfo));
    }

    public void deleteUserInfo() {
        UserInfoDatabase.databaseWriteExecutor.execute(userInfoDAO::deleteUserInfo);
    }

}