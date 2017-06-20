package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Transporte;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TransporteDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTransporte {
    private Log log = LogFactory.getLog(ManejadorTransporte.class);
    private TransporteDAO dao;

    public ManejadorTransporte() {
        dao = new TransporteDAO();
    }


    public Collection listarTransportes() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ListarTransportes");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;         
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarTransporte(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarTransporte");
        }
        try {
            HibernateUtil.beginTransaction();           
            Transporte transporte = dao.buscarPorId(id, true);
            if (transporte != null) {
              dao.hazTransitorio(transporte);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearTransporte(Transporte transporte) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">crearTransporte");
        }

        try {
            HibernateUtil.beginTransaction();           
            
            if (dao.existeTransporte(transporte.getTipo())) {
               resultado = 1; // Excepci�n. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(transporte);

               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }    
}
