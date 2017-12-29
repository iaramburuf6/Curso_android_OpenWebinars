package com.aramburu.inaki.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Metodo 2
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Metodo 2
        texto=(TextView) findViewById(R.id.textoEvento);

        // Metodo 2 a Implica repeticion de codigo si hay mas eventos. This no hace referencia al activity
        /*texto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               Toast.makeText(MainActivity.this, "Has hecho click con el escuchador", Toast.LENGTH_SHORT).show();
            }
        });*/

        /* Metodo 2 b, una unica declaracion del metodo onClick().
         En este caso, la clase debe implementar a la clase View.OnClickListener */
        texto.setOnClickListener(this);
    }

    // Metodo 1 para instanciar el metodo que hace referencia el metodo onClick definido en activity_main.xml
    /*public void initSecActivity(View view)
    {
        // Mostrar el mensaje un tiempo corto, 3 segundos
        Toast.makeText(this, "Has hecho click en el texto", Toast.LENGTH_SHORT).show();

        // Mostrar el mensaje un tiempo largo > 3 segundos
        Toast.makeText(this, "Has hecho click en el texto", Toast.LENGTH_LONG).show();

    }*/

    // Metodo 2 b, una unica declaracion del metodo onClick()
    @Override
    public void onClick(View view)
    {
        Toast.makeText(MainActivity.this, "Has hecho click con el escuchador metodo 2", Toast.LENGTH_SHORT).show();
    }



}
