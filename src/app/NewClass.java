package app;

import app.DAO.SqlUsuarios;
import app.gui.Inicio;
import app.gui.Registro;
import app.modelo.Usuario;

public class NewClass {

    public static void main(String[] args) {
        Usuario us = new Usuario();
        SqlUsuarios sqlUs = new SqlUsuarios();
        Registro vRegistrarse = new Registro();

        Inicio vInicio = new Inicio();
        vInicio.setVisible(true);
        vInicio.setLocationRelativeTo(vInicio);

    }

}
