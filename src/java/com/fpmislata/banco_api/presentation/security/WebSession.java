/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco_api.presentation.security;

import com.fpmislata.banco.business.domain.Usuario;
import java.util.Date;

/**
 *
 * @author alumno
 */
public class WebSession {
    private Usuario usuario;
    private Date fechaCreacion;

    public WebSession(Usuario usuario, Date fechaCreacion) {
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
    }

    public WebSession() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
