package com.eblink.android.features.catalog.presenter;

import com.eblink.android.app.presenter.BasePresenter;
import com.eblink.android.database.Retrievable;
import com.eblink.android.features.catalog.view.CatalogView;

public interface CatalogPresenter extends BasePresenter<CatalogView>, Retrievable.DatabaseQueryListener {

}