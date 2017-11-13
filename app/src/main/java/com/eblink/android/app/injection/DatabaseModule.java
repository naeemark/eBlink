package com.eblink.android.app.injection;

import android.content.Context;

import com.eblink.android.database.dao.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Naeem(naeemark@gmail.com)
 * On 12/11/2017.
 * For eBlink
 */

@Module
public final class DatabaseModule {

    @Provides
    @Singleton
    public AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getAppDatabase(context);
    }

}
