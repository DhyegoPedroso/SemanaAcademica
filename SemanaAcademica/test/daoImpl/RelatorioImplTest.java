/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoImpl;

import java.sql.Timestamp;
import java.util.Date;
import model.bean.Aluno;
import model.bean.Palestra;
import model.bean.Palestrante;
import model.bean.Relatorio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dhyeg
 */
public class RelatorioImplTest {

    public RelatorioImplTest() {
    }

    @Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
//        (Integer id, Aluno aluno, Palestrante palestrante, Palestra palestra, Date data) {
        Aluno aluno = new Aluno();
        aluno.setId(1);
        Palestra palestra = new Palestra();
        palestra.setId(1);
        Palestrante palestrante = new Palestrante();
        palestrante.setId(1);
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Relatorio relatorio = new Relatorio(null, aluno,palestra);

        RelatorioImpl impl = new RelatorioImpl();
        impl.salvar(relatorio);

    }

//    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Object object = null;
        RelatorioImpl instance = new RelatorioImpl();
        instance.alterar(object);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Integer id = null;
        RelatorioImpl instance = new RelatorioImpl();
        instance.excluir(id);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        Integer id = null;
        RelatorioImpl instance = new RelatorioImpl();
        Object expResult = null;
        Object result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
