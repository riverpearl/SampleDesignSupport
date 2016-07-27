package com.tacademy.sampledesignsupport;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabPagerActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;
    MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_pager);

        tabs = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(mAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // 액티비티에서 프래그먼트 별 타이틀 세팅할 때는 여기서!
            @Override
            public void onPageSelected(int position) {
                setTitle("pager : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabs.setupWithViewPager(pager);
        tabs.removeAllTabs();

        for (int i = 0; i < 10; i++)
            tabs.addTab(tabs.newTab().setText("TT" + i).setTag("tt" + i));
    }
}
