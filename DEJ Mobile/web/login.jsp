<%-- 
    Document   : login
    Created on : 08-12-2016, 16:11:15
    Author     : Luis Fredes & José Villaseca
--%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>

        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="css/freelancer.min.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        
        <script src="js/validaciones.js" type="text/javascript"></script>
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bg-primary">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="intro-text">
                        <h1>Iniciar Session</h1>
                        <form action="LoginServlet" method="post" name="form" onSubmit="javascript:return VerificaRut(document.form.txtRut.value)">
                            <div class="row control-group">
                                <div class="form-group col-xs-6 floating-label-form-group controls">
                                    RUT:<br>
                                    <input type="text" pattern="[0-9]{7,8}-[0-9Kk]{1}" title="Ejemplo 11222333-4" name="txtRut" placeholder="Ingrese RUT" required=""><br>
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-6 floating-label-form-group controls">
                                    CLAVE:<br>
                                    <input type="password" pattern="[0-9]{4}$" title="Ejemplo ****" name="txtPass" placeholder="Ingrese Clave" required=""><br>
                                </div>
                            </div>
                            <div class="row control-group">
                                <div class="form-group col-xs-12">
                                    <br>
                                    <input type="submit" value="Iniciar Sesion" class="btn btn-success bg-danger">  
                                </div>
                            </div>
                            <a href="cliente.jsp">REGISTRARSE</a>  

                            
                            <script type="text/javascript">
                                <% String message = (String) request.getAttribute("alertMsg");%>
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
