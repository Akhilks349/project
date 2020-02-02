package com.arun.k_police;

public class FirModel {

    public String id,name,place,distance,direction,date,section,witness,witDescr;

    public FirModel() {
    }

    public FirModel(String id, String name, String place, String distance, String direction, String date, String section, String witness, String witDescr) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.distance = distance;
        this.direction = direction;
        this.date = date;
        this.section = section;
        this.witness = witness;
        this.witDescr = witDescr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public String getWitDescr() {
        return witDescr;
    }

    public void setWitDescr(String witDescr) {
        this.witDescr = witDescr;
    }
}
