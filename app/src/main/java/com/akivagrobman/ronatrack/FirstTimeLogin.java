package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class FirstTimeLogin extends AppCompatActivity {

    LinearLayout first_page, second_page, third_page, fourth_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_login);

        //pages
        first_page = findViewById(R.id.first_page);
        second_page = findViewById(R.id.second_page);
        third_page = findViewById(R.id.third_page);
        fourth_page = findViewById(R.id.fourth_page);

    }

    public void ocClick(View view) {

        switch (view.getId()){

            case R.id.next :
                //go next do stuff in current pos
                break;

            case R.id.back :
                    //go back do stuff in current pos
                break;

        }
    }
}