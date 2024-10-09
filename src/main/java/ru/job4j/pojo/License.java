package ru.job4j.pojo;

import java.util.Date;

public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    public String getOwner() {
        return owner;
    }

    public String getModel() {
        return model;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCode() {
        return code;
    }

    public Date getCreated() {
        return created;
    }
}
