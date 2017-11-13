package com.eblink.android.features.splash;

import android.content.Context;

import com.eblink.android.R;
import com.eblink.android.app.interactor.impl.BaseInteractorImpl;
import com.eblink.android.database.Retrievable;
import com.eblink.android.database.dao.AppDatabase;
import com.eblink.android.model.entity.Book;
import com.eblink.android.utils.BookRepository;
import com.eblink.android.utils.NetworkUtils;
import com.eblink.android.utils.PreferencesUtils;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.schedulers.Schedulers;


public final class SplashInteractorImpl extends BaseInteractorImpl implements SplashInteractor {

    private final Context mContext;

    private final PreferencesUtils mPreferencesUtils;
    private AppDatabase mAppDatabase;
    private BookRepository mBookRepository;

    @Inject
    public SplashInteractorImpl(Context context, PreferencesUtils preferencesUtils, AppDatabase appDatabase, BookRepository bookRepository) {
        this.mContext = context;
        this.mPreferencesUtils = preferencesUtils;
        this.mAppDatabase = appDatabase;
        mBookRepository = bookRepository;
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
    public void isDataAvailable(final Retrievable.DatabaseInitializer listener) {

        Flowable<Integer> flowable = mAppDatabase.bookDao().getCount();
        subscribe(flowable, integer -> listener.onCheckDataExistence(integer != 0));
    }

    /**
     * Initializes the application database by Json Objects provided in assets
     * @param listener
     */
    @Override
    public void initializeDatabase(Retrievable.DatabaseInitializer listener) {

        Book[] books = mBookRepository.getBooks();

        if (books == null || books.length == 0) {
            listener.onDatabaseInitializeFailed();
        } else {
            new CompletableFromAction(() -> mAppDatabase.bookDao().insertAll(books))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(listener::onDatabaseInitialized);
        }
    }

}