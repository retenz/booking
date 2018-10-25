/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gis.booking.app.entities;

/**
 *
 * @author Tenadze
 */
public class Place {
    private String cinema;
    private String hall;
    private String row;
    private String sit1;
    private String sit2;
    private String sit3;
    private String sit4;
    private String sit5;
    private String sit6;

    public Place(String cinema, String hall, String row, String sit1, String sit2, String sit3, String sit4, String sit5, String sit6) {
        this.cinema = cinema;
        this.hall = hall;
        this.row = row;
        this.sit1 = sit1;
        this.sit2 = sit2;
        this.sit3 = sit3;
        this.sit4 = sit4;
        this.sit5 = sit5;
        this.sit6 = sit6;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }
    
    public String getSit1() {
        return sit1;
    }

    public void setSit1(String sit1) {
        this.sit1 = sit1;
    }

    public String getSit2() {
        return sit2;
    }

    public void setSit2(String sit2) {
        this.sit2 = sit2;
    }

    public String getSit3() {
        return sit3;
    }

    public void setSit3(String sit3) {
        this.sit3 = sit3;
    }

    public String getSit4() {
        return sit4;
    }

    public void setSit4(String sit4) {
        this.sit4 = sit4;
    }

    public String getSit5() {
        return sit5;
    }

    public void setSit5(String sit5) {
        this.sit5 = sit5;
    }

    public String getSit6() {
        return sit6;
    }

    public void setSit6(String sit6) {
        this.sit6 = sit6;
    }
@Override
    public String toString() {
        return "Place{" + "cinema=" + cinema + ", hall=" + hall + ", row=" + row + ", sit1=" + sit1 + ", sit2=" + sit2 + ", sit3=" + sit3 + ", sit4=" + sit4 + ", sit5=" + sit5 + ", sit6=" + sit6 + '}';
    }

    
    
}
