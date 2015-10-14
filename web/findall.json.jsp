<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page import="java.util.List"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();
    
    int contador = 0;
    for (EntidadBancaria entidadBancaria: entidadesBancarias){
        
        contador++;
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonEntidadBancaria = objectMapper.writeValueAsString(entidadBancaria);
        
        out.println(jsonEntidadBancaria);
        
    }
%>