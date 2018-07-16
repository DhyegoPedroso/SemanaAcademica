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
import model.bean.Aluno;

/**
 *
 * @author felipedania
 */
public class AlunoImpl implements AlunoDao, Serializable {

    private Aluno aluno;
    private Connection conn = ConnectionsFactory.getConnection();
    private PreparedStatement psmt = null;
    private ResultSet rs;
    String sql = "";

    @Override
    public void salvar(Object object) throws SQLException {
        aluno = (Aluno) object;
        sql = "INSERT INTO aluno(nomeAluno, nomeCurso, faseCurso) values(?, ?, ?)";
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            psmt.setString(1, aluno.getNome());
            psmt.setString(2, aluno.getNomeCurso());
            psmt.setInt(3, aluno.getFaseCurso());
            psmt.executeUpdate();
            rs = psmt.getGeneratedKeys();
            rs.next();
            aluno.setId(rs.getInt(1));

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        aluno = (Aluno) object;
        try {
            sql = "UPDATE aluno SET nomeAluno = ?, nomeCurso = ?, faseCurso = ? WHERE idAluno = ?";
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, aluno.getNome());
            psmt.setString(2, aluno.getNomeCurso());
            psmt.setInt(3, aluno.getFaseCurso());
            psmt.setInt(4, aluno.getId());
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao alterar aluno " + e.getMessage());
        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        try {
            psmt = conn.prepareStatement("DELETE FROM aluno WHERE idAluno = ?");
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao excluir " + e.getMessage());
        }
    }

    @Override
    public Object pesquisarPorId(Integer id) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement("select * from aluno where idAluno = ?");
            psmt.setInt(1, id);
            rs = psmt.executeQuery();

            while (rs.next()) {
                aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeCurso(rs.getString("nomeCurso"));
                aluno.setFaseCurso(rs.getInt("faseCurso"));
                alunos.add(aluno);
            }
        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
        return alunos;
    }

    @Override
    public List<Aluno> pesquisarPorNome(String nome) throws SQLException {

        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement("select * from aluno where nomeAluno like ?");
            psmt.setString(1, "%" + nome + "%");
            rs = psmt.executeQuery();

            while (rs.next()) {

                aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeCurso(rs.getString("nomeCurso"));
                aluno.setFaseCurso(rs.getInt("faseCurso"));
                alunos.add(aluno);

            }

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }

        return alunos;

    }

    @Override
    public List<Aluno> pesquisarAll() throws SQLException {

        List<Aluno> alunos = new ArrayList<>();
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement("select * from aluno");
            rs = psmt.executeQuery();

            while (rs.next()) {

                aluno = new Aluno();
                aluno.setId(rs.getInt("idAluno"));
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeCurso(rs.getString("nomeCurso"));
                aluno.setFaseCurso(rs.getInt("faseCurso"));
                alunos.add(aluno);

            }

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }

        return alunos;

    }

}
