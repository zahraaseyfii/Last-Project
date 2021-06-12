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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText editText1,editText2;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

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

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
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
