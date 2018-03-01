package com.example.ravindra.php_mysql_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_activity extends AppCompatActivity {

    Button displayList;
    Button updateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        displayList=(Button) findViewById(R.id.displayList);
        updateData=(Button) findViewById(R.id.updateData);

        displayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home_activity.this,displaying_list.class));
            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),upload_data.class));
            }
        });

    }
}
