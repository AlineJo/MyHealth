package com.example.myhealth.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myhealth.R;
import com.example.myhealth.fragments.AdminHomeFragment;
import com.example.myhealth.fragments.AdminSearchFragment;
import com.example.myhealth.fragments.ChallengeFragment;
import com.example.myhealth.fragments.Goals;
import com.example.myhealth.fragments.GoalsControlFragment;
import com.example.myhealth.fragments.GoalsFragment;
import com.example.myhealth.fragments.LifeStyleFragment;
import com.example.myhealth.fragments.PActivityFragment;
import com.example.myhealth.fragments.SportActivitiesFragment;
import com.google.android.material.navigation.NavigationView;

public class SideMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        changeFragmentTo(new LifeStyleFragment(), LifeStyleFragment.class.getSimpleName());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.profile:
                Toast.makeText(SideMenuActivity.this, "الملف الشخصي", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                PActivityFragment fragment = new PActivityFragment();
                fragment.setMsg("Hello!!!!");
                changeFragmentTo(fragment, PActivityFragment.class.getSimpleName());

                break;
            case R.id.lifestyle:
                Toast.makeText(SideMenuActivity.this, "قيم صحتك", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity:
                Toast.makeText(SideMenuActivity.this, "الانشطة الرياضية", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                changeFragmentTo(new SportActivitiesFragment(), SportActivitiesFragment.class.getSimpleName());

                break;
            case R.id.food:
                Toast.makeText(SideMenuActivity.this, "الوجبات", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                changeFragmentTo(new GoalsControlFragment(), GoalsControlFragment.class.getSimpleName());
                break;
            case R.id.goal:
                Toast.makeText(SideMenuActivity.this, "الاهداف", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                changeFragmentTo(new GoalsFragment(), GoalsFragment.class.getSimpleName());

                break;
            case R.id.challenge:
                Toast.makeText(SideMenuActivity.this, "التحدي", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                changeFragmentTo(new ChallengeFragment(), ChallengeFragment.class.getSimpleName());
                break;
            case R.id.logout:
                Toast.makeText(SideMenuActivity.this, "الخروج", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return false;
    }


    public void changeFragmentTo(Fragment fragmentToLoad, String fragmentTag) {
        if (getSupportFragmentManager().findFragmentByTag(fragmentTag) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fl_container, fragmentToLoad, fragmentTag)
                    .addToBackStack(fragmentTag)
                    .commit();

        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.fl_container, fragmentToLoad, fragmentTag)
                    .commit();
        }
    }

   /* void fun(){
        Intent intent = new Intent(this,SideMenuActivity.class);
        finish();
        startActivity(intent);
    }*/

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }
}
