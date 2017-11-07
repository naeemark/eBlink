package com.eblink.android.presenter.loader;

import android.support.annotation.NonNull;

import com.eblink.android.presenter.BasePresenter;

/**
 * Factory to implement to create a presenter
 */
public interface PresenterFactory<T extends BasePresenter> {
    @NonNull
    T create();
}
