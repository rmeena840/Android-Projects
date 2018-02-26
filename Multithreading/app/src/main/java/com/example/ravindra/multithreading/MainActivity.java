package com.example.ravindra.multithreading;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    Button button;
    EditText editText;
    ListView listView;
    String[] imageurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        editText= (EditText) findViewById(R.id.editText);
        listView= (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
        imageurl=getResources().getStringArray(R.array.imageurl);
    }

    public void downloadImage(View view){
        Thread mythread=new Thread(new DownloadImageThread());
        mythread.start();
    }

    public boolean downloadimageusingurl(String url){


        URL downloadURL=null;
        boolean successful=false;
        HttpURLConnection connection=null;
        InputStream inputStream=null;

        try {

            downloadURL=new URL(url);
            connection=(HttpURLConnection) downloadURL.openConnection();
            inputStream=connection.getInputStream();
            Log.d("ravi","yes");
            int read=-1;
            while((read=inputStream.read())!=-1){
                Log.d("ravi", "asd");
            }
        } catch (MalformedURLException e) {
            Log.d("ravi","no");
        }
        catch (IOException e) {
            Log.d("ravi","bz");
        }
        finally {
            if(connection!=null)
            {
                connection.disconnect();
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return successful;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText(imageurl[i]);
    }

    private class DownloadImageThread implements Runnable{

        @Override
        public void run() {
            downloadimageusingurl(imageurl[0]);
        }
    }
}
