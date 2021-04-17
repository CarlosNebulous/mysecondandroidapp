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

        // View holder pattern
        ViewHolder holder;

        if (convertView == null) {
            // Define Layout inflater and set it up
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            // Modify the holder view elements according the fruit element
            holder.textViewFruit = convertView.findViewById(R.id.textViewFruit);
            holder.textViewOrigin  = convertView.findViewById(R.id.textViewOrigin);
            holder.imageViewIcon = convertView.findViewById(R.id.imageViewIcon);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current fruit from the fruits list
        Fruit currentFruit = this.fruits.get(position);

        holder.textViewFruit.setText(currentFruit.getName());
        holder.textViewOrigin.setText(currentFruit.getOrigin());
        holder.imageViewIcon.setImageResource(currentFruit.getIcon());

        return convertView;
    }

    static class ViewHolder {
        private TextView textViewFruit;
        private TextView textViewOrigin;
        private ImageView imageViewIcon;
    }

}
