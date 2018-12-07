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
                carro.setNome(rs.getString("NOME"));
                carro.setAno(rs.getString("ANO"));
                carro.setFabricante(rs.getString("FABRICANTE"));
                carro.setPreco(rs.getFloat("PRECO"));
                carros.add(carro);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return carros;
    }

    public boolean AlterarCarro(int pk_ve, String newNome, String newAno, String newFabricante, float newPreco) {

        boolean isUser = false;

        String consulta = "UPDATE Carros SET nome = '" + newNome + "' , ano = '" + newAno + "', fabricante = '" + newFabricante + "', preco = '" + newPreco + "'  WHERE pk_ve = '" + pk_ve + "'";

        try {
            PreparedStatement ps = getCon().prepareStatement(consulta);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao logar");
            System.out.println("CAUSADO POR: " + e.getMessage());
        }
        Conexao.FecharConexão(getCon());
        return isUser;
    }
}
