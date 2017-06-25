/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.modelo.Lugar;
import edu.uag.iidis.scec.servicios.ManejadorLugares;
import edu.uag.iidis.scec.vista.FormaModificarLugar;
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
public class MCUModificarLugar extends MappingDispatchAction{
    
    private final Log log = LogFactory.getLog(MCUModificarLugar.class);
    
    public ActionForward solicitarModificarLugar(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        if (this.log.isDebugEnabled()) {
            this.log.debug(">solicitarModificarLugar");
        }
        FormaModificarLugar formaModificarLugar = (FormaModificarLugar)form;
        System.out.println("Get imagen " + formaModificarLugar.getImagen());
        
        return mapping.findForward("exito");
    }

    public ActionForward procesarModificarLugar(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        if (this.log.isDebugEnabled()) {
            this.log.debug("> procesarModificarLugar");
        }
        
        FormaModificarLugar formaModificarLugar = (FormaModificarLugar)form;
        Lugar lugar = new Lugar(
                formaModificarLugar.getNombre(),
                formaModificarLugar.getDescripcion(),
                formaModificarLugar.getPoblacion(),
                formaModificarLugar.getCoordenadas(),
                formaModificarLugar.getEstado(),
                formaModificarLugar.getImagen(),
                formaModificarLugar.getPais(),
                formaModificarLugar.getMoneda()
        );
        
        lugar.setId(formaModificarLugar.getId());
        ManejadorLugares m = new ManejadorLugares();
        Boolean flag = m.modificarLugar(lugar);
        
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");
    }
    
}
