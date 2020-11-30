package DB.Classes;

import java.sql.Date;

public class Post {
    private Long id;
    private String title;
    private String short_content;
    private String content;
    private java.sql.Date post_date;
    private User user;

    public Post() {
    }

    public Post(String title, String short_content, String content, Date post_date, User user) {
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.user = user;
    }

    public Post(String title, String short_content, String content, User user) {
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.user = user;
    }

    public Post(Long id, String title, String short_content, String content, Date post_date, User user) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
        this.user = user;
    }

    public Post(Long id, String title, String short_content, String content, Date post_date) {
        this.id = id;
        this.title = title;
        this.short_content = short_content;
        this.content = content;
        this.post_date = post_date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
