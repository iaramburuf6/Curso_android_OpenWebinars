package apirest.iaramburu.conexion_api_rest.Fragments;

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

import apirest.iaramburu.conexion_api_rest.Interfaces.OnNuevaAveriaListener;
import apirest.iaramburu.conexion_api_rest.R;


/**
 * Created by i.aramburu on 10/01/2018.
 */

public class NuevaAveriaDialogo extends DialogFragment {

    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;
    View v;
    EditText editTextTitulo, editTextDescripcion, editTextModeloCoche;
    Context ctx;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Conseguir el contexto
        ctx = getActivity();

        builder = new AlertDialog.Builder(ctx);

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        v = inflater.inflate(R.layout.dialogo_nueva_averia, null);
        editTextTitulo = (EditText) v.findViewById(R.id.editTextTitulo);
        editTextDescripcion = (EditText) v.findViewById(R.id.editTextDescripcion);
        editTextModeloCoche = (EditText) v.findViewById(R.id.editTextModeloCoche);

        builder.setView(v);

        // Cuando el usuario pulsa el boton guardar, se rescatan los datos introducidos para luego guardarlos
        builder.setTitle("Nueva avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Avería guardada", Toast.LENGTH_SHORT).show();

                        String titulo = editTextTitulo.getText().toString();
                        String descripcion = editTextDescripcion.getText().toString();
                        String modeloCoche = editTextModeloCoche.getText().toString();
                        if(!titulo.isEmpty() && !descripcion.isEmpty() && !modeloCoche.isEmpty()) {

                            // Comunicacion con el activity para guardar los datos (implementado en el MainActivity.java)
                            mListener.onAveriaGuardarClickListener(titulo, descripcion, modeloCoche);

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
