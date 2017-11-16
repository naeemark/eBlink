package com.eblink.android.features.catalog.view;

import android.support.annotation.UiThread;

import com.eblink.android.app.view.BaseView;
import com.eblink.android.model.entity.Book;

import java.util.List;

@UiThread
public interface CatalogView extends BaseView {

    void loadList(List<Book> list);
}