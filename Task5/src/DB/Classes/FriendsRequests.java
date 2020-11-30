package DB.Classes;

import java.sql.Date;

public class FriendsRequests {
    private Long id;
    private User user;
    private User request_sender;
    private java.sql.Date sent_time;

    public FriendsRequests() {}

    public FriendsRequests(User user, User request_sender, Date sent_time) {
        this.user = user;
        this.request_sender = request_sender;
        this.sent_time = sent_time;
    }

    public FriendsRequests(Long id, User user, User request_sender, Date sent_time) {
        this.id = id;
        this.user = user;
        this.request_sender = request_sender;
        this.sent_time = sent_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getRequest_sender() {
        return request_sender;
    }

    public void setRequest_sender(User request_sender) {
        this.request_sender = request_sender;
    }

    public Date getSent_time() {
        return sent_time;
    }

    public void setSent_time(Date sent_time) {
        this.sent_time = sent_time;
    }
}
