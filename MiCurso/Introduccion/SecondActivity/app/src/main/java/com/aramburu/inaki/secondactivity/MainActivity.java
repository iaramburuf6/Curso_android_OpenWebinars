package com.aramburu.inaki.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metodo 1 para instanciar el metodo que hace referencia el metodo onClick definido en activity_main.xml
    /*public void initSecActivity(View view)
    {
        // Mostrar el mensaje un tiempo corto, 3 segundos
        Toast.makeText(this, "Has hecho click en el texto", Toast.Length_Short).show();

        // Mostrar el mensaje un tiempo largo > 3 segundos
        Toast.makeText(this, "Has hecho click en el texto", Toast.Length_Long).show();

    }*/

}
