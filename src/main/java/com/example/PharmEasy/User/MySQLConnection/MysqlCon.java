package com.example.PharmEasy.User.MySQLConnection;

import java.sql.*;

public class MysqlCon {
    Statement stmt;
    MysqlCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pharmeasy", "root", "root");
            stmt = con.createStatement();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void insertlogin(String username,String password) {
        try(
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/pharmeasy","root","root");
            Statement stmt = con.createStatement();)
        {
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO Login "  +
                    "VALUES('" + username + "','" + password + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        try{
            MysqlCon con = new MysqlCon();
            con.insertlogin("pqr","pqr123");
            con.getAllLoingRecords();
        }catch(Exception e){ System.out.println(e);}
    }

    private void getAllLoingRecords() throws SQLException {
        ResultSet rs = stmt.executeQuery("select * from Login");
        while(rs.next())
            System.out.println(rs.getString(1) + ",  " + rs.getString(2));
    }
}