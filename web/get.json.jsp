
<%@page import="com.fpmislata.banco.presentation.json.impl.JsonTransformerImplJackson"%>
<%@page import="com.fpmislata.banco.presentation.json.JsonTransformer"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));
EntidadBancaria entidadBancaria = entidadBancariaService.get(idEntidadBancaria);
JsonTransformer jsonTransformer = new JsonTransformerImplJackson();


String jsonEntidadBancaria = jsonTransformer.toJson(entidadBancaria);

out.println(jsonEntidadBancaria);
%>

