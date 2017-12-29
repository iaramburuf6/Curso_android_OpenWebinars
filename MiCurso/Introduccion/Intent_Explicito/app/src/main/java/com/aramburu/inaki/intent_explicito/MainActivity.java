package com.aramburu.inaki.intent_explicito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarDatosActivity(View view)
    {
        // Escribiremos el codigo necesario para iniciar el DatosActivity
        // Lo haremos con un intent explicito
        Intent intentDatos = new Intent(this,DatosActivity.class);
        intentDatos.putExtra("numero",5);
        intentDatos.putExtra("nombre","Yo");
        startActivity(intentDatos);
    }

}
