package com.checkfood.singluten.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checkfood.singluten.R;
import com.checkfood.singluten.domain.model.ProductData;
import com.checkfood.singluten.domain.model.ProductModel;
import com.checkfood.singluten.presentation.ui.adapters.ProductAdapter;

/**
 * Created by Oliva on 9/18/16.
 */
public class ProductFragment extends HomeFragment {

    private GridLayoutManager lLayout;

    public ProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        ProductAdapter adapter = new ProductAdapter();
        lLayout = new GridLayoutManager(getActivity(), 2);

        RecyclerView rView = (RecyclerView)view.findViewById(R.id.recycler_view_products);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        for(ProductModel product : ProductData.productList) {
            adapter.addData(product);
        }

        rView.setAdapter(adapter);

        return view;
    }
}
