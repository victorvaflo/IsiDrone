package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Item;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MItem {

    public static ArrayList<Item> getItems(int category) {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            MDB.connect();
            String query;
            PreparedStatement ps;
            ResultSet rs;

            if (category == 1) {
                query = "SELECT * FROM product";
                ps = MDB.getPS(query);
            } else {
                query = "SELECT * FROM product WHERE category = ?";
                ps = MDB.getPS(query);
                ps.setInt(1, category);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                items.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return items;
    }

    public static Item getItemById(int id) {
        Item item = null;
        try {
            MDB.connect();
            String query = "SELECT * FROM product WHERE id = ?";

            PreparedStatement ps = MDB.getPS(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item = getItemFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return item;
    }

    public static ArrayList<Item> getFeaturedItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            MDB.connect();
            String query;
            ResultSet rs;

            query = "SELECT * FROM product WHERE id IN (SELECT product FROM featured_product)";

            rs = MDB.execQuery(query);

            while (rs.next()) {
                items.add(getItemFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return items;
    }

    public static ArrayList<Item> getItemsBySearch(String wordSearchBy) {
        ArrayList<Item> items = new ArrayList<Item>();
        try {
            MDB.connect();
            PreparedStatement ps;
            ResultSet rs;
            String query = "Select * from product WHERE description COLLATE UTF8_GENERAL_CI LIKE '%" + wordSearchBy + "%' OR name COLLATE UTF8_GENERAL_CI LIKE '%" + wordSearchBy + "%'";

            ps = MDB.getPS(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                items.add(getItemFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return items;
    }

    /* -1 : Problème de connexion
	 *  0 : L'adresse email est déjà présente dans la base de données
	 *  1 : L'adresse email n'est pas présente dans la base de données
	 * */
    private static int isExist(Item item) {
        int isExist = -1;

        try {
            MDB.connect();

            String query = "SELECT id FROM product WHERE name = ?";
            PreparedStatement ps = MDB.getPS(query);

            ps.setString(1, item.getName());
            ResultSet rs = ps.executeQuery();

            isExist = (rs.first() ? 0 : 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return isExist;
    }

    public static int addItems(Item item) {
        int code = isExist(item);
        System.out.println("MItem " + code);
        if (code == 1) {
            try {
                MDB.connect();

                String query = "INSERT INTO product (`category`, `name`, `description`, `price`, `serialNumber`, `imgName`, `stockQty`, `isActive`) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

                PreparedStatement ps = MDB.getPS(query);

                ps.setInt(1, item.getCategory());
                ps.setString(2, item.getName());
                ps.setString(3, item.getDescription());
                ps.setDouble(4, item.getPrice());
                ps.setString(5, item.getSerial());
                ps.setString(6, item.getImage());
                ps.setInt(7, item.getStock());
                ps.setInt(8, item.isActive());

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MDB.disconnect();
            }
        }
        return code;
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

    public static void deletItem(int id)  {
     
        try {
            MDB.connect();
   
        String deletQuerry = " DELETE FROM product WHERE id = ?";
            PreparedStatement ps = MDB.getPS(deletQuerry);
            ps.setInt(1, id);
             ps.executeUpdate();
        } catch (Exception ex) {
            out.println(ex);
        }
        
        
    }
    public static boolean updateItem(int id,int category, String name,String description, double price, String serial, String image,int stock, int isActive) {
        boolean allOk = true;
        try {
            MDB.connect();
            String query = "UPDATE category SET category = ? ,name = ? , description = ? , price = ? , serial = ? , image = ? , stock = ? , isActive = ? WHERE id = ?";
            PreparedStatement ps = MDB.getPS(query);
            ps.setInt(1, category);
            ps.setString(2, name);
            ps.setString(3, description);
            ps.setDouble(4, price);
            ps.setString(5, serial);
            ps.setString(6, image);
            ps.setInt(7, stock);
            ps.setInt(8, isActive);
            ps.setInt(9, id);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return allOk;
    }

   
}
