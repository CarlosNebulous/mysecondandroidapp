package com.example.mysecondandroidapp.models;

import com.example.mysecondandroidapp.R;

public class Fruit {

    public String Name;
    public String Origin;
    public int Icon;
    public static int Apple_icon = R.mipmap.ic_apple;
    public static int Banana_icon = R.mipmap.ic_banana;

    public Fruit(String Name, String Origin, int Icon) {
        this.Name = Name;
        this.Origin = Origin;
        this.Icon = Icon;
    }

    public String getName() {
        return Name;
    }

    public int getIcon() {
        return Icon;
    }

    public String getOrigin() {
        return Origin;
    }
}
