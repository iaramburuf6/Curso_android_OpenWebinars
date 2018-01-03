package navegation.iaramburu.diseno_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_averia_add:
                Toast.makeText(this,"Has pulsado la opcion de añadir",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_averia_search:
                Toast.makeText(this,"Has pulsado la opcion de buscar",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_averia_cancel:
                Toast.makeText(this,"Has pulsado la opcion de cancelar",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
