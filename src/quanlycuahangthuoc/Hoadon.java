/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import static quanlycuahangthuoc.Main.kn;

/**
 *
 * @author admin
 */
public final class Hoadon extends JFrame {

    JPanel pnlMain = new JPanel();
    JPanel pnlTop = new JPanel();
    JPanel pnlBottom = new JPanel();
    JPanel pnlTleft = new JPanel();
    JPanel pnlTright = new JPanel();
    JPanel pnlBleft = new JPanel();
    JPanel pnlBright = new JPanel();
    JPanel pnlDSHD = new JPanel();
    JPanel pnlDST = new JPanel();
    JPanel pnlTRnorth = new JPanel();
    JPanel pnlTRcenter = new JPanel();
    JPanel pnlTRcenterT = new JPanel();
    JPanel pnlTRcenterB = new JPanel();
    JPanel pnlBRnorth = new JPanel();
    JPanel pnlBRcenter = new JPanel();
    JPanel pnlBRcenterT = new JPanel();
    JPanel pnlBRcenterB = new JPanel();
    JPanel pnlBLsouth = new JPanel();
    //
    JLabel lblSohoadon = new JLabel("Số hóa đơn");
    JLabel lblNguoimua = new JLabel("Người mua");
    JLabel lblNguoiban = new JLabel("Người bán");
    JLabel lblNgayban = new JLabel("Ngày bán");
    JLabel lblDsthuoc = new JLabel("Danh sách thuốc");
    JLabel lblDshoadon = new JLabel("Danh sách hóa đơn");
    JLabel lblGiatrihoadon = new JLabel("Giá trị hóa đơn");
    JLabel lblMathuoc = new JLabel("Mã thuốc");
    JLabel lblTenthuoc = new JLabel("Tên thuốc");
    JLabel lblHamluong = new JLabel("Hàm lượng");
    JLabel lblSoluong = new JLabel("Số lượng");
    //
    JTextField txtSohoadon = new JTextField(5);
    JTextField txtNguoimua = new JTextField(5);
    JTextField txtNguoiban = new JTextField(5);
    JTextField txtNgayban = new JTextField(5);
    JTextField txtMathuoc = new JTextField(5);
    JTextField txtTenthuoc = new JTextField(5);
    JTextField txtHamluong = new JTextField(5);
    JTextField txtSoluong = new JTextField(5);
    JTextField txtGiatrihoadon = new JTextField(5);
    //
    JButton btnThem = new JButton("Thêm");
    JButton btnThemT = new JButton("Thêm");
    JButton btnLuu = new JButton("Lưu");
    JButton btnLuuT = new JButton("Lưu");
    JButton btnSua = new JButton("Sửa");
    JButton btnSuaT = new JButton("Sửa");
    JButton btnXoa = new JButton("Xóa");
    JButton btnXoaT = new JButton("Xóa");
    JButton btnBoqua = new JButton("Bỏ qua");
    JButton btnBoquaT = new JButton("Bỏ qua");

