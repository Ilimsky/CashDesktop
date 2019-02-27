package CRUDf;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    /*public void createDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Product " +
                "(code INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "description VARCHAR (200), " +
                "why DECIMAL (10, 8), " +
                "amount DECIMAL (10, 8))";
        try {
            Statement s = ConnectDataBase.getConect().createStatement();
            s.execute(sql);
            s.close();
            JOptionPane.showMessageDialog(null, "Table Created Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problem Creating Table :" +e );
        }
    }*/

    public void insert(Product product) {
        String sql = "insert into Product (description, why, amount) values (?,?,?)";
        try {

            Connection conn = ConnectDataBase.getConect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getWhy());
            ps.setDouble(3, product.getAmount());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registered successfully");
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problems in registering :" +e );
        }
    }


    public void change(Product product) {
        try {
            String sql = "update Product set  description = ? , why = ? , amount = ? where code = ?";
            Connection conn = ConnectDataBase.getConect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getWhy());
            ps.setDouble(3, product.getAmount());
            ps.setInt(4, product.getCode());
            ps.execute();
            ps.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Changed Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problems with the change:" +e );
        }
    }

    public void delete(int code) {
        try {
            String sql = "delete from Product where code = ?";
            Connection conn = ConnectDataBase.getConect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, code);
            ps.execute();
            conn.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problems deleting:" +e );
        }
    }
    public List<Product> listAll() {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from Product";
            Connection conn = ConnectDataBase.getConect();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()) {
                Product product = new Product();
                product.setCode(rs.getInt("code"));
                product.setDescription(rs.getString("description"));
                product.setWhy(rs.getDouble("why"));
                product.setAmount(rs.getDouble("amount"));
                list.add(product);
            }
            s.close();
            conn.close();
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problems while listing:" +e );
            e.printStackTrace();
        }
        return list;
    }


    public List<Product> listDescription(String description) {
        List<Product> list = new ArrayList<Product>();
        try {
            String sql = "select * from Product where description like '%"+description+"%'";
            Connection conn = ConnectDataBase.getConect();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while(rs.next()) {
                Product product = new Product();
                product.setCode(rs.getInt("code"));
                product.setDescription(rs.getString("description"));
                product.setWhy(rs.getDouble("why"));
                product.setAmount(rs.getDouble("amount"));
                list.add(product);
            }
            s.close();
            conn.close();
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problems while listing:" +e );
            e.printStackTrace();
        }
        return list;
    }
}
