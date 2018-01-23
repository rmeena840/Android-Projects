package com.example.ravindra;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ravindra.customgirdview.R;

public class MyDialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
        Intent intent=getIntent();
        if(intent!=null){
//            int imageid=intent.getIntExtra("image",R.drawable.home1);
            String name=intent.getStringExtra("name");
            ImageView image= (ImageView) findViewById(R.id.imageView2);
//            image.setImageResource(imageid);
            TextView textView= (TextView) findViewById(R.id.textView);
            textView.setText("This is "+name);
        }
    }
    public void closeDialog(View view){
        finish();
    }
}
