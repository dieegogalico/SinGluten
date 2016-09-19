package com.checkfood.singluten.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.checkfood.singluten.app.dependencyinjection.components.DaggerGitHubComponent;
import com.checkfood.singluten.app.dependencyinjection.components.DaggerNetworkComponent;
import com.checkfood.singluten.app.dependencyinjection.components.GitHubComponent;
import com.checkfood.singluten.app.dependencyinjection.components.NetworkComponent;
import com.checkfood.singluten.app.dependencyinjection.modules.AppModule;
import com.checkfood.singluten.app.dependencyinjection.modules.GitHubModule;
import com.checkfood.singluten.app.dependencyinjection.modules.NetworkModule;
import com.checkfood.singluten.network.GitHubApiInterface;
import com.crittercism.app.Crittercism;

import timber.log.Timber;
import timber.log.Timber.DebugTree;

public class AndroidApplication extends Application {

    private NetworkComponent mNetworkComponent;
    private GitHubComponent mGitHubComponent;

    /**
     * Static method for get application context
     *
     * @param context
     *
     * @return
     */
    public static AndroidApplication get(Context context) {
        return (AndroidApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //initiate Crittercism
        Crittercism.initialize(this, Constants.CRITTERCISM_API_KEY);
        // initiate Timber
        Timber.plant(new DebugTree());

        mNetworkComponent = DaggerNetworkComponent.builder()
                                                  // list of modules that are part of this component need to be created here too
                                                  .appModule(new AppModule(this))
                                                  .networkModule(new NetworkModule(GitHubApiInterface.SERVICE_ENDPOINT))
                                                  .build();

        mGitHubComponent = DaggerGitHubComponent.builder()
                                                .networkComponent(mNetworkComponent)
                                                .gitHubModule(new GitHubModule())
                                                .build();
    }

    public NetworkComponent getNetworkComponent() {
        return mNetworkComponent;
    }

    public GitHubComponent getGitHubComponent() {
        return mGitHubComponent;
    }

    public boolean hasNetwork() {
        return checkIfHasNetwork();
    }

    private boolean checkIfHasNetwork() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

}
