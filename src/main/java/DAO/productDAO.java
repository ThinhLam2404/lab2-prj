/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.connectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author thinh
 */
public class productDAO extends connectDB {

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Product";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getString("pro_id"),
                        rs.getString("pro_name"),
                        rs.getString("pro_pic"),
                        rs.getNString("pro_des"),
                        rs.getInt("pro_quan"),
                        rs.getInt("pro_price"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public void updateQuan(String quan, String name) {
        String sql = "update Product\n"
                + "set pro_quan = ?\n"
                + "where pro_name = ? ";
        try {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setString(1, quan);
           ps.setString(2, name);
           ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String id) {
        String sql = "delete from Product\n"
                + "where pro_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void insertProduct(String id, String name, String quan, String price, String url, String des) {
        String sql = "insert into Product\n"
                + "values (?, ?,?, ?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, quan);
            ps.setString(4, price);
            ps.setString(5, url);
            ps.setString(6, des);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Product getProductById(String id) {
        String sql = "select *\n"
                + "from Product\n"
                + "where pro_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getInt(3), rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateProduct(String id, String name, String quan, String price, String pic, String des) {
        String sql = "update Product\n"
                + "set pro_name = ?,\n"
                + "pro_quan = ?,\n"
                + "pro_price = ?, \n"
                + "pro_pic = ?,\n"
                + "pro_des = ?\n"
                + "where pro_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, quan);
            ps.setString(3, price);
            ps.setString(4, pic);
            ps.setString(5, des);
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        productDAO product = new productDAO();
        List<Product> list = product.getAll();
//        for (int i = 0; i < 5; i++) {
        System.out.println(list.get(0).getPro_des());
        System.out.println(list.get(1).getPro_des());

    }
}
