<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gerenciamento de Cemit�rio</title>
</head>
<body>
	<h1>Adiciona Terreno</h1>
	<form action="adicionaTerreno" method="post">
		<p>Nome propriet�rio: <input type="text" name="nome" ></p>
		<p>Rua: <input type="text" name="rua" ></p>
		<p>Lote: <input type="text" name="lote" ></p>
		<p>Largura: <input type="text" name="largura" ></p>
		<p>Comprimento: <input type="text" name="comprimento" ></p>
		<p>Pre�o: <input type="text" name="preco" ></p>
		<p>Observ��o: <textarea name="observacao" rows="5" cols="50"></textarea></textarea></p>
		<input type="submit" name="Salvar" value="Salvar" >
	</form>
</body>
</html>