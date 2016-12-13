<%-- 
    Document   : conector
    Created on : 08-12-2016, 10:22:21
    Author     : Luis Fredes & José Villaseca
--%>
<%@page import="DAO.ComunaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>DEJ Mobile</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <style>
            div.dej {
                background-color: tomato;
                color: white;
                margin: 20px 0 20px 0;
                padding: 20px;
            } 
        </style>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <script src="js/validaciones.js" type="text/javascript"></script>
    </head>

    <body id="page-top" >
        <div class="bg-info">
            <div class="container" >
                <div class="row">
                    <div class="col-lg-6">
                        <div class="intro-text">
                            <h1>Registro</h1>
                            <form action="crudCliente" method="post" name="form2" onSubmit="javascript:return VerificaRut(document.form2.txtRut.value)">
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Rut:<br>
                                        <input type="text" pattern="[0-9]{7,8}-[0-9Kk]{1}" title="Ejemplo 11222333-4" name="txtRut" class="form-control" placeholder="Ingrese su Rut" required data-validation-required-message="Ingrese su Rut">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Clave:<br>
                                        <input type="password" pattern="[0-9]{4}$" title="Ejemplo ****" name="txtClave" class="form-control" placeholder="Ingrese su Clave" required data-validation-required-message="Ingrese su Clave">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Confirmar Clave:<br>
                                        <input type="password" pattern="[0-9]{4}$" title="Ejemplo ****" name="txtConfirmaClave" class="form-control" placeholder="Confirmar Clave" required data-validation-required-message="Confirme su Clave">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Nombre:<br>
                                        <input type="text" pattern="[A-Za-z]+" name="txtNombre" class="form-control" placeholder="Ingrese su Nombre" required data-validation-required-message="Ingrese su Nombre">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Apellido Paterno:<br>
                                        <input type="text" pattern="[A-Za-z]+" name="txtApePaterno" class="form-control" placeholder="Ingrese su Apellido Paterno" required data-validation-required-message="Ingrese su Apellido Paterno">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Apellido Materno:<br>
                                        <input type="text" pattern="[A-Za-z]+"name="txtApeMaterno" class="form-control" placeholder="Ingrese su Apellido Materno" required data-validation-required-message="Ingrese su Apellido Materno">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Direccion:<br>
                                        <input type="text" pattern="[A-Za-z0-9]+"name="txtDireccion" class="form-control" placeholder="Ingrese su Direccion" required data-validation-required-message="Ingrese su Direccion">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Numeracion:<br>
                                        <input type="text" pattern="[0-9]+" title="Ejemplo 1234" name="txtNumeracion" class="form-control" placeholder="Ingrese su Numeracion" required data-validation-required-message="Ingrese su Numeracion">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Seleccione Comuna:<br><% try {
                                                DAO.ComunaDAO reComDao = new ComunaDAO();%>
                                        <select name="ddlComuna" class="form-control">
                                            <% for (ENTITY.Comuna tmp : reComDao.getLista()) {%>
                                            <option><%= tmp.getNombreComuna()%></option><%}%>
                                        </select>*
                                        <%} catch (Exception e) {
                                                out.print(e.getMessage());
                                            }%>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        Telefono:<br>
                                        <input type="text" pattern="[0-9]{9}$" title="Ejemplo 9 XXXX XXXX o 2 2XXX XXXX" name="txtTelefono" class="form-control" placeholder="Ingrese su Telefono" required data-validation-required-message="Ingrese su Telefono">
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 ">
                                        <br>
                                        <input type="submit" value="ENVIAR" class="btn btn-success" onclick="checkRut()"/>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="row control-group">
                                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                        <br>
                                        <a href="index.jsp">
                                            <span style="color: blue">VOLVER</span>
                                        </a>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>                                
                                Todos los Campos Obligatorios.
                                <% String message = (String) request.getAttribute("alertMsg");%>
                                <script type="text/javascript">
                                    var msg = "<%=message%>";
                                    alert(msg);
                                </script>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer>
            <div class="container">
                <p>&copy; 2016 DEJ MOBILE. All Rights Reserved.</p>            
            </div>
        </footer>

        <!-- jQuery -->
        <script src="vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        <!-- Theme JavaScript -->
        <script src="js/new-age.min.js"></script>

    </body>

</html>

