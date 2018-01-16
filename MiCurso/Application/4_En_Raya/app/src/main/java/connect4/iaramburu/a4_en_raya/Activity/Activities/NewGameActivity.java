package connect4.iaramburu.a4_en_raya.Activity.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import connect4.iaramburu.a4_en_raya.Activity.Dialogs.AlertDialogFragment;
import connect4.iaramburu.a4_en_raya.Activity.Logic.Game;
import connect4.iaramburu.a4_en_raya.R;

public class NewGameActivity extends AppCompatActivity {

    private final int ids[][] = {
            { R.id.c0, R.id.c1, R.id.c2, R.id.c3, R.id.c4, R.id.c5, R.id.c6 },
            { R.id.c7, R.id.c8, R.id.c9, R.id.c10, R.id.c11, R.id.c12, R.id.c13 },
            { R.id.c14, R.id.c15, R.id.c16, R.id.c17, R.id.c18, R.id.c19,
                    R.id.c20 },
            { R.id.c21, R.id.c22, R.id.c23, R.id.c24, R.id.c25, R.id.c26,
                    R.id.c27 },
            { R.id.c28, R.id.c29, R.id.c30, R.id.c31, R.id.c32, R.id.c33,
                    R.id.c34 },
            { R.id.c35, R.id.c36, R.id.c37, R.id.c38, R.id.c39, R.id.c40,
                    R.id.c41 } };

    private Game game;
    private TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game); // muestro el tablero

        game=new Game();

        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
        resultadoTextView.setText(R.string.partida_nueva);
    }


    // Metodo onClick de cada boton, configurado en styles
    public void pulsarPosicionJugando(View view) throws InterruptedException {

        int fila = 0, columna = 0, id = view.getId(), sePuede = 0;

        // Comprueba si es el final del juego
        if (game.finalJuego()) {
            // Dialogo de alerta
            new AlertDialogFragment().show(getFragmentManager(), "ALERT DIALOG");
            return;
        }

        fila = identificadorFilaElemento(id);
        columna = identificadorColumnaElemento(id);

        //Toast.makeText(this,"tecla pulsada fila "+fila+" columna "+columna,Toast.LENGTH_LONG).show();

        // Comprueba si el sitio esta libre para colocar una ficha, y si es la posicion más baja para poder colocarla
        sePuede = game.sePuedeColocarFicha(fila, columna,2);

        if (sePuede == 0) {

            Toast.makeText(this, R.string.nosepuedecolocarficha,Toast.LENGTH_SHORT).show();
            return;
        }
        // Si la posicion escogida es correcta, esta libre y es la más baja
        else if(sePuede == 1) {
            game.setJugador(fila, columna);
        }

        dibujarTablero();

        if (game.comprobarCuatro(Game.JUGADOR)) {
            dibujarTablero();
            resultadoTextView.setText(R.string.gana_humano);
            // Dialogo de alerta
            new AlertDialogFragment().show(getFragmentManager(), "ALERT DIALOG");
            return;
        }

        game.juegaMaquina();

        if (game.comprobarCuatro(Game.MAQUINA)) {
            dibujarTablero();
            resultadoTextView.setText(R.string.gana_maquina);
            // Dialogo de alerta
            new AlertDialogFragment().show(getFragmentManager(), "ALERT DIALOG");
            return;
        }

        dibujarTablero();
    }

    // Metodo para dibujar el tablero segun se hayan colocado las fichas
    public void dibujarTablero() {
        int id = 0;

        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++)
            {
                if(game.estaVacio(i, j)==true)
                {
                    id=R.drawable.c4_button;
                }

                else if(game.estaJugador(i, j)==true)
                {
                    id=R.drawable.c4_human_pressed_button;
                }

                else
                {
                    id=R.drawable.c4_machine_pressed_button;
                }

                // Poner la imagen que corresponda a cada id de boton del tablero, vacio, jugador, maquina
                ImageButton imageButton = (ImageButton) findViewById(ids[i][j]);
                imageButton.setImageResource(id);
            }
    }


    private int identificadorFilaElemento(int id) {
        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return i;
        return -1;
    }

    private int identificadorColumnaElemento(int id) {
        for (int i = 0; i < Game.NFILAS; i++)
            for (int j = 0; j < Game.NCOLUMNAS; j++)
                if (ids[i][j] == id)
                    return j;
        return -1;
    }

    public void restartGame(){
        game.restart();
        resultadoTextView.setText(R.string.partida_nueva);
    }

}
