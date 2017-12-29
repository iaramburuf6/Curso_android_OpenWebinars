package com.aramburu.inaki.intent_explicito;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Bundle extras=getIntent().getExtras();
        int n=extras.getInt("numero");
        String s=extras.getString("nombre");

        Toast.makeText(this, "numero: "+n+", nombre: "+s, Toast.LENGTH_SHORT).show();
    }
}
