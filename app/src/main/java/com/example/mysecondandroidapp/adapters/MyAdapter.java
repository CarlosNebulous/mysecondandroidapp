package com.example.mysecondandroidapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysecondandroidapp.R;
import com.example.mysecondandroidapp.models.Fruit;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruits;

    public MyAdapter(Context context, int layout, List<Fruit> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return this.fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return this.fruits.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Initialize view
        View v = convertView;

        // Define Layout inflater and set it up
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_item, null);

        // Get the current fruit from the fruits list
        Fruit currentFruit = this.fruits.get(position);

        // Modify the view elements according the fruit element
        TextView textViewFruit = v.findViewById(R.id.textViewFruit);
        TextView textViewOrigin  = v.findViewById(R.id.textViewOrigin);
        ImageView imageViewIcon = v.findViewById(R.id.imageViewIcon);

        textViewFruit.setText(currentFruit.getName());
        textViewOrigin.setText(currentFruit.getOrigin());
        imageViewIcon.setImageResource(currentFruit.getIcon());

        return v;
    }
}
