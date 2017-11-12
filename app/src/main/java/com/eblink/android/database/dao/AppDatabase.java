package com.eblink.android.database.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.eblink.android.constants.AppConstants;
import com.eblink.android.model.entity.Book;


/**
 * Created by Naeem(naeemark@gmail.com)
 * On 12/11/2017.
 * For eBlink
 */

@Database(entities = {Book.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract BookDao bookDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, AppConstants.DATABASE_NAME)
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}