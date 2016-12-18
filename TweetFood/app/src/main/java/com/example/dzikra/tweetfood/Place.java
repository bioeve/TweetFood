package com.example.dzikra.tweetfood;

/**
 * Created by Dzikra on 30/11/2016.
 */

public class Place {
    private String tPlaceName;
    private String tPlaceType;
    private String tPriceRate;
    private String tOpenHour;
    private String tClosingHour;
    private String address;
    private int tImage;

    public Place(String PlaceName, String PlaceType, int image) {
        this.tPlaceName = PlaceName;
        this.tPlaceType = PlaceType;
        this.tImage = image;
    }

    public Place(String PlaceName, String PlaceType, String PriceRate, String OpenHour, String ClosingHour, String address, int image) {
        this.tPlaceName = PlaceName;
        this.tPlaceType = PlaceType;
        this.tPriceRate = PriceRate;
        this.tOpenHour = OpenHour;
        this.tClosingHour = ClosingHour;
        this.address = address;
        this.tImage = image;
    }

    public String gettPlaceName() {
        return tPlaceName;
    }

    public void settPlaceName(String tPlaceName) {
        this.tPlaceName = tPlaceName;
    }

    public String gettPriceRate() {
        return tPriceRate;
    }

    public void settPriceRate(String tPriceRate) {
        this.tPriceRate = tPriceRate;
    }

    public String gettClosingHour() {
        return tClosingHour;
    }

    public void settClosingHour(String tClosingHour) {
        this.tClosingHour = tClosingHour;
    }

    public String gettPlaceType() {
        return tPlaceType;
    }

    public void settPlaceType(String tPlaceType) {
        this.tPlaceType = tPlaceType;
    }

    public String gettOpenHour() {
        return tOpenHour;
    }

    public void settOpenHour(String tOpenHour) {
        this.tOpenHour = tOpenHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return tImage;
    }

    public void setImage(int image) {
        this.tImage = image;
    }
}
