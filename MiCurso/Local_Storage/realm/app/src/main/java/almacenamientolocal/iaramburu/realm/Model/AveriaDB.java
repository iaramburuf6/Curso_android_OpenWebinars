package almacenamientolocal.iaramburu.realm.Model;

import almacenamientolocal.iaramburu.realm.app.MyApp;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by inakiaramburu on 5/1/18.
 */

public class AveriaDB extends RealmObject {

    // Para recibir los parametros
    public static final String AVERIADB_ID = "id";
    public static final String AVERIADB_TITULO = "titulo";
    public static final String AVERIADB_DESCRIPCION = "descripcion";
    public static final String AVERIADB_MODELOCOCHE = "modeloCoche";

    @PrimaryKey
    private long id;

    private String titulo;
    private String modeloCoche;
    private String urlFoto;
    private String descripcion;
    private int numeroPresupuestos;

    public AveriaDB() {

        // Conseguir e incrementar en 1 el valor del ID gracias al metodo de la clase AtomicLong
        this.id = MyApp.AveriaID.incrementAndGet();
    }

    public AveriaDB(String titulo, String modeloCoche, String urlFoto, int numeroPresupuestos, String descripcion) {
        this.id = MyApp.AveriaID.incrementAndGet();
        this.descripcion=descripcion;
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlFoto = urlFoto;
        this.numeroPresupuestos = numeroPresupuestos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroPresupuestos() {
        return numeroPresupuestos;
    }

    public void setNumeroPresupuestos(int numeroPresupuestos) {
        this.numeroPresupuestos = numeroPresupuestos;
    }
}
