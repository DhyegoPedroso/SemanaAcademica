/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import java.util.List;
import java.sql.SQLException;
import model.bean.Aluno;

/**
 *
 * @author felipedania
 */
public interface AlunoDao extends BaseDao {

    List<Aluno> pesquisarPorNome(String nome) throws SQLException;

    List<Aluno> pesquisarAll() throws SQLException;

}
