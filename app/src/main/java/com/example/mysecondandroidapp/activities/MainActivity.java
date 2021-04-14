package com.example.mysecondandroidapp.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ListView;

import com.example.mysecondandroidapp.R;
import com.example.mysecondandroidapp.adapters.MyAdapter;
import com.example.mysecondandroidapp.models.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // Create a sample fruit and initialize the list
        Fruit fruit = new Fruit("Apple", "Spain", Fruit.Apple_icon);
        fruits = new ArrayList<Fruit>();
        fruits.add(fruit);

        // Initialize and set custom adapter
        MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, fruits);
        listView.setAdapter(myAdapter);


    }
}