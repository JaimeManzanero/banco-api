
<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();

int idEntidadBancaria = Integer.parseInt(request.getParameter("idEntidadBancaria"));

EntidadBancaria entidadBancaria = entidadBancariaService.get(idEntidadBancaria);
%>

{
"idEntidadBancaria":<%=entidadBancaria.getIdEntidadBancaria()%>,
"nombre":"<%=entidadBancaria.getNombre()%>",
"codigoEntidad":"<%=entidadBancaria.getCodigoEntidad()%>",
"fechaCreacion":"<%=entidadBancaria.getFechaCreacion()%>",
"direccion":"<%=entidadBancaria.getDireccion()%>",
"cif":"<%=entidadBancaria.getCIF()%>"
}
