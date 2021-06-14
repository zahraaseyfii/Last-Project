package com.example.lastproject;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;


public class Item2Fragment extends Fragment {


    public Item2Fragment() {
    }
    FirebaseFirestore database2;
    Button button3,button4;
    EditText editText6,editText7,editText8,editText9,editText10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button3=button3.findViewById(R.id.button11);
        button4=button4.findViewById(R.id.button12);

        editText6=editText6.findViewById(R.id.editText8);
        editText7=editText7.findViewById(R.id.editText10);
        editText8=editText8.findViewById(R.id.editText12);
        editText9=editText9.findViewById(R.id.editText13);
        editText10=editText10.findViewById(R.id.editText14);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mablagh,daste,hesab,date,note;
                mablagh=editText6.getText().toString();
                daste=editText7.getText().toString();
                hesab=editText8.getText().toString();
                date=editText9.getText().toString();
                note=editText10.getText().toString();


                //----------------------------------
                final Cost cost=new Cost();
                cost.setMablagh(mablagh);
                cost.setDaste(daste);
                cost.setHesab(hesab);
                cost.setDate(date);
                cost.setNote(note);
                database2.collection("Incomes");
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item2, container, false);
    }
}