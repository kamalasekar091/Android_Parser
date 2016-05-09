package com.example.logintrail.parser;

import android.util.Log;

import java.util.ArrayList;

/**
 *  This class contains all getter and setter methods to set and retrieve data.
 *
 **/
public class XMLGettersSetters {

    //The attributes are been declared over here.
    private ArrayList<String> title = new ArrayList<String>();
    private ArrayList<String> artist = new ArrayList<String>();
    private ArrayList<String> country = new ArrayList<String>();
    private ArrayList<String> company = new ArrayList<String>();
    private ArrayList<String> price = new ArrayList<String>();
    private ArrayList<String> year = new ArrayList<String>();
    private ArrayList<String> CD = new ArrayList<String>();

    /**
     * Getter setter for CD
     * @return
     */
    public ArrayList<String> getCD() {
        return CD;
    }

    public void setAttribute(String attr) {
        this.CD.add(attr);
        Log.i("Sold out?: ", attr);
    }

    /**
     * Getter setter for Company
     * @return
     */
    public ArrayList<String> getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company.add(company);
        Log.i("This is the company:", company);
    }

    /**
     * Getter setter for Price
     * @return
     */
    public ArrayList<String> getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price.add(price);
        Log.i("This is the price:", price);
    }

    /**
     * Getter setter for Year
     * @return
     */
    public ArrayList<String> getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year.add(year);
        Log.i("This is the year:", year);
    }

    /**
     * Getter setter for Title
     * @return
     */
    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.add(title);
        Log.i("This is the title:", title);
    }

    /**
     * Getter setter for Artist
     * @return
     */
    public ArrayList<String> getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.add(artist);
        Log.i("This is the artist:", artist);
    }

    /**
     * Getter setter for Contry
     * @return
     */
    public ArrayList<String> getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country.add(country);
        Log.i("This is the country:", country);
    }

}
