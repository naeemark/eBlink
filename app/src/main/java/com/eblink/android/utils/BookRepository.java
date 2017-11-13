package com.eblink.android.utils;

import android.content.Context;

import com.eblink.android.model.entity.Book;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Naeem(naeemark@gmail.com)
 * On 13/11/2017.
 * For eBlink
 */

@Singleton
public class BookRepository {

    private static final String BOOKS_JSON_FILE = "books.json";
    private Context mContext;

    @Inject
    public BookRepository(Context context) {
        mContext = context;
    }

    public Book[] getBooks() {
        String fileContent = readFile(BOOKS_JSON_FILE);
        return new Gson().fromJson(fileContent, Book[].class);
    }

    private String readFile(String path) {
        String json = null;
        try {
            InputStream is = mContext.getAssets().open(path);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

}
