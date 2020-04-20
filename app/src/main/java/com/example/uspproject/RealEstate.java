package com.example.uspproject;

import java.util.Objects;

public class RealEstate {

    private String adress;
    private String roomNumber;
    private String status;
    private String exposure;
    private String price;

    public RealEstate(RealEstate realEstate) {
        this.adress=realEstate.getAdress();
        this.roomNumber=realEstate.getRoomNumber();
        this.status= realEstate.getStatus();
        this.price=realEstate.getPrice();
        this.exposure=realEstate.getExposure();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RealEstate that = (RealEstate) o;
        return roomNumber == that.roomNumber &&
                Objects.equals(adress, that.adress) &&
                Objects.equals(status, that.status) &&
                Objects.equals(exposure, that.exposure)&&
                Objects.equals(price,that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adress, roomNumber, status, exposure,price);
    }


    public RealEstate(String adress, String roomNumber, String status, String exposure, String price) {
        this.adress = adress;
        this.roomNumber = roomNumber;
        this.status = status;
        this.exposure = exposure;
        this.price = price;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExposure() {
        return exposure;
    }

    public void setExposure(String exposure) {
        this.exposure = exposure;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }




}
