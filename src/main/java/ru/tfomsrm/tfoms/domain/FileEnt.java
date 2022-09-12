package ru.tfomsrm.tfoms.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FileEnt {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;
    private String filename;
    private String date;
    private Integer status;

    public FileEnt() {
    }

    public FileEnt(User user) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
