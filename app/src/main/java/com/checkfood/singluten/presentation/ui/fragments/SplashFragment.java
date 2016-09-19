package com.checkfood.singluten.presentation.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.checkfood.singluten.R;
import com.checkfood.singluten.app.AndroidApplication;
import com.checkfood.singluten.domain.model.Data;
import com.checkfood.singluten.domain.model.GithubModel;
import com.checkfood.singluten.network.GitHubApiInterface;
import com.checkfood.singluten.presentation.ui.activities.HomeActivity;
import com.checkfood.singluten.presentation.ui.adapters.CardAdapter;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by diego.galico on 14/09/2016.
 */
public class SplashFragment extends BaseFragment{

    @Inject
    GitHubApiInterface mGitHubApiInterface;

    public static SplashFragment newInstance() {
        SplashFragment splashFragment = new SplashFragment();
        return splashFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((AndroidApplication) getActivity().getApplication()).getGitHubComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        /**
         * Set up Android CardView/RecycleView
         */
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        final CardAdapter mCardAdapter = new CardAdapter();
        mRecyclerView.setAdapter(mCardAdapter);

        /**
         * START: button set up
         */
        Button bClear = (Button) view.findViewById(R.id.button_clear);
        Button bFetch = (Button) view.findViewById(R.id.button_fetch);
        bClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
                startActivity(homeIntent);
            }
        });

        bFetch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                for(String login : Data.githubList) {
                    Observable<GithubModel> user = mGitHubApiInterface.getUser(login);
                    user.subscribeOn(Schedulers.newThread())
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Subscriber<GithubModel>() {
                                @Override
                                public final void onCompleted() {
                                    // do nothing
                                }

                                @Override
                                public final void onError(Throwable e) {
                                    Log.e("GithubDemo", e.getMessage());
                                }

                                @Override
                                public final void onNext(GithubModel response) {
                                    mCardAdapter.addData(response);
                                }
                            });
                }
            }
        });

        return view;
    }

}
