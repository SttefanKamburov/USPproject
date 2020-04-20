package com.example.uspproject;

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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddRealEstate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddRealEstate extends DialogFragment implements View.OnClickListener {
    private EditText adress;
    private EditText roomNumber;
    private EditText exposure;
    private EditText status;
    private EditText price;
    private Button addButton;
    private AddRealEstateListener AddRealEstateListener;


    public AddRealEstate() {
        // Required empty public constructor
    }

    public static AddRealEstate newInstance (){return new AddRealEstate();}


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_real_estate,container,false);
    }

public void onViewCreated(View view,Bundle savedInstanceState){
    super.onViewCreated(view,savedInstanceState);
    adress=view.findViewById(R.id.adressEditText);
    roomNumber=view.findViewById(R.id.roomNumberEditText);
    exposure=view.findViewById(R.id.roomNumberEditText);
    status=view.findViewById(R.id.statusEditText);
    price=view.findViewById(R.id.priceEditText);
    addButton=view.findViewById(R.id.button);
    addButton.setOnClickListener((View.OnClickListener) this);
    adress.requestFocus();
    getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

}

public void onAttach(Context context){
super.onAttach(context);
AddRealEstateListener=(AddRealEstateListener) context;
}

    public void onClick(View view) {
        RealEstate contact = new RealEstate(
                adress.getText().toString(), roomNumber.getText().toString(), status.getText().toString(),
                exposure.getText().toString(),price.getText().toString()
        );
        AddRealEstateListener.finishAdd(contact);
        dismiss();

    }


}
