package com.eblink.android.features.catalog.interactor.impl;

import com.eblink.android.app.interactor.impl.BaseInteractorImpl;
import com.eblink.android.database.Retrievable;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.features.catalog.interactor.CatalogInteractor;
import com.eblink.android.model.entity.Book;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public final class CatalogInteractorImpl extends BaseInteractorImpl implements CatalogInteractor {
    private final AppDatabase mAppDatabase;

    @Inject
    public CatalogInteractorImpl(AppDatabase appDatabase) {

        mAppDatabase = appDatabase;
    }

    @Override
    public void fetchData(Retrievable.DatabaseQueryListener listener) {
        Flowable<List<Book>> booksFlowable = mAppDatabase.bookDao().retrieveAll();

        subscribe(booksFlowable, new Consumer<List<Book>>() {
            @Override
            public void accept(List<Book> list) throws Exception {
                listener.onDatabaseRetrieved(list);
            }
        });


    }
}