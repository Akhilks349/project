package com.arun.k_police;

public class LawModel {
    public String section,law;

    public LawModel() {
    }

    public LawModel(String section, String law) {
        this.section = section;
        this.law = law;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }
}
