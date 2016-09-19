package com.checkfood.singluten.domain.model;

import com.checkfood.singluten.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oliva on 9/19/16.
 */
public class ProductData {
    public static List<ProductModel> productList = new ArrayList<ProductModel>() {{
        add(new ProductModel("Snacks", R.drawable.snack));
        add(new ProductModel("Vegetales", R.drawable.vegetables));
        add(new ProductModel("Pastas", R.drawable.pasta));
        add(new ProductModel("Lactos", R.drawable.lacteal));
        add(new ProductModel("Cereales", R.drawable.cereal));
        add(new ProductModel("Golosinas", R.drawable.candy));
        add(new ProductModel("Fiambres", R.drawable.meat));
        add(new ProductModel("Frutas", R.drawable.fruit));
    }};
}
