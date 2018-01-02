package interfaz_grafica.iaramburu.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imagenInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagenInternet=(ImageView) findViewById(R.id.imageViewInternet);

        Picasso.with(this)
                .load("http://imagenpng.com/wp-content/uploads/2015/09/imagenes-png-635x508.png")
                .into(imagenInternet);
    }
}
