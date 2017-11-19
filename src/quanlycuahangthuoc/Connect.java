/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.Executor;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class Connect extends JFrame{
    DefaultTableModel tbn=new DefaultTableModel();
    Connection cnn=null;

    public Connect() throws HeadlessException {
   laydulieu();
    }
   
       
    public Connection getConnect(){
        try {
            String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=QLCHT";
            String user="sa";
            String pass="123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnn=DriverManager.getConnection(url, user, pass);
          
        } catch (Exception e) {
            System.out.println("lỗi connection ở : " +e);
        }
    return cnn;
    
    }
    public ResultSet getData() throws SQLException{
    ResultSet kq=null;
    Statement stm=this.cnn.createStatement();
    String sql="SELECT * FROM NHANVIEN";
    kq=stm.executeQuery(sql);
    return kq;
    }
    public void Insert(String MANV,String TENNV,String GIOITINH,String NAMSINH,String DIACHI,String TRINHDO,String NGAYNDILAM ) throws SQLException{
    Statement stm=this.cnn.createStatement();
    String sql="INSERT INTO NHANVIEN VALUES('"+MANV+"','"+TENNV+"','"+GIOITINH+"','"+NAMSINH+"','"+DIACHI+"','"+TRINHDO+"','"+NGAYNDILAM+"')";
    stm.executeQuery(sql);
    }
    public void Delete(String MANV) throws SQLException{
    Statement stm=this.cnn.createStatement();
    String sql="DELETE NHANVIEN where MANV='"+MANV+"'";
    stm.executeQuery(sql);
    }
    public void Update(String MANV,String TENNV,String GIOITINH,String NAMSINH,String DIACHI,String TRINHDO,String NGAYNDILAM ) throws SQLException{
    Statement stm=this.cnn.createStatement();
    String sql="UPDATE NHANVIEN SET TENNV="+TENNV+" ,GIOITINH="+GIOITINH+",NAMSINH="+NAMSINH+",DIACHI="+DIACHI+",TRINHDO="+TRINHDO+",NGAYNDILAM="+NGAYNDILAM+" where MANV="+MANV+"";
    stm.executeQuery(sql);
    }
   public void laydulieu(){
   }

    void Close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
