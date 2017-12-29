package com.aramburu.inaki.checkbox_buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saberAveria(View view) {

        CheckBox checkbox = (CheckBox)view;

        boolean chequeado=checkbox.isChecked();

        String tipo="";

        switch (view.getId())
        {
            case R.id.checkBoxChapaPintura:
                tipo="Chapa y pintura";
                break;
            case R.id.checkBoxCristal:
                tipo="Cristal";
                break;
            case R.id.checkBoxMecanica:
                tipo="Mecanica";
                break;
        }

        Toast.makeText(this,tipo+" ("+chequeado+")",Toast.LENGTH_SHORT).show();

    }
}
