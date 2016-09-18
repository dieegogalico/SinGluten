package com.checkfood.singluten.app.dependencyinjection.components;

import android.content.SharedPreferences;

import com.checkfood.singluten.app.dependencyinjection.modules.AppModule;
import com.checkfood.singluten.app.dependencyinjection.modules.NetworkModule;
import com.checkfood.singluten.presentation.ui.activities.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by diego.galico on 14/09/2016.
 */
@Singleton
@Component(modules={AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    SharedPreferences sharedPreferences();
}
