package com.eblink.android.features.catalog.injection;

import com.eblink.android.app.injection.ActivityScope;
import com.eblink.android.app.injection.AppComponent;
import com.eblink.android.features.catalog.view.impl.CatalogActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = CatalogViewModule.class)
public interface CatalogViewComponent {
    void inject(CatalogActivity activity);
}