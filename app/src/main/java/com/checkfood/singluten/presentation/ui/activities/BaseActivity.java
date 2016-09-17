package com.checkfood.singluten.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by diego.galico on 14/09/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutResourceId());
    }

    /**
     * This returns the resource id layout.
     *
     * @return The layout res id.
     */
    protected abstract int getLayoutResourceId();

}
