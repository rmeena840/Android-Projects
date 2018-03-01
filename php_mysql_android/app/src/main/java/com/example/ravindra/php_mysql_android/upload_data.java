package com.example.ravindra.php_mysql_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class upload_data extends AppCompatActivity {

    EditText tkname,tkphone,tkemail,tkage,tkbranch;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);

        tkname=(EditText) findViewById(R.id.tkname);
        tkphone=(EditText) findViewById(R.id.tkphone);
        tkemail=(EditText) findViewById(R.id.tkemail);
        tkage=(EditText) findViewById(R.id.tkage);
        tkbranch=(EditText) findViewById(R.id.tkbranch);
        submit=(Button)findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "http://172.16.186.92/practice/upload_student_details.php";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("ravi", response);
                                if (response.contains("Uploaded")) {
                                    Toast.makeText(getApplicationContext(), "Uploaded! :)", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "Error Uploading", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params=new HashMap<>();
                        params.put("Name",tkname.getText().toString());
                        params.put("Branch",tkbranch.getText().toString());
                        params.put("Phone",tkphone.getText().toString());
                        params.put("Email",tkemail.getText().toString());
                        params.put("Age",tkage.getText().toString());
                        return params;
                    }
                };

                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

            }
        });

    }
}
