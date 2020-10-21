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
import com.virgilio.mascotas.classes.Mascota;
import com.virgilio.mascotas.R;
import com.virgilio.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    ConstructorMascotas constructorMascotas;

    public MascotaAdaptador( ArrayList<Mascota> mascotas ){
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_mascota, parent, false );
        constructorMascotas = new ConstructorMascotas( v.getContext() );
        return new MascotaViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get( position );
        holder.imgImage.setImageResource(mascota.getImage());
        holder.txtNombre.setText(mascota.getNombre());
        holder.txtRaiting.setText(String.valueOf(mascota.getRaiting()));

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constructorMascotas.darLikeMascota( mascota );
                holder.txtRaiting.setText( String.valueOf( constructorMascotas.getLikesMascota( mascota ) ) );
                Snackbar.make( view, "Le has dado Me Gusta a " + mascota.getNombre() + "!", Snackbar.LENGTH_SHORT ).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgImage;
        private TextView txtNombre;
        private TextView txtRaiting;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImage = (ImageView) itemView.findViewById(R.id.imgImage);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtRaiting = (TextView) itemView.findViewById(R.id.txtRaiting);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

}
