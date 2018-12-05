package DAO;

import model.Carro;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

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

}
