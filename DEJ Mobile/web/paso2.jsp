<%-- 
    Document   : paso2
    Created on : 09-12-2016, 14:36:53
    Author     : Luis Fredes & José Villaseca
--%>
<%@page import="ENTITY.Cliente"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Paso 2</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bg-info">
        <% ENTITY.Cliente user = new Cliente();
            String rut = "";
            if (request.getSession().getAttribute("userSes") == null) {
                response.sendRedirect("login.jsp");
            } else {
                user = (ENTITY.Cliente) request.getSession().getAttribute("userSes");
            }

        %>
        <label><span style="color: black" class="skills">
                Bienvenido : <%= user.getNombre() + " " + user.getApellidoPaterno() + " " + user.getApellidoMaterno()%> 
            </span></label> 
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-text">
                        <h1>Solicita tu Plan :: Paso 2</h1>
                        <form action="ConfirmaPlanServlet" method="post">
                            <div class="row control-group">
                                <div class="form-group col-xs-12">
                                    Confirma tu Plan:<br>
                                    <% String detalle1 = "", detalle2 = "", detalle3 = "", detalle4 = "";
                                        if (request.getSession().getAttribute("detalle1") != null
                                                && request.getSession().getAttribute("detalle2") != null
                                                && request.getSession().getAttribute("detalle3") != null
                                                && request.getSession().getAttribute("detalle4") != null) {
                                            detalle1 = request.getSession().getAttribute("detalle1").toString();
                                            detalle2 = request.getSession().getAttribute("detalle2").toString();
                                            detalle3 = request.getSession().getAttribute("detalle3").toString();
                                            detalle4 = request.getSession().getAttribute("detalle4").toString();
                                        }
                                        rut = user.getRutCliente();
                                    %>
                                    <div class="row control-group">
                                        <div class="form-group col-xs-12 floating-label-form-group controls">                                                                       
                                            <br>
                                            <input type="text" name="txtdetalle1" value="<%= detalle1%>" readonly=""  />
                                            <br>
                                        </div>
                                    </div>
                                    <div class="row control-group">
                                        <div class="form-group col-xs-12 floating-label-form-group controls">                                                                       
                                            <br>
                                            <input type="text" name="txtdetalle2" value="<%= detalle2%>" readonly=""  />
                                            <br>
                                        </div>
                                    </div>
                                    <div class="row control-group">
                                        <div class="form-group col-xs-12 floating-label-form-group controls">                                                                       
                                            <br>
                                            <input type="text" name="txtdetalle3" value="<%= detalle3%>" readonly=""  />
                                            <br>
                                        </div>
                                    </div>
                                    <div class="row control-group">
                                        <div class="form-group col-xs-12 floating-label-form-group controls">                                                                       
                                            <br>
                                            Total: $<input type="text" name="txtdetalle4" value="<%= detalle4%>" readonly=""  /> Mensuales
                                            <input type="text" name="txtrut" value="<%= rut%>" readonly="" style="visibility: hidden"/>
                                            <br>
                                        </div>
                                    </div>                                    
                                    <div class="row control-group">
                                        <div class="form-group col-xs-12">                                                                       
                                            <br>
                                            <input type="submit" value="Solicitar Plan" class="btn btn-lg btn-success bg-danger"/>                                                                   
                                            <p class="help-block text-danger"></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a href="paso1.jsp">VOLVER</a> 
                            <div class="row control-group">
                                <div class="form-group col-xs-12">                                                                       
                                    <br>
                                    <a  href="index.jsp" class="btn btn-lg btn-default" role="button">Ir al Menú</a> 

                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            
                            <script src="js/validaciones.js" type="text/javascript"></script>
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
    </body>
</html>
