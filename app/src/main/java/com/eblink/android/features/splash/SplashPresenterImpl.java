package com.eblink.android.features.splash;

import android.os.Handler;
import android.support.annotation.NonNull;

import com.eblink.android.app.presenter.impl.BasePresenterImpl;
import com.eblink.android.database.DatabasQueryResponseListener;

import javax.inject.Inject;

import timber.log.Timber;

public final class SplashPresenterImpl extends BasePresenterImpl<SplashView> implements SplashPresenter, Runnable, DatabasQueryResponseListener {

    @NonNull
    private final SplashInteractor mInteractor;
    private Handler mHandler = new Handler();

    @Inject
    public SplashPresenterImpl(@NonNull SplashInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean viewCreated) {
        super.onStart(viewCreated);

        if (viewCreated) {
            startLoading();
//            if (!mInteractor.isSplashDone()) {
//                doSplash();
//            } else {
//                launchNextActivity();
//            }
            doSplash();
        }
    }

    @Override
    public void onStop() {
        mHandler.removeCallbacks(this);
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
//        mHandler.postDelayed(this, AppConstants.SPLASH_TIME_MILLI_SECONDS);
//        mInteractor.setSpalshDone();


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
//        stopLoading();
    }

    @Override
    public void run() {
        launchNextActivity();
    }

    @Override
    public void onCheckDataExistance(boolean flag) {
        Timber.e("isDataAvailable: " + flag);
    }
}