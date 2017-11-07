package com.eblink.android.app.injection;

import android.content.Context;

import com.eblink.android.app.EBlinkApp;
import com.eblink.android.utils.PreferencesUtils;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getAppContext();

    EBlinkApp getApp();

    PreferencesUtils exposePreferencesUtils();

}