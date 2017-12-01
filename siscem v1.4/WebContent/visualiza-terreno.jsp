<%@page import="java.util.*,  
				br.edu.fatec.dao.*, 
				br.edu.fatec.entidade.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gerenciamento de Cemitério</title>
</head>
<body>
	<h1>Vizualiza Terreno</h1>
	<%
			String numId = request.getParameter("id");
			TerrenoDao dao = new TerrenoDao();
			List<Terreno> terrenos = dao.getTerreno(numId);
			
			for (Terreno terreno : terrenos) {
		%>
	<form action="alteraTerreno" method="post">
		<p>Nome proprietário: <input type="text" name="nome" value="<%=terreno.getNome() %>" readonly></p>
		<p>Rua: <input type="text" name="rua" value="<%=terreno.getRua() %>" readonly></p>
		<p>Lote: <input type="text" name="lote" value="<%=terreno.getLote() %>" readonly></p>
		<p>Largura: <input type="text" name="largura" value="<%=terreno.getLargura() %>" readonly></p>
		<p>Comprimento: <input type="text" name="comprimento" value="<%=terreno.getComprimento() %>" readonly></p>
		<p>Preço: <input type="text" name="preco" value="<%=terreno.getPreco() %>" readonly></p>
		<p>Observção: <textarea name="observacao" rows="5" cols="50" value="<%=terreno.getObservacao() %>" readonly></textarea></textarea></p>

	</form>
	<%} %>
</body>
</html>