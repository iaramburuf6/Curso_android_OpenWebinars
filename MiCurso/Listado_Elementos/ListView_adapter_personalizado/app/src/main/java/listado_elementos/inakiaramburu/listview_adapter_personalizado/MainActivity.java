package listado_elementos.inakiaramburu.listview_adapter_personalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<Averia> averiaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=(ListView) findViewById(R.id.listViewAverias);

        averiaList=new ArrayList<>();
        averiaList.add(new Averia("Espejo roto","Audi -- A4","",2));
        averiaList.add(new Averia("Parachoques delantero","Citroen -- C4","",0));
        averiaList.add(new Averia("Embrague","Seat -- Ibiza","http://www.simpsoncrazy.com/content/pictures/homer/homer-pythagoras.png",0));
        averiaList.add(new Averia("Cambio de aceite","Seat -- Toledo","",1));

        MiAdaptadorAverias adaptadorAverias= new MiAdaptadorAverias(
                this,
                R.layout.averia_item,
                averiaList
        );

        lista.setAdapter(adaptadorAverias);

    }
}
