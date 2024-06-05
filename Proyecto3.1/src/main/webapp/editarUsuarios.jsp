<%-- 
    Document   : altaUsuario
    Created on : 7 may. 2024, 20:27:04
    Author     : Sergio
--%>

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
<h1 class="h3 mb-2 text-gray-800">Editar usuarios</h1>

<%Usuario usuario=(Usuario)request.getSession().getAttribute("usuEditar");%>

<form class="user" action="SvEditUsuarios" method="Post">
    <div class="form-group col">
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusu" name="nombreusu"
                   placeholder="Nombre usuario" value="<%=usuario.getNombreUsuario()%>">
        </div>
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol"value="<%=usuario.getRol()%>">
        </div>
        <div class="col-sm-12 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" value="<%=usuario.getContrasenia()%>">
        </div>
      

 
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">
        Guardar cambios
    </button>

</form>


<%@include file="Componentes/footer.jsp" %>
