package com.whiwol.petagram.adaptadores;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.whiwol.petagram.R;
import com.whiwol.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Jmdra on 20/06/2016.
 */
public class FotosPerfilAdaptador extends RecyclerView.Adapter<FotosPerfilAdaptador.FotosPerfilViewHolder>{

    //4.- Declarando la coleccion de los contactos
    ArrayList<Mascota> mascotas;
    Activity activity;

    //10.- Generando el Metodo Constructor
    public FotosPerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override //6.- Esto infla o le da vida a nuestro layout cardview, Infla el layout y lo pasa al viewholder
    public FotosPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_perfil, parent, false);
        return new FotosPerfilViewHolder(v);
    }

    @Override //7.- Aqui vamos a pasar la lista de Mascotas
    public void onBindViewHolder(FotosPerfilViewHolder fotosPerfilViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        fotosPerfilViewHolder.tvLikesCVPerfil.setText(String.valueOf(mascota.getLikes()));
        fotosPerfilViewHolder.imgFotoPerfil.setImageResource(mascota.getFoto());

    }

    @Override //5.- EL numero total de mascotas
    public int getItemCount() {
        return mascotas.size();
    }

    //1.-
    public static class FotosPerfilViewHolder extends RecyclerView.ViewHolder{

        //2.- Se declaran todos los views declarados dentro del cardview aqui es donde se adaptan
        private ImageView imgFotoPerfil;
        private TextView tvLikesCVPerfil;

        public FotosPerfilViewHolder(View itemView) {
            super(itemView);
            // 3.- Se asocia el ImageView y se hace el casting
            imgFotoPerfil         = (ImageView)   itemView.findViewById(R.id.imgFotoPerfil);
            tvLikesCVPerfil       = (TextView)    itemView.findViewById(R.id.tvLikesCVPerfil);
        }
    }
}
