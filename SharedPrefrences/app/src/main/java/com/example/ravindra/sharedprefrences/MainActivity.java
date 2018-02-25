package com.example.ravindra.sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username= (EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.passwrod);
    }

    public void save(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Username",username.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.commit();
        Toast.makeText(this,"Saved!",Toast.LENGTH_SHORT).show();
    }

    public void next(View view){
        startActivity(new Intent(this,ActivityB.class));
    }

}
