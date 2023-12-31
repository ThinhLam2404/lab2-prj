package model;



import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thinh
 */
public class Account {
      private String username, password,fullname,gender, department;
    private Date birthday;

    public Account(String username, String password, String fullname, String gender, String department, Date birthday) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.department = department;
        this.birthday = birthday;
    }

    public Account() {
    }

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", fullname=" + fullname + ", gender=" + gender + ", department=" + department + ", birthday=" + birthday + '}';
    }
    
}
