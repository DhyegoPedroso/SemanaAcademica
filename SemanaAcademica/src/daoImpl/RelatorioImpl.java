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
import java.util.ArrayList;
import java.util.List;
import model.bean.Aluno;
import model.bean.Palestra;
import model.bean.Relatorio;

/**
 *
 * @author dhyeg
 */
public class RelatorioImpl implements RelatorioDao, Serializable {

    private Relatorio relatorio;
    private Connection conn = ConnectionsFactory.getConnection();
    private PreparedStatement psmt = null;
    private ResultSet rs;
    String sql = "";

    @Override
    public void salvar(Object object) throws SQLException {
        relatorio = (Relatorio) object;
        sql = "INSERT INTO relatorio(idAluno, idPalestra, dia) values(?, ?, current_timestamp)";
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, relatorio.getAluno().getId());
            psmt.setInt(2, relatorio.getPalestra().getId());
            psmt.executeUpdate();

        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {

    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Object pesquisarPorId(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Relatorio> pesquisarAll() throws SQLException {
        List<Relatorio> relatorios = new ArrayList<>();
        try {
            conn = ConnectionsFactory.getConnection();
            psmt = conn.prepareStatement("select r.idRelatorio, a.nomeAluno, a.nomeCurso, a.faseCurso, p.tituloPalestra, p.diaPalestra,  r.dia  \n"
                    + "from relatorio r \n"
                    + "inner join aluno a on r.idAluno = a.idAluno\n"
                    + "inner join palestra p on r.idPalestra = p.idPalestra "
                    + "order by r.idRelatorio");
            rs = psmt.executeQuery();

            while (rs.next()) {
                relatorio = new Relatorio();
                relatorio.setId(rs.getInt("idRelatorio"));
                Aluno aluno = new Aluno();
                aluno.setNome(rs.getString("nomeAluno"));
                aluno.setNomeCurso(rs.getString("nomeCurso"));
                aluno.setFaseCurso(rs.getInt("faseCurso"));
                Palestra palestra = new Palestra();
                palestra.setTitulo(rs.getString("tituloPalestra"));
                palestra.setDia(rs.getInt("diaPalestra"));
                relatorio.setData(rs.getTimestamp("dia"));
                relatorio.setAluno(aluno);
                relatorio.setPalestra(palestra);
                relatorios.add(relatorio);
            }
        } finally {
            ConnectionsFactory.closeConnection(conn, psmt, rs);
        }
        return relatorios;
    }
}
