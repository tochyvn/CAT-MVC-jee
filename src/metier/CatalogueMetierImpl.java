package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements IcatalogueMetier {

	@Override
	public void addProduit(Produit p) {
		Connection conn = SingletonConnection.getConnection();
		String sql = "INSERT INTO PRODUITS (REF_PROD, DESIGNATION, PRIX, QUANTITE) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getReference());
			ps.setString(2, p.getDesignation());
			ps.setDouble(3, p.getPrix());
			ps.setInt(4, p.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> listProduits() {
		List<Produit> produits = new ArrayList<Produit>();
		
		Connection conn = SingletonConnection.getConnection();
		String sql = "SELECT * FROM PRODUITS";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public List<Produit> produitsParMc(String mc) {
		List<Produit> produits = new ArrayList<Produit>();
		Connection conn = SingletonConnection.getConnection();
		String sql = "SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit getProduit(String ref) {
		Produit p = null;
		Connection conn = SingletonConnection.getConnection();
		String sql = "SELECT * FROM PRODUITS WHERE REF_PROD = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ref);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Produit();
				p.setReference(rs.getString("REF_PROD"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("PRIX"));
				p.setQuantite(rs.getInt("QUANTITE"));
				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (p == null) {
			throw new RuntimeException("Produit non trouvable");
		}
		return p;
	}

	@Override
	public void updateProduit(Produit p) {
		Connection conn = SingletonConnection.getConnection();
		String sql = "UPDATE PRODUITS "
				+ " SET DESIGNATION = ?, "
				+ " PRIX = ?, "
				+ " QUANTITE = ? "
				+ " WHERE REF_PROD = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setString(4, p.getReference());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduit(String ref) {
		Connection conn = SingletonConnection.getConnection();
		String sql = "DELETE FROM PRODUITS WHERE REF_PROD = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ref);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
