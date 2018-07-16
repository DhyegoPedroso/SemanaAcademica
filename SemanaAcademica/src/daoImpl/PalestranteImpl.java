/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import dao.ConnectionsFactory;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.bean.Palestrante;

/**
 *
 * @author felipedania
 */
public class PalestranteImpl implements PalestranteDao, Serializable {

    private Palestrante palestrante;
    private Connection conn = ConnectionsFactory.getConnection();
    private PreparedStatement psmt = null;
    String sql = "";

    @Override
    public void salvar(Object object) throws SQLException {
        ResultSet rs = null;
        palestrante = (Palestrante) object;
        sql = "INSERT INTO palestrante(nome, nomePalestra, dataPalestra) values(?, ?, ?)";
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, palestrante.getNome());
            psmt.setString(2, palestrante.getNomePalestra());
            psmt.setInt(3, palestrante.getDataPalestra());
            psmt.setInt(5, palestrante.getId());
            psmt.executeUpdate();
            rs = psmt.getGeneratedKeys();
            rs.next();
            palestrante.setId(rs.getInt(1));

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        ResultSet rs = null;
        palestrante = (Palestrante) object;
        try {
            sql = "UPDATE palestrante SET nome = ?, nomePalestra = ?, dataPalestra = ? WHERE idPalestrante = ?";
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, palestrante.getNome());
            psmt.setString(2, palestrante.getNomePalestra());
            psmt.setInt(3, palestrante.getDataPalestra());
            psmt.setInt(5, palestrante.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar palestrante " + e.getMessage());
        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            psmt = conn.prepareStatement("DELETE FROM palestrante WHERE idPalestrante = ?");
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir " + e.getMessage());
        }
    }

    @Override
    public Object pesquisarPorId(Integer id) throws SQLException {
        ResultSet rs = null;
        sql = "SELECT * FROM palestrante where idPalestrante = ?";
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            if (rs.next()) {
                palestrante = new Palestrante();
                palestrante.setId(rs.getInt("idPalestrante"));
                palestrante.setNome(rs.getString("nome"));
                palestrante.setNomePalestra(rs.getString("nomePalestra"));
                palestrante.setDataPalestra(rs.getInt("dataPalestra"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por idPalestrante " + e.getMessage());
        }
        return palestrante;
    }

    @Override
    public List<Palestrante> pesquisarPorNome(String nome) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Palestrante> pesquisarAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
