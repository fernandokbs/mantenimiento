package edu.uag.iidis.scec.control;


import edu.uag.iidis.scec.control.MCULogin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando
 */
public class MCULogout extends MappingDispatchAction{
    private Log log = LogFactory.getLog(MCULogout.class);

    public ActionForward solicitarLogout(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
    {
        request.getSession().invalidate();
        return (mapping.findForward("exito"));
    }
    
}
