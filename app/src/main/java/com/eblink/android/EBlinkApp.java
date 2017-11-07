package com.eblink.android;

import android.app.Application;
import android.support.annotation.NonNull;

import com.eblink.android.injection.AppComponent;
import com.eblink.android.injection.AppModule;
import com.eblink.android.injection.DaggerAppComponent;

public final class EBlinkApp extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}