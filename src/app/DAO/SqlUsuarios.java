package app.DAO;

import app.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends Conexion {

    public Boolean registrarse(Usuario us) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuario (nombre, apellido, dni, correo, usuario, contraseña) VALUES (?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getApellido());
            ps.setString(3, us.getDni());
            ps.setString(4, us.getCorreo());
            ps.setString(5, us.getUsuario());
            ps.setString(6, us.getContraseña());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public int existeCorreo(String correo) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT count (id) FROM usuario WHERE correo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public boolean login(Usuario us) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT contraseña, correo FROM  usuario WHERE correo = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, us.getCorreo());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (us.getContraseña().equals(rs.getString(1))) {

                    us.setCorreo(rs.getString(2));
                  
                    return true;
                } else {
                    return false;
                }
            }

            return false;

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, e);
            }
        }

    }

}
