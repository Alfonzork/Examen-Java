<%-- 
    Document   : planes
    Created on : 10-12-2016, 15:45:58
    Author     : Luis Fredes & José Villaseca
--%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator"%>
<%@page import="ENTITY.Solicitud"%>
<%@page import="DAO.MinutoDAO"%>
<%@page import="DAO.CuotaDAO"%>
<%@page import="DAO.ClienteDAO"%>
<%@page import="ENTITY.Cliente"%>
<%@page import="DAO.SolicitudDAO"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Mis Planes</title>

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
    <div class="row control-group">
        <div class="form-group col-xs-12">                                                                       
            <br>
            <a  href="index.jsp">Ir al Menú</a> 
        </div>
    </div>
</head>
<body class="bg-success">
    <% ENTITY.Cliente user = new Cliente();
        if (request.getSession().getAttribute("userSes") == null) {
            response.sendRedirect("login.jsp");
        } else {
            user = (ENTITY.Cliente) request.getSession().getAttribute("userSes");
        }
        String rut = user.getRutCliente();
    %>
    <label><span style="color: black" class="skills">
            Bienvenido : <%= user.getNombre() + " " + user.getApellidoPaterno() + " " + user.getApellidoMaterno()%> 
        </span></label> 
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="intro-text">
                    <h1>Mis Planes ::</h1>
                    <form action="" method="">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <table border="0" class="table table-bordered">
                                    <thead>
                                        <% ENTITY.Solicitud soli = (ENTITY.Solicitud) request.getSession().getAttribute("solicitud");%>
                                        <tr>
                                            <th>Código</th>
                                            <th>Gigas</th>
                                            <th>Minutos</th>
                                            <th>Entrega de Chip</th>
                                            <th>Teléfono</th>
                                            <th>Comuna</th>
                                            <th>Ingreso</th>
                                            <th>Total</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            try {

                                                DAO.SolicitudDAO solDAO = new SolicitudDAO();
                                                DAO.ClienteDAO cliDAO = new ClienteDAO();

                                                for (ENTITY.Solicitud sol : solDAO.getLista()) {


                                        %>
                                        <tr>
                                            <td><%= sol.getIdSolicitud()%></td>          
                                            <td><%= sol.getCuotaNavegacion().getDescripcion()%></td>                                              
                                            <td><%= sol.getMinuto().getDescripcion()%></td>                                               
                                            <td><%= sol.getCliente().getDireccion()%></td>
                                            <td><%= sol.getCliente().getTelefono()%></td>
                                            <td><%= sol.getCliente().getComuna()%></td>                                          
                                            <td><%= sol.getFechaSolicitud()%></td>
                                            <td><%= sol.getTotal()%></td>                                                
                                        </tr>
                                        <% }

                                            } catch (Exception e) {
                                                out.print(e.getMessage());
                                            }%>
                                    </tbody>
                                </table>


                            </div>
                        </div>
                        <a href="paso1.jsp">VOLVER</a> 

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
