package apirest.iaramburu.conexion_api_rest.Interfaces;

import apirest.iaramburu.conexion_api_rest.Responses.ResponseAverias;
import apirest.iaramburu.conexion_api_rest.Responses.ResponseRegistro;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by i.aramburu on 12/01/2018.
 */

public interface ApiMecAroundInterface {

    // Metodo para hacer una accion cuando se incluye esa URL. Es FormUrlEncoded porque se pasan los parametros como x-www-form-urlencoded
    @FormUrlEncoded
    @POST("auth/login")
    Call<ResponseRegistro> doLogin(@Field("email") String e,
                                   @Field("password") String p);


    @GET("averia/lista")
    Call<ResponseAverias> getAverias(@Query("X-API-KEY") String key);

}
