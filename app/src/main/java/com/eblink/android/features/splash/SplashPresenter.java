package com.eblink.android.features.splash;

import com.eblink.android.app.presenter.BasePresenter;
import com.eblink.android.database.Retrievable;

public interface SplashPresenter extends BasePresenter<SplashView>, Retrievable.DatabaseInitializer {

    void startLoading();

    void stopLoading();

    void doSplash();

    void checkNetwork();

    void launchNextActivity();
}