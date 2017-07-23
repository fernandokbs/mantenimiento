/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.modelo.Triplan;
import edu.uag.iidis.scec.servicios.ManejadorLugares;
import edu.uag.iidis.scec.servicios.ManejadorTriplanes;
import edu.uag.iidis.scec.vista.FormaModificarLugar;
import edu.uag.iidis.scec.vista.FormaModificarTriplan;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author Fernando
 */
public class MCUModificarTriplan extends MappingDispatchAction{
    
    private final Log log = LogFactory.getLog(MCUModificarTriplan.class);
    
    public ActionForward solicitarModificarTriplan(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        if (this.log.isDebugEnabled()) {
            this.log.debug(">solicitarModificarLugar");
        }
        FormaModificarTriplan formaModificarTriplan = (FormaModificarTriplan)form;
        System.out.println("Get imagen " + formaModificarTriplan.getImagen());
        
        return mapping.findForward("exito");
    }

    public ActionForward procesarModificarTriplan(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        if (this.log.isDebugEnabled()) {
            this.log.debug("> procesarModificarLugar");
        }
        
        FormaModificarTriplan formaModificarTriplan = (FormaModificarTriplan)form;
        Triplan triplan = new Triplan(
                formaModificarTriplan.getNombre(),
                formaModificarTriplan.getDescripcion(),
                formaModificarTriplan.getPoblacion(),
                formaModificarTriplan.getCoordenadas(),
                formaModificarTriplan.getEstado(),
                formaModificarTriplan.getImagen(),
                formaModificarTriplan.getPais(),
                formaModificarTriplan.getMoneda()
        );
        
        triplan.setId(formaModificarTriplan.getId());
        ManejadorTriplanes m = new ManejadorTriplanes();
        Boolean flag = m.modificarTriplan(triplan);
        
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");
    }
    
}

