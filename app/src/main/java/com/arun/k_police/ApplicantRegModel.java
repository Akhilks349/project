package com.arun.k_police;

public class ApplicantRegModel {
    public String name,address,dob,mob,email,password;

    public ApplicantRegModel() {
    }

    public ApplicantRegModel(String name, String address, String dob, String mob, String email, String password) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.mob = mob;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
