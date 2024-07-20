<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<h1>Alta Pacientes</h1>

<p>Este es el apartado para dar de alta los diferentes Pacientes del sistema.</p>

<form class="user" action="SvPacientes" method="post">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" name="dni" placeholder="DNI">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombre" name="nombre" placeholder="Nombre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido" placeholder="Apellido">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="telefono" name="telefono" required placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="direccion" name="direccion" required placeholder="Dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fechanac" name="fecha_nac" required placeholder="Fecha Nac">
        </div>

        <!-- Datos propios de Pacientes -->
        <div class="col-sm-6 mb-3">
            <label>¿Tiene Obra Social?</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tiene_os" id="tiene_os_si" value="Si">
                <label class="form-check-label" for="tiene_os_si">Sí</label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tiene_os" id="tiene_os_no" value="No" checked>
                <label class="form-check-label" for="tiene_os_no">No</label>
            </div>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre" required placeholder="Tipo de Sangre">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="responsable" name="responsable" placeholder="Responsable">
        </div>
    </div>

    <button class="btn btn-primary btn-user btn-block" type="submit">Crear Paciente</button>
</form>

<%@include file="/components/bodyfinal.jsp" %>
