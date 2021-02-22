package manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Category;
import entities.Item;
import static java.lang.System.out;

public class MCategory {

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();

        try {
            MDB.connect();
            String query = "SELECT * FROM category";
            ResultSet rs = MDB.execQuery(query);
            while (rs.next()) {
                categories.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return categories;
    }

    public static int isExist(int category) {
        int isExist = -1;
        try {
            MDB.connect();
            String query = "SELECT 'exist' FROM category WHERE id = ?";
            PreparedStatement ps = MDB.getPS(query);

            ps.setInt(1, category);
            ResultSet rs = ps.executeQuery();

            isExist = (rs.first() ? 0 : 1);
        } catch (SQLException e) {
            isExist = -1;
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return isExist;
    }

    public static Category getCategoryById(int id) {
        Category category = null;
        try {
            MDB.connect();
            if (isExist(id) != 1) {
                String query = "SELECT * FROM category WHERE id = ?";

                PreparedStatement ps = MDB.getPS(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    category = getCategoryFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }

        return category;
    }

    public static boolean updateCategory(int id, String name, String description, int isActive, int order) {
        boolean allOk = true;
        try {
            MDB.connect();
            String query = "UPDATE category SET name = ? , description = ? , `order` = ? , isActive = ? WHERE id = ?";
            PreparedStatement ps = MDB.getPS(query);
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, order);
            ps.setInt(4, isActive);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return allOk;
    }

    public static int addCategory(Category category) {
        int code = verificationCategory(category);
        System.out.println("MCategory " + code);
        if (code == 1) {
            try {
                MDB.connect();
                String query = "INSERT INTO category (`name`, `description`, `order`, `isActive`) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = MDB.getPS(query);
                ps.setString(1, category.getName());
                ps.setString(2, category.getDescription());
                ps.setInt(3, category.getOrder());
                ps.setInt(4, category.getIsActive());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MDB.disconnect();
            }
        }
        return code;
    }

    public static void deleteCategory(int id) {
        try {
            MDB.connect();
            String deletQuerry = " DELETE FROM category WHERE id = ?";
            PreparedStatement ps = MDB.getPS(deletQuerry);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            out.println(ex);
        } finally {
            MDB.disconnect();
        }
    }

    private static Category getCategoryFromResultSet(ResultSet rs) {
        Category category = new Category();

        try {
            category.setId(rs.getInt("id"));
            category.setDescription(rs.getString("description"));
            category.setOrder(rs.getInt("order"));
            category.setName(rs.getString("name"));
            category.setIsActive(rs.getInt("isActive"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    private static int verificationCategory(Category category) {
        int verificationCategory = -1;
        try {
            MDB.connect();
            String query = "SELECT 'exist' FROM category WHERE name = ?";
            PreparedStatement ps = MDB.getPS(query);
            ps.setString(1, category.getName());
            ResultSet rs = ps.executeQuery();
            verificationCategory = (rs.first() ? 0 : 1);
        } catch (SQLException e) {
            verificationCategory = -1;
            e.printStackTrace();
        } finally {
            MDB.disconnect();
        }
        return verificationCategory;
    }
}
