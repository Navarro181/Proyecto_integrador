<%-- 
    Document   : Altas.jsp
    Created on : 5 may. 2024, 20:36:55
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
<h1 class="h3 mb-2 text-gray-800">Alta veterinarios</h1>

<form class="user" action="SvVet" method="Post">
    <div class="form-group row">
        <div class="col-sm-2 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" name="dni"
                   placeholder="DNI" required>
        </div>
        <div class="col-sm-5 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
                   placeholder="Nombre" required>
        </div>
        <div class="col-sm-5 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido" required>
        </div>
        <div class="col-sm-4 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono"
                   placeholder="Telefóno" required>
        </div>
                <div class="col-sm-8 mb-3">
            <input type="text" class="form-control form-control-user" id="correo" name="correo"
                   placeholder="Correo" required>
        </div>    
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion"
                   placeholder="Domicilio">
        </div>
                <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad"
                   placeholder="Especialidad" required>
        </div>       

 
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">
        Crear perfil
    </button>

</form>


<%@include file="Componentes/footer.jsp" %>