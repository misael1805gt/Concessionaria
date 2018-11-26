/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;

/**
 *
 * @author Kbyte
 */
public class UsuarioDAO extends ExecuteSQL {

    public UsuarioDAO(Connection con) {
        super(con);
    }
    
    public boolean logar(String login, String senha) {

        boolean isUser = false;
        
        String consulta = "SELECT id, login, senha FROM usuario WHERE login = '" + login + "' AND senha = '" + senha + "'";

        try {
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                Usuario user = new Usuario();

                if (rs.next()) {

                    user.setId(rs.getInt(1));
                    user.setLogin(rs.getString(2));
                    user.setSenha(rs.getString(3));
                    isUser = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar");
            System.out.println("CAUSADO POR: " + e.getMessage());
        }
        return isUser;
    }

}
