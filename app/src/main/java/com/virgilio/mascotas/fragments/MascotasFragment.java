package com.virgilio.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virgilio.mascotas.classes.Mascota;
import com.virgilio.mascotas.R;
import com.virgilio.mascotas.adapters.MascotaAdaptador;
import com.virgilio.mascotas.presentador.IMascotasFragmentPresenter;
import com.virgilio.mascotas.presentador.IRankingFragmentPresenter;
import com.virgilio.mascotas.presentador.MascotasFragmentPresenter;
import com.virgilio.mascotas.presentador.RankingFragmentPresenter;

import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    private IMascotasFragmentPresenter iMascotasFragmentPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        iMascotasFragmentPresenter = new MascotasFragmentPresenter( this, getContext() );
        iMascotasFragmentPresenter.obtenerMascotasBD();
        generateLinearLayot();

        return v;
    }

    public void initMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add( new Mascota(R.drawable.app1, "Dogui", 5) );
        mascotas.add( new Mascota(R.drawable.app2, "Tarzán", 1) );
        mascotas.add( new Mascota(R.drawable.app3, "Talvi", 2) );
        mascotas.add( new Mascota(R.drawable.app4, "Manini", 11) );
        mascotas.add( new Mascota(R.drawable.app5, "Mujica", 10) );
        mascotas.add( new Mascota(R.drawable.app6, "Cebolla", 4) );
        mascotas.add( new Mascota(R.drawable.app7, "Ragnar", 20) );
        mascotas.add( new Mascota(R.drawable.app8, "Floki", 2) );
    }

    @Override
    public void generateLinearLayot() {
        LinearLayoutManager llm = new LinearLayoutManager( getContext() );
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador( mascotas );
        return mascotaAdaptador;
    }

    @Override
    public void initAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter( adaptador );
    }
}