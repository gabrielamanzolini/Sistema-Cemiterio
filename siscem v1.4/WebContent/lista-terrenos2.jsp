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
			String numId = request.getParameter("id");
			TerrenoDao dao = new TerrenoDao();
			List<Terreno> terrenos = dao.getTerreno(numId);
			
			for (Terreno terreno : terrenos) {
		%>
				<tr>
					<td><%=terreno.getNome() %></td>
					<td><%=terreno.getRua() %></td>
					<td><%=terreno.getLote() %></td>
					<td><%=terreno.getLargura() %></td>
					<td><%=terreno.getComprimento() %></td>
					<td><%=terreno.getPreco() %></td>
					<td><a href="mvc?logica=VisualizaTerreno&id=<%=terreno.getId() %>">Visualizar</a>
					<td><a href="mvc?logica=AlteraTerreno&id=<%=terreno.getId() %>">Alterar</a>
					<td><a href="mvc?logica=RemoveTerreno&id=<%=terreno.getId() %>">Remover</a>
				</tr>
		<%
			}
		%>
	</table>

</body>
</html>