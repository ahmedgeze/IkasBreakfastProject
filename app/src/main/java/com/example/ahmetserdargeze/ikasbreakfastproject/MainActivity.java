package com.example.ahmetserdargeze.ikasbreakfastproject;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.MatrixCursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    TextView name,mail;
    FrameLayout fl;
    String token;

    List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu> newList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);





        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View username=navigationView.getHeaderView(0);
        View email=navigationView.getHeaderView(0);

        name=(TextView) username.findViewById(R.id.namesurname_tv);
        mail=(TextView) email.findViewById(R.id.mail_tv);

        name.setText(getIntent().getStringExtra("name"));
        mail.setText(getIntent().getStringExtra("email"));
        token=getIntent().getStringExtra("token");
        fl=(FrameLayout) findViewById(R.id.main_fl);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item=menu.findItem(R.id.menu_search);
        SearchView searchView=(SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                newList.clear();
                for (int i=0;i<FoodFragment.dataset.size();i++){
                    if(FoodFragment.dataset.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                        newList.add(FoodFragment.dataset.get(i));
                    }


                }

//                System.out.println("aranan:"+newText+newList.get(0).getName());
                for (int j=0;j<newList.size();j++){

                    Toast.makeText(getApplicationContext(),newList.get(j).getName()+"BULUNDU",Toast.LENGTH_SHORT).show();

                }
                if (newList.size()<0)
                    Toast.makeText(getApplicationContext(),query+" BULUNAMADI",Toast.LENGTH_SHORT).show();



                return true;



            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                List<com.example.ahmetserdargeze.ikasbreakfastproject.model.menu.Menu> newList=new ArrayList<>();
//                for (int i=0;i<FoodFragment.dataset.size();i++){
//                    if(FoodFragment.dataset.get(i).getName().toLowerCase().contains(newText.toLowerCase())){
//                        newList.add(FoodFragment.dataset.get(i));
//                    }
//
//                }
//
////                System.out.println("aranan:"+newText+newList.get(0).getName());
//                for (int j=0;j<newList.size();j++)
//                    Toast.makeText(getApplicationContext(),newList.get(j).getName(),Toast.LENGTH_SHORT).show();

                return true;
            }
        });



        return true;
    }




        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Bundle bundle=new Bundle();
            bundle.putString("token", token);
            FoodFragment foodFragment=new FoodFragment();
            foodFragment.setArguments(bundle);
            FragmentManager manager=getFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.main_fl,foodFragment,"food");
            transaction.addToBackStack(null);
            transaction.commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
