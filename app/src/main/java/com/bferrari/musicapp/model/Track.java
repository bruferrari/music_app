package com.bferrari.musicapp.model;

import java.io.Serializable;

/**
 * Created by bferrari on 06/11/17.
 */

public class Track implements Serializable {

    private int id;
    private String name;
    private Album album;

    public Track(int id, String name, Album album) {
        this.id = id;
        this.name = name;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum() {
        return album;
    }
}
