/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author Fernando
 */
public class MCUEliminarLugar extends MappingDispatchAction{
     private Log log = LogFactory.getLog(MCUEliminarLugar.class);
     
      public ActionForward procesarEliminarLugar(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception 
      {
          if (log.isDebugEnabled()) {
            log.debug(">procesarEliminarLugar");
        }

        FormaEliminarLugar forma = (FormaEliminarLugar)form;
        ManejadorLugares mr = new ManejadorLugares();
        mr.eliminarLugar(forma.getId());
          return (mapping.findForward("exito"));
      }
}
