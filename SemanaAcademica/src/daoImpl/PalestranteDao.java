/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import java.sql.SQLException;
import java.util.List;
import model.bean.Palestrante;

/**
 *
 * @author felipedania
 */
public interface PalestranteDao extends BaseDao {

    List<Palestrante> pesquisarPorNome(String nome) throws SQLException;

    List<Palestrante> pesquisarAll() throws SQLException;

}
