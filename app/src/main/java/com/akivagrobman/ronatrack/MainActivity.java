package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPreferences;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String IS_FIRST_TIME = "is_first_time";
    public static boolean isFirstTime = true;

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sharedPreferences
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        isFirstTime = sharedPreferences.getBoolean(IS_FIRST_TIME, true);

        if (isFirstTime) {
            startActivity(new Intent(this, FirstTimeLogin.class));
        }

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

    public void onBackPressed() {
        System.exit(0);
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }else if(x1 > x2){
                Intent i = new Intent(MainActivity.this, Questionnaires.class);
                startActivity(i);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            break;
        }
        return false;
    }


}