/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Juciano Victor
 */
public class ExecuteSQL {
    private Connection con; //Variável con
   
    public ExecuteSQL(Connection con){ //Método construtor que executará o setCon() sempre que for instaciado um objeto dessa classe
    setCon(con);
    }

    public Connection getCon(){ //Pega o valor con da classe
    return con;
    }
    
    public void setCon(Connection con) {
     this.con = con; //A variável con da class recebe o valor de con do parâmetro
    }
}
