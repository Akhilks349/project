package com.arun.k_police;

public class CrminalModel {

    public String name,description,crime,date;

    public CrminalModel() {
    }

    public CrminalModel(String name, String description, String crime, String date) {
        this.name = name;
        this.description = description;
        this.crime = crime;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
