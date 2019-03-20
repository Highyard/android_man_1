package com.example.courseratingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.courseratingapp.domain.User;

public class CreateUserActivity extends AppCompatActivity {

    private final static String TAG = "CreateUserActivity";

    private EditText email, password;
    private Button signUp;

    private User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        Log.d(TAG, getString(R.string.onCreate));
        init();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }



    protected void init(){
        Log.d(TAG, getString(R.string.init));
        email = findViewById(R.id.et1);
        password = findViewById(R.id.et2);
        signUp = findViewById(R.id.b1);
    }
}
