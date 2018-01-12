package apirest.iaramburu.conexion_api_rest.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by i.aramburu on 12/01/2018.
 */

public class ResponseAverias {

    @SerializedName("averias")
    @Expose
    private List<AveriaDB> averias = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseAverias() {
    }

    /**
     *
     * @param averias
     */
    public ResponseAverias(List<AveriaDB> averias) {
        super();
        this.averias = averias;
    }

    public List<AveriaDB> getAverias() {
        return averias;
    }

    public void setAverias(List<AveriaDB> averias) {
        this.averias = averias;
    }

    public ResponseAverias withAverias(List<AveriaDB> averias) {
        this.averias = averias;
        return this;
    }


}
