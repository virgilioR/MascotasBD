package com.virgilio.mascotas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.virgilio.mascotas.R;
import com.virgilio.mascotas.classes.Mascota;
import com.virgilio.mascotas.classes.Perfil;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Perfil> fotos;

    public PerfilAdaptador( ArrayList<Perfil> fotos ){
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_mi_mascota, parent, false );
        return new PerfilAdaptador.PerfilViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptador.PerfilViewHolder holder, int position) {
        final Perfil perfil = fotos.get( position );
        holder.imgImage.setImageResource(perfil.getImage());
        holder.txtRaiting.setText(String.valueOf(perfil.getRaiting()));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgImage;
        private TextView txtRaiting;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImage = (ImageView) itemView.findViewById(R.id.imgImage);
            txtRaiting = (TextView) itemView.findViewById(R.id.txtRaiting);
        }
    }
}
