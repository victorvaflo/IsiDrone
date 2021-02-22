package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Item;

public class MEditProduct {
	
	

	public static Item getItemById(int id) {
		Item item = null;
		try {
			MDB.connect();
			String query = "SELECT * FROM product WHERE id = ?";
			
			PreparedStatement ps = MDB.getPS(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = getItemFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			MDB.disconnect();
		}
		
		return item;
	}

public static boolean editItemById(String nom,int categorie,String description,double prix,String numero_de_serie,int quantite_en_stock,int  produit_actif,int produit_id){
int rowsUpdated = 0;
    try {
    MDB.connect();
			String query = "UPDATE product SET category = ?, name = ?, description = ?, price = ?,serialNumber = ?,stockQty = ?,isActive = ? WHERE id = ?";
			
			PreparedStatement ps = MDB.getPS(query);
			ps.setInt(1, categorie);
                        ps.setString(2, nom);
                        ps.setString(3, description);
                        ps.setDouble(4, prix);
                        ps.setString(5, numero_de_serie);
                        ps.setInt(6, quantite_en_stock);
                        ps.setInt(7, produit_actif);
                        ps.setInt(8, produit_id);
                        //renvoie le nbre de colonne modifier
		rowsUpdated = ps.executeUpdate();
                
			
		} catch (SQLException e) {
			e.printStackTrace();
                        
                        e.getMessage();
		}
		finally {
			MDB.disconnect();
		}
    
  return rowsUpdated > 0;

}	
      
	
	private static Item getItemFromResultSet(ResultSet rs) {

		Item item = new Item();
		
		try {
			item.setId(rs.getInt("id"));
			item.setCategory(rs.getInt("category"));
			item.setName(rs.getString("name"));
			item.setDescription(rs.getString("description"));
			item.setPrice(rs.getDouble("price"));
			item.setSerial(rs.getString("serialNumber"));
			item.setImage(rs.getString("imgName"));
			item.setStock(rs.getInt("stockQty"));
			item.setActive(rs.getInt("isActive"));
                    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
}
