package com.arun.k_police;

public class LisenseModel {

    public String name,purpose,email,description;

    public LisenseModel() {
    }

    public LisenseModel(String name, String purpose, String email, String description) {
        this.name = name;
        this.purpose = purpose;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
