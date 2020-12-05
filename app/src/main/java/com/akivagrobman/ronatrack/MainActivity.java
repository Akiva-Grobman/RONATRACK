package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String IS_FIRST_TIME = "is_first_time";
    public static boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        isFirstTime = sharedPreferences.getBoolean(IS_FIRST_TIME, true);

        if(isFirstTime){
          //open the first time login todo : create the first time login
            //...
            //...
        }

    }

    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_TIME, isFirstTime);
        editor.apply();
    }

}