package com.example.uspproject;

import java.util.ArrayList;

public class RealEstateSource {
    private static ArrayList<RealEstate> realEstates;

    static {
        realEstates=new ArrayList<RealEstate>();
        realEstates.add(new RealEstate("Varna","3","rent","west","70000"));
        realEstates.add(new RealEstate("Burgas","4","sale","east","75000"));
        realEstates.add(new RealEstate("Plovdiv","7","rent","south","66666"));
    }

    public static ArrayList<RealEstate> getRealEstates(){return realEstates;}

}
