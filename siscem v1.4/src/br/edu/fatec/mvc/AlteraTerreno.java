package br.edu.fatec.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.dao.TerrenoDao;
import br.edu.fatec.entidade.Terreno;

public class AlteraTerreno implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		long id = Long.parseLong(req.getParameter("id"));
		
		Terreno terreno = new Terreno();
		terreno.setId(id);
		
		TerrenoDao dao = new TerrenoDao();
		dao.remove(terreno);
		
		return "lista-terrenos.jsp";
	}

}
