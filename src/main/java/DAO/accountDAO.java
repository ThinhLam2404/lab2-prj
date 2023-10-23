package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import connection.connectDB;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thinh
 */
public class accountDAO extends connectDB{
     public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account s = new Account(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getDate("birthday"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        accountDAO account = new accountDAO();
        List<Account> list = account.getAll();
//        for (int i = 0; i < 5; i++) {
        System.out.println(list.get(0).getFullname());
        System.out.println(list.get(0).getUsername());
        System.out.println(list.get(0).getPassword());
        System.out.println(list.get(0).getGender());
        System.out.println(list.get(0).getDepartment());
        System.out.println(list.get(0).getBirthday());

    }
}
