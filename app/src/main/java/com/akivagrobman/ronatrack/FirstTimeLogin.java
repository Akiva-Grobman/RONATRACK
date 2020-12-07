package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class FirstTimeLogin extends AppCompatActivity {

    LinearLayout first_page, second_page, third_page, fourth_page;
    Button back, next;
    private int counter = 0;

    //basic info
    private EditText  etheight, etweight, etage;
    private static String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_login);

        //pages
        first_page = findViewById(R.id.first_page);
        second_page = findViewById(R.id.second_page);
        third_page = findViewById(R.id.third_page);
        fourth_page = findViewById(R.id.fourth_page);
        //back next buttons
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        //basic info
        etheight = findViewById(R.id.height);
        etweight = findViewById(R.id.weight);
        etage = findViewById(R.id.age);

    }


    public void ocClick(View view) {

        switch (view.getId()){

            case R.id.next :

                counter++;
                switch (counter){

                    case 1:
                        first_page.setVisibility(View.GONE);
                        second_page.setVisibility(View.VISIBLE);
                        back.setVisibility(View.VISIBLE);
                        break;

                    case 2:
                        second_page.setVisibility(View.GONE);
                        third_page.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        third_page.setVisibility(View.GONE);
                        fourth_page.setVisibility(View.VISIBLE);
                        break;

                    case 4:
                        saveFirstTimeParameter();
                        startActivity(new Intent(this, MainActivity.class));
                        break;

                    default:
                        Toast.makeText(this, "not optional", Toast.LENGTH_SHORT).show();
                        counter--;
                        break;
                }

                break; // break of -> case r.id.next:

            case R.id.back :

                counter--;
                switch (counter) {

                    case 0:
                        second_page.setVisibility(View.GONE);
                        first_page.setVisibility(View.VISIBLE);
                        back.setVisibility(View.GONE);
                        break;

                    case 1:
                        third_page.setVisibility(View.GONE);
                        second_page.setVisibility(View.VISIBLE);
                        break;

                    case 2:
                        fourth_page.setVisibility(View.GONE);
                        third_page.setVisibility(View.VISIBLE);
                        break;

                    default:
                        Toast.makeText(this, "not optional", Toast.LENGTH_SHORT).show();
                        counter++;
                        break;
                }

                break; // break of -> case r.id.back:
        }
    }

    public void onRadioButtonClicked(View view){

        boolean  checked = ((RadioButton) view).isChecked();

        switch (view.getId()){

            case R.id.male:
                if(checked){
                    gender = "Male";
                }
                break;

            case R.id.female:
                if(checked){
                    gender = "Female";
                }
                break;
        }
    }

    private void storeInfoInBasicInfoObject(){

        String height = etheight.getText().toString();
        String weight = etweight.getText().toString();
        String age = etage.getText().toString();

        BasicInfo basicInfo = new BasicInfo(height, weight, age, gender);

    }


    private void saveFirstTimeParameter() {
        MainActivity.isFirstTime = false;
        SharedPreferences.Editor editor = MainActivity.sharedPreferences.edit();
        editor.putBoolean(MainActivity.IS_FIRST_TIME, MainActivity.isFirstTime);
        editor.apply();

    }


}