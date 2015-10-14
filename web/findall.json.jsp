<%@page import="com.fpmislata.banco.presentation.json.impl.JsonTransformerImplJackson"%>
<%@page import="com.fpmislata.banco.presentation.json.JsonTransformer"%>
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
    JsonTransformer jsonTransformer = new JsonTransformerImplJackson();

    String jsonEntidadBancaria = jsonTransformer.toJson(entidadesBancarias);

    out.println(jsonEntidadBancaria);
%>