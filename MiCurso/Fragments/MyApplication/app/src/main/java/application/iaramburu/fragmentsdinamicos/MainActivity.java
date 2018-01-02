package application.iaramburu.fragmentsdinamicos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // Variable para controlar el switch de los 2 fragments
    boolean pulsado=true;

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
                // Modificar el fragmento que sale en la pantalla dentro del container
                if(pulsado)
                {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contenedor,new SegundoFragment())
                            .commit();
                    pulsado=false;
                }
                else
                {
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.contenedor,new PrimerFragment())
                            .commit();
                    pulsado=true;
                }

            }
        });

        // Rescatamos el contenedor y le vamos a cargar un fragmento
        getSupportFragmentManager().beginTransaction()
                .add(R.id.contenedor,new PrimerFragment())
                .commit();
    }
}
