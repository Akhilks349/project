package com.arun.k_police;

public class AdvocateRegModel {

    public String name,court,designation,concat,userName,password;

    public AdvocateRegModel() {
    }

    public AdvocateRegModel(String name, String court, String designation, String concat, String userName, String password) {
        this.name = name;
        this.court = court;
        this.designation = designation;
        this.concat = concat;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getConcat() {
        return concat;
    }

    public void setConcat(String concat) {
        this.concat = concat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
