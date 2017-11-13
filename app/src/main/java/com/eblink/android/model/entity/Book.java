package com.eblink.android.model.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "books")
public class Book implements Serializable {

    @PrimaryKey
    private long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "author_name")
    private String authorName;

    @ColumnInfo(name = "author_code")
    private String authorCode;

    @ColumnInfo(name = "isbn")
    private String isbn;

    @ColumnInfo(name = "entry_date")
    private String entryDate;

    @ColumnInfo(name = "rating")
    private double rating;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "cover_url")
    private String coverUrl;


    public Book(long id, String title, String authorName, String authorCode, String isbn, String entryDate, double rating, String language, String coverUrl) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.authorCode = authorCode;
        this.isbn = isbn;
        this.entryDate = entryDate;
        this.rating = rating;
        this.language = language;
        this.coverUrl = coverUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorCode() {
        return authorCode;
    }

    public void setAuthorCode(String authorCode) {
        this.authorCode = authorCode;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorCode='" + authorCode + '\'' +
                ", isbn='" + isbn + '\'' +
                ", entryDate='" + entryDate + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                '}';
    }
}
