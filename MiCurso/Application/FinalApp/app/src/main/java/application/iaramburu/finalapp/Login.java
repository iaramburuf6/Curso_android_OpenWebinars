package application.iaramburu.finalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Login extends AppCompatActivity {

    ImageView logotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logotipo=(ImageView) findViewById(R.id.imageViewLogotipo);

        RequestOptions fitOptions=new RequestOptions().fitCenter();

        Glide.with(this)
                .load("http://miguelcamposrivera.com/logo_mecaround.png")
                .apply(fitOptions)
                .into(logotipo);
    }
}
