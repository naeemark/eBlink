package com.eblink.android.features.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;

import com.eblink.android.R;
import com.eblink.android.app.injection.AppComponent;
import com.eblink.android.app.presenter.loader.PresenterFactory;
import com.eblink.android.app.view.impl.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;

public final class SplashActivity extends BaseActivity<SplashPresenter, SplashView> implements SplashView {

    @BindView(R.id.linearLayout_loading) protected LinearLayout loadingLayout;

    @Inject
    PresenterFactory<SplashPresenter> mPresenterFactory;

    @Override
    protected void setupComponent(@NonNull AppComponent parentComponent) {
        DaggerSplashViewComponent.builder()
                .appComponent(parentComponent)
                .splashViewModule(new SplashViewModule())
                .build()
                .inject(this);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @NonNull
    @Override
    protected PresenterFactory<SplashPresenter> getPresenterFactory() {
        return mPresenterFactory;
    }


    @Override
    public void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
    }

    @Override
    public void finishActivity() {
        finish();
    }

    @Override
    public void launchNextActivity() {
        // Todo: Launch next activity
    }

    @Override
    public void showNetworkError() {
        super.showToast(getString(R.string.error_no_network));
    }
}
