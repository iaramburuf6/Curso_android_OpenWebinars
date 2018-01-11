package googlemaps.iaramburu.defaultconfiguration;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private Marker marker;

    Circle circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        // Añadir marcadores al map
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(43.317167,-1.917408))
                .title("Home")
                .draggable(true)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(43.304735,-2.009007))
                .title("School")
                .snippet("Estudío aqui"));

        marker = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(43.298515,-2.005877))
                .title("Work")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_custom_icon)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(),10));

        // Configurar el mapa por defecto de tipo hibrido
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);


        // Instantiates a new CircleOptions object and defines the center and radius
        CircleOptions circleOptions = new CircleOptions()
                .center(marker.getPosition())
                // Para poder acceder a los colores definidos en colors.xml, ContextCompat
                .fillColor(ContextCompat.getColor(this,R.color.colorAccent))
                .strokeColor(ContextCompat.getColor(this,R.color.colorPrimary))
                .strokeWidth(10)
                .radius(1000); // In meters

        // Get back the mutable Circle
        circle = mMap.addCircle(circleOptions);


        // Implementar el evento de un click en esta clase, this
        mMap.setOnMapClickListener(this);

        // Implementar el evento de un click largo en esta clase, this
        mMap.setOnMapLongClickListener(this);

    }

    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(this,"Has hecho click en "+latLng.latitude+","+latLng.longitude,Toast.LENGTH_SHORT).show();
        marker.setPosition(latLng);

        // Mueve el foco de la camara bruscamente a la nueva localizacion del marker
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Mueve el foco de la camara más lentamente a la nueva localizacion del marker
        //mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        // Mueve el foco de la camara, el zoom y la posicion del marker (dependiendo del zoom) más lentamente a la nueva localizacion del marker. Hay que añadir al layout map:uiZoomControls="true"
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

        circle.setCenter(latLng);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(this,"Has hecho un click largo en "+latLng.latitude+","+latLng.longitude,Toast.LENGTH_SHORT).show();
    }
}
