package com.aramburu.inaki.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogroupAv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radiogroupAv =(RadioGroup) findViewById(R.id.radioGroupAverias);
    }

    public void tipoAveria(View view) {

        String tipo = "";

        switch (view.getId()) {
            case R.id.radioButtonChapaPintura:
                tipo = "Chapa y pintura";
                break;
            case R.id.radioButtonCristal:
                tipo = "Cristal";
                break;
            case R.id.radioButtonMecanica:
                tipo = "Mecanica";
                break;
        }

        Toast.makeText(this,"Tipo de averia:"+tipo,Toast.LENGTH_SHORT).show();
    }

    public void SaberAveria(View view) {

        int idSeleccionado=radiogroupAv.getCheckedRadioButtonId();
        String tipo="";

        if(idSeleccionado==R.id.radioButtonChapaPintura)
        {
            tipo="Has seleccionado chapa y pintura";
        }
        else if(idSeleccionado==R.id.radioButtonCristal)
        {
            tipo="Has seleccionado cristal";
        }
        else if(idSeleccionado==R.id.radioButtonMecanica)
        {
            tipo="Has seleccionado mecánica";
        }
        else
        {
            tipo="No has seleccionado nada";
        }
        Toast.makeText(this,tipo,Toast.LENGTH_SHORT).show();

    }
}
