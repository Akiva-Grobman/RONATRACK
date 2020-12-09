package com.akivagrobman.ronatrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.akivagrobman.ronatrack.database.UserInfo;
import com.akivagrobman.ronatrack.repository.Repository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repository = new Repository(getApplication());
        TextView view = findViewById(R.id.view);
//        UserInfo userInfo = repository.getUserInfo().getValue();
//        view.setText(getText(userInfo));
//        MyViewModel model = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyViewModel.class);
//        model.getUserInfo().setValue(repository.getUserInfo().getValue());
//        final Observer<UserInfo> infoObserver = info -> view.setText(getText(info));
//        repository.getUserInfo().observe(this, infoObserver);
    }

    private String  getText(UserInfo userInfo) {
        String text = "";
        text += userInfo.getGender() + "\n";
        text += userInfo.getAge() + "\n";
        text += userInfo.getHeight() + "\n";
        text += userInfo.getWeight() + "\n";
        return text;
    }

}