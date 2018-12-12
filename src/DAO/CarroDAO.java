package DAO;

import model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;
import javax.swing.JOptionPane;

public class CarroDAO extends ExecuteSQL {

    public CarroDAO(Connection con) {
        super(con);
    }

    public ArrayList<Carro> getCarroLista() {
        ArrayList<Carro> carros = new ArrayList<>();
        String query = "Select * From Carro";
        try {
            PreparedStatement ps = getCon().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt(1));
                carro.setNome(rs.getString("NOME"));
                carro.setAno(rs.getString("ANO"));
                carro.setFabricante(rs.getString("FABRICANTE"));
                carro.setPreco(rs.getFloat("PRECO"));
                carros.add(carro);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        Conexao.FecharConexão(getCon());
        return carros;
    }

    public boolean AlterarCarro(int pk_ve, String newNome, String newAno, String newFabricante, float newPreco) {
        // criando o codigo sql para trabalhar com o banco
        String consulta
                = "UPDATE carro SET"
                + " nome = '" + newNome + "',"
                + " ano = '" + newAno + "',"
                + " fabricante = '" + newFabricante + "',"
                + " preco = '" + newPreco + "'"
                + " WHERE pk_niv = '" + pk_ve + "'";
        try {
            PreparedStatement ps = getCon().prepareStatement(consulta);
            //Realizando um teste para ver se a Execução da consulta no banco deu certo, ele retorna 1 se der certo
            if (ps.executeUpdate() > 0) {
                Conexao.FecharConexão(getCon());
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar");
            System.out.println("CAUSADO POR: " + e.getMessage());
        }
        Conexao.FecharConexão(getCon());
        return false;
    }

    public boolean CadastrarCarro(String nomeCarro, String ano, String fabricante, float preco) {
        // criando o codigo sql para trabalhar com o banco
        String consulta
                = "INSERT INTO carro "
                + "("
                + "pk_niv,"
                + " nome, "
                + "ano, "
                + "fabricante,"
                + " preco"
                + ") "
                + "VALUES"
                + "("
                + "0, '"
                + "" + nomeCarro + "',"
                + " '" + ano + "',"
                + " '" + fabricante + "',"
                + " " + preco 
                + ")";
        try {
            PreparedStatement ps = getCon().prepareStatement(consulta);
            //Realizando um teste para ver se a Execução da consulta no banco deu certo, ele retorna 1 se der certo
            if (ps.executeUpdate() > 0) {
                Conexao.FecharConexão(getCon());
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
            System.out.println("CAUSADO POR: " + e.getMessage());
        }
        Conexao.FecharConexão(getCon());
        return false;
    }

    public boolean ExcluirCarro(int pk_niv) {
        // criando o codigo sql para trabalhar com o banco
        String consulta = "DELETE FROM carro WHERE pk_niv = "+pk_niv;
        try {
            PreparedStatement ps = getCon().prepareStatement(consulta);
            //Realizando um teste para ver se a Execução da consulta no banco deu certo, ele retorna 1 se der certo
            if (ps.executeUpdate() > 0) {
                Conexao.FecharConexão(getCon());
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir");
            System.out.println("CAUSADO POR: " + e.getMessage());
        }
        Conexao.FecharConexão(getCon());
        return false;
    }
}
