package metier;

import java.util.Iterator;
import java.util.List;

public class TestMetier {
	
	public static void main(String[] args) {
		IcatalogueMetier metier = new CatalogueMetierImpl();
		/*metier.addProduit(new Produit("REF01", "Imprimantes HP", 1000, 20));
		metier.addProduit(new Produit("REF02", "Imprimantes LASER XP-200", 1000, 31));
		metier.addProduit(new Produit("REF03", "Imprimantes JET ENCRE", 1000, 5));
		metier.addProduit(new Produit("REF04", "Imprimantes ACER", 1000, 15));*/
		List<Produit> produits = metier.listProduits();
		//List<Produit> produits = metier.produitsParMc("HP");
		for (Iterator iterator = produits.iterator(); iterator.hasNext();) {
			Produit produit = (Produit) iterator.next();
			System.out.println(produit);
		}
	}
}
