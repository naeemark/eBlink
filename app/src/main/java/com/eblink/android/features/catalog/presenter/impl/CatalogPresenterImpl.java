package com.eblink.android.features.catalog.presenter.impl;

import android.support.annotation.NonNull;

import com.eblink.android.app.presenter.impl.BasePresenterImpl;
import com.eblink.android.features.catalog.interactor.CatalogInteractor;
import com.eblink.android.features.catalog.presenter.CatalogPresenter;
import com.eblink.android.features.catalog.view.CatalogView;
import com.eblink.android.model.entity.Book;

import java.util.List;

import javax.inject.Inject;

public final class CatalogPresenterImpl extends BasePresenterImpl<CatalogView> implements CatalogPresenter {

    @NonNull
    private final CatalogInteractor mInteractor;

    @Inject
    public CatalogPresenterImpl(@NonNull CatalogInteractor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void onStart(boolean viewCreated) {
        super.onStart(viewCreated);

        if(viewCreated){
            loadList();
        }
    }

    @Override
    public void onStop() {
        mInteractor.cancelOnGoingRequest();
        super.onStop();
    }

    private void loadList() {
        mInteractor.fetchData(this);
    }

    @Override
    public void onDatabaseRetrieved(List<Book> list) {
        mView.loadList(list);
    }
}