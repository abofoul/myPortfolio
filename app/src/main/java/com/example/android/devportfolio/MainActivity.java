package com.example.android.devportfolio;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.devportfolio.controller.DevPagerAdapter;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create instance of the Adapter
        DevPagerAdapter devPagerAdapter = new DevPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);

        //set the adapter to the view pager
        viewPager.setAdapter(devPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabTextColors(Color.YELLOW , Color.parseColor("white"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //attach each fragment to the tab layout
        tabLayout.setupWithViewPager(viewPager);

        TextView textView = findViewById(R.id.get_in_touch);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:01020220883"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Log.e("Error","NO call ");
                    return;
                }
                startActivity(phoneIntent);
            }
        });
    }
}
