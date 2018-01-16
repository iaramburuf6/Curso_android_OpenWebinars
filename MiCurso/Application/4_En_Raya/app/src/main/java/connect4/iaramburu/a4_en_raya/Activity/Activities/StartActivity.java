package connect4.iaramburu.a4_en_raya.Activity.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import connect4.iaramburu.a4_en_raya.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void buttonNewPulsado(View view) {
        Intent newGame = new Intent(StartActivity.this, NewGameActivity.class);
        startActivity(newGame);
        Toast.makeText(this, "Nuevo juego", Toast.LENGTH_SHORT).show();
    }
}
