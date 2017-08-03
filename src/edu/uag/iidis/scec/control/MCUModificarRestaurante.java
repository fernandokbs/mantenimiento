package edu.uag.iidis.scec.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.modelo.Hotel;
import edu.uag.iidis.scec.modelo.Restaurante;
import edu.uag.iidis.scec.vista.FormaModificarRestaurante;

public class MCUModificarRestaurante extends MappingDispatchAction {

    private final Log log = LogFactory.getLog(MCUModificarRestaurante.class);

    public ActionForward solicitarModificarRestaurante(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (this.log.isDebugEnabled()) {

            this.log.debug(">solicitarModificarRestaurante");

        }
        return mapping.findForward("exito");
    }

    public ActionForward procesarModificarRestaurante(ActionMapping mapping, ActionForm form,
                HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        if (this.log.isDebugEnabled()) {
            this.log.debug("> procesarModificarRestaurante");
        }

        FormaModificarRestaurante formaModificarRestaurante = (FormaModificarRestaurante) form;

        //Hotel(String nombre, String descripcion,String precio,String horario,String estado, String imagen, String pais, String direccion);
        Restaurante restaurante = new Restaurante(
                formaModificarRestaurante.getNombre(),
                formaModificarRestaurante.getDescripcion(),
                formaModificarRestaurante.getPrecio(),
                formaModificarRestaurante.getHorario(),
                formaModificarRestaurante.getEstado(),
                formaModificarRestaurante.getImagen(),
                formaModificarRestaurante.getPais(),
                formaModificarRestaurante.getDireccion()
        );

        restaurante.setId(formaModificarRestaurante.getId());
        
        ManejadorRestaurantes manejadorRestaurantes = new ManejadorRestaurantes();

        manejadorRestaurantes.modificarRestaurante(restaurante );
        ActionMessages errores = new ActionMessages();

        return mapping.findForward("exito");
    }
}
