package com.eblink.android.features.splash;

import android.support.annotation.NonNull;

import com.eblink.android.app.presenter.impl.BasePresenterImpl;

import javax.inject.Inject;

import timber.log.Timber;

public final class SplashPresenterImpl extends BasePresenterImpl<SplashView> implements SplashPresenter {

    @NonNull
    private final SplashInteractor mInteractor;

    @Inject
    public SplashPresenterImpl(@NonNull SplashInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean viewCreated) {
        super.onStart(viewCreated);

        if (viewCreated) {
            doSplash();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void startLoading() {
        assert mView != null;
        mView.showLoading();
    }

    @Override
    public void stopLoading() {
        assert mView != null;
        mView.hideLoading();
        mView.finishActivity();
    }

    @Override
    public void doSplash() {
        startLoading();
        mInteractor.isDataAvailable(this);
    }

    @Override
    public void checkNetwork() {
        if (!mInteractor.isNetworkConnected()) {
            assert mView != null;
            mView.showNetworkError();
        }
    }

    @Override
    public void launchNextActivity() {
        assert mView != null;
        mView.launchNextActivity();
        stopLoading();
    }

    @Override
    public void onCheckDataExistence(boolean flag) {
        Timber.e("isDataAvailable: " + flag);
        if (flag) {
            launchNextActivity();
        } else {
            mInteractor.initializeDatabase(this);
        }
    }

    @Override
    public void onDatabaseInitialized() {
        launchNextActivity();
    }

    @Override
    public void onDatabaseInitializeFailed() {
        // TODO: 13/11/2017 Show uiError

    }
}