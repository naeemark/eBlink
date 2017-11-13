package com.eblink.android.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.eblink.android.BuildConfig;
import com.eblink.android.app.injection.AppComponent;
import com.eblink.android.app.injection.AppModule;
import com.eblink.android.app.injection.DaggerAppComponent;
import com.eblink.android.app.injection.DatabaseModule;

import timber.log.Timber;

public final class EBlinkApp extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // Shows logs only in Debug Build type
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .build();
    }

    @NonNull
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}