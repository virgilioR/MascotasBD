package com.virgilio.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virgilio.mascotas.R;
import com.virgilio.mascotas.adapters.MascotaAdaptador;
import com.virgilio.mascotas.adapters.PerfilAdaptador;
import com.virgilio.mascotas.classes.Mascota;
import com.virgilio.mascotas.classes.Perfil;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MiMascotaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MiMascotaFragment extends Fragment {

    private ArrayList<Perfil> fotos;
    private RecyclerView rvMiMascota;

    public MiMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mi_mascota, container, false);

        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);

        GridLayoutManager glm = new GridLayoutManager( getContext(), 3 );

        rvMiMascota.setLayoutManager(glm);

        initFotos();

        rvMiMascota.setAdapter( new PerfilAdaptador( fotos ) );

        return v;
    }

    public void initFotos(){
        fotos = new ArrayList<Perfil>();
        fotos.add( new Perfil(R.drawable.app1,  5) );
        fotos.add( new Perfil(R.drawable.app1, 1) );
        fotos.add( new Perfil(R.drawable.app1, 2) );
        fotos.add( new Perfil(R.drawable.app1,  11) );
        fotos.add( new Perfil(R.drawable.app1,  10) );
        fotos.add( new Perfil(R.drawable.app1, 4) );
        fotos.add( new Perfil(R.drawable.app1,  20) );
        fotos.add( new Perfil(R.drawable.app1, 25) );
        fotos.add( new Perfil(R.drawable.app1, 11) );
        fotos.add( new Perfil(R.drawable.app1, 12) );
    }
}