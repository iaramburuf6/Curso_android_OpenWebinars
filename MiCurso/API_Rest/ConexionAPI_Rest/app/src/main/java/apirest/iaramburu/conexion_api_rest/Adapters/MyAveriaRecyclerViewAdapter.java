package apirest.iaramburu.conexion_api_rest.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import apirest.iaramburu.conexion_api_rest.Interfaces.OnAveriaInteractionListener;
import apirest.iaramburu.conexion_api_rest.R;
import apirest.iaramburu.conexion_api_rest.Responses.AveriaDB;


public class MyAveriaRecyclerViewAdapter extends RecyclerView.Adapter<MyAveriaRecyclerViewAdapter.ViewHolder> {

    private final List<AveriaDB> mValues;
    private final OnAveriaInteractionListener mListener;
    private Context ctx;

    public MyAveriaRecyclerViewAdapter(Context context, List<AveriaDB> items, OnAveriaInteractionListener listener) {
        mValues = items;
        mListener = listener;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.averia_listado_averias_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewModelo.setText(holder.mItem.getModelo());
        holder.textViewPresupuesto.setText("0 presupuestos");

        // Metodo que comprueba si se ha pinchado en el boton de editar
        holder.imageViewEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Si se ha pulsado, se llama al metodo implementado en MainActivity.java
                    mListener.onAveriaEdit(holder.mItem);
                }
            }
        });

        // Metodo que comprueba si se ha pinchado en el boton de detalle
        holder.imageViewDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Si se ha pulsado, se llama al metodo implementado en MainActivity.java
                    mListener.onAveriaDetalle(holder.mItem);
                }
            }
        });

        // Metodo que comprueba si se ha pinchado en el boton de detalle
        holder.imageViewEliminarAveriaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    // Si se ha pulsado, se llama al metodo implementado en MainActivity.java
                    mListener.onAveriaEliminar(holder.mItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewTitulo;
        public final TextView textViewModelo;
        public final TextView textViewPresupuesto;

        public final ImageView imageViewDetalle;
        public final ImageView imageViewEditar;
        public final ImageView imageViewEliminarAveriaID;
        public AveriaDB mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = (TextView) view.findViewById(R.id.textViewID);
            textViewModelo = (TextView) view.findViewById(R.id.textViewModeloCoche);
            textViewPresupuesto = (TextView) view.findViewById(R.id.textViewPresupuesto);

            imageViewDetalle = (ImageView) view.findViewById(R.id.imageViewPresupuesto);

            imageViewEditar = (ImageView) view.findViewById(R.id.imageViewEditar);

            imageViewEliminarAveriaID = (ImageView) view.findViewById(R.id.imageViewEliminarAveria);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}
