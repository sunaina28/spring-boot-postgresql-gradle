package com.example.demo;

import java.util.Date;

public class ErrorDetails {

    private Date timeStamp;

    private String mesage;

    private  String details;

    public ErrorDetails(Date timeStamp, String mesage, String details) {
        this.timeStamp = timeStamp;
        this.mesage = mesage;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
