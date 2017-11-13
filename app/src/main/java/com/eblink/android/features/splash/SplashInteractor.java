package com.eblink.android.features.splash;


import com.eblink.android.app.interactor.BaseInteractor;
import com.eblink.android.database.Retrievable;

public interface SplashInteractor extends BaseInteractor {

    boolean isNetworkConnected();

    String getNoNetworkErrorText();

    boolean isSplashDone();

    void setSplashDone();

    void isDataAvailable(Retrievable.DatabaseInitializer listener);

    void initializeDatabase(Retrievable.DatabaseInitializer listener);
}