package com.example.lastproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText editText1,editText2;
    Button button1,button2;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        database=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();
        editText1=findViewById(R.id.editText4);
        editText2=findViewById(R.id.editText5);
        button1=findViewById(R.id.button4);
        button2=findViewById(R.id.button6);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignActivity.this,LoginActivity.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass;
                email=editText1.getText().toString();
                pass=editText2.getText().toString();

                final User user=new User();
                user.setEmail(email);
                user.setPass(pass);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            database.collection("Users").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(SignActivity.this,LoginActivity.class));
                                }
                            });
                            Toast.makeText(SignActivity.this,"Your Account is Created :)" ,Toast.LENGTH_SHORT ).show();
                        }
                        else{
                            Toast.makeText(SignActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT ).show();
                        }
                    }
                });
            }
        });
    }
}
