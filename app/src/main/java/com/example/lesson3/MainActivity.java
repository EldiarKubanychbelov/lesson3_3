package com.example.lesson3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnShowBottonSheet;
    private BottomNavigationView bottomNavigationView;
    private  ViewPagerAdapter pagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowBottonSheet = findViewById(R.id.btn_show_botton_sheet);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        initViewPager();

        btnShowBottonSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog dialog = new BottomSheetDialog();
                dialog.show(getSupportFragmentManager(),"BottomSheet");
            }
        });




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();

                switch (item.getItemId()) {
                    case R.id.item_home:
                        manager.beginTransaction()

                                .replace(R.id.container_main, HomeFragment.newInstance("Value 1", " Value 2 "))
                                .commit();
                        break;
                    case R.id.item_camera:
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivity(intent);
                        break;
                    case R.id.item_profile:
                        manager.beginTransaction()
                                .replace(R.id.container_main, ProfileFragment.newInstance("Value 1", " Value 2 "))
                                .commit();
                        break;
                }return false;
            }
                });



    }

    private void initViewPager() {
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }

}