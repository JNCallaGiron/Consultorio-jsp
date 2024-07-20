<%@page import="logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyprimeraparte.jsp"%>

<h1>Alta Odontólogos</h1>
<p>Este es el apartado para editar la informacion de un Odontólogo</p>

<% Odontologo odo = (Odontologo) request.getSession().getAttribute("odoEditar");  %>

<form class="user" action="SvEditOdonto" method="post">
     <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" 
                   name="dni" placeholder="DNI" value="<%=odo.getDni()%>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="nombre"
                    name="nombre" placeholder="Nombre" value="<%=odo.getNombre()%>">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" 
                   name="apellido" placeholder="Apellido" value="<%=odo.getApellido()  %>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="telefono"
                    name="telefono"  required placeholder="Teléfono" value="<%=odo.getTelefono()  %>">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="direccion" 
                    name="direccion"  required placeholder="Dirección" value="<%=odo.getDireccion()  %>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fechanac" 
                   name="fecha_nac"  required placeholder="Fecha Nac" value="<%=odo.getFecha_nac()  %>" >
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad" 
                   name="especialidad" required placeholder="Especialidad" value="<%=odo.getEspecialidad()  %>">
        </div>
                                    
        <!-- Acá va a ir todo lo que respecta a horarios y usuarios -->
        <!-- Datos de usuario -->
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" 
                   name="nombreUsuario" placeholder="Nombre de Usuario" value="<%=odo.getUnUsuario().getNombreUsuario()  %>" required>
         </div>
        <div class="col-sm-6 mb-3">
                <input type="password" class="form-control form-control-user" id="contrasenia"
                       name="contrasenia" placeholder="Contraseña" value="<%=odo.getUnUsuario().getContrasenia()%>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol"
                   name="rol" placeholder="Rol" value="<%=odo.getUnUsuario().getRol()  %>"  required>
        </div>

        <!-- Datos de horario -->
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="horario_inicio"
                   name="horario_inicio" placeholder="Horario Inicio" value="<%=odo.getUnHorario().getHorario_inicio()  %>" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="horario_fin"
                   name="horario_fin" placeholder="Horario Fin" value="<%=odo.getUnHorario().getHorario_fin()  %>"  required>
        </div>
    
                                   
    </div>
                                
    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Guardar Cambios
    </button>
                               
</form>


<%@ include file="components/bodyfinal.jsp"%>
