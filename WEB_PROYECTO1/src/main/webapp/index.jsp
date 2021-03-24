<%-- 
    Document   : index
    Created on : 8 mar 2021, 12:52:45
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a DATA FORMS</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Resourses/CSS/index.css"/>
        <script src="${pageContext.request.contextPath}/Resourses/JS/jsindex.js"></script>
    </head>
    <body>
        <form action="getForm" method="GET">
            <h1><span>DATA</span> FORMS</h1>
            <input placeholder="Codigo del Formulario" type="text" name="idForm" id="idForm"/>
            <button class="btn">Buscar Formulario</button>
        </form>
        <footer>
            <h5>Mas informacion en el repocitorio de GIT: <a target="_blank" href="https://github.com/cresb-49/PROYECTO_1_COMPI1">cresb-49</a></h5>
        </footer>
    </body>
</html>
