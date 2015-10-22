/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation.controladores;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.business.service.EntidadBancariaService;
import com.fpmislata.banco.presentation.json.JsonTransformer;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EntidadBancariaController {
    
    @Autowired
    EntidadBancariaService entidadBancariaService;
    @Autowired
    JsonTransformer jsonTransformer;
    
    @RequestMapping(value="/entidadBancaria", method=RequestMethod.GET, produces="application/json")
    public void findAll(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();
        String jsonEntidadBancaria = jsonTransformer.toJson(entidadesBancarias);
        try{
            httpServletResponse.getWriter().println(jsonEntidadBancaria);
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
    
    @RequestMapping(value="/entidadBancaria/{id}", method=RequestMethod.GET, produces="application/json")
    public void get(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        try{
            httpServletResponse.getWriter().println(jsonTransformer.toJson(entidadBancariaService.get(id)));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
    
    @RequestMapping(value="/entidadBancaria/{id}", method=RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int id){
        
        entidadBancariaService.delete(id);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    @RequestMapping(value="/entidadBancaria", method=RequestMethod.POST, consumes="application/json", produces="application/json")
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        try{
            EntidadBancaria entidadBancaria = jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
            jsonTransformer.toJson(entidadBancariaService.insert(entidadBancaria));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        }catch(Exception ex){
//            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(ex);
        }
    }
    
    @RequestMapping(value="/entidadBancaria/", method=RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada){
        EntidadBancaria entidadBancaria = jsonTransformer.fromJson(jsonEntrada, EntidadBancaria.class);
        try{
            httpServletResponse.getWriter().println(jsonTransformer.toJson(entidadBancariaService.update(entidadBancaria)));
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException ex) {
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
