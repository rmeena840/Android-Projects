package com.example.ravindra.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view){

        Intent intent=null,chooser=null;
        if(view.getId()==R.id.google_maps){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.1463055,72.8909537"));
            chooser=Intent.createChooser(intent,"Laucnh maps");
            startActivity(chooser);
        }else if(view.getId()==R.id.play_store){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.carnot&hl=en"));
            chooser=Intent.createChooser(intent,"Launch Market");
            startActivity(chooser);

        }else if(view.getId()==R.id.email){
            intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"xyz@gmail.com","ABC@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Summer Internship");
            intent.putExtra(Intent.EXTRA_TEXT,"I am applying for summer internship 2018");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Launch email");
            startActivity(chooser);
        }

    }
}