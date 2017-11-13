package com.eblink.android.features.splash;

import android.content.Context;

import com.eblink.android.R;
import com.eblink.android.app.interactor.impl.BaseInteractorImpl;
import com.eblink.android.database.DatabaseQueryResponseListener;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.utils.NetworkUtils;
import com.eblink.android.utils.PreferencesUtils;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public final class SplashInteractorImpl extends BaseInteractorImpl implements SplashInteractor {

    private final Context mContext;

    private final PreferencesUtils mPreferencesUtils;
    private AppDatabase mAppDatabase;

    @Inject
    public SplashInteractorImpl(Context context, PreferencesUtils preferencesUtils, AppDatabase appDatabase) {
        this.mContext = context;
        this.mPreferencesUtils = preferencesUtils;
        this.mAppDatabase = appDatabase;
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetAvailable(mContext);
    }

    @Override
    public String getNoNetworkErrorText() {
        return mContext.getString(R.string.error_no_network);
    }

    @Override
    public boolean isSplashDone() {
        return mPreferencesUtils.getBoolean(PreferencesUtils.PrefKeys.IS_SPLASH_DONE.name());
    }

    @Override
    public void setSpalshDone() {
        mPreferencesUtils.putBoolean(PreferencesUtils.PrefKeys.IS_SPLASH_DONE.name(), true);

    }

    @Override
    public void isDataAvailable(final DatabaseQueryResponseListener listener) {
//        listener.onCheckDataExistance(mAppDatabase.bookDao().getCount() != 0);


        Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return mAppDatabase.bookDao().getCount() != 0;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Timber.e("Result: " + aBoolean);
                        listener.onCheckDataExistance(mAppDatabase.bookDao().getCount() != 0);
                    }
                });


    }

}