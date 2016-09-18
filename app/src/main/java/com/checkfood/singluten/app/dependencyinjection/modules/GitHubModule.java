package com.checkfood.singluten.app.dependencyinjection.modules;

import com.checkfood.singluten.network.GitHubApiInterface;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by diego.galico on 14/09/2016.
 */
@Module
public class GitHubModule {

    @Provides
    public GitHubApiInterface providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(GitHubApiInterface.class);
    }
}