    //
    public Hoadon() {
//        btnLuu.setBackground(Color.LIGHT_GRAY);
//        btnSua.setBackground(Color.LIGHT_GRAY);
//        btnThem.setBackground(Color.LIGHT_GRAY);
//        btnXoa.setBackground(Color.LIGHT_GRAY);

        pnlMain.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTleft.setLayout(new BorderLayout());
        pnlTright.setLayout(new BorderLayout());
        pnlBottom.setLayout(new BorderLayout());
        pnlBleft.setLayout(new BorderLayout());
        pnlBright.setLayout(new BorderLayout());
        pnlBLsouth.setLayout(new BorderLayout());
        pnlTRnorth.setLayout(new GridBagLayout());
        pnlBRnorth.setLayout(new GridBagLayout());
        pnlTRcenter.setLayout(new BorderLayout());
        pnlTRcenterT.setLayout(new FlowLayout());
        pnlTRcenterB.setLayout(new FlowLayout());
        pnlBRcenter.setLayout(new BorderLayout());
        pnlBRcenterT.setLayout(new FlowLayout());
        pnlBRcenterB.setLayout(new FlowLayout());
        //

        JTable tableleft = new JTable();
        Vector dat=new Vector();
        Vector head=new Vector();
        head.add("stt");
        head.add("Số hóa đơn");
        head.add("Ngày bán");
        Connection cn=kn.getConnect();
        try {
            String sql="Select INVOICE_ID,FRIEND_DAY from INVOICE";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            int i=1;
            while(rs.next()){
            Vector dat1=new Vector();
            dat1.add(i);
            dat1.add(rs.getString(1));
            dat1.add(rs.getString(2));
            dat.add(dat1);
            tableleft.setModel(new DefaultTableModel(dat, head));
            i++;
            }
        } catch (Exception e) {
        }
        tableleft.setModel(new DefaultTableModel(dat, head));
        tableleft.setPreferredScrollableViewportSize(new Dimension(450, 170));
        tableleft.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableleft.setFillsViewportHeight(true);
        JScrollPane scrdanhsachhoadon = new JScrollPane(tableleft);
        //
        String[] header = {"STT", "Mã thuốc", "Tên thuốc", "Hàm lượng", "Số lượng", "Giá tiền"};
        Object[][] data = {
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},
            {"", "", "", "", "", ""},};
        JTable table = new JTable(data, header);
        table.setPreferredScrollableViewportSize(new Dimension(700, 170));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scrDanhsachthuoc = new JScrollPane(table);
        //render color table
//        table.getColumnModel().getColumn(0).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer) new render());

        //MouseMoved table
        table.addMouseMotionListener(new MouseAdapter() {
            public void MouseMoved(MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                render.curentrow = table.rowAtPoint(evt.getPoint());
                //table.repaint();
            }
        });
        //
        pnlTRnorth.add(lblSohoadon, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTRnorth.add(txtSohoadon, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 200, 0));
        pnlTRnorth.add(lblNguoimua, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTRnorth.add(txtNguoimua, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 200, 0));
        pnlTRnorth.add(lblNguoiban, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTRnorth.add(txtNguoiban, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 200, 0));
        pnlTRnorth.add(lblNgayban, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTRnorth.add(txtNgayban, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 200, 0));

