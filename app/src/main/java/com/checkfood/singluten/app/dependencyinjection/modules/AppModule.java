package com.checkfood.singluten.app.dependencyinjection.modules;

import com.checkfood.singluten.app.AndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by diego.galico on 14/09/2016.
 */
@Module
public class AppModule {

    AndroidApplication mApplication;

    public AppModule(AndroidApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    AndroidApplication providesApplication() {
        return mApplication;
    }

}

