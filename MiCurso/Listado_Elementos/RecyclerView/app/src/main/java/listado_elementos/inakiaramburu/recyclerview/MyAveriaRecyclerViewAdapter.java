package listado_elementos.inakiaramburu.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import java.util.List;

public class MyAveriaRecyclerViewAdapter extends RecyclerView.Adapter<MyAveriaRecyclerViewAdapter.ViewHolder> {

    private final List<Averia> mValues;
    private final OnAveriaInteractionListener mListener;
    private Context ctx;

    public MyAveriaRecyclerViewAdapter(Context context, List<Averia> items, OnAveriaInteractionListener listener) {
        mValues = items;
        mListener = listener;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.averia_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewTitulo.setText(holder.mItem.getTitulo());
        holder.textViewModelo.setText(holder.mItem.getModeloCoche());
        holder.textViewPresupuesto.setText(String.valueOf(holder.mItem.getNumeroPresupuestos()));

        if(!holder.mItem.getUrlFoto().isEmpty()) {
            Glide.with(ctx)
                    .load(holder.mItem.getUrlFoto())
                    .into(holder.imageViewFoto);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.OnAveriaClick(holder.mItem);
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
        public final ImageView imageViewFoto;
        public Averia mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewTitulo = (TextView) view.findViewById(R.id.textViewTitulo);
            textViewModelo = (TextView) view.findViewById(R.id.textViewModeloCoche);
            textViewPresupuesto = (TextView) view.findViewById(R.id.textViewPresupuesto);
            imageViewFoto = (ImageView) view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewTitulo.getText() + "'";
        }
    }
}
