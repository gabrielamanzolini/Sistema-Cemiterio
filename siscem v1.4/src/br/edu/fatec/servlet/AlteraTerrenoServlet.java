package br.edu.fatec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fatec.dao.TerrenoDao;
import br.edu.fatec.entidade.Terreno;

/**
 * Servlet implementation class AdicionaTerrenoServlet
 */
@WebServlet("/alteraTerreno")
public class AlteraTerrenoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlteraTerrenoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String rua = request.getParameter("rua");
		int lote = Integer.parseInt(request.getParameter("lote"));
		int largura = Integer.parseInt(request.getParameter("largura"));
		int comprimento = Integer.parseInt(request.getParameter("comprimento"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		String observacao = request.getParameter("observacao");
		
		Terreno terreno = new Terreno();
		terreno.setNome(nome);
		terreno.setRua(rua);
		terreno.setLote(lote);
		terreno.setLargura(largura);
		terreno.setComprimento(comprimento);
		terreno.setPreco(preco);
		terreno.setObservacao(observacao);
		terreno.setId(id);
		
		TerrenoDao dao = new TerrenoDao();
		dao.altera(terreno);
		
		RequestDispatcher rd = request.getRequestDispatcher("/terreno-adicionado.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
