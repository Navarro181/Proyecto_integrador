<%-- 
    Document   : verUsuarios
    Created on : 18 may. 2024, 22:14:32
    Author     : Sergio
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Componentes/header.jsp"%>
<%@include file="Componentes/body.jsp" %>
               <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver usuarios</h1>


                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" widht="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre de usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <% 
                                    List<Usuario>listaUsuarios=(List)request.getSession().getAttribute("listaUsuarios");
                                    %>
                                    
                                    <tbody>
                                        <%
                                        for(Usuario usuario: listaUsuarios){
                                        %>                                       
          
                                        <tr>
                                            <td><%=usuario.getId_usuario()%> </td>                                     
                                            <td><%=usuario.getNombreUsuario()%> </td>
                                            <td><%=usuario.getRol()%> </td>
                                            
                                            <td style="display: flex; width: 230px;">
                                                <form name="eliminar" action="SvElimUsuarios" method="POST">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background: #e02d1b;margin-right: 5px;"> 
                                                        <i class="fas fa-trash-alt"></i>Eliminar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=usuario.getId_usuario()%>">
                                                </form>
                                                
                                                <form name="editar" action="SvEditUsuarios" method="get">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;"> 
                                                        <i class="fas fa-pencil-alt"></i>Editar
                                                    </button>
                                                    <input type="hidden" name="id" value="<%=usuario.getId_usuario()%>">
                                                </form>                                                
                                            </td>
                                            

                                        </tr>
                                        <%}
                                        %>
                                    </tbody>
                            </table>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->



<%@include file="Componentes/footer.jsp" %>

