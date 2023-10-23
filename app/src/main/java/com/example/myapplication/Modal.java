package com.example.myapplication;

public class Modal {
    private String Date;
    private String Details;
    private int Ammount;

    public Modal(String date, String details, int ammount) {
        Date = date;
        Details = details;
        Ammount = ammount;
    }

    public Modal(String string) {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public int getAmmount() {
        return Ammount;
    }

    public void setAmmount(int ammount) {
        Ammount = ammount;
    }
}
