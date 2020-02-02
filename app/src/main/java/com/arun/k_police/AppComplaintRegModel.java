package com.arun.k_police;

public class AppComplaintRegModel {
    public String name,email,phone,complaint,description;

    public AppComplaintRegModel() {
    }

    public AppComplaintRegModel(String name, String email, String phone, String complaint, String description) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.complaint = complaint;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
