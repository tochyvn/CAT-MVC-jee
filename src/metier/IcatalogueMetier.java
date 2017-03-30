package metier;

import java.util.List;

public interface IcatalogueMetier {

	public void addProduit(Produit P);
	public List<Produit> listProduits();
	public List<Produit> produitsParMc(String mc);
	public Produit getProduit(String ref);
	public void updateProduit(Produit p);
	public void deleteProduit(String ref);
	
}
