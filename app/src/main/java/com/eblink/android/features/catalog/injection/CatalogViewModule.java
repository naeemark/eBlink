package com.eblink.android.features.catalog.injection;

import android.support.annotation.NonNull;

import com.eblink.android.app.presenter.loader.PresenterFactory;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.features.catalog.interactor.CatalogInteractor;
import com.eblink.android.features.catalog.interactor.impl.CatalogInteractorImpl;
import com.eblink.android.features.catalog.presenter.CatalogPresenter;
import com.eblink.android.features.catalog.presenter.impl.CatalogPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public final class CatalogViewModule {
    @Provides
    public CatalogInteractor provideInteractor(AppDatabase appDatabase) {
        return new CatalogInteractorImpl(appDatabase);
    }

    @Provides
    public PresenterFactory<CatalogPresenter> providePresenterFactory(@NonNull final CatalogInteractor interactor) {
        return new PresenterFactory<CatalogPresenter>() {
            @NonNull
            @Override
            public CatalogPresenter create() {
                return new CatalogPresenterImpl(interactor);
            }
        };
    }
}
