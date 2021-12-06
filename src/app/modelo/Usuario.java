
package app.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String usuario;
    private String contraseña;
    private String repContraseña;
   //private registrarse vRegistrarse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRepContraseña() {
        return repContraseña;
    }

    public void setRepContraseña(String repContraseña) {
        this.repContraseña = repContraseña;
    }

     public boolean esEmail(String correo) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher;
        matcher = pattern.matcher(correo);

        return matcher.find();
    }
    
    
}
