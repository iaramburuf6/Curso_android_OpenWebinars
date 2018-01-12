package apirest.iaramburu.conexion_api_rest.Interfaces;


import apirest.iaramburu.conexion_api_rest.Responses.AveriaDB;

/**
 * Created by inakiaramburu on 5/1/18.
 */

public interface OnAveriaInteractionListener {

    public void onAveriaEdit(AveriaDB mItem);
    public void onAveriaDetalle(AveriaDB mItem);
    public void onAveriaEliminar(AveriaDB mItem);
}
