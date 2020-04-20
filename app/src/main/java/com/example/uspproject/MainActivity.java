package com.example.uspproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements AddRealEstateListener,SearchRealEstate {
    private RealEstateAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);

        this.adapter = new RealEstateAdapter(RealEstateSource.getRealEstates());


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


       FloatingActionButton fab = findViewById(R.id.addRealEstate);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
                AddRealEstate blankFragment = AddRealEstate.newInstance();
                blankFragment.show(fm,"fragment_add_real_estate");
            }
        });

       FloatingActionButton fab2 = findViewById(R.id.searchRealEstate);
       fab2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

                FragmentManager fm = getSupportFragmentManager();
               SearchFragment blankFragment = SearchFragment.newInstance();
               blankFragment.show(fm,"search");
            }
        });


    }

    public void finishAdd(RealEstate realEstate) {
        this.adapter.addContact(realEstate);
    }



    @Override
    public void searchRealEstate(String adress, String roomNumber, String price) {
        String endResult="";
        ArrayList<RealEstate>myEstates = adapter.searchEstates(adress,roomNumber,price);
        for(int i=0;i<myEstates.size();i++)
        {
            endResult+=myEstates.get(i).getAdress().toString()+" "+myEstates.get(i).getRoomNumber().toString()+" "+
                    myEstates.get(i).getPrice().toString()+" "+myEstates.get(i).getExposure()+" "+myEstates.get(i).getStatus()+"\n";
        }
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, endResult, duration);
        toast.show();



    }
    }

