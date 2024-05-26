package com.example.civilclass;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragments.FragmentFraud;
import fragments.FragmentMain;
import fragments.FragmentMy;

public class ZYMActivity extends AppCompatActivity {

    private ViewPager myViewPager;
    private BottomNavigationView myBottom;

    private Fragment[] fragments = {new FragmentMain(), new FragmentFraud(), new FragmentMy() };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z_y_m);
        initView();
        Resources resources = getResources();
        ColorStateList csl = resources.getColorStateList(R.drawable.bottom_btn_selected_cplor);
        myBottom.setItemTextColor(csl);

    }


    private void initView() {
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        myBottom = (BottomNavigationView) findViewById(R.id.myBottom);

        myViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });

        myBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch ( menuItem.getItemId() ){
                    case R.id.navigation_home:
                        myViewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_smart:
                        myViewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_my:
                        myViewPager.setCurrentItem(2);
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });

        myBottom.setItemIconTintList(null);

        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                myBottom.getMenu().getItem( position ).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}