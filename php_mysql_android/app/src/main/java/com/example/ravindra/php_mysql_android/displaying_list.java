package com.example.ravindra.php_mysql_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

public class displaying_list extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaying_list);

        listView=(ListView) findViewById(R.id.listview);

        String url = "http://172.16.186.92/practice/student_details.php";

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("ravi", response);
                        ArrayList<student_details> jsonObjects=new JsonConverter<student_details>().toArrayList(response,student_details.class);

                        BindDictionary<student_details> dictionary=new BindDictionary<>();
                        dictionary.addStringField(R.id.Name, new StringExtractor<student_details>() {
                            @Override
                            public String getStringValue(student_details student_details, int position) {
                                return student_details.Name;
                            }
                        });

                        dictionary.addStringField(R.id.Branch, new StringExtractor<student_details>() {
                            @Override
                            public String getStringValue(student_details student_details, int position) {
                                return student_details.Branch;
                            }
                        });

                        dictionary.addStringField(R.id.Email, new StringExtractor<student_details>() {
                            @Override
                            public String getStringValue(student_details student_details, int position) {
                                return student_details.Email;
                            }
                        });

                        dictionary.addStringField(R.id.Age, new StringExtractor<student_details>() {
                            @Override
                            public String getStringValue(student_details student_details, int position) {
                                return String.valueOf(student_details.Age);
                            }
                        });

                        dictionary.addStringField(R.id.Phone, new StringExtractor<student_details>() {
                            @Override
                            public String getStringValue(student_details student_details, int position) {
                                return String.valueOf(student_details.Phone);
                            }
                        });

                        FunDapter<student_details> adapter=new FunDapter<>(getApplicationContext(),jsonObjects,R.layout.student_details_layoiut,dictionary);

                        listView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                });

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }
}
