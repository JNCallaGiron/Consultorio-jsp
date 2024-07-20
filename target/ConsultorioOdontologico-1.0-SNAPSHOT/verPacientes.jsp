<%@page import="logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa pacientes</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre de Paciente</th>
                            <th>Apellido de Paciente</th>
                            <th>Dni</th>
                            <th>Obra Social</th>
                            <th>Tipo de Sangre</th>
                            <th>Responsable</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                           <th>Id</th>
                            <th>Nombre de Paciente</th>
                            <th>Apellido de Paciente</th>
                            <th>Dni</th>
                            <th>Obra Social</th>
                            <th>Tipo de Sangre</th>
                            <th>Responsable</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% 
                            // Obtener la lista de pacientes de la sesión
                            List<Paciente> listaPacientes = (List<Paciente>) request.getSession().getAttribute("listaPacientes");

                            // Iterar sobre la lista y mostrar solo los pacientes
                            for (Paciente pac : listaPacientes) {
                                String obraSocial = pac.isTiene_OS() ? "Sí" : "No";
                                String responsable = pac.getUnResponsable() != null ? pac.getUnResponsable().toString() : "N/A"; // Asume que getUnResponsable() devuelve un objeto Responsable
                        %>
                        <tr>
                            <td id="id_usu<%= pac.getId() %>"><%= pac.getId() %></td>
                            <td><%= pac.getNombre() %></td>
                            <td><%= pac.getApellido() %></td>
                            <td><%= pac.getDni() %></td>
                            <td><%= obraSocial %></td>
                            <td><%= pac.getTipoSangre() %></td>
                            <td><%= responsable %></td>
                            <td style="display: flex; width: 230px;">
                                <form name="eliminar" action="SvElimPacientes" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getId() %>">
                                </form>
                                <form name="editar" action="SvEditPaciente" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getId() %>">
                                </form>
                                <form name="turno" action="SvTurnos" method="get">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:green; margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Dar Turno
                                    </button>
                                    <input type="hidden" name="id" value="<%= pac.getId() %>">
                                </form>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<%@include file="/components/bodyfinal.jsp" %>
