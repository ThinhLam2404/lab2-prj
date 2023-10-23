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
import model.Order;

/**
 *
 * @author thinh
 */
public class orderDAO extends connectDB {

    /**
     *
     * @param user
     * @return
     */
    public List<Order> getAll(String user) {
        List<Order> list = new ArrayList<>();
        String sql = "select *\n"
                + "from [Order]\n"
                + "where username = ?";
//                + "where username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user);
//            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getString("order_id"),
                        rs.getString("username"),
                        rs.getString("order_des"),
                        rs.getInt("order_total"),
                        rs.getString("order_date"));
                list.add(o);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return list;
    }

    public void addOrder(String id, String username, String total, String date, String des) {
        String sql = "insert into [Order]\n"
                + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, username);
            ps.setString(3, total);
            ps.setString(4, date);
            ps.setString(5, des);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrder(String id) {
        String sql = "delete from [Order]\n"
                + "where order_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Order getProductById(String id) {
        String sql = "select *\n"
                + "from [Order]\n"
                + "where order_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getString(1), rs.getString(2), rs.getString(5), rs.getInt(3), rs.getString(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateOrder(String id, String user, String total, String des) {
        String sql = "update [Order]\n"
                + "set order_total = ?,\n"
                + "order_des = ?\n"
                + "where order_id = ? and username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, total);
            ps.setString(2, des);
            ps.setString(3, id);
            ps.setString(4, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

}
