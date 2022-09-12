package ru.tfomsrm.tfoms.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NasEnt {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    private String filename;
    private String date;
    private Integer status;

    public NasEnt() {
    }

    public NasEnt(User user) {
        this.author = user;
        this.date = new Date().toString();
        this.status = 0;
    }

    public String getDate() {
        return date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
