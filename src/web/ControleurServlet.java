package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.IcatalogueMetier;
import metier.Produit;

public class ControleurServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IcatalogueMetier metier;
	

	@Override
	public void init() throws ServletException {
		metier = new CatalogueMetierImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ma methode GET");
		req.getRequestDispatcher("produits.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Ma methode POST");
		ProduitModel model = new ProduitModel();
		model.setMotCle(req.getParameter("keyword"));
		List<Produit> produits = metier.produitsParMc(model.getMotCle());
		model.setProduits(produits);
		req.setAttribute("model", model);
		System.out.println(model.getMotCle());
		req.getRequestDispatcher("produits.jsp").forward(req, resp);
	}
	
	

}
