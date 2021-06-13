package com.example.lastproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        BottomNavigationView btnNav=findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout,new Item1Fragment()).commit();




    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.Item1:
                            selectedFragment =new Item1Fragment();
                            break;

                        case  R.id.Item2:
                            selectedFragment =new Item2Fragment();
                            break;

                        case R.id.Item3:
                            selectedFragment =new Item3Fragment();
                            break;

                        case R.id.Item4:
                            selectedFragment =new Item4Fragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout
                            ,selectedFragment).commit();

                    return true;

                }
            };
}
