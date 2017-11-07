package com.eblink.android.features.splash;


import com.eblink.android.app.interactor.BaseInteractor;

public interface SplashInteractor extends BaseInteractor {

    boolean isNetworkConnected();

    String getNoNetworkErrorText();

    boolean isSplashDone();

    void setSpalshDone();
}