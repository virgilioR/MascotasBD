package com.virgilio.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.virgilio.mascotas.adapters.MascotaAdaptador;
import com.virgilio.mascotas.adapters.PageAdapter;
import com.virgilio.mascotas.fragments.MascotasFragment;
import com.virgilio.mascotas.fragments.MiMascotaFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBarCustom = (Toolbar) findViewById(R.id.actionBarCustom);
        //actionBarCustom.setTitleTextColor(getResources().);
        setSupportActionBar( actionBarCustom );

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        /*if(toolbar != null){

        }*/

        setUpViewPager();


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();

        fragments.add( new MascotasFragment() );
        fragments.add( new MiMascotaFragment() );

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter( new PageAdapter( getSupportFragmentManager(), agregarFragments() ));
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mContacto:
                startActivity( new Intent( getApplication(), Contacto.class ) );
                break;
            case R.id.mAcercaDe:
                startActivity( new Intent( getApplication(), AcercaDe.class ) );
                break;
            case R.id.mMejores5:
                startActivity( new Intent( getApplication(), Favoritas.class ) );
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}