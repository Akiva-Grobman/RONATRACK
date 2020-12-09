package com.akivagrobman.ronatrack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.akivagrobman.ronatrack.database.UserInfo;

public class MyViewModel extends ViewModel {

    private MutableLiveData<UserInfo> userInfo;

    public MutableLiveData<UserInfo> getUserInfo() {
        if(userInfo == null) {
            userInfo = new MutableLiveData<>();
        }
        return userInfo;
    }

}
