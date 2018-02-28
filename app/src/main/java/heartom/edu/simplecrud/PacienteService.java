package heartom.edu.simplecrud;


import java.util.List;

import heartom.edu.simplecrud.Otro.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PacienteService {

    @GET("users")
    Call<List<Usuario>> getPacientes();

    @POST("users")
    Call<Usuario> registrarPaciente(@Body Usuario paciente);
}
