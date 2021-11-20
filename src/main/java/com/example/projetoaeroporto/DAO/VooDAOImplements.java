package com.example.projetoaeroporto.DAO;

import com.example.projetoaeroporto.entity.Voo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VooDAOImplements implements VooDAO{

    private static final String URLDB = "jdbc:mariadb://localhost:3306/Aeroporto?allowMultiQueries=true";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "poo123";


    public VooDAOImplements() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URLDB, USUARIO, PASSWORD);
    }

    @Override
    public void reservar(Voo v) {
        try {
            Connection con = getConnection();
            String sql = "INSERT INTO pet (id, origem, destino, decolagem, preco) " +
                    "VALUES (?, ?, ?, ?, ?)";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, v.getId());
            stmt.setString(2, v.getOrigem());
            stmt.setString(3, v.getDestino());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(v.getDecolagem()));
            stmt.setDouble(5, v.getPreco());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Voo> pesquisarPorId(Integer id) {
        List<Voo> lista = new ArrayList<>();
        try {
            Connection con = getConnection();
            String sql = "SELECT * FROM voo WHERE id like ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + id + "%");
            ResultSet rs = stmt.executeQuery();

            while( rs.next() ) {
                Voo v = new Voo();
                v.setId(rs.getInt("id"));
                v.setOrigem(rs.getString("Origem"));
                v.setDestino(rs.getString("Destino"));
                v.setDecolagem(rs.getTimestamp("Decolagem").toLocalDateTime());
                v.setPreco(rs.getDouble("Preço"));
                lista.add(v);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void remover(int id) {
        try {
            Connection con = getConnection();
            String sql = "DELETE FROM voo WHERE id = ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(int id, Voo v) {
        try {
            Connection con = getConnection();
            String sql = "UPDATE pet SET id = ?, origem = ?, destino = ?, decolagem = ?, preco=? WHERE id = ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, v.getId());
            stmt.setString(2, v.getOrigem());
            stmt.setString(3, v.getDestino());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(v.getDecolagem()));
            stmt.setDouble(5, v.getPreco());
            stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
