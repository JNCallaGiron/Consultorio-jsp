<%@page import="logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyprimeraparte.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Ver Odontólogos</h1>
    <p class="mb-4">A continuación podrá visualizar la lista completa de odontólogos</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Odontólogos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Hora de Entrada</th>
                            <th>Nombre de Odontólogo</th>
                            <th>Apellido de Odontólogo</th>
                            <th>Especialidad</th>
                            <th>Hora de Salida</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Hora de Entrada</th>
                            <th>Nombre de Odontólogo</th>
                            <th>Apellido de Odontólogo</th>
                            <th>Especialidad</th>
                            <th>Hora de Salida</th>
                            <th style="width: 210px">Acción</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% 
                            // Obtener la lista de odontólogos de la sesión
                            List<Odontologo> listaOdontologos = (List<Odontologo>) request.getSession().getAttribute("listaOdonto");

                            // Verificar si la lista no está vacía
                            if (listaOdontologos != null && !listaOdontologos.isEmpty()) {
                                // Iterar sobre la lista y mostrar solo los odontólogos que tienen horario asignado
                                for (Odontologo odo : listaOdontologos) {
                                    if (odo.getUnHorario() != null) {
                        %>
                        <tr>
                            <td><%= odo.getId() %></td>
                            <td><%= odo.getUnHorario().getHorario_inicio() %></td>
                            <td><%= odo.getNombre() %></td>
                            <td><%= odo.getApellido() %></td>
                            <td><%= odo.getEspecialidad() %></td>
                            <td><%= odo.getUnHorario().getHorario_fin() %></td>
                            <td style="display: flex; width: 230px;">
                               
                                <!-- Botón para eliminar el odontólogo -->
                                <form name="eliminar" action="SvElimOdonto" method="POST">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="background-color:red; margin-right: 5px;">
                                        <i class="fas fa-trash-alt"></i> Eliminar
                                    </button>
                                    <input type="hidden" name="id" value="<%= odo.getId() %>">
                                </form>
                                <!-- Botón para editar el odontólogo -->
                                <form name="editar" action="SvEditOdonto" method="GET">
                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                        <i class="fas fa-pencil-alt"></i> Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%= odo.getId() %>">
                                </form>
                            </td>
                        </tr>
                        <% 
                                    } // Fin de la verificación del horario
                                } // Fin del bucle for
                            } else { 
                        %>
                        <tr>
                            <td colspan="7">No hay datos disponibles.</td>
                        </tr>
                        <% 
                            } // Fin de la verificación de la lista
                        %>
                    </tbody>

                </table>
            </div>
        </div>
    </div>
</div>
<!-- /.container-fluid -->

<%@ include file="components/bodyfinal.jsp"%>
