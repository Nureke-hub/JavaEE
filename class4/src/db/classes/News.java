package db.classes;

import java.sql.Date;

public class News {
    private Long id;
    private String title;
    private String short_content;
    private String content;
    private Date post_date;
    private String picture_url;
    private Languages language;
    private Publications publication;

    public News() {
    }

    public News(Long id, String title, String short_content, String content, Date post_date, String picture_url, Languages language, Publications publication) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.picture_url = picture_url;
        this.language = language;
        this.publication = publication;
    }

    public News(String title, String short_content, String content, String picture_url, Languages language, Publications publication) {
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.picture_url = picture_url;
        this.language = language;
        this.publication = publication;
    }

    public News(Long id, String title, String short_content, String content, Date post_date, String picture_url) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.picture_url = picture_url;
    }

    public News(String title, String short_content, String content, String picture_url) {
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.picture_url = picture_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_content() {
        return short_content;
    }

    public void setShort_content(String short_content) {
        this.short_content = short_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public Publications getPublication() {
        return publication;
    }

    public void setPublication(Publications publication) {
        this.publication = publication;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", short_content='" + short_content + '\'' +
                ", content='" + content + '\'' +
                ", post_date=" + post_date +
                ", picture_url='" + picture_url + '\'' +
                ", language=" + language +
                ", publication=" + publication +
                '}';
    }
}
