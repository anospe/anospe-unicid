<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Demonstração JSP</h1>
    <%
        String mensagem = "Olá, bem-vindo à disciplina de Sistemas Cliente-Servidor!<br>";
        for (int i = 0; i < 5; i++) {
            out.println(mensagem);
        }
    %>
</body>
</html>