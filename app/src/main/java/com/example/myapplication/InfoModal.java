package com.example.myapplication;

public class InfoModal {
    String date;
    String Details;
    String Ammount;

    public InfoModal(String date, String details, String ammount) {
        this.date = date;
        Details = details;
        Ammount = ammount;
    }

    public String getDate() {
        return date;
    }

    public String getDetails() {
        return Details;
    }

    public String getAmmount() {
        return Ammount;
    }
}
