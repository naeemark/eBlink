package com.eblink.android.database;

import com.eblink.android.model.entity.Book;

import java.util.List;

/**
 * An Interface to provide callback functions for Database queries
 * Created by Naeem(naeemark@gmail.com)
 * On 12/11/2017.
 * For eBlink
 */

public interface Retrievable {

    interface DatabaseInitializer {

        void onCheckDataExistence(boolean flag);

        void onDatabaseInitialized();

        void onDatabaseInitializeFailed();
    }

    interface DatabaseQueryListener {

        void onDatabaseRetrieved(List<Book> list);
    }

}
