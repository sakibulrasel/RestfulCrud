package dao;

import bean.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnect;

public class ProductDAO {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from product");
            while (rs.next()) {
                list.add(new Product(rs.getInt("pid"), rs.getString("pname"), rs.getDouble("price"), rs.getInt("qty")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product saveProduct(Product p) {
        String sql = "insert into product (pname, price, qty) values('" + p.getPname() + "','" + p.getPrice() + "','" + p.getQty() + "')";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product updateProduct(Product p) {
        String sql = "update product set pname='" + p.getPname() + "', price='" + p.getPrice() + "', qty='" + p.getQty() + "' where pid='" + p.getPid() + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Product saleProduct(Product p, int id, int qty) {
        int old=p.getQty();
        int newqty=qty-old;
        String sql = "update product set  qty='" + newqty + "' where pid='" + id + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public boolean deleteProduct(int id) {
        String sql = "delete from product where pid='" + id + "'";
        try {
            int value = DBConnect.getConnection().createStatement().executeUpdate(sql);
            if (value > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Product getProduct(int id) {
        Product p = new Product();
        try {
            ResultSet rs = DBConnect.getConnection().createStatement().executeQuery("select * from product where pid='" + id + "'");
            while (rs.next()) {
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPrice(rs.getDouble("price"));
                p.setQty(rs.getInt("qty"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
