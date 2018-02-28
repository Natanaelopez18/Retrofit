package heartom.edu.simplecrud.Otro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nathanael López on 16/2/2018.
 */

public class Usuario {

    private int id;
    @SerializedName("username")
    @Expose
    private String userName;
    private String email;
    private String password;
    @SerializedName("created_at")
    @Expose
    private  String fechaCreada;
    @SerializedName("updated_at")
    @Expose
    private String fecchaActualizada;


    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechaCreada(String fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public void setFecchaActualizada(String fecchaActualizada) {
        this.fecchaActualizada = fecchaActualizada;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFechaCreada() {
        return fechaCreada;
    }

    public String getFecchaActualizada() {
        return fecchaActualizada;
    }
}
