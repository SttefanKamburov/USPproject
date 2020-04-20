package com.example.uspproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class SearchFragment extends DialogFragment implements View.OnClickListener {
    private EditText adress;
    private EditText roomNumber;
    private EditText price;
    private String endResult;
    private Button searchButton;
    private SearchRealEstate SearchRealEstate;
    ArrayList<RealEstate>myEstates;


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance (){return new SearchFragment();}


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search,container,false);
    }

    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        adress=view.findViewById(R.id.searchAdress);
        roomNumber=view.findViewById(R.id.searchRoom);
        price=view.findViewById(R.id.searchPrice);
        searchButton=view.findViewById(R.id.Search);
        searchButton.setOnClickListener((View.OnClickListener) this);
        adress.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    }

    public void onAttach(Context context){
        super.onAttach(context);
        SearchRealEstate=(SearchRealEstate) context;
    }

    public void onClick(View view) {
       SearchRealEstate.searchRealEstate(adress.getText().toString(),roomNumber.getText().toString(),price.getText().toString());

        dismiss();
    }


}
