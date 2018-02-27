package com.example.dz.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button loginButton = findViewById(R.id.LoginButton);
        final EditText editText = (EditText)findViewById(R.id.textName) ;
        final EditText editText1 = (EditText)findViewById(R.id.txtpass) ;
        final SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        editText.setText(sharedPreferences.getString("DefaultEmail","email@domain.com"));
        editText1.setText(sharedPreferences.getString("Login","email@domain.com"));
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("DefaultEmail", editText.getText().toString());
                editor.putString("Login", editText1.getText().toString());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this,
                        StartActivity.class);
                startActivity(intent);
            }
        });

        Log.i(ACTIVITY_NAME,"In OnCreate()");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME,"In OnResume()");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME,"In OnStart()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME,"In OnPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME,"In OnStop()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME,"In OnDestroy()");
    }
}