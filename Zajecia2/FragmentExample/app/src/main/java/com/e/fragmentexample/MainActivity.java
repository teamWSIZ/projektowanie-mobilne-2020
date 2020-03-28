package com.e.fragmentexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    class MyFragmentAdapter extends FragmentStatePagerAdapter{

        public MyFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new BlankFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<androidx.viewpager.widget.ViewPager/>

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
    }
}
