package com.example.ravindra.sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityB extends AppCompatActivity {

    TextView usernameview,passwrodview;
    public static final String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        usernameview= (TextView) findViewById(R.id.usernameview);
        passwrodview= (TextView) findViewById(R.id.passwordview);
    }
    public void load(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("Username",DEFAULT);
        String password=sharedPreferences.getString("Password",DEFAULT);
        if(name.equals(DEFAULT) || password.equals(DEFAULT)){
            Toast.makeText(this,"Error loading data!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Data Loaded!",Toast.LENGTH_SHORT).show();
            usernameview.setText(name);
            passwrodview.setText(password);
        }
    }

    public void previous(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
