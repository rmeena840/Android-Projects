package com.example.ravindra.customgirdview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ravindra.MyDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new VivzAdapter(this));

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this, MyDialog.class);
        VivzAdapter.ViewHolder holder=(VivzAdapter.ViewHolder)view.getTag();
        family temp= (family) holder.imageView.getTag();
//        intent.putExtra("image",temp.image);
        intent.putExtra("name",temp.name);
        startActivity(intent);
    }
}

class family {
    int image;
    String name;

    family(int imageid, String nameid) {
        this.image = imageid;
        this.name = nameid;
    }
}

class VivzAdapter extends BaseAdapter {

    ArrayList<family> list;
    Context context;

    VivzAdapter(Context context) {
        list = new ArrayList<family>();
        Resources res = context.getResources();
        this.context = context;
        String[] name = res.getStringArray(R.array.names);
        int[] images = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5, R.drawable.home6, R.drawable.home7, R.drawable.home8, R.drawable.home9, R.drawable.home10};
        for (int i = 0; i < 10; i++) {
            family tempfamily = new family(images[i], name[i]);
            list.add(tempfamily);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        ImageView imageView;

        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.single_item, viewGroup, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder=(ViewHolder)row.getTag();
        }
        family temp=list.get(i);
//        holder.imageView.setImageResource(temp.image);
        return row;
    }
}