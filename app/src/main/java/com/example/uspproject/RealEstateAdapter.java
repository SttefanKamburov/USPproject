package com.example.uspproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RealEstateAdapter extends RecyclerView.Adapter<RealEstateView> {
    private ArrayList<RealEstate> realEstates;

    public RealEstateAdapter(ArrayList<RealEstate> realEstates) {
        this.realEstates = realEstates;
    }

    public RealEstateView onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.card_view, parent, false);
        return new RealEstateView(contactView);
    }

    public void onBindViewHolder(RealEstateView holder, int position) {
        final RealEstate estate = realEstates.get(position);
        holder.setAdress(estate.getAdress());
        holder.setExposure(estate.getExposure());
        holder.setPrice(estate.getPrice());
        holder.setStatus(estate.getStatus());
        holder.setRoomNumber(estate.getRoomNumber());

    }

    public ArrayList<RealEstate> getRealEstates(){return this.realEstates;}

    public int getItemCount() {
        return realEstates.size();
    }

    public void addContact(RealEstate realEstate) {
        this.realEstates.add(new RealEstate(realEstate));
        notifyItemChanged(this.realEstates.size() - 1);
    }

    public ArrayList<RealEstate> searchEstates(String adress,String roomNumber,String price)
    {
        ArrayList<RealEstate>searchedEstates = new ArrayList<>();
        for(int i=0;i<getItemCount();i++)
        {
            if(realEstates.get(i).getAdress().equals(adress) && realEstates.get(i).getRoomNumber().equals(roomNumber) && realEstates.get(i).getPrice().equals(price)) {
                searchedEstates.add(realEstates.get(i));
            }
        }
        return  searchedEstates;
    }
}




