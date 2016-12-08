<%-- 
    Document   : login
    Created on : 08-12-2016, 16:11:15
    Author     : Alfonzork
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="LoginServlet" method="post">
            RUT:<br>
            <input type="text" name="txtRut"><br>
            CLAVE:<br>
            <input type="password" name="txtPass"><br>
            <input type="submit" value="Iniciar Sesion">
        </form>

    </body>
</html>
