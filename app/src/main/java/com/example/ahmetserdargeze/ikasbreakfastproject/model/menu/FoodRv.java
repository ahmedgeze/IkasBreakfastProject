package com.example.ahmetserdargeze.ikasbreakfastproject.model.menu;

import android.graphics.Bitmap;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class FoodRv {
    Bitmap image;
    public String name;
    public String price;

    public FoodRv() {
    }

    public FoodRv(Bitmap image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
