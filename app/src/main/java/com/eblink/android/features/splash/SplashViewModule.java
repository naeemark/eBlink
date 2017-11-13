package com.eblink.android.features.splash;

import android.content.Context;
import android.support.annotation.NonNull;

import com.eblink.android.app.presenter.loader.PresenterFactory;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.utils.BookRepository;
import com.eblink.android.utils.PreferencesUtils;

import dagger.Module;
import dagger.Provides;

@Module
public final class SplashViewModule {

    @Provides
    public SplashInteractor provideInteractor(Context context, PreferencesUtils preferencesUtils, AppDatabase appDatabase, BookRepository bookRepository) {
        return new SplashInteractorImpl(context, preferencesUtils, appDatabase, bookRepository);
    }

    @Provides
    public PresenterFactory<SplashPresenter> providePresenterFactory(@NonNull final SplashInteractor interactor) {
        return new PresenterFactory<SplashPresenter>() {
            @NonNull
            @Override
            public SplashPresenter create() {
                return new SplashPresenterImpl(interactor);
            }
        };
    }
}
