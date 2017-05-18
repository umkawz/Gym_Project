package com.example.leshka.schedule_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.leshka.schedule_2.Adapter.TabsFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private static final int LAYOUT = R.layout.activity_main;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    //private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationViev();
        initTab();

    }

    private void initToolbar() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }

    private void initTab() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initNavigationViev() {
        drawerLayout=(DrawerLayout) findViewById(R.id.DrawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_notification_open, R.string.view_notification_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItemId) {
                drawerLayout.closeDrawers();
                switch(menuItemId.getItemId()){
                    case R.id.actionNotificationItem:
                        showNotificationTab();

                }


                return true;
            }
        });

    }

    private void showNotificationTab(){
        viewPager.setCurrentItem(Constants.TAB_TWO);
    }
}
