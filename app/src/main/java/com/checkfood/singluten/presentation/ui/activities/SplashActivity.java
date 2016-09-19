package com.checkfood.singluten.presentation.ui.activities;

import android.os.Bundle;

import com.checkfood.singluten.R;
import com.checkfood.singluten.presentation.presenters.MainPresenter.View;
import com.checkfood.singluten.presentation.ui.fragments.SplashFragment;

public class SplashActivity extends BaseActivity implements View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            addInfoFragment();
        }
    }

    public void addInfoFragment() {
        SplashFragment splashFragment = SplashFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, splashFragment)
                .commit();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_container;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }
}
