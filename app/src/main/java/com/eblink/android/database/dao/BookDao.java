package com.eblink.android.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.eblink.android.model.entity.Book;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Implementation of CRUD for the entity
 *
 * Created by Naeem(naeemark@gmail.com)
 * On 12/11/2017.
 * For eBlink
 */

@Dao
public interface BookDao {

    @Query("SELECT * FROM books")
    List<Book> retrieveAll();

    @Query("SELECT COUNT(*) from books")
    Flowable<Integer> getCount();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Book... books);

    @Delete
    void delete(Book book);

    @Query("SELECT * from books LIMIT 1")
    Flowable<Book> retrieveBook();
}
