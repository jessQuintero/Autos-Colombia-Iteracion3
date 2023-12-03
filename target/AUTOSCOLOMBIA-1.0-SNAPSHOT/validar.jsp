<%-- 
    Document   : validar
   
--%>

<% 
	if (session.getAttribute("sesion") == null) {
		request.setAttribute("mensaje", "Debe autenticarse para ingresar al sistema");
		pageContext.forward("index.jsp");
	}
%>