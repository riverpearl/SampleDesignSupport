package com.tacademy.sampledesignsupport;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fr = MessageFragment.newInstance(tab.getText().toString());
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fr, (String)tab.getTag())
                        .commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == null) return;

                String tag = (String)tab.getTag();
                Fragment fr = MessageFragment.newInstance(tag);

                if (fr != null) {
                    getSupportFragmentManager().beginTransaction()
                            .detach(fr).commit();
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                String tag = (String)tab.getTag();
                Fragment fr = getSupportFragmentManager().findFragmentByTag(tag);

                if (fr != null) {
                    getSupportFragmentManager().beginTransaction()
                            .attach(fr).commit();
                }
            }
        });

        for (int i = 0; i < 10; i++)
            tabs.addTab(tabs.newTab().setText("TAB" + i).setTag("tab" + i));
    }
}
