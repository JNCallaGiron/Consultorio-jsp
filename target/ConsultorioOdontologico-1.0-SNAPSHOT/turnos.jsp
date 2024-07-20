<%@page import="logica.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<h1>Aquí se asignarán los turnos a los pacientes</h1>

<%
    Paciente pac = (Paciente) request.getSession().getAttribute("paciente");
    List<Odontologo> listaOdontologos = (List<Odontologo>) request.getSession().getAttribute("listaOdontologos");
%>

<form action="SvTurnos" method="post">
    <input type="hidden" name="idPaciente" value="<%= pac.getId() %>">

    <div class="form-group">
        <label for="nombre_apellido">Nombre y Apellido del paciente</label>
        <input type="text" class="form-control" id="nombre_apellido" name="nombre_apellido" value="<%= pac.getNombre() + " " + pac.getApellido() %>" readonly>
    </div>

    <div class="form-group">
        <label for="fecha_turno">Fecha del Turno</label>
        <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required>
    </div>

    <div class="form-group">
        <label for="hora_turno">Hora del Turno</label>
        <input type="time" class="form-control" id="hora_turno" name="hora_turno" required>
    </div>

    <div class="form-group">
        <label for="afeccion">Afección</label>
        <input type="text" class="form-control" id="afeccion" name="afeccion" required>
    </div>

    <div class="form-group">
        <label for="odontologo">Odontólogo</label>
        <select class="form-control" id="odontologo" name="odontologo" required>
            <option value="" disabled selected>Seleccione un odontólogo</option>
                <% for (Odontologo odonto : listaOdontologos) {
                       if (odonto.getUnHorario() != null) {
                %>
                    <option value="<%= odonto.getId() %>"><%= odonto.getNombre() + " " + odonto.getApellido() %></option>
                <% } } %>
        </select>
    </div>

    <div class="form-group">
        <label for="responsable">Responsable</label>
        <input type="text" class="form-control" id="responsable" name="responsable" required>
    </div>
        
    <div class="col-sm-6 mb-3">
            <label>Tiene Obra Social</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="obra_social" id="obra_social_si" value="Si">
                <label class="form-check-label" for="obra_social_si">Sí</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="obra_social" id="obra_social_no" value="No" checked>
                <label class="form-check-label" for="obra_social_no">No</label>
            </div>
      </div>

    <button type="submit" class="btn btn-primary">Asignar Turno</button>
</form>

<%@include file="/components/bodyfinal.jsp"%>
