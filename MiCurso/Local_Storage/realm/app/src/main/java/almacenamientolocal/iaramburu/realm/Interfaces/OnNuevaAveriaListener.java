package almacenamientolocal.iaramburu.realm.Interfaces;

/**
 * Created by i.aramburu on 10/01/2018.
 */

public interface OnNuevaAveriaListener {

    public void onAveriaGuardarClickListener(String titulo, String descripcion, String modelo);
    public void onAveriaUpdateClickListener(long id, String titulo, String descripcion, String modelo);

}
