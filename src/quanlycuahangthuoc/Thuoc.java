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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static quanlycuahangthuoc.Main.kn;

/**
 *
 * @author admin
 */
public final class Thuoc extends JFrame {

    //
    JPanel pnlMain = new JPanel();
    JPanel pnlTop = new JPanel();
    JPanel pnlBottom = new JPanel();
    //
    JPanel pnlNorth = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlCenterT = new JPanel();
    JPanel pnlCenterB = new JPanel();
    JPanel pnlSouth = new JPanel();
    //
    JLabel lblMathuoc = new JLabel("Mã thuốc");
    JLabel lblTen = new JLabel("Tên");
    JLabel lblHansudung = new JLabel("Hạn sử dụng");
    JLabel lblDonvi = new JLabel("Đơn vị ");
    JLabel lblHoatchat = new JLabel("Hoạt chất");
    JLabel lblHamluong = new JLabel("Hàm lượng(mg)");
    JLabel lblHangSanXuat = new JLabel("Hãng Sản Xuất");
    JLabel lblGiaban = new JLabel("Giá bán ");
    JLabel lblCachdung = new JLabel("Cách dùng");
    JLabel lblDanhsachthuoc = new JLabel("Danh sách thuốc");
    JLabel lblNuocSanXuat = new JLabel("Nước Sản Xuất");
    //
    JTextField txtMathuoc = new JTextField(10);
    JTextField txtTen = new JTextField(10);
    JTextField txtHansudung = new JTextField(10);
    JTextField txtDonvi = new JTextField(10);
    JTextField txtHoatchat = new JTextField(10);
    JTextField txtHamluong = new JTextField(10);
    JTextField txtHangsanxuat = new JTextField(10);
    JTextField txtGiaban = new JTextField(10);
    JTextField txtNuocSanXuat = new JTextField(10);
    //
    JTextArea taCachdung = new JTextArea(7, 3);
    //
    JButton btnThem = new JButton("Thêm");
    JButton btnLuu = new JButton("Lưu");
    JButton btnXoa = new JButton("Xóa");
    JButton btnSua = new JButton("Sửa");
    JButton btnBoqua = new JButton("Bỏ qua");
    String country[] = {"India", "Aus", "U.S.A", "England", "Newzeland"};

    JComboBox cb = new JComboBox(country);

    //cb.setBounds(50, 50,90,20);
    //
    public Thuoc() {

        pnlMain.setLayout(new BorderLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlBottom.setLayout(new BorderLayout());
        pnlNorth.setLayout(new GridBagLayout());
        pnlSouth.setLayout(new BorderLayout());
        pnlCenter.setLayout(new BorderLayout());
        pnlCenterT.setLayout(new FlowLayout());
        pnlCenterB.setLayout(new FlowLayout());
        //TABLE

        JTable tableleft = new JTable();
        tableleft.setPreferredScrollableViewportSize(new Dimension(550, 150));
        tableleft.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableleft.setFillsViewportHeight(true);
        JScrollPane scrleft = new JScrollPane(tableleft);
        Vector data = new Vector();
        Vector head = new Vector();
        head.add("stt");
        head.add("Mã thuốc");
        head.add("Tên thuốc");
        Connection cn = kn.getConnect();
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select MATHUOC, TENTHUOC FROM THUOC";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                Vector data1 = new Vector();
                data1.add(i);
                data1.add(rs.getString(1));
                data1.add(rs.getString(2));
                data.add(data1);
                tableleft.setModel(new DefaultTableModel(data, head));
                i++;
            }
        } catch (Exception e) {
        }
        //
        JScrollPane scrta = new JScrollPane(taCachdung);
        taCachdung.setLineWrap(true);
        //
        pnlNorth.add(lblMathuoc, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtMathuoc, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 60, 0));
        pnlNorth.add(lblTen, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtTen, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblHansudung, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtHansudung, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblDonvi, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtDonvi, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 60, 0));
        pnlNorth.add(lblHoatchat, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtHoatchat, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblHamluong, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtHamluong, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblHangSanXuat, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtHangsanxuat, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblGiaban, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtGiaban, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblGiaban, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtGiaban, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlNorth.add(lblNuocSanXuat, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtNuocSanXuat, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 60, 0));
        //

        //
        pnlMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        pnlSouth.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 5));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
