package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
            startActivity(new Intent(this, FirstTimeLogin.class));
        }

    }

    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(IS_FIRST_TIME, isFirstTime);
        editor.apply();
    }

    public void ocClick(View view) {

        switch (view.getId()){

            case R.id.food:
                //open the MoreBasicInfo.xml and gives you the questionnaire
            break;

            case R.id.sleep:
                //open the MoreBasicInfo.xml and gives you the questionnaire
                break;

            case R.id.health:
                //open the MoreBasicInfo.xml and gives you the questionnaire
                break;

            case R.id.interactions:
                //open the MoreBasicInfo.xml and gives you the questionnaire
                break;

            case R.id.i_have_corona:
                Toast.makeText(this, "We don't care", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}