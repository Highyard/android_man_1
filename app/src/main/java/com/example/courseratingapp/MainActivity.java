package com.example.courseratingapp;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseratingapp.domain.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "MainActivity";

    // Variable that holds the current state of the email input text field, password does not persist through orientation changes //
    private final static String EMAIL_STATE = "";

    // Key name for the User Object value //
    public final static String USER_KEY = "USER";


    private TextView tv1;
    private EditText et1;
    private EditText et2;
    private Button b1;
    private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, getString(R.string.onCreate));
        init();

        if (savedInstanceState != null){
            et1.setText(EMAIL_STATE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d(TAG, getString(R.string.onSaveInstanceState));

        outState.putString(EMAIL_STATE, et1.getText().toString());
    }



    protected void init() {
        Log.d(TAG, getString(R.string.init));
        tv1 = findViewById(R.id.tv1);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, getString(R.string.onClick));
        switch (v.getId()) {
            case (R.id.b1):
                Intent intent = new Intent(MainActivity.this, com.example.courseratingapp.CoursesPageActivity.class);

                String email = et1.getText().toString();
                String password = et2.getText().toString();
                User user = new User(email, password);

                intent.putExtra(USER_KEY, user);

                if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty()) {
                    Toast.makeText(this, getString(R.string.fill_out_fields), Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(intent);
                }
            case(R.id.b2):
                Intent register = new Intent(MainActivity.this, com.example.courseratingapp.CreateUserActivity.class);
                startActivity(register);
        }


    }
}
