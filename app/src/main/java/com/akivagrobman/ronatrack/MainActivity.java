package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.akivagrobman.ronatrack.models.Question;
import com.akivagrobman.ronatrack.models.UserInfo;
import com.akivagrobman.ronatrack.repository.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}