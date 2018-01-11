package almacenamientolocal.iaramburu.realm.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import almacenamientolocal.iaramburu.realm.Interfaces.OnNuevaAveriaListener;
import almacenamientolocal.iaramburu.realm.Model.AveriaDB;
import almacenamientolocal.iaramburu.realm.R;

/**
 * Created by i.aramburu on 10/01/2018.
 */

public class EditAveriaDialogFragment extends DialogFragment {

    private long idAveria;

    private String titulo, descripcion, modelo;

    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;
    View v;
    EditText editTextTitulo, editTextDescripcion, editTextModeloCoche;
    Context ctx;

    public EditAveriaDialogFragment() {
        // Required empty public constructor
    }

    // Constructor que recibe el ID de la averia para luego editarla. Recibe los datos de la base de datos
    public static EditAveriaDialogFragment newInstance(long idA, String t, String d, String m) {
        EditAveriaDialogFragment fragment = new EditAveriaDialogFragment();
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
        if (getArguments() != null) {
            // Conseguimos el ID, Titulo ... que recibimos gracias a la variables definida en el modelo
            idAveria = getArguments().getLong(AveriaDB.AVERIADB_ID);
            titulo = getArguments().getString(AveriaDB.AVERIADB_TITULO);
            descripcion = getArguments().getString(AveriaDB.AVERIADB_DESCRIPCION);
            modelo = getArguments().getString(AveriaDB.AVERIADB_MODELOCOCHE);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        builder = new AlertDialog.Builder(getActivity());

        ctx = getActivity();

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        v = inflater.inflate(R.layout.dialogo_nueva_averia, null);
        editTextTitulo = (EditText) v.findViewById(R.id.editTextTitulo);
        editTextDescripcion = (EditText) v.findViewById(R.id.editTextDescripcion);
        editTextModeloCoche = (EditText) v.findViewById(R.id.editTextModeloCoche);

        // Poner los valores a los componentes de layout, para que aparezcan
        editTextTitulo.setText(titulo);
        editTextDescripcion.setText(descripcion);
        editTextModeloCoche.setText(modelo);

        builder.setView(v);

        // Metodo para actualizar la averia con el metodo de actualizarOnClick implementado en MainActivity.java
        builder.setTitle("Editar avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Avería guardada", Toast.LENGTH_SHORT).show();

                        // Recuperamos los datos introducidos por el usuario
                        String titulo = editTextTitulo.getText().toString();
                        String descripcion = editTextDescripcion.getText().toString();
                        String modeloCoche = editTextModeloCoche.getText().toString();
                        if(!titulo.isEmpty() && !descripcion.isEmpty() && !modeloCoche.isEmpty()) {

                            // Pasamos los datos al metodo implementado en MainActivity.java para actualizar los datos de la averia
                            mListener.onAveriaUpdateClickListener(idAveria, titulo, descripcion, modeloCoche);

                            dialog.dismiss();
                        } else {
                            Toast.makeText(ctx, "Introduzca todos los datos", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancelar > cerrar el cuadro de diálogo
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (OnNuevaAveriaListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement OnNuevaAveriaListener");
        }
    }

}
