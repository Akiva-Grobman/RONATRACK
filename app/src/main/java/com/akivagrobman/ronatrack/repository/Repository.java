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
    private final LiveData<UserInfo> userInfo;

    public Repository(Application application) {
        UserInfoDatabase database = UserInfoDatabase.getDatabase(application);
        userInfoDAO = database.userInfoDAO();
        userInfo = userInfoDAO.getUserInfo(ID);
    }

    public LiveData<UserInfo> getUserInfo() {
        return userInfo;
    }

    public void insert(UserInfo userInfo) {
        UserInfoDatabase.databaseWriteExecutor.execute(() -> userInfoDAO.insert(userInfo));
    }

    public void deleteUserInfo() {
        UserInfoDatabase.databaseWriteExecutor.execute(userInfoDAO::deleteUserInfo);
    }

}
