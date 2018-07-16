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
import java.util.ArrayList;
import java.util.List;
import model.bean.Palestra;

/**
 *
 * @author felipedania
 */
public class PalestraImpl implements PalestraDao, Serializable {

    private Palestra palestra;
    private Connection conn = ConnectionsFactory.getConnection();
    private PreparedStatement psmt = null;
    private ResultSet rs;
    String sql = "";

    @Override
    public void salvar(Object object) throws SQLException {
        palestra = (Palestra) object;
        sql = "INSERT INTO palestra(tituloPalestra, descricaoPalestra, diaPalestra) values(?, ?, ?)";
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, palestra.getTitulo());
            psmt.setString(2, palestra.getDescricao());
            psmt.setInt(3, palestra.getDia());
            psmt.executeUpdate();
            rs = psmt.getGeneratedKeys();
            rs.next();
            palestra.setId(rs.getInt(1));

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            psmt = conn.prepareStatement("DELETE FROM evento WHERE idEvento = ?");
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir " + e.getMessage());
        }
    }

    @Override
    public Object pesquisarPorId(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Palestra> pesquisarPorNome(String nome) throws SQLException {
        return null;
    }

    @Override
    public List<Palestra> pesquisarAll() throws SQLException {

        List<Palestra> palestras = new ArrayList<>();
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement("select * from palestra");
            rs = psmt.executeQuery();

            while (rs.next()) {

                palestra = new Palestra();
                palestra.setId(rs.getInt("idPalestra"));
                palestra.setTitulo(rs.getString("tituloPalestra"));
                palestra.setDescricao(rs.getString("descricaoPalestra"));
                palestra.setDia(rs.getInt("diaPalestra"));
                palestras.add(palestra);

            }

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }

        return palestras;

    }

}
