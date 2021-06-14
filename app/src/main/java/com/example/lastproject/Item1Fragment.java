package com.example.lastproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class Item1Fragment extends Fragment {


    public Item1Fragment() {
    }
    FirebaseFirestore database1;
    Button button,button1;
    EditText editText1,editText2,editText3,editText4,editText5;

    DatabaseReference reference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database1=FirebaseFirestore.getInstance();
        button= (button).findViewById(R.id.button7);
        button1= (button1).findViewById(R.id.button8);


        editText1=editText1.findViewById(R.id.editText3);
        editText2=editText2.findViewById(R.id.editText6);
        editText3=editText3.findViewById(R.id.editText7);
        editText4=editText4.findViewById(R.id.editText9);
        editText5=editText5.findViewById(R.id.editText11);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mablagh,daste,hesab,date,note;
                mablagh=editText1.getText().toString();
                daste=editText2.getText().toString();
                hesab=editText3.getText().toString();
                date=editText4.getText().toString();
                note=editText5.getText().toString();


                //----------------------------------
                final Cost cost=new Cost();
                cost.setMablagh(mablagh);
                cost.setDaste(daste);
                cost.setHesab(hesab);
                cost.setDate(date);
                cost.setNote(note);
                database1.collection("Costs");
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item1, container, false);


    }
}
