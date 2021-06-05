package com.example.test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class photos extends BaseAdapter {

    /*private String thumbnail_URL;
    private String photo_URL;

    public photos(String thumbnail_URL, String photo_URL) {
        this.thumbnail_URL = thumbnail_URL;
        this.photo_URL = photo_URL;
    }

    public String getThumbnail_URL() {
        return thumbnail_URL;
    }

    public void setThumbnail_URL(String thumbnail_URL) {
        this.thumbnail_URL = thumbnail_URL;
    }

    public String getPhoto_URL() {
        return photo_URL;
    }

    public void setPhoto_URL(String photo_URL) {
        this.photo_URL = photo_URL;
    }

    @Override
    public String toString() {
        return "photos{" +
                "thumbnail_URL='" + thumbnail_URL + '\'' +
                ", photo_URL='" + photo_URL + '\'' +
                '}';
    }*/

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public photos(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public String toString() {
        return "photos{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