//        lblDanhsachthuoc.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        lblCachdung.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 5));
        pnlSouth.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        //
        pnlCenterT.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlCenterT.add(btnThem);
        pnlCenterT.add(btnSua);
        pnlCenterT.add(btnXoa);
        //
        pnlCenterB.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlCenterB.add(btnLuu);
        pnlCenterB.add(btnBoqua);
        //
        pnlSouth.add(pnlCenterT, BorderLayout.NORTH);
        pnlSouth.add(pnlCenterB, BorderLayout.SOUTH);
        //
        pnlCenter.add(lblCachdung, BorderLayout.NORTH);
        pnlCenter.add(scrta, BorderLayout.CENTER);
        //
        pnlBottom.add(pnlNorth, BorderLayout.NORTH);
        pnlBottom.add(pnlCenter, BorderLayout.CENTER);
        pnlBottom.add(pnlSouth, BorderLayout.SOUTH);
        //
        pnlTop.add(lblDanhsachthuoc, BorderLayout.NORTH);
        pnlTop.add(scrleft, BorderLayout.CENTER);
        //
        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlBottom, BorderLayout.CENTER);
        this.add(pnlMain);
        // color Jlabel

        //
        // Sự kiện 
        tableleft.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                // Connect cn=new Connect();
                Connection cnn = kn.getConnect();
                int row = tableleft.getSelectedRow();
                int col = tableleft.getSelectedColumn();
                txtMathuoc.setText(tableleft.getValueAt(row, 1) + "");
                txtTen.setText(tableleft.getValueAt(row, 2) + "");
                txtGiaban.setText("");
            }
            JTable table = new JTable();
            Vector r = new Vector();
            Vector data = new Vector();

        });
        txtHansudung.setToolTipText("ngày /tháng/năm hoặc ngày-tháng-năm");
        //Thêm
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Connect cn = new Connect();
                    Connection cnn = cn.getConnect();
                    PreparedStatement ps = cnn.prepareStatement("Insert into THUOC values(?,?,?,?,?,?,?,?,?)");
                    ps.setString(1, txtMathuoc.getText());
                    ps.setString(2, txtDonvi.getText());
                    ps.setString(3, txtTen.getText());
                    ps.setString(4, txtHoatchat.getText());
                    ps.setString(5, txtHangsanxuat.getText());
                    ps.setString(6, txtHansudung.getText());
                    ps.setString(7, txtHamluong.getText());
                    ps.setString(8, txtGiaban.getText());
                    ps.setString(9, txtNuocSanXuat.getText());
                    boolean kq = true;
                    String l = txtHamluong.getText();
                    String ik = txtGiaban.getText();
                    String k = txtHansudung.getText();
                    Integer it = new Integer(ik);
                    Integer lk = new Integer(l);
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                    try {
                        lk.parseInt(l);
                        it.parseInt(ik);
                        df.parse(k);
                        // parse dateString thành kiểu Date
                        kq = true;
                    } catch (ParseException ex) { // quăng lỗi nếu dateString ko hợp lệ
                        System.out.println("Invalid date");
                        kq = false;
                    }

                    if (kq == false || txtMathuoc.getText().isEmpty() || txtDonvi.getText().isEmpty() || txtTen.getText().isEmpty() || txtHoatchat.getText().isEmpty() || txtHangsanxuat.getText().isEmpty() || txtHansudung.getText().isEmpty() || txtHamluong.getText().isEmpty() || txtGiaban.getText().isEmpty() || txtNuocSanXuat.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "bạn chưa nhập đầy đủ thông tin");
                    } else {
                        int chk = ps.executeUpdate();
                        if (chk > 0) {
                            txtMathuoc.setText("");
                            txtTen.setText("");
                            txtHansudung.setText("");
                            txtDonvi.setText("");
                            txtHoatchat.setText("");
                            txtHamluong.setText("");
                            txtHangsanxuat.setText("");
                            txtGiaban.setText("");
                            taCachdung.setText("");
                            txtNuocSanXuat.setText("");
                            txtMathuoc.requestFocus();
                            btnLuu.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Saved");
                            tableleft.setModel(new DefaultTableModel(data, head));
                            Connection cn1 = kn.getConnect();
                            tableleft.setPreferredScrollableViewportSize(new Dimension(930, 230));
                            Statement st = null;
                            ResultSet rs = null;
                            String sql = "Select MATHUOC,TENTHUOC FROM THUOC";
                            try {
                                st = cn1.createStatement();
                                rs = st.executeQuery(sql);
                                int i = 1;
                                while (rs.next()) {
                                    Vector data1 = new Vector();

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
                        } else {
                            JOptionPane.showMessageDialog(null, "thông tin không hợp lệ");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại hoặc thông tin không hợp lệ");
                }
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        //SỬA
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect cn = new Connect();
                Connection cnn = cn.getConnect();
                try {
                    PreparedStatement ps = cnn.prepareStatement("Delete THUOC Where MATHUOC=?");
                    ps.setString(1, tableleft.getValueAt(tableleft.getSelectedRow(), 1) + "");
                    if (JOptionPane.showConfirmDialog(null, "ban co muon xoa ko?", "config", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ps.executeUpdate();

                        tableleft.setModel(new DefaultTableModel(data, head));
                        Connection cn1 = kn.getConnect();
                        tableleft.setPreferredScrollableViewportSize(new Dimension(930, 230));
                        Statement st = null;
                        ResultSet rs = null;
                        String sql = "Select MATHUOC,TENTHUOC FROM THUOC";
                        try {
                            st = cn1.createStatement();
                            rs = st.executeQuery(sql);
                            int i = 1;
                            while (rs.next()) {
                                Vector data1 = new Vector();

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
                                ps.close();
                            }

                        } catch (SQLException ex) {
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        //SỬA
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connect cn = new Connect();
                Connection cnn = cn.getConnect();
                try {
                    PreparedStatement ps = cnn.prepareStatement("Update THUOC SET DONVI=?,TENTHUOC=?,HOATCHAT=?,HANGSANXUAT=?,HANSUDUNG=?,HAMLUONG=?,GIABAN=?,NUOCSX=?,CACHDUNG=? WHERE MATHUOC=?");
                    ps.setString(9, txtMathuoc.getText());
                    ps.setString(1, txtDonvi.getText());
                    ps.setString(2, txtTen.getText());
                    ps.setString(3, txtHoatchat.getText());
                    ps.setString(4, txtHangsanxuat.getText());
                    ps.setString(5, txtHansudung.getText());
                    ps.setString(7, txtGiaban.getText());
                    ps.setString(8, txtNuocSanXuat.getText());
                    ps.setString(6, txtHamluong.getText());
                    ps.setString(9, taCachdung.getText());
                    int chk = ps.executeUpdate();

                    if (chk > 0) {
                        JOptionPane.showMessageDialog(null, "Edited");
                        tableleft.setModel(new DefaultTableModel(data, head));
                        Connection cn1 = kn.getConnect();
                        tableleft.setPreferredScrollableViewportSize(new Dimension(930, 230));
                        Statement st = null;
                        ResultSet rs = null;
                        String sql = "Select * FROM THUOC";
                        try {
                            st = cn1.createStatement();
                            rs = st.executeQuery(sql);
                            int i = 1;
                            while (rs.next()) {
                                Vector data1 = new Vector();

                                data1.add(i);
                                data1.add(rs.getString(1));
                                data1.add(rs.getString(3));
//                                data1.add(rs.getString(3));
//                                data1.add(rs.getString(4));
//                                data1.add(rs.getString(5));
//                                data1.add(rs.getString(6));
//                                data1.add(rs.getString(7));
//                                 data.add(rs.getString(8));
//                                  data.add(rs.getString(9));
                                data.add(data1);
                                tableleft.setModel(new DefaultTableModel(data, head));
                                i++;

                            }

                        } catch (SQLException ex) {
                            System.out.println("LOI " + ex);
                        }
                    }
                } catch (SQLException ex) {
                    System.out.println("loi 2" + ex);
                    Logger.getLogger(Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

//        btnThem.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    btnThem.setBackground(Color.LIGHT_GRAY);
//                    txtMathuoc.requestFocus();
//                }
//
//            }
//
//        });
//        //
//        btnLuu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(false);
//            }
//        });
//        //
//        btnXoa.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(true);
//            }
//        });
//        //
//        btnSua.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                btnLuu.setVisible(true);
//            }
//        });
//        //
//        txtMathuoc.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                txtMathuoc.setForeground(Color.red);
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtTen.requestFocus();
//                    txtMathuoc.setForeground(Color.BLACK);
//                    txtTen.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtTen.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtHansudung.requestFocus();
//                    txtTen.setForeground(Color.BLACK);
//                    txtHansudung.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtHansudung.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtDonvi.requestFocus();
//                    txtHansudung.setForeground(Color.BLACK);
//                    txtDonvi.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtDonvi.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                txtDonvi.setForeground(Color.BLACK);
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtHoatchat.requestFocus();
//                    txtDonvi.setForeground(Color.BLACK);
//                    txtHoatchat.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtHoatchat.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtHoatchat.setForeground(Color.BLACK);
//
//                    txtHamluong.requestFocus();
//                    txtHamluong.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtHamluong.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtHangsanxuat.requestFocus();
//                    txtHamluong.setForeground(Color.BLACK);
//                    txtHangsanxuat.setForeground(Color.red);
//                }
//            }
//        });
//        btnThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                /*              try{
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
//                 */
//                JOptionPane.showMessageDialog(null, "đã thêm vào bảng");
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        btnSua.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "edited");
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        btnLuu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Saved");
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        //
//        txtHangsanxuat.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtGiaban.requestFocus();
//                    txtHangsanxuat.setForeground(Color.BLACK);
//                    txtGiaban.setForeground(Color.red);
//                }
//            }
//        });
//        //
//        txtGiaban.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//
//                    txtGiaban.setForeground(Color.BLACK);
//                    taCachdung.requestFocus();
//                    taCachdung.setForeground(Color.red);
//                }
//            }
//        });
//        taCachdung.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    btnThem.requestFocus();
//                    btnThem.setBackground(Color.red);
//                    taCachdung.setForeground(Color.BLACK);
//                }
//            }
//        });
//        //SỬA
//        btnSua.addMouseListener(new MouseAdapter() {
//
//            public void mouseEntered(MouseEvent e) {
//                btnSua.setBackground(Color.RED);
//
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnSua.setBackground(Color.LIGHT_GRAY);
//
//            }
//        });
//        btnLuu.addMouseListener(new MouseAdapter() {
//
//            public void mouseEntered(MouseEvent e) {
//                btnLuu.setBackground(Color.RED);
//
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnLuu.setBackground(Color.LIGHT_GRAY);
//
//            }
//        });
//        //XÓA
//        btnXoa.addMouseListener(new MouseAdapter() {
//
//            public void mouseEntered(MouseEvent e) {
//                btnXoa.setBackground(Color.RED);
//
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnXoa.setBackground(Color.LIGHT_GRAY);
//
//            }
//        });
//        //THÊM
//        btnThem.addMouseListener(new MouseAdapter() {
//
//            public void mouseEntered(MouseEvent e) {
//                btnThem.setBackground(Color.RED);
//
//            }
//
//            public void mouseExited(MouseEvent e) {
//                btnThem.setBackground(Color.LIGHT_GRAY);
//
//            }
//        });
    }

}
