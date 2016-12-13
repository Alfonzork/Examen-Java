<%-- 
    Document   : paso1
    Created on : 09-12-2016, 14:36:42
    Author     : Luis Fredes & José Villaseca
--%>
<%@page import="ENTITY.Cliente"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator"%>
<%@page import="DAO.MinutoDAO"%>
<%@page import="DAO.CuotaDAO"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Paso 1</title>

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
        <%
            ENTITY.Cliente user = new Cliente();
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
                        <h1>Arma tu Plan :: Paso 1</h1>
                        <form action="SolicitudServlet" method="post">
                            <div class="row control-group">
                                <div class="form-group col-xs-3 floating-label-form-group controls">
                                    CUOTA:<br>
                                    <label>Cuota</label><% try {
                                            DAO.CuotaDAO reCuoDao = new CuotaDAO();
                                            DAO.MinutoDAO miDAO = new MinutoDAO(); %>
                                    <select name="ddlCuota" class="form-control">
                                        <% for (ENTITY.CuotaNavegacion tmp : reCuoDao.getLista()) {%>
                                        <option><%= tmp.getDescripcion()%></option><%}%>
                                    </select>*                                                                      
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    MINUTOS:<br><br><% for (ENTITY.Minuto mm : miDAO.getLista()) {%>
                                    <input type="radio" name="rbMinuto" value="<%= mm.getDescripcion() %>" /> <%= mm.getDescripcion() %><br>
                                   <p class="help-block text-danger"></p><%}%>
                                </div>
                                <%} catch (Exception e) {
                                        out.print(e.getMessage());
                                    }%>  
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls"> 
                                    <p></p>
                                    <input type="checkbox" name="cvDomicilio" value="ON" /> Entrega del Chip a Domicilio                             
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>                                    
                            <div class="row control-group">
                                <div class="form-group col-xs-12">                                                                       
                                    <br>
                                    <input type="submit" value="Paso 2" class="btn btn-success bg-danger"/>                                                                   
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 ">                                                                       
                                    <p></p>
                                    <a href="index.jsp">VOLVER</a>                                    
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
