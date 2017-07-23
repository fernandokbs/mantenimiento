/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uag.iidis.scec.pruebas;

import edu.uag.iidis.scec.modelo.Hotel;
import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.persistencia.HotelDAO;
import edu.uag.iidis.scec.persistencia.LugarDAO;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import static edu.uag.iidis.scec.pruebas.HotelDAOTest.suite;
import junit.extensions.TestSetup;
import static junit.framework.Assert.assertTrue;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 *
 * @author Fernando
 */




public class LugarDAOTest extends TestCase {
    
    public void testCrearHotelE() throws Exception {
        LugarDAO dao = new LugarDAO();
        
        Lugar lugar = new Lugar(
                "lugar4", "lugar", 400l, "54", "chiapas", "lugar.jpg", "mexico", "peso"
        );
        
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(lugar);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Lugar lugarb = dao.buscarPorNombre(lugar.getNombre());
            assertTrue(lugarb != null);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Lugar lugar2 = dao.buscarPorNombre(lugar.getNombre());
            if (lugar2 != null) {
                dao.hazTransitorio(lugar2);
            }
            HibernateUtil.commitTransaction();
            
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally {
            HibernateUtil.closeSession();
        }
    }
    
    public void testActualizarLugarE() throws Exception {
        LugarDAO dao = new LugarDAO();
        
        Lugar lugar = new Lugar(
                "lugarUpdate", "lugar", 400l, "54", "chiapas", "lugar.jpg", "mexico", "peso"
        );
        
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(lugar);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Lugar lugarB = dao.buscarPorNombre(lugar.getNombre());
            lugarB.setNombre(lugarB.getNombre());
            Boolean a = dao.modificar(lugarB);
            assertTrue(a);
            HibernateUtil.commitTransaction();
            
            HibernateUtil.beginTransaction();
            Lugar lugar2 = dao.buscarPorNombre(lugar.getNombre());
            if (lugar2 != null) {
              dao.hazTransitorio(lugar2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteLugarE() throws Exception {


        LugarDAO dao = new LugarDAO();
        Lugar lugar = new Lugar(
                "lugarExiste", "lugar", 400l, "54", "chiapas", "lugar.jpg", "mexico", "peso"
        );
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(lugar);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeLugar(lugar.getNombre());
            assertTrue(existe);
            HibernateUtil.commitTransaction();
            
            HibernateUtil.beginTransaction();
            Lugar lugar2 = dao.buscarPorNombre(lugar.getNombre());
            if (lugar2 != null) {
              dao.hazTransitorio(lugar2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testExisteLugarF() throws Exception {
        LugarDAO dao = new LugarDAO();
        Lugar lugar = new Lugar(
                "lugarExiste", "lugar", 400l, "54", "chiapas", "lugar.jpg", "mexico", "peso"
        );
        
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(lugar);
            HibernateUtil.commitTransaction();


            HibernateUtil.beginTransaction();
            Boolean existe =  dao.existeLugar("adsfasdf");
            assertTrue(! existe);
            HibernateUtil.commitTransaction();
            
            HibernateUtil.beginTransaction();
            Lugar lugar2 = dao.buscarPorNombre(lugar.getNombre());
            if (lugar2 != null) {
              dao.hazTransitorio(lugar2);
            }
            HibernateUtil.commitTransaction();

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public void testEliminarLugarE() throws Exception {
        
        LugarDAO dao = new LugarDAO();
        Lugar lugar = new Lugar(
                "lugarEliminar", "lugar", 400l, "54", "chiapas", "lugar.jpg", "mexico", "peso"
        );
        
        try {

            HibernateUtil.beginTransaction();
            dao.hazPersistente(lugar);
            HibernateUtil.commitTransaction();

            HibernateUtil.beginTransaction();
            Lugar lugar2 = dao.buscarPorNombre(lugar.getNombre());
            if (lugar2 != null) {
              dao.hazTransitorio(lugar2);
            }
            HibernateUtil.commitTransaction();

            Lugar lugarb = dao.buscarPorNombre(lugar.getNombre());

            assertTrue(lugarb == null);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }
    
    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(LugarDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                
                // Se ejecuta al inicio de la suite

                //SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
                //ddlExport.create(false, true);

                //dao = new UsuarioDAO();
                //rolDAO = new RolDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                //dao = null;
                //rolDAO = null;
            }
        };

        return suite;
    }
    
    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }
}
