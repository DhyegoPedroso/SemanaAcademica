/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import java.sql.SQLException;

public interface BaseDao {

    void salvar(Object object) throws SQLException;

    void alterar(Object object) throws SQLException;

    void excluir(Integer id) throws SQLException;

    Object pesquisarPorId(Integer id) throws SQLException;
}
