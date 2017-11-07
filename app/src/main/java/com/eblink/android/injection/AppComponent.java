package com.eblink.android.injection;

import android.content.Context;

import com.eblink.android.EBlinkApp;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Context getAppContext();

    EBlinkApp getApp();

    Retrofit exposeRetrofit();
}