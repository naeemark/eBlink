package com.eblink.android.app.injection;

import android.content.Context;

import com.eblink.android.app.EBlinkApp;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.utils.BookRepository;
import com.eblink.android.utils.PreferencesUtils;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {

    Context getAppContext();

    EBlinkApp getApp();

    PreferencesUtils exposePreferencesUtils();

    AppDatabase exposeDatabase();

    BookRepository exposeRepository();

}