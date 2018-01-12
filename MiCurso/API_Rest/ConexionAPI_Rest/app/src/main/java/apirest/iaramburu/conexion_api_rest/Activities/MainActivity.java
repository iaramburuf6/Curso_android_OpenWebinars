package apirest.iaramburu.conexion_api_rest.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import apirest.iaramburu.conexion_api_rest.Fragments.ListadoAveriasFragment;
import apirest.iaramburu.conexion_api_rest.Fragments.NuevaAveriaDialogo;
import apirest.iaramburu.conexion_api_rest.Interfaces.OnAveriaInteractionListener;
import apirest.iaramburu.conexion_api_rest.Interfaces.OnNuevaAveriaListener;
import apirest.iaramburu.conexion_api_rest.R;
import apirest.iaramburu.conexion_api_rest.Responses.AveriaDB;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnNuevaAveriaListener, OnAveriaInteractionListener {

    DialogFragment dialogNuevaAveria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Si se pincha en boton flotante +, se carga el dialogo de nueva averia
                dialogNuevaAveria = new NuevaAveriaDialogo();
                dialogNuevaAveria.show(getSupportFragmentManager(),"DialogNuevaAveria");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // Personalización del contenido del NavigationView header
        ImageView ivAvatar = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.imageViewAvatar);
        ivAvatar.setImageResource(R.drawable.ic_man);

        TextView textViewNombre = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textViewNombre);
        TextView textViewEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textViewEmail);

        // Recargar/refrescar el fragment que se muestra
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment,new ListadoAveriasFragment())
                .commit();

        // Recuperar las preferencias guardadas del usuario para mostrarlos en textView
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);
        String email = sharedPref.getString(getString(R.string.preferencias_email),"");
        textViewEmail.setText(email);

        String nombre = sharedPref.getString(getString(R.string.preferencias_nombre),"");
        textViewNombre.setText(nombre);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment f = null;

        if (id == R.id.nav_averias) {
            f = new ListadoAveriasFragment();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_logout)
        {
            // Recuperar las preferencias guardadas del usuario y borrarlas
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.clear();
            editor.commit();

            finish();
        }

        // Si se ha seleccionado alguna opcion del menu se reemplaza el contenedor de fragments por el fragment en cuestion
        if(f!=null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment,f)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onAveriaGuardarClickListener(String titulo, String descripcion, String modelo) {

    }

    @Override
    public void onAveriaUpdateClickListener(long id, String titulo, String descripcion, String modelo) {

    }

    @Override
    public void onAveriaEdit(AveriaDB mItem) {

    }

    @Override
    public void onAveriaDetalle(AveriaDB mItem) {

    }

    @Override
    public void onAveriaEliminar(AveriaDB mItem) {

    }
}
