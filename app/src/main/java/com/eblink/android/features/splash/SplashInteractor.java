package com.eblink.android.features.splash;


import com.eblink.android.app.interactor.BaseInteractor;
import com.eblink.android.database.DatabasQueryResponseListener;

public interface SplashInteractor extends BaseInteractor {

    boolean isNetworkConnected();

    String getNoNetworkErrorText();

    boolean isSplashDone();

    void setSpalshDone();

    void isDataAvailable(DatabasQueryResponseListener listener);
}