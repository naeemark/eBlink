package com.eblink.android.injection;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eblink.android.EBlinkApp;

import dagger.Module;
import dagger.Provides;

@Module
public final class AppModule {
    @NonNull
    private final EBlinkApp mApp;

    public AppModule(@NonNull EBlinkApp app) {
        mApp = app;
    }

    @Provides
    public Context provideAppContext() {
        return mApp;
    }

    @Provides
    public EBlinkApp provideApp() {
        return mApp;
    }
}
