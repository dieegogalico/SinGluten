package com.checkfood.singluten;

import android.app.Application;

import com.checkfood.singluten.domain.Constants;
import com.crittercism.app.Crittercism;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //initiate Crittercism
        Crittercism.initialize(this, Constants.CRITTERCISM_API_KEY);
        // initiate Timber
        Timber.plant(new DebugTree());
    }
}
