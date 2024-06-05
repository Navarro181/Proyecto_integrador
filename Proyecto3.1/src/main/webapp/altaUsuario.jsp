<%-- 
    Document   : altaUsuario
    Created on : 7 may. 2024, 20:27:04
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
<h1 class="h3 mb-2 text-gray-800">Alta de usuarios</h1>

<form class="user" action="SvUsuarios" method="Post">
    <div class="form-group col">
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusu" name="nombreusu"
                   placeholder="Nombre usuario" required>
        </div>
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol" required>
        </div>
        <div class="col-sm-12 mb-3">
            <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña" required>
        </div>
      

 
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear usuario
    </button>

</form>


<%@include file="Componentes/footer.jsp" %>
