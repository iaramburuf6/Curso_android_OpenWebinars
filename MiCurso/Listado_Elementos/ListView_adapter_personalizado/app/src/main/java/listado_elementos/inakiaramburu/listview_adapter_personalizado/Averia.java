package listado_elementos.inakiaramburu.listview_adapter_personalizado;

/**
 * Created by inakiaramburu on 5/1/18.
 */

class Averia {

    private String titulo;
    private String modeloCoche;
    private String urlFoto;
    private int numeroPresupuestos;

    public Averia(String titulo, String modeloCoche, String urlFoto, int numeroPresupuestos) {
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

    public int getNumeroPresupuestos() {
        return numeroPresupuestos;
    }

    public void setNumeroPresupuestos(int numeroPresupuestos) {
        this.numeroPresupuestos = numeroPresupuestos;
    }
}
