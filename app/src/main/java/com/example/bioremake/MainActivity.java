package com.example.bioremake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.bioremake.data.Bio;
import com.example.bioremake.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding frontBinder;
    private  Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frontBinder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Elon Musk");

        frontBinder.setBio(bio);
        frontBinder.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHobbies(view);
            }
        });
    }

    public void addHobbies(View view){

        String hobbiesInput = frontBinder.enterHobby.getText().toString().trim();

        if(hobbiesInput.equals("")) return; //If the string is empty, do nothing

        bio.setHobbies("Hobbies : " + hobbiesInput);

        //frontBinder.hobbiesText.setText("Hobbies : " + frontBinder.enterHobby.getText().toString().trim()  );
        frontBinder.invalidateAll();
        frontBinder.hobbiesText.setVisibility(View.VISIBLE);

        // Hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}