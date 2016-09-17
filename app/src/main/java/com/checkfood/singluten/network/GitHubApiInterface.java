package com.checkfood.singluten.network;

import com.checkfood.singluten.domain.model.GithubModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by diego.galico on 14/09/2016.
 */
public interface GitHubApiInterface {
    String SERVICE_ENDPOINT = "https://api.github.com";

    @GET("/users/{login}")
    Observable<GithubModel> getUser(@Path("login") String login);
}
