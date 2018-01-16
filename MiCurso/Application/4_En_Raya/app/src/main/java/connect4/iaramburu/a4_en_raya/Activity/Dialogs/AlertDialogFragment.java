package connect4.iaramburu.a4_en_raya.Activity.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import connect4.iaramburu.a4_en_raya.Activity.Activities.NewGameActivity;
import connect4.iaramburu.a4_en_raya.R;

public class AlertDialogFragment extends DialogFragment {
	
    /*
   	Se ejecuta cuando el jugador pulsa el boton negativo del dialogo de alerta.
     - La actividad finaliza.
     - El dialogo se elimina, como en la opcion positiva.
    */
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final NewGameActivity main = (NewGameActivity) getActivity();

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				getActivity());
		alertDialogBuilder.setTitle(R.string.fin_del_juego);
		alertDialogBuilder.setMessage(R.string.mensaje_fin_del_juego);
		alertDialogBuilder.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.restartGame();
						main.dibujarTablero();
						dialog.dismiss();
					}
				});
		
		alertDialogBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						main.finish();
						dialog.dismiss();
					}
				});
		
		return alertDialogBuilder.create();
	}
}