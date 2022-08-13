package com.example.uas_akb_if2_10119081;
/**
 * Nama :Muhammad Elza Abiezal
 * Kelas : IF2
 * NIM :10119081
 * Email : elza.10119081@mahasiswa.unikom.ac.id
 * **/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.uas_akb_if2_10119081.note.FragmentNote;
import com.example.uas_akb_if2_10119081.ui.AboutFragment;
import com.example.uas_akb_if2_10119081.ui.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize fragment
//        Fragment fragment = new MyLocationFragment();
//
//        //open Fragment
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_container,fragment)
//                .commit();

        bottomnavigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentNote()).commit();
        bottomnavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        selectedFragment = new FragmentNote();
                        break;
                    case R.id.profile:
                        selectedFragment = new ProfileFragment();
                        break;
                    case R.id.about:
                        selectedFragment = new AboutFragment();
                        break;

                    case R.id.logout:
                        selectedFragment = new LogoutActivity();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });


    }
}