<%-- 
    Document   : altaPaciente
    Created on : 25 may. 2024, 18:32:26
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
<h1 class="h3 mb-2 text-gray-800">Alta paciente</h1>

<form class="user" action="SvPaciente" method="Post">
    <div class="form-group row">
        <div class="col-sm-12 mb-3">
        <input type="text" class="form-control form-control-user" id="responsable" name="responsable"
               placeholder="Dueño" required>
    </div> 
        <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="nombre" name="nombre"
               placeholder="Nombre" required>
    </div>
    <div class="col-sm-6 mb-3">
        <input type="date" class="form-control form-control-user" id="fecha_nacimiento" name="fecha_nacimiento"
               placeholder="Fecha de nacimiento" required>
    </div>

    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="especie" name="especie"
               placeholder="Especie required">
    </div>
    <div class="col-sm-6 mb-3">
        <input type="text" class="form-control form-control-user" id="raza" name="raza"
               placeholder="Raza" required>
    </div>



</div>

<button class="btn btn-primary btn-user btn-block" type="submit">
    Crear perfil
</button>

</form>


<%@include file="Componentes/footer.jsp" %>