        //
        pnlBRnorth.add(lblMathuoc, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlBRnorth.add(txtMathuoc, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlBRnorth.add(lblTenthuoc, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlBRnorth.add(txtTenthuoc, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlBRnorth.add(lblHamluong, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlBRnorth.add(txtHamluong, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlBRnorth.add(lblSoluong, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlBRnorth.add(txtSoluong, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        //
        pnlMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
        pnlBRcenter.setBorder(BorderFactory.createEmptyBorder(23, 0, 0, 0));
        lblDshoadon.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        lblDsthuoc.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        pnlBLsouth.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 315));
        lblGiatrihoadon.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        //
        pnlBLsouth.add(lblGiatrihoadon, BorderLayout.WEST);
        pnlBLsouth.add(txtGiatrihoadon, BorderLayout.CENTER);
        //
        pnlTRcenterT.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlTRcenterT.add(btnThem);
        pnlTRcenterT.add(btnSua);
        pnlTRcenterT.add(btnXoa);
        //
        pnlTRcenterB.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlTRcenterB.add(btnLuu);
        pnlTRcenterB.add(btnBoqua);
        //
        pnlBRcenterT.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBRcenterT.add(btnThemT);
        pnlBRcenterT.add(btnSuaT);
        pnlBRcenterT.add(btnXoaT);
        //
        pnlBRcenterB.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlBRcenterB.add(btnLuuT);
        pnlBRcenterB.add(btnBoquaT);
        //
        pnlTRcenter.add(pnlTRcenterT, BorderLayout.NORTH);
        pnlTRcenter.add(pnlTRcenterB, BorderLayout.CENTER);
        //
        pnlBRcenter.add(pnlBRcenterT, BorderLayout.NORTH);
        pnlBRcenter.add(pnlBRcenterB, BorderLayout.CENTER);
        //
        pnlBleft.add(lblDsthuoc, BorderLayout.NORTH);
        pnlBleft.add(scrDanhsachthuoc, BorderLayout.CENTER);
        pnlBleft.add(pnlBLsouth, BorderLayout.SOUTH);
        //
        pnlBright.add(pnlBRnorth, BorderLayout.NORTH);
        pnlBright.add(pnlBRcenter, BorderLayout.CENTER);
        //
        pnlTleft.add(lblDshoadon, BorderLayout.NORTH);
        pnlTleft.add(scrdanhsachhoadon, BorderLayout.CENTER);
        //
        pnlTright.add(pnlTRnorth, BorderLayout.NORTH);
        pnlTright.add(pnlTRcenter, BorderLayout.SOUTH);
        //
//        //
        pnlTop.add(pnlTleft, BorderLayout.WEST);
        pnlTop.add(pnlTright, BorderLayout.CENTER);
//        //
        pnlBottom.add(pnlBleft, BorderLayout.WEST);
        pnlBottom.add(pnlBright, BorderLayout.CENTER);
        //
        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlBottom, BorderLayout.SOUTH);
        this.add(pnlMain);
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Connection cn = kn.getConnect();
                Statement stm = null;
                ResultSet rs = null;
                String sql = "Select * from HOADON";
                try {
                    stm = cn.createStatement();
                    rs = stm.executeQuery(sql);
                    int i=0;
                    while (rs.next()) {
                       
                        
                       // Object[][] data={{"",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)} };
                        System.out.println("id :" + rs.getString(1) + "   name :" + rs.getString(2));
                        //tableleft.setValueAt(rs.getString(1), i, 1);
                        tableleft.setValueAt(rs.getString(1), i, 1);
                        tableleft.setValueAt(rs.getString(4), i, 2);
//                        tableleft.setValueAt(rs.getString(4), i, 4);
//                        tableleft.setValueAt(rs.getString(5), i, 5);
//                        tableleft.setValueAt(rs.getString(6), i, 6);
                      i++;
                    }
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("lỗi ở nút thêm " + ex);
                }

//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
       
        //
        btnLuu.setVisible(false);
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtSohoadon.setText("");
                txtNguoimua.setText("");
                txtNguoiban.setText("");
                txtNgayban.setText("");
                txtGiatrihoadon.setText("");
                txtSohoadon.requestFocus();
                btnLuu.setVisible(true);
 try {
                   
                    Connect cn=new Connect();
                    Connection cnn=cn.getConnect();
                    PreparedStatement ps=cnn.prepareStatement("Insert into HOADON values(?,?,?,?)");
                    ps.setString(1, txtSohoadon.getText());
                  ps.setString(2, txtNguoimua.getText());
                  ps.setString(3, txtNguoiban.getText());
                  ps.setString(4, txtNgayban.getText());
                  ps.setString(5, txtMathuoc.getText());
                  ps.setString(6, txtHamluong.getText());
                  ps.setString(7, txtSoluong.getText());
            Connection cn1 = kn.getConnect();
          tableleft.setPreferredScrollableViewportSize(new Dimension(930, 230));
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select MATHUOC,TENTHUOC FROM THUOC";
        try {
            st = cn1.createStatement();
            rs = st.executeQuery(sql);
            int i=1;
            while (rs.next()) {
                Vector data1=new Vector();
                 Vector data=new Vector();
                
                data1.add(i);
                data1.add(rs.getString(1));
                data1.add(rs.getString(3));
//                data1.add(rs.getString(3));
//                data1.add(rs.getString(4));
//                data1.add(rs.getString(5));
//                data1.add(rs.getString(6));
//                data1.add(rs.getString(7));
               // data.add(rs.getString(8));
                data.add(data1);
                
                tableleft.setModel(new DefaultTableModel(data, head));
                i++;

            }

        } catch (SQLException ex) {
        }
 }
 catch(Exception ex){}}

        });
//        btnThem.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtSohoadon.requestFocus();
//                    btnThem.setBackground(Color.LIGHT_GRAY);
//                }
//            }
//        });
//        btnThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//        /*              try{
//      int i=table.getSelectedRow();
//      int j=table.getSelectedColumn(); 
//    
//     
//     for(j=0;j<4;j++){
//  
//     
//     }
//     
//    }
//catch(Exception ex){
//             JOptionPane.showMessageDialog(null, "bạn chưa nh");
//             }
//         */
//        // JOptionPane.showMessageDialog(null, "đã thêm vào bảng");
//
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//           }
//       });
//  btnSua.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(null, "edited");
//                
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//  btnLuu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                 JOptionPane.showMessageDialog(null, "Saved");
//                
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        //
//        btnLuu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(false);
//            }
//            
//        });
////        //XÓA
//        btnXoa.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(true);
//                 
//            }
//           
//        });
//       //LƯU
//        btnLuu.addMouseListener(new MouseAdapter() {
//           
//            
//            public void mouseEntered(MouseEvent e){
//            btnLuu.setBackground(Color.RED);
//          
//            }
//           public void mouseExited(MouseEvent e){
//            btnLuu.setBackground(Color.LIGHT_GRAY);
//          
//            }
//        });
//        //XÓA
//         btnXoa.addMouseListener(new MouseAdapter() {
//           
//            
//            public void mouseEntered(MouseEvent e){
//            btnXoa.setBackground(Color.RED);
//          
//            }
//           public void mouseExited(MouseEvent e){
//            btnXoa.setBackground(Color.LIGHT_GRAY);
//          
//            }
//        });
//         //THÊM
//         btnThem.addMouseListener(new MouseAdapter() {
//           
//            
//            public void mouseEntered(MouseEvent e){
//            btnThem.setBackground(Color.RED);
//          
//            }
//           public void mouseExited(MouseEvent e){
//            btnThem.setBackground(Color.LIGHT_GRAY);
//          
//            }
//        });
//        //SỬA
//         btnSua.addMouseListener(new MouseAdapter() {
//           
//            
//            public void mouseEntered(MouseEvent e){
//            btnSua.setBackground(Color.RED);
//          
//            }
//           public void mouseExited(MouseEvent e){
//            btnSua.setBackground(Color.LIGHT_GRAY);
//          
//            }
//        });
//        btnSua.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(true);
//            }
//        });
//        //
        txtSohoadon.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent evt) {
                txtSohoadon.setForeground(Color.red);
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNguoimua.requestFocus();
                    txtSohoadon.setForeground(Color.BLACK);
                    txtNguoimua.setForeground(Color.red);
                }
            }
        });
//        //
        txtNguoimua.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNguoimua.setForeground(Color.BLACK);
                    txtNguoiban.requestFocus();
                    txtNguoiban.setForeground(Color.red);
                }
            }
        });
//        //
        txtNguoiban.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNgayban.requestFocus();
                    txtNguoiban.setForeground(Color.BLACK);
                    txtNgayban.setForeground(Color.red);
                }
            }
        });
//        //
        txtNgayban.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                txtNgayban.setForeground(Color.RED);
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtGiatrihoadon.requestFocus();
                    txtNgayban.setForeground(Color.BLACK);
                    txtGiatrihoadon.setForeground(Color.red);
                }
            }
        });
//        //
        txtGiatrihoadon.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnThem.requestFocus();
                    txtGiatrihoadon.setForeground(Color.BLACK);
                    btnThem.setBackground(Color.red);
                }
            }
        });
    }
}
