<%@page import="com.fpmislata.banco.business.service.impl.EntidadBancariaServiceImpl"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.service.EntidadBancariaService"%>
<%@page import="com.fpmislata.banco.business.domain.EntidadBancaria"%>
<%@page import="java.util.List"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%
    EntidadBancariaService entidadBancariaService = new EntidadBancariaServiceImpl();
    List<EntidadBancaria> entidadesBancarias = entidadBancariaService.findAll();
    
%>
[
<%
    int contador = 0;
    for (EntidadBancaria entidadBancaria: entidadesBancarias){
        
        contador++;
%>
{
    "idEntidadBancaria":<%=entidadBancaria.getIdEntidadBancaria()%>,
    "nombre":"<%=entidadBancaria.getNombre()%>",
    "codigoEntidad":"<%=entidadBancaria.getCodigoEntidad()%>",
    "fechaCreacion":"<%=entidadBancaria.getFechaCreacion()%>",
    "direccion":"<%=entidadBancaria.getDireccion()%>",
    "cif":"<%=entidadBancaria.getCIF()%>"
}
<%if(contador < entidadesBancarias.size()){%>
,
<% } %>
<% } %>
]