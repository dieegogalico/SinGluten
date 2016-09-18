package com.checkfood.singluten.app.dependencyinjection.components;

import com.checkfood.singluten.app.dependencyinjection.modules.GitHubModule;
import com.checkfood.singluten.app.dependencyinjection.scopes.UserScope;
import com.checkfood.singluten.presentation.ui.fragments.SplashFragment;

import dagger.Component;

/**
 * Created by diego.galico on 14/09/2016.
 */
@UserScope
@Component(dependencies = NetworkComponent.class, modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(SplashFragment fragment);
}
