package com.eblink.android.features.splash;

import com.eblink.android.app.injection.ActivityScope;
import com.eblink.android.app.injection.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = SplashViewModule.class)
public interface SplashViewComponent {
    void inject(SplashActivity activity);
}