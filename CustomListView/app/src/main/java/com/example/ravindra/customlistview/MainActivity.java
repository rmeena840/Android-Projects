package com.example.ravindra.customlistview;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] title;
    String[] description;
    int[] images = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5, R.drawable.home6, R.drawable.home7, R.drawable.home8, R.drawable.home9, R.drawable.home10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        title = res.getStringArray(R.array.title);
        description = res.getStringArray(R.array.description);

        listView = (ListView) findViewById(R.id.listview);

        ListAdapter listAdapter = new ListAdapter(this, title, images, description);
        listView.setAdapter(listAdapter);

    }
}

class ListAdapter extends ArrayAdapter<String> {

    Context context;
    int[] images;
    String[] title;
    String[] desc;

    public ListAdapter(Context context, String[] titles, int[] images, String[] desc) {
        super(context, R.layout.single_row, R.id.textView, titles);
        this.context = context;
        this.images = images;
        this.title = titles;
        this.desc = desc;
    }

    class MyViewHolder{
        ImageView imageView;
        TextView title;
        TextView desc;

        MyViewHolder(View view){
            imageView=(ImageView)view.findViewById(R.id.imageView2);
            title=(TextView) view.findViewById(R.id.textView);
            desc=(TextView) view.findViewById(R.id.textView2);
        }

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        MyViewHolder holder=null;

        if(row==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
        }else{
            holder=(MyViewHolder)row.getTag();
        }

//        holder.imageView.setImageResource(images[position]);
        holder.title.setText(title[position]);
        holder.desc.setText(desc[position]);

        return row;

    }
}