package ru.tfomsrm.tfoms.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String message;
    private String date;

    public LogEntity() {
        this.date = new Date().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
