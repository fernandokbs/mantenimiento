package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.modelo.Triplan;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TriplanDAO {

    private Log log = LogFactory.getLog(TriplanDAO.class);

    public TriplanDAO() {
    }


    public Triplan buscarPorId(Long idTriplan, boolean bloquear)
            throws ExcepcionInfraestructura {

        Triplan triplan = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTriplan + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                triplan = (Triplan)HibernateUtil.getSession()
                                                .load(Triplan.class, 
                                                      idTriplan, 
                                                      LockMode.UPGRADE);
            } else {
                triplan = (Triplan)HibernateUtil.getSession()
                                                .load(Triplan.class,
                                                      idTriplan);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return triplan;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection triplanes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            triplanes = HibernateUtil.getSession()
                                    .createCriteria(Triplan.class)
                                    .list();
                                    
              log.debug(">buscarTodos() ---- list   " + triplanes.size());
			log.debug(">buscarTodos() ---- contenido   " + triplanes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return triplanes;
    }


    public Collection buscarPorEjemplo(Triplan triplan)
            throws ExcepcionInfraestructura {


        Collection triplanes;
 
        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Triplan.class);
            triplanes = criteria.add(Example.create(triplan)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return triplanes;
    }


    public void hazPersistente(Triplan triplan)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(triplan)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(triplan);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Triplan triplan)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(triplan)");
        }

        try {
            HibernateUtil.getSession().delete(triplan);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeTriplan(String nombreTriplan)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
            
            
//            String consultaCuentaRoles =
//            "select count(*) from Ciudad r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles, 
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato
 
            String hql = "select nombre from Triplan where nombre = :nombre";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreTriplan);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreTriplan);
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

    //cambios
    public Collection buscarImagen(String nombreTriplan)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
            String hql = "from Triplan where nombre = '"+nombreTriplan+"'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreTriplan);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }
            
            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

	public Collection buscarTriplan(String nombreTriplan)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
            String hql = "from Triplan where nombre like '"+nombreTriplan+"%'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreTriplan);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }
            
            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    public boolean modificar( Triplan triplan ) throws ExcepcionInfraestructura {
        boolean toReturn = false;

        if (this.log.isDebugEnabled()) {
            this.log.debug(">modificar(triplan)");
        }
        try {
            HibernateUtil.getSession().saveOrUpdate(triplan);

            toReturn = true;
        } catch (HibernateException ex) {
            if (this.log.isWarnEnabled()) {
                this.log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return toReturn;
    }
        
    public Collection buscarEstado(String nombreLugar)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {
 
            String hql = "from Triplan where nombre = '"+nombreLugar+"'";
            
             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreLugar);
            }
        
            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return results;
            }
            
            return results;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }
    
    public Collection ordenarTriplanesPor(String attribute)
            throws ExcepcionInfraestructura {

        Collection triplanes;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            String hql = "from Triplan ORDER BY " + attribute;

            if (log.isDebugEnabled()) {
                log.debug(hql);
            }

            triplanes = HibernateUtil.getSession()
                    .createQuery(hql).list();
            if (log.isDebugEnabled()) {
                log.debug("<<<<<<<<< create query ok ");
            }
            /*hoteles = HibernateUtil.getSession()
                                    .createCriteria(Hotel.class)
                                    .list();*/

            log.debug(">buscarTodos() ---- list   " + triplanes.size());
            log.debug(">buscarTodos() ---- contenido   " + triplanes);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return triplanes;
    }
}
