package com.example.mysecondandroidapp.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mysecondandroidapp.R;
import com.example.mysecondandroidapp.adapters.MyAdapter;
import com.example.mysecondandroidapp.models.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;
    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        // Set by default list view by hiding grid view
        listView.setVisibility(View.INVISIBLE);
        listView.setEnabled(false);

        // Create a sample fruit and initialize the list
        Fruit fruit = new Fruit("Apple", "Spain", Fruit.Apple_icon);
        fruits = new ArrayList<Fruit>();
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);
        fruits.add(fruit);


        // Initialize and set custom adapter
        MyAdapter myAdapter = new MyAdapter(this, R.layout.grid_item, fruits);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked: " + fruits.get(position).Name, Toast.LENGTH_LONG).show();
            }
        });

    }
}