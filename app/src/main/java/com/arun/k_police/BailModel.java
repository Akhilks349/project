package com.arun.k_police;

public class BailModel {
    public String name,address,mobno,caseno,warrentno;

    public BailModel() {
    }

    public BailModel(String name, String address, String mobno, String caseno, String warrentno) {
        this.name = name;
        this.address = address;
        this.mobno = mobno;
        this.caseno = caseno;
        this.warrentno = warrentno;
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

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public String getCaseno() {
        return caseno;
    }

    public void setCaseno(String caseno) {
        this.caseno = caseno;
    }

    public String getWarrentno() {
        return warrentno;
    }

    public void setWarrentno(String warrentno) {
        this.warrentno = warrentno;
    }
}
