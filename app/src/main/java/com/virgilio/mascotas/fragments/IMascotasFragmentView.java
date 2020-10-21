package com.virgilio.mascotas.fragments;

import com.virgilio.mascotas.adapters.MascotaAdaptador;
import com.virgilio.mascotas.classes.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {
    public void generateLinearLayot();
    public MascotaAdaptador generateMascotaAdaptador(ArrayList<Mascota> mascotas );
    public void initAdaptadorRV( MascotaAdaptador adaptador );
}
