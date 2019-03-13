package de.lette.models;

import java.util.Date;

public class Request {

    private RequestNumber requestNumber;
    private String description;
    private Date date;

    public RequestNumber getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(RequestNumber requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
