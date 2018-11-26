/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Juciano Victor
 */
public class Conexao {

    public static Connection AbrirConexão() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/db_concessionaria";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Deu ruim :" + e.getMessage());
        }
        return con;
    }

    public static void FecharConexão(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Deu ruim :" + e.getMessage());
        }
    }

}
