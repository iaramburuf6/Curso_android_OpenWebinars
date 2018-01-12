package apirest.iaramburu.conexion_api_rest.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import apirest.iaramburu.conexion_api_rest.Interfaces.OnAveriaInteractionListener;
import apirest.iaramburu.conexion_api_rest.R;
import apirest.iaramburu.conexion_api_rest.Responses.AveriaDB;


public class DetalleAveriaDialogFragment extends DialogFragment {

   /* OnAveriaInteractionListener mListener;
    List<AveriaDB> averiaDBList;

    AlertDialog.Builder builder;
    View v;
    TextView TextViewTitulo, TextViewID, TextViewDescripcion, TextViewModeloCoche;
    Context ctx;

    private long idAveria;
    private String titulo, descripcion, modelo;


    public DetalleAveriaDialogFragment() {
    }

    // Constructor que recibe el ID de la averia para luego editarla. Recibe los datos de la base de datos
    public static DetalleAveriaDialogFragment newInstance(long idA, String t, String d, String m) {
        DetalleAveriaDialogFragment fragment = new DetalleAveriaDialogFragment();
        Bundle args = new Bundle();

        args.putLong(AveriaDB.AVERIADB_ID, idA);
        args.putString(AveriaDB.AVERIADB_TITULO,t);
        args.putString(AveriaDB.AVERIADB_DESCRIPCION,d);
        args.putString(AveriaDB.AVERIADB_MODELOCOCHE,m);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Recupera el estado de la base de datos
        realm = Realm.getDefaultInstance();

        if (getArguments() != null) {
            // Conseguimos el ID, Titulo ... que recibimos gracias a la variables definida en el modelo
            idAveria = getArguments().getLong(AveriaDB.AVERIADB_ID);
            titulo = getArguments().getString(AveriaDB.AVERIADB_TITULO);
            descripcion = getArguments().getString(AveriaDB.AVERIADB_DESCRIPCION);
            modelo = getArguments().getString(AveriaDB.AVERIADB_MODELOCOCHE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias. Busca y muestra todas los datos que se hayan guardado en la base de datos
            averiaDBList = realm.where(AveriaDB.class).findAll();

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(getActivity(),averiaDBList, mListener));
        }
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        ctx = getActivity();

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        v = inflater.inflate(R.layout.dialogo_detalle_averia, null);
        TextViewTitulo = (TextView) v.findViewById(R.id.textViewID);
        TextViewID = (TextView) v.findViewById(R.id.textViewID);
        TextViewDescripcion = (TextView) v.findViewById(R.id.textViewDescripcion);
        TextViewModeloCoche = (TextView) v.findViewById(R.id.textViewModeloCoche);

        // Poner los valores a los componentes de layout, para que aparezcan
        TextViewTitulo.setText(titulo);
        TextViewTitulo.setText(String.valueOf(idAveria));
        TextViewDescripcion.setText(descripcion);
        TextViewModeloCoche.setText(modelo);

        builder.setView(v);

        // Metodo para actualizar la averia con el metodo de actualizarOnClick implementado en MainActivity.java
        builder.setTitle("Detalle avería")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/
}
