package com.example.dentistapp.model;

public class DateInfo {
    private long date;
    private String dateType;

    public DateInfo(long date, String dateType) {
        this.date = date;
        this.dateType = dateType;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }
}
