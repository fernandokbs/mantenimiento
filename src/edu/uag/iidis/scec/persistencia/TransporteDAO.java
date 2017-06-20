package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Transporte;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TransporteDAO {

    private Log log = LogFactory.getLog(TransporteDAO.class);

    public TransporteDAO() {
    }


    public Transporte buscarPorId(Long idTransporte, boolean bloquear)
            throws ExcepcionInfraestructura {

        Transporte transporte = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTransporte + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                transporte = (Transporte)HibernateUtil.getSession()
                                                .load(Transporte.class, 
                                                      idTransporte, 
                                                      LockMode.UPGRADE);
            } else {
                transporte = (Transporte)HibernateUtil.getSession()
                                                .load(Transporte.class,
                                                      idTransporte);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return transporte;
    }
    

    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection transportees;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            transportees = HibernateUtil.getSession()
                                    .createCriteria(Transporte.class)
                                    .list();
									
			  log.debug(">buscarTodos() ---- list	");									
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return transportees;
    }


    public Collection buscarPorEjemplo(Transporte transporte)
            throws ExcepcionInfraestructura {


        Collection transportees;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Transporte.class);
            transportees = criteria.add(Example.create(transporte)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return transportees;
    }


    public void hazPersistente(Transporte transporte)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(transporte)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(transporte);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Transporte transporte)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(transporte)");
        }

        try {
            HibernateUtil.getSession().delete(transporte);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeTransporte(String tipo)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
			
			
//            String consultaCuentaRoles =
//            "select count(*) from Transporte r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
			String hql = "select tipo from Transporte where tipo = :tipo";
			
			 if (log.isDebugEnabled()) {
           		 log.debug(hql + tipo);
        	}
		
			Query query = HibernateUtil.getSession()
										.createQuery(hql);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< create query ok " );
        	}

			query.setParameter("tipo", tipo);
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
        	}
			List results = query.list();
			int resultado = results.size();
			if (log.isDebugEnabled()) {
           		 log.debug("<<<<<<<<< Result size " + resultado);
        	}
            if (resultado == 0) {
               return false;
            }
            
            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}