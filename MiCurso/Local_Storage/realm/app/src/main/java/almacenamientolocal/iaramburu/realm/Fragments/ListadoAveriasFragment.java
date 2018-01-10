package almacenamientolocal.iaramburu.realm.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import almacenamientolocal.iaramburu.realm.Adapters.MyAveriaRecyclerViewAdapter;
import almacenamientolocal.iaramburu.realm.Interfaces.OnAveriaInteractionListener;
import almacenamientolocal.iaramburu.realm.Model.AveriaDB;
import almacenamientolocal.iaramburu.realm.R;
import io.realm.Realm;
import io.realm.RealmResults;

public class ListadoAveriasFragment extends Fragment {

    OnAveriaInteractionListener mListener;
    RealmResults<AveriaDB> averiaDBList;

    Realm realm;

    public ListadoAveriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Recupera el estado de la base de datos
        realm = Realm.getDefaultInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_averia_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            // Lista de averias. Busca y muestra todas los datos que se hayan guardado en la base de datos
            averiaDBList = realm.where(AveriaDB.class).findAll();

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(getActivity(),averiaDBList, mListener));
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
