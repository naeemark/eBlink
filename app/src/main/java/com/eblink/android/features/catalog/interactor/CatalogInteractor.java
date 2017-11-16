package com.eblink.android.features.catalog.interactor;

import com.eblink.android.app.interactor.BaseInteractor;
import com.eblink.android.database.Retrievable;

public interface CatalogInteractor extends BaseInteractor {

    void fetchData(Retrievable.DatabaseQueryListener listener);
}