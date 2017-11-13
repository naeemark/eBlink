package com.eblink.android.app.interactor;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public interface BaseInteractor {

    <T> void subscribe(Flowable<T> flowable, Consumer<T> consumer);

    void unsubscribe();

    void cancelOnGoingRequest();
}
