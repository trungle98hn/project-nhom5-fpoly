/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Main {

    static Connect kn = new Connect();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        JFrame fr=new JFrame("Login");
//        fr.setVisible(true);
//         fr.setLocationRelativeTo(null);
//        fr.setSize(150 ,250);
//        fr.setVisible(true);
//
//        boolean k=true;
//        
//        if(k==false){
        Menu m = new Menu();
        // Thuoc thuoc=new Thuoc();

        //Thuoc.setTitle("Quản lý cửa hàng thuốc");
        // thuoc.setSize(740, 420);
        // m.setResizable(false);
        // m.setLocationRelativeTo(null);
        // m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //thuoc.setVisible(true);
        m.setTitle("Quản lý cửa hàng thuốc");
        m.setSize(1050, 600);
        m.setResizable(false);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);

        //Connection
        //  Connection cnn=kn.getConnection();
        Connection cn = kn.getConnect();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "Select * from STAFF";
        try {
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                //  System.out.println("id :"+rs.getString(1)+"   name :" +rs.getString(2));

            }
        } catch (Exception e) {
        }

    }
//    }
}
