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
	<table>
		<tr>
			<th>Nome</th>
			<th>Rua</th>
			<th>Lote</th>
			<th>Largura</th>
			<th>Comprimento</th>
			<th>Preço</th>
			<th colspan="3">Ações</th>
		</tr>
		<%
			TerrenoDao dao = new TerrenoDao();
			List<Terreno> terrenos = dao.getLista();
			
			for (Terreno terreno : terrenos) {
		%>
				<tr>
					<td><%=terreno.getNome() %></td>
					<td><%=terreno.getRua() %></td>
					<td><%=terreno.getLote() %></td>
					<td><%=terreno.getLargura() %></td>
					<td><%=terreno.getComprimento() %></td>
					<td><%=terreno.getPreco() %></td>
					<td><a href="visualiza-terreno.jsp?id=<%=terreno.getId() %>">Visualizar</a>
					<td><a href="altera-terreno.jsp?id=<%=terreno.getId() %>">Alterar</a>
					<td><a href="mvc?logica=RemoveTerreno&id=<%=terreno.getId() %>">Remover</a>
				</tr>
		<%
			}
		%>
	</table>

</body>
</html>