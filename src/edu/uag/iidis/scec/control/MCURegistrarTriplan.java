package edu.uag.iidis.scec.control;

import java.util.Collection;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;
import java.io.*;
import java.util.*;
import org.apache.struts.upload.FormFile;


public final class MCURegistrarTriplan 
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarTriplan.class);


    public ActionForward solicitarRegistroTriplan(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroLugar");
        }
	FormaNuevoTriplan forma = (FormaNuevoTriplan)form;

        ManejadorEstados mr = new ManejadorEstados();
        Collection resultado = mr.listarEstados();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setEstados(resultado);
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));                
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }
		
    }



    public ActionForward procesarRegistroTriplan(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroLugar");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        
        String filePath = getServlet().getServletContext().getRealPath("/");
        log.debug("ruta: " + filePath);
        File folder = new File(filePath);
        if(!folder.exists()){
            folder.mkdir();
        }
        FormaNuevoTriplan forma = (FormaNuevoTriplan)form;
        FormFile file = forma.getImagen();
        String fileName = file.getFileName();
        File newFile =  null;
        if(!("").equals(fileName)){  
            
            newFile = new File(filePath, fileName);
              
            if(!newFile.exists()){
              FileOutputStream fos = new FileOutputStream(newFile);
              fos.write(file.getFileData());
              fos.flush();
              fos.close();
            }
        }
        Triplan triplan = new Triplan(forma.getNombre(),
                          forma.getDescripcion(),forma.getPoblacion(),forma.getCoordenadas(),forma.getEstado(),fileName,forma.getPais(),forma.getMoneda());

        ManejadorTriplanes mr = new ManejadorTriplanes();
        int resultado = mr.crearTriplan(triplan);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:   
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreLugarYaExiste",
                                               forma.getNombre()));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));                
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}

