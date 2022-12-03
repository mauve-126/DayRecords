package com.example.dayrecords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout main_home;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        SettingListener();

        bottomNavigationView.setSelectedItemId(R.id.tab_calendar);
    }

    private void init() {
        main_home = findViewById(R.id.main_home);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
    }

    private void SettingListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new TabSelectedListener());
    }

    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.tab_calendar: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_home, new CalendarFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_list: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_home, new ListFragment())
                            .commit();
                    return true;
                }
                case R.id.tab_user: {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_home, new UserFragment())
                            .commit();
                    return true;
                }
            }

            return false;
        }
    }
}