package almacenamientolocal.iaramburu.realm.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import almacenamientolocal.iaramburu.realm.Fragments.DetalleAveriaDialogFragment;
import almacenamientolocal.iaramburu.realm.Fragments.EditAveriaDialogFragment;
import almacenamientolocal.iaramburu.realm.Fragments.NuevaAveriaDialogo;
import almacenamientolocal.iaramburu.realm.Interfaces.OnAveriaInteractionListener;
import almacenamientolocal.iaramburu.realm.Interfaces.OnNuevaAveriaListener;
import almacenamientolocal.iaramburu.realm.Model.AveriaDB;
import almacenamientolocal.iaramburu.realm.R;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        OnAveriaInteractionListener,
        OnNuevaAveriaListener {

    DialogFragment dialogNuevaAveria, dialogEditAveria, dialogDetalle;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
    }


    // Metodo para crear el Menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    // Metodo para saber si se ha escogido alguna opcion en el menu de opciones
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_averia_add:
                dialogNuevaAveria = new NuevaAveriaDialogo();
                dialogNuevaAveria.show(getSupportFragmentManager(),"DialogNuevaAveria");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Metodo para instanciar y lanzar el dialogo de editar una averia
    @Override
    public void onAveriaEdit(AveriaDB mItem) {
        dialogEditAveria = EditAveriaDialogFragment.newInstance(mItem.getId(),mItem.getTitulo(),mItem.getDescripcion(),mItem.getModeloCoche());
        dialogEditAveria.show(getSupportFragmentManager(),"EditAveriaDialogo");
    }

    // Metodo para instanciar y lanzar el dialogo de detalle una averia
    @Override
    public void onAveriaDetalle(AveriaDB mItem) {
        dialogDetalle = DetalleAveriaDialogFragment.newInstance(mItem.getId(),mItem.getTitulo(),mItem.getDescripcion(),mItem.getModeloCoche());
        dialogDetalle.show(getSupportFragmentManager(),"DetalleAveriaDialogo");
    }

    // Metodo para eliminar una averia mediante un Dialogo de confirmacion
    @Override
    public void onAveriaEliminar(AveriaDB mItem) {
        mostrarDialogoConfirmacion(mItem);
    }

    private void mostrarDialogoConfirmacion(final AveriaDB averiaDB) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Eliminar avería");
        builder.setMessage("¿Desea eliminar definitivamente la avería: "+averiaDB.getTitulo()+"?");

        builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        // Recuperamos el ID de la averia para poder borrar solo esa
                        long idAveriaEliminar = averiaDB.getId();
                        AveriaDB averiaEliminar = realm.where(AveriaDB.class).equalTo(AveriaDB.AVERIADB_ID,idAveriaEliminar).findFirst();
                        averiaEliminar.deleteFromRealm();
                    }
                });

                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    // Metodo para guardar los datos con realm
    @Override
    public void onAveriaGuardarClickListener(final String titulo, final String descripcion, final String modelo) {

        //realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            // Se crea un nuevo hilo en segundo plano
            @Override
            public void execute(Realm realm) {
                // Se crea un nuevo objeto
                AveriaDB nuevaAveria = new AveriaDB();
                nuevaAveria.setTitulo(titulo);
                nuevaAveria.setModeloCoche(modelo);
                nuevaAveria.setNumeroPresupuestos(0);
                nuevaAveria.setDescripcion(descripcion);
                nuevaAveria.setUrlFoto("");

                // Se copia/guarda el nuevo objeto en realm
                realm.copyToRealm(nuevaAveria);

            }
        });
    }

    // Metodo para actualizar datos ya guardados anteriormente
    @Override
    public void onAveriaUpdateClickListener(final long id, final String titulo, final String descripcion, final String modelo) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                AveriaDB nuevaAveria = new AveriaDB();
                nuevaAveria.setId(id);
                nuevaAveria.setTitulo(titulo);
                nuevaAveria.setModeloCoche(modelo);
                nuevaAveria.setNumeroPresupuestos(0);
                nuevaAveria.setDescripcion(descripcion);
                nuevaAveria.setUrlFoto("");

                realm.copyToRealmOrUpdate(nuevaAveria);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
