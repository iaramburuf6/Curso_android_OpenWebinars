package almacenamientolocal.iaramburu.realm.Interfaces;

import almacenamientolocal.iaramburu.realm.Model.AveriaDB;

/**
 * Created by inakiaramburu on 5/1/18.
 */

public interface OnAveriaInteractionListener {

    public void onAveriaEdit(AveriaDB mItem);
    public void onAveriaDetalle(AveriaDB mItem);
    public void onAveriaEliminar(AveriaDB mItem);
}
