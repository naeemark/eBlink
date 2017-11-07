package com.eblink.android.features.splash;

import com.eblink.android.app.presenter.BasePresenter;

public interface SplashPresenter extends BasePresenter<SplashView> {

    void startLoading();

    void stopLoading();

    void doSplash();

    void checkNetwork();

    void launchNextActivity();
}