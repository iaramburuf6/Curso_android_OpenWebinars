package apirest.iaramburu.conexion_api_rest.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.util.List;

import apirest.iaramburu.conexion_api_rest.Adapters.MyAveriaRecyclerViewAdapter;
import apirest.iaramburu.conexion_api_rest.Commons.Constantes;
import apirest.iaramburu.conexion_api_rest.Interfaces.ApiMecAroundInterface;
import apirest.iaramburu.conexion_api_rest.Interfaces.OnAveriaInteractionListener;
import apirest.iaramburu.conexion_api_rest.R;
import apirest.iaramburu.conexion_api_rest.Responses.AveriaDB;
import apirest.iaramburu.conexion_api_rest.Responses.ResponseAverias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ListadoAveriasFragment extends Fragment {

    OnAveriaInteractionListener mListener;
    List<AveriaDB> averiaDBList;

    RecyclerView recyclerView;

    Context ctx;
    String apiKey;

    public ListadoAveriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Recuperar la activity, ya que es un fragment
        ctx = getActivity();

        // Recuperar las preferencias de la app guardadas, en este caso, la API-KEY
        SharedPreferences sharedPref = ctx.getSharedPreferences(getString(R.string.preferencias_mecaround_file),Context.MODE_PRIVATE);
        apiKey = sharedPref.getString(getString(R.string.preferencias_key),"");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Cargar en el objeto view el layout/fragmento para luego mostrarlo
        View view = inflater.inflate(R.layout.fragment_averia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            /* Lista de averias*/

            // Crear objeto retrofit para recibir los datos del servidor remoto. La configuracion esta hecha para que GSON convierta los datos recibidos en JSON a java
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.API_BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiMecAroundInterface apiService = retrofit.create(ApiMecAroundInterface.class);

            // Llamar al servicio para obtener las averias
            Call<ResponseAverias> peticionAverias = apiService.getAverias(apiKey);

            // Implementar la accion de respuesta del servidor.
            peticionAverias.enqueue(new Callback<ResponseAverias>() {
                // El metodo devuelve respuesta
                @Override
                public void onResponse(Call<ResponseAverias> call, Response<ResponseAverias> response) {

                    // Si la respuesta http es correcta
                    if(response.code()== HttpURLConnection.HTTP_OK) {
                        averiaDBList = response.body().getAverias();
                        recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(ctx, averiaDBList, mListener));
                    } else {
                        Toast.makeText(ctx, "Error en la respuesta", Toast.LENGTH_SHORT).show();
                    }

                }

                // El metodo no devuelve respuesta
                @Override
                public void onFailure(Call<ResponseAverias> call, Throwable t) {

                }
            });
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAveriaInteractionListener) {
            mListener = (OnAveriaInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
