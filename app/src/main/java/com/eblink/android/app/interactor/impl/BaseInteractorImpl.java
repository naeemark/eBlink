package com.eblink.android.app.interactor.impl;

import com.eblink.android.app.interactor.BaseInteractor;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author Naeem <naeemark@gmail.com>
 * @version 1.0.0
 */

public class BaseInteractorImpl implements BaseInteractor {

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public <T> void subscribe(Flowable<T> flowable, Consumer<T> consumer) {
        Disposable disposable = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
        mDisposable.add(disposable);
    }

    @Override
    public void unsubscribe() {
        if (!mDisposable.isDisposed()) {
            Timber.i("mDisposable.dispose()");
            mDisposable.dispose();
            mDisposable.clear();
        }
    }

    @Override
    public void cancelOnGoingRequest() {
        Timber.i("cancelOnGoingRequest()");
        unsubscribe();
    }
}
