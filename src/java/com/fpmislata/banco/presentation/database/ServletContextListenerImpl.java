/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentation.database;

import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.presentation.json.JsonTransformer;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author alumno
 */
public class ServletContextListenerImpl implements ServletContextListener{
    @Autowired
    JsonTransformer jsonTransformer;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory=webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
        EntidadBancaria entidadBancaria = new EntidadBancaria(1, "Pro", 1, new Date(), "Calle de pros", "pro");
        String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);
        System.out.println(jsonEntidadBancaria);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        AutowireCapableBeanFactory autowireCapableBeanFactory=webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
        EntidadBancaria entidadBancaria = new EntidadBancaria(2, "Puro Pro", 2, new Date(), "Calle de pros", "pro");
        String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);
        System.out.println(jsonEntidadBancaria);
    }
    
}
