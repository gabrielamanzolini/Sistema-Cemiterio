package br.edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.entidade.Terreno;
import br.edu.fatec.jdbc.ConnectionFactory;

public class TerrenoDao {

	private Connection connection;
	
	public TerrenoDao(){
		this.connection =  new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Terreno t) {
		
		String sql = "INSERT INTO terrenos (nome, rua, lote, largura, comprimento, preco, observacao) " +
				 " VALUES (?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement( sql );
			stmt.setString( 1, t.getNome() );
			stmt.setString(2, t.getRua());
			stmt.setInt(3, t.getLote());
			stmt.setInt(4,  t.getLargura());
			stmt.setInt(5 , t.getComprimento());
			stmt.setDouble(6, t.getPreco());
			stmt.setString(7, t.getObservacao());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void altera(Terreno t) {
		
		String sql = "UPDATE terrenos SET nome=?, rua=?, lote=?, largura=?, comprimento=?, preco=?, observacao=? " +
				 " WHERE id=? ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement( sql );
			stmt.setString( 1, t.getNome() );
			stmt.setString(2, t.getRua());
			stmt.setInt(3, t.getLote());
			stmt.setInt(4,  t.getLargura());
			stmt.setInt(5 , t.getComprimento());
			stmt.setDouble(6, t.getPreco());
			stmt.setString(7, t.getObservacao());
			stmt.setLong(8, t.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remove(Terreno terreno) {
		
		try {
			String sql = "delete from terrenos where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, terreno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public List<Terreno> getLista() {
		
		try {
			String sql = "select * from terrenos";
			List<Terreno> terrenos = new ArrayList<Terreno>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Terreno terreno = new Terreno();
				terreno.setId(rs.getLong("id"));
				terreno.setNome(rs.getString("nome"));
				terreno.setRua(rs.getString("rua"));
				terreno.setLote(rs.getInt("lote"));
				terreno.setLargura(rs.getInt("largura"));
				terreno.setComprimento(rs.getInt("comprimento"));
				terreno.setPreco(rs.getDouble("preco"));
				
				terrenos.add(terreno);
				
			}
			rs.close();
			stmt.close();
			
			return terrenos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public List<Terreno> getTerreno(String numId) {
		
		try {
			String sql = "select * from terrenos where id = '" + numId + "'";
			List<Terreno> terrenos = new ArrayList<Terreno>();
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Terreno terreno = new Terreno();
				terreno.setId(rs.getLong("id"));
				terreno.setNome(rs.getString("nome"));
				terreno.setRua(rs.getString("rua"));
				terreno.setLote(rs.getInt("lote"));
				terreno.setLargura(rs.getInt("largura"));
				terreno.setComprimento(rs.getInt("comprimento"));
				terreno.setPreco(rs.getDouble("preco"));
				
				terrenos.add(terreno);
				
			}
			rs.close();
			stmt.close();
			
			return terrenos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
