/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import java.sql.SQLException;
import java.util.List;
import model.bean.Relatorio;

/**
 *
 * @author dhyeg
 */
public interface RelatorioDao extends BaseDao {

    public List<Relatorio> pesquisarAll() throws SQLException;
}
