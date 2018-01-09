package almacenamientolocal.iaramburu.realm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        // Recuperar las preferencias compartidas
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file),Context.MODE_PRIVATE);
        boolean isLogin = sharedPref.getBoolean(getString(R.string.preferencias_islogin),false); // false en caso de no tener valor isLogin

        // Si ya se ha hecho login y no se ha hecho logout, iniciar directamente la activity siguiente
        if(isLogin) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }

    }


    public void doLogin(View view) {

        // Conseguir del layout el email y password escritos
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(email.equals("iaramburu@indaba.es") && pass.equals("1234"))
        {
            // Guardar/Almacenar los datos del login
            SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preferencias_mecaround_file), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.preferencias_email), email);
            editor.putBoolean(getString(R.string.preferencias_islogin), true);
            editor.commit();

            // Iniciar la nueva Actividad una vez hecho bien el login
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);

        }
        else {
            // Mostrar mensaje de login incorrecto
            Toast.makeText(this,"Email y/o contraseña incorrectos",Toast.LENGTH_SHORT).show();
        }


    }
}
