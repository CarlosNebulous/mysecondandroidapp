package com.example.mysecondandroidapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.Objects;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private GridView gridView;
    private List<Fruit> fruits;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // To display Icon
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Set Views
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        // Set clickable for the views
        listView.setOnItemClickListener(this);
        gridView.setOnItemClickListener(this);
        registerForContextMenu(listView);
        registerForContextMenu(gridView);

        // Set by default list view by hiding grid view
        gridView.setVisibility(View.INVISIBLE);
        gridView.setEnabled(false);

        // Create a sample fruit and initialize the list
        fruits = new ArrayList<Fruit>();
        fruits.add(createRandomFruit());

        // Initialize and set default list adapter
        myAdapter = new MyAdapter(this, R.layout.list_item, fruits);
        listView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                // Add a new fruit
                this.fruits.add(createRandomFruit());
                // Notify the change in the data to the adapter
                this.myAdapter.notifyDataSetChanged();
                break;
            case R.id.change_view:
                // Change View
                changeView();
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        // To get the info about the current item
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.delete_item) {
            // Remove current fruit
            this.fruits.remove(info.position);
            // Notify the change in the data to the adapter
            this.myAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String origin = fruits.get(position).getOrigin();
        String name = fruits.get(position).getName();
        Toast.makeText(this, "The best fruit from " + origin + " is " + name, Toast.LENGTH_SHORT).show();
    }

    public Fruit createRandomFruit() {
        String name;
        String origin;
        int icon;
        Random rand = new Random(); //instance of random class
        int upper_bound = 5;
        //generate random values from 0-4
        int int_random = rand.nextInt(upper_bound) + 1;

        switch (int_random) {
            case 1:
                name = "Banana";
                origin = "Canarias";
                icon = Fruit.Banana_icon;
                break;
            case 2:
                name = "Manzanita";
                origin = "Soria";
                icon = Fruit.Apple_icon;
                break;
            case 3:
                name = "Platano";
                origin = "Honduras";
                icon = Fruit.Banana_icon;
                break;
            case 4:
                name = "Apple";
                origin = "Westminster";
                icon = Fruit.Apple_icon;
                break;
            case 5:
                name = "Ananas";
                origin = "Ultramar";
                icon = Fruit.Banana_icon;
                break;
            default:
                name = "Apple";
                origin = "Madrid";
                icon = Fruit.Apple_icon;
        }

        return new Fruit(name, origin, icon);
    }

    public void changeView() {
        View view;
        // Change the view displayed
        if (this.listView.getVisibility() == View.VISIBLE && this.gridView.getVisibility() == View.INVISIBLE) {
            // Disable and make invisible list view while activating gridView
            this.listView.setVisibility(View.INVISIBLE);
            this.listView.setEnabled(false);
            this.gridView.setVisibility(View.VISIBLE);
            this.gridView.setEnabled(true);
            // Set adapter
            myAdapter = new MyAdapter(this, R.layout.grid_item, fruits);
            gridView.setAdapter(myAdapter);
            view = gridView;
        } else {
            this.listView.setVisibility(View.VISIBLE);
            this.listView.setEnabled(true);
            this.gridView.setVisibility(View.INVISIBLE);
            this.gridView.setEnabled(false);
            // Set adapter
            myAdapter = new MyAdapter(this, R.layout.list_item, fruits);
            listView.setAdapter(myAdapter);
            view = listView;
        }
    }


}