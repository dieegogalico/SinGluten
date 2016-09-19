package com.checkfood.singluten.domain.model;

/**
 * Created by Oliva on 9/18/16.
 */
public class ProductModel {

    private String name;
    private int imageResource;

    public ProductModel(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return imageResource;
    }

    public void setImage(int image) {
        this.imageResource = image;
    }
}
