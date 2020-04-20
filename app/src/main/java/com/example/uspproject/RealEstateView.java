package com.example.uspproject;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RealEstateView extends RecyclerView.ViewHolder {
    private TextView adress;
    private TextView roomNumber;
    private TextView status;
    private TextView exposure;
    private TextView price;

    public RealEstateView(View itemView){
        super(itemView);
        adress=itemView.findViewById(R.id.adressTextView);
        roomNumber=itemView.findViewById(R.id.roomNumberTextView);
        status=itemView.findViewById(R.id.statusTextView);
        exposure=itemView.findViewById(R.id.exposureTextView);
        price=itemView.findViewById(R.id.priceTextView);

    }

    public void setAdress(String adress) {
        this.adress.setText("Adress : "+adress);
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber.setText("Number of rooms : "+roomNumber);
    }
    public void setStatus(String status) {
        this.status.setText("For sale/rent : "+status);
    }
    public void setExposure(String exposure) {
        this.exposure.setText("Exposure : "+exposure);
    }
    public void setPrice(String price) {
        this.price.setText("Price in lev "+price);
    }
}
