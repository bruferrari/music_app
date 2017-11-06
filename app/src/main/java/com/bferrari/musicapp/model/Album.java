package com.bferrari.musicapp.model;

import java.io.Serializable;

/**
 * Created by bferrari on 06/11/17.
 */

public class Album implements Serializable {

    private String title;
    private String author;
    private String coverUrl;

    public Album(String title, String author, String coverUrl) {
        this.title = title;
        this.author = author;
        this.coverUrl = coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}
