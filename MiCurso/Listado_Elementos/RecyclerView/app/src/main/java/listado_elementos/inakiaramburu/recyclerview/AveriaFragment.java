package listado_elementos.inakiaramburu.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class AveriaFragment extends Fragment {

    OnAveriaInteractionListener mListener;
    List<Averia> averiaList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

            // Lista de averias
            averiaList=new ArrayList<>();
            averiaList=new ArrayList<>();
            averiaList.add(new Averia("Espejo roto","Audi -- A4","",2));
            averiaList.add(new Averia("Parachoques delantero","Citroen -- C4","",0));
            averiaList.add(new Averia("Embrague","Seat -- Ibiza","http://www.simpsoncrazy.com/content/pictures/homer/homer-pythagoras.png",0));
            averiaList.add(new Averia("Cambio de aceite","Seat -- Toledo","",1));

            recyclerView.setAdapter(new MyAveriaRecyclerViewAdapter(getActivity(),averiaList, mListener));
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
