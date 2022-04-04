package com.example.bioremake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.bioremake.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding frontBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frontBinder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        frontBinder.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHobbies(view);
            }
        });
    }

    public void addHobbies(View view){
        frontBinder.hobbiesText.setText("Hobbies : " + frontBinder.enterHobby.getText().toString().trim()  );
        frontBinder.hobbiesText.setVisibility(View.VISIBLE);
    }
}