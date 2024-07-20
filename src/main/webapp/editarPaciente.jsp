<%@page import="logica.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/components/header.jsp" %>
<%@include file="/components/bodyprimeraparte.jsp" %>

<h1>Edicion de  Pacientes</h1>

<p>Este es el apartado para editar los diferentes pacientes del sistema.</p>

<% Paciente pac = (Paciente) request.getSession().getAttribute("editPaciente"); %>

<form class="user" action="SvEditPaciente" method="post">
     <div class="form-group col">
         
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" 
                   name="dni" placeholder="DNI" value="<%=pac.getDni() %>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="nombre"
                    name="nombre" placeholder="Nombre" value="<%=pac.getNombre() %>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                   placeholder="Apellido" value="<%=pac.getApellido() %>" >
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="telefono" name="telefono"  required
                    placeholder="Teléfono" value="<%=pac.getTelefono() %>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="direccion" name="direccion"  required
                    placeholder="Dirección" value="<%=pac.getDireccion() %>" >
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fechanac" name="fecha_nac"  required 
                   placeholder="Fecha Nac" value="<%=pac.getFecha_nac() %>" >
        </div>
        
        <!-- Datos propios de Pacientes -->
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="tiene_os" name="tiene_os"  required
                    placeholder="tiene obra social" value="<%=pac.isTiene_OS() %>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="tipoSangre" name="tipoSangre"  required
                    placeholder="Tipo de Sangre" value="<%=pac.getTipoSangre() %>" >
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="responsable" name= "responsable" 
                    placeholder="Responsable" value="<%=pac.getUnResponsable().getTipo_resp() %>" >
        </div>
                                   
    </div>
                                
    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Guardar Cambios de Paciente
    </button>
                               
</form>


<%@include file="/components/bodyfinal.jsp" %>
