/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco_api.presentation.controladores;

import com.fpmislata.banco.business.domain.Rol;
import com.fpmislata.banco.business.domain.Usuario;
import com.fpmislata.banco_api.presentation.security.WebSession;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alumno
 */
@Controller
@RequestMapping(value = {"/login"})
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public void nuevaSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Usuario usuario = new Usuario("admin", "admin", Rol.ADMINISTRADOR);
        httpServletRequest.getSession().setAttribute("WEB_SESSION", new WebSession(usuario, new Date()));
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    }
}
