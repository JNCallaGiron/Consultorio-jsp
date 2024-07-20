<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="components/header.jsp"%>
<%@ include file="components/bodyprimeraparte.jsp"%>

<h1>Alta Odontólogos</h1>
<p>Esto es una prueba</p>

<form class="user" action="SvOdonto" method="post">
     <div class="form-group col">
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="dni" name="dni" placeholder="DNI">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="nombre" name="nombre" placeholder="Nombre">
        </div>
         <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="apellido" name="apellido"
                                            placeholder="Apellido">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="telefono" name="telefono"  required
                                            placeholder="Teléfono">
        </div>
        <div class="col-sm-6 mb-3">
             <input type="text" class="form-control form-control-user" id="direccion" name="direccion"  required
                                            placeholder="Dirección">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="date" class="form-control form-control-user" id="fechanac" name="fecha_nac"  required
                                            placeholder="Fecha Nac">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="especialidad" name="especialidad" required
                                            placeholder="Especialidad">
        </div>
                                    
        <!-- Acá va a ir todo lo que respecta a horarios y usuarios -->
        <!-- Datos de usuario -->
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreUsuario" name="nombreUsuario" placeholder="Nombre de Usuario" required>
         </div>
        <div class="col-sm-6 mb-3">
                <input type="password" class="form-control form-control-user" id="contrasenia" name="contrasenia" placeholder="Contraseña" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="rol" name="rol" placeholder="Rol" required>
        </div>

        <!-- Datos de horario -->
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="horario_inicio" name="horario_inicio" placeholder="Horario Inicio" required>
        </div>
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="horario_fin" name="horario_fin" placeholder="Horario Fin" required>
        </div>
    
                                   
    </div>
                                
    <button class="btn btn-primary btn-user btn-block" type="submit"> 
        Crear Odontólogo
    </button>
                               
</form>


<%@ include file="components/bodyfinal.jsp"%>