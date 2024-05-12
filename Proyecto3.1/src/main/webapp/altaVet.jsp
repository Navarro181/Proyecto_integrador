<%-- 
    Document   : Altas.jsp
    Created on : 5 may. 2024, 20:36:55
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
<h1>Alta veterinario</h1>

<form class="user">
    <div class="form-group row">
        <div class="col-sm-2 mb-3">
            <input type="text" class="form-control form-control-user" id="dni"
                   placeholder="DNI">
        </div>
        <div class="col-sm-5 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre"
                   placeholder="Nombre">
        </div>
        <div class="col-sm-5 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido"
                   placeholder="Apellido">
        </div>
        <div class="col-sm-4 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono"
                   placeholder="Telefóno">
        </div>
                <div class="col-sm-8 mb-3">
            <input type="text" class="form-control form-control-user" id="correo"
                   placeholder="Correo">
        </div>    
        <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="domicilio"
                   placeholder="Domicilio">
        </div>
                <div class="col-sm-12 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad"
                   placeholder="Especialidad">
        </div>       

 
    </div>

    <a href="XXX" class="btn btn-primary btn-user btn-block">
        Crear veterinario
    </a>

</form>


<%@include file="Componentes/footer.jsp" %>