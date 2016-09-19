package com.checkfood.singluten.presentation.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.checkfood.singluten.R;
import com.checkfood.singluten.presentation.ui.adapters.HomePagerAdapter;
import com.checkfood.singluten.presentation.ui.fragments.BuyFragment;
import com.checkfood.singluten.presentation.ui.fragments.ProductFragment;
import com.checkfood.singluten.presentation.ui.fragments.RecipeFragment;
import com.checkfood.singluten.presentation.ui.fragments.ScanCodeFragment;

/**
 * Created by diego.galico on 9/18/16.
 */
public class HomeActivity extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        if (savedInstanceState == null) {
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

            viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProductFragment(), getResources().getString(R.string.title_product));
        adapter.addFragment(new ScanCodeFragment(), getResources().getString(R.string.title_scan_code));
        adapter.addFragment(new RecipeFragment(), getResources().getString(R.string.title_recipe));
        adapter.addFragment(new BuyFragment(), getResources().getString(R.string.title_buy));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

}
