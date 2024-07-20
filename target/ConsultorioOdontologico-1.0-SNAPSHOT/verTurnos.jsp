<%@page import="java.util.List"%>
<%@page import="logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Listado de Turnos</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de turnos</p>
    
    <%
    List<Turno> listaTurnos = (List<Turno>) request.getSession().getAttribute("listaTurnos");
%>

    
    

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Turnos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID Paciente</th>
                            <th>Nombre Paciente</th>
                            <th>Apellido Paciente</th>
                            <th>Fecha del Turno</th>
                            <th>Hora del Turno</th>
                            <th>Afección</th>
                            <th>Odontólogo</th>
                            <th>Responsable</th>
                            <th>Obra Social</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID Paciente</th>
                            <th>Nombre Paciente</th>
                            <th>Apellido Paciente</th>
                            <th>Fecha del Turno</th>
                            <th>Hora del Turno</th>
                            <th>Afección</th>
                            <th>Odontólogo</th>
                            <th>Responsable</th>
                            <th>Obra Social</th>
                            <th>Acciones</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% if (listaTurnos != null) { 
                            for (Turno turno : listaTurnos) { %>
                            <tr>
                                <td><%= turno.getPacien().getId() %></td>
                                <td><%= turno.getPacien().getNombre() %></td>
                                <td><%= turno.getPacien().getApellido() %></td>
                                <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(turno.getFecha_turno()) %></td>
                                <td><%= turno.getHora_turno() %></td>
                                <td><%= turno.getAfeccion() %></td>
                                <td><%= turno.getOdonto().getNombre() + " " + turno.getOdonto().getApellido() %></td>
                                <td><%= turno.getPacien().getUnResponsable().getTipo_resp() %></td>
                                <td><%= turno.getPacien().isTiene_OS() ? "Sí" : "No" %></td>
                                <td style="display: flex; width: 230px;">
                                    
                                    <form action="SvElimTurnos" method="post" style="display:inline;">
                                        <input type="hidden" name="idTurno" value="<%= turno.getId_turno() %>">
                                        <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;"> 
                                            <i class="fas fa-trash-alt"></i> Eliminar
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        <% } } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<%@include file="/components/bodyfinal.jsp" %>
