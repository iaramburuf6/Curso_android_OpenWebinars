package fragments.iaramburu.dialogos;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.Toast;

/**
 * Created by i.aramburu on 02/01/2018.
 */

public class NuevaAveriaDialogo extends DialogFragment {

    AlertDialog.Builder builder;
    OnNuevaAveriaListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
         builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater=getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialogo_nueva_averia,null));

        builder.setTitle("Nueva Averia")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(),"Averia guardada",Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                        mListener.OnAveriaGuardarListener();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancelar > cerrar el cuadro de dialogo
                        Toast.makeText(getActivity(),"Averia cancelada",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

        // Create the alertDialog object and return it
        return builder.create();
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
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
                    + " must implement NoticeDialogListener");
        }
    }
}
