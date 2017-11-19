/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

import static com.sun.scenario.effect.impl.prism.PrEffectHelper.render;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import org.w3c.dom.events.EventException;
import static quanlycuahangthuoc.Main.kn;

/**
 *
 * @author admin
 */
public final class Nhanvien extends JFrame {

    JPanel pnlMain = new JPanel();
    JPanel pnlNorth = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlSouth = new JPanel();
    JPanel pnlCenterT = new JPanel();
    JPanel pnlCenterB = new JPanel();
    //
    JButton btnThem = new JButton("Thêm");
    JButton btnLuu = new JButton("Lưu");
    JButton btnXoa = new JButton("Xóa");
    JButton btnSua = new JButton("Sửa");
    JButton btnBoqua = new JButton("Bỏ qua");
    //
    JLabel lblMaso = new JLabel("Mã nhân viên");
    JLabel lblHoten = new JLabel("Họ tên");
    JLabel lblGioitinh = new JLabel("Giới tính");
    JLabel lblNamsinh = new JLabel("Năm sinh");
    JLabel lblDiachi = new JLabel("Địa chỉ");
    JLabel lblTrinhdo = new JLabel("Trình độ");
    JLabel lblNgaydilam = new JLabel("Ngày đi làm");
    JLabel lblDanhsach = new JLabel("Danh sách nhân viên bán hàng");
    //
    JTextField txtMaso = new JTextField(10);
    JTextField txtHoten = new JTextField(10);
    JTextField txtGioitinh = new JTextField(10);
    JTextField txtNamsinh = new JTextField(10);
    JTextField txtDiachi = new JTextField(10);
    JTextField txtTrinhdo = new JTextField(10);
    JTextField txtNgaydilam = new JTextField(10);

    //
    public Nhanvien() {
//        btnLuu.setBackground(Color.LIGHT_GRAY);
//        btnSua.setBackground(Color.LIGHT_GRAY);
//        btnThem.setBackground(Color.LIGHT_GRAY);
//        btnXoa.setBackground(Color.LIGHT_GRAY);
        pnlMain.setLayout(new BorderLayout());
        pnlNorth.setLayout(new GridBagLayout());
        pnlSouth.setLayout(new BorderLayout());
        pnlCenter.setLayout(new BorderLayout());
        pnlCenterT.setLayout(new FlowLayout());
        pnlCenterB.setLayout(new FlowLayout());
        //
        pnlNorth.add(lblMaso, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtMaso, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblHoten, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtHoten, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblGioitinh, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtGioitinh, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblNamsinh, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtNamsinh, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblDiachi, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtDiachi, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblTrinhdo, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtTrinhdo, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        pnlNorth.add(lblNgaydilam, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlNorth.add(txtNgaydilam, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 150, 0));
        //Table

        JTable table = new JTable();
        DefaultTableModel dftb = new DefaultTableModel();
        Vector data = new Vector();
        Vector header = new Vector();
        header.add("STT");
        header.add("Mã nhân viên");
        header.add("Họ tên");
        header.add("Giới tính");
        header.add("Năm sinh");
        header.add("Địa chỉ");
        header.add("Trình độ");
        header.add("Ngày đi làm");
        Connection cn = kn.getConnect();
        table.setPreferredScrollableViewportSize(new Dimension(1000, 230));
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select * FROM NHANVIEN";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                Vector data1 = new Vector();

                data1.add(i);
                data1.add(rs.getString(1));
                data1.add(rs.getString(2));
                data1.add(rs.getString(3));
                data1.add(rs.getString(4));
                data1.add(rs.getString(5));
                data1.add(rs.getString(6));
                data1.add(rs.getString(7));
                // data.add(rs.getString(8));
                data.add(data1);
                table.setModel(new DefaultTableModel(data, header));
                i++;

            }

        } catch (Exception e) {
        }
        JScrollPane scrDanhsach = new JScrollPane(table);
        table.setModel(new DefaultTableModel(data, header));

        txtMaso.setText(table.getValueAt(1, 1) + "");
        txtHoten.setText(table.getValueAt(1, 2) + "");
        txtGioitinh.setText(table.getValueAt(1, 3) + "");
        txtNamsinh.setText(table.getValueAt(1, 4) + "");
        txtDiachi.setText(table.getValueAt(1, 5) + "");
        txtTrinhdo.setText(table.getValueAt(1, 6) + "");
        txtNgaydilam.setText(table.getValueAt(1, 7) + "");

//        table.getColumnModel().getColumn(0).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(1).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(2).setCellRenderer((TableCellRenderer) new render());
//        table.getColumnModel().getColumn(3).setCellRenderer((TableCellRenderer) new render());
        //
        pnlMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlCenter.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlSouth.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        lblDanhsach.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
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
        pnlCenter.add(pnlCenterT, BorderLayout.NORTH);
        pnlCenter.add(pnlCenterB, BorderLayout.SOUTH);
        //
        pnlSouth.add(lblDanhsach, BorderLayout.NORTH);
        pnlSouth.add(scrDanhsach, BorderLayout.CENTER);
        //
        pnlMain.add(pnlNorth, BorderLayout.CENTER);
        pnlMain.add(pnlCenter, BorderLayout.SOUTH);
        pnlMain.add(pnlSouth, BorderLayout.NORTH);
        this.add(pnlMain);

        //
//        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                //for(col=1;col<7;col++){
                txtMaso.setText(table.getValueAt(row, 1) + "");
                txtHoten.setText(table.getValueAt(row, 2) + "");
                txtGioitinh.setText(table.getValueAt(row, 3) + "");
                txtNamsinh.setText(table.getValueAt(row, 4) + "");
                txtDiachi.setText(table.getValueAt(row, 5) + "");
                txtTrinhdo.setText(table.getValueAt(row, 6) + "");
                txtNgaydilam.setText(table.getValueAt(row, 7) + "");

            }

        });
        btnBoqua.setVisible(false);
        btnLuu.setVisible(false);
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connect cn = new Connect();
                Connection cnn = cn.getConnect();
                try {
                    PreparedStatement ps = cnn.prepareStatement("Update NHANVIEN SET TENNV=?,GIOITINH=?,NAMSINH=?,DIACHI=?,TRINHDO=?,NGAYNDILAM=? WHERE MANV=?");
                    ps.setString(7, txtMaso.getText());
                    ps.setString(1, txtHoten.getText());
                    ps.setString(2, txtGioitinh.getText());
                    ps.setString(3, txtNamsinh.getText());
                    ps.setString(4, txtDiachi.getText());
                    ps.setString(5, txtTrinhdo.getText());
                    ps.setString(6, txtNgaydilam.getText());
                    int chk = ps.executeUpdate();

                    if (chk > 0) {
                        JOptionPane.showMessageDialog(null, "Edited");
                        table.setModel(new DefaultTableModel(data, header));
                        Connection cn1 = kn.getConnect();
                        table.setPreferredScrollableViewportSize(new Dimension(930, 230));
                        Statement st = null;
                        ResultSet rs = null;
                        String sql = "Select * FROM NHANVIEN";
                        try {
                            st = cn1.createStatement();
                            rs = st.executeQuery(sql);
                            int i = 1;
                            while (rs.next()) {
                                Vector data1 = new Vector();

                                data1.add(i);
                                data1.add(rs.getString(1));
                                data1.add(rs.getString(2));
                                data1.add(rs.getString(3));
                                data1.add(rs.getString(4));
                                data1.add(rs.getString(5));
                                data1.add(rs.getString(6));
                                data1.add(rs.getString(7));
                                // data.add(rs.getString(8));
                                data.add(data1);
                                table.setModel(new DefaultTableModel(data, header));
                                i++;

                            }
                            btnBoqua.setVisible(true);
                            btnLuu.setVisible(true);
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
        btnLuu.setVisible(false);
        btnBoqua.setVisible(false);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                //for(col=1;col<7;col++){
                txtMaso.setText(table.getValueAt(row, 1) + "");
                txtHoten.setText(table.getValueAt(row, 2) + "");
                txtGioitinh.setText(table.getValueAt(row, 3) + "");
                txtNamsinh.setText(table.getValueAt(row, 4) + "");
                txtDiachi.setText(table.getValueAt(row, 5) + "");
                txtTrinhdo.setText(table.getValueAt(row, 6) + "");
                txtNgaydilam.setText(table.getValueAt(row, 7) + "");

            }

        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connect cn = new Connect();
                Connection cnn = cn.getConnect();
                try {
                    PreparedStatement ps = cnn.prepareStatement("Delete NHANVIEN Where MANV=?");
                    ps.setString(1, txtMaso.getText());
                    if (JOptionPane.showConfirmDialog(null, "ban co muon xoa ko?", "config", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ps.executeUpdate();
                        btnBoqua.setVisible(true);
                        btnLuu.setVisible(true);
                        DefaultTableModel tbn = new DefaultTableModel();
                        table.setModel(tbn);
                        tbn.setRowCount(0);
                        try {
                            Connect a = new Connect();
                            Connection cnn2 = a.getConnect();
                            Vector row, col;
                            int dem;
                            col = new Vector();
                            Statement st = cnn2.createStatement();
                            ResultSet rs = st.executeQuery("Select * FROM NHANVIEN");
                            ResultSetMetaData meta = rs.getMetaData();
                            dem = meta.getColumnCount();
                            for (int i = 1; i <= dem; i++) {
                                col.add(meta.getColumnName(i));
                            }
                            tbn.setColumnIdentifiers(col);
                            while (rs.next()) {
                                row = new Vector();
                                for (int i = 1; i <= dem; i++) {
                                    row.addElement(rs.getString(i));
                                }
                                tbn.addRow(row);
                                table.setModel(tbn);
                            }

                        } catch (SQLException ex) {
                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Nhanvien.class.getName()).log(Level.SEVERE, null, ex);
                }

                table.setModel(new DefaultTableModel(data, header));

            }
        });
        txtGioitinh.setToolTipText("Nam/Nữ");
        txtNamsinh.setToolTipText("ngày/tháng/năm hoặc ngày-tháng-năm");
        txtNgaydilam.setToolTipText("ngày/tháng/năm hoặc ngày-tháng-năm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                btnBoqua.setVisible(true);
                btnLuu.setVisible(true);
                btnThem.setVisible(false);
                btnSua.setVisible(false);
                btnXoa.setVisible(false);
                txtDiachi.setText("");
                txtGioitinh.setText("");
                txtHoten.setText("");
                txtMaso.setText("");
                txtNamsinh.setText("");
                txtNgaydilam.setText("");
                txtTrinhdo.setText("");
                txtMaso.requestFocus();
//     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Connect cn = new Connect();
                    Connection cnn = cn.getConnect();
                    PreparedStatement ps = cnn.prepareStatement("Insert into NHANVIEN values(?,?,?,?,?,?,?)");
                    ps.setString(1, txtMaso.getText());
                    ps.setString(2, txtHoten.getText());
                    ps.setString(3, txtGioitinh.getText());
                    ps.setString(4, txtNamsinh.getText());
                    ps.setString(5, txtDiachi.getText());
                    ps.setString(6, txtTrinhdo.getText());
                    ps.setString(7, txtNgaydilam.getText());

                    btnThem.setVisible(true);
                    btnXoa.setVisible(true);
                    btnSua.setVisible(true);
                    boolean kq = true;
                    String dateString = txtNamsinh.getText();
                    String k = txtNgaydilam.getText();
                    SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                    DefaultTableModel tbn = new DefaultTableModel();
                    df.setLenient(false); // set false để kiểm tra tính hợp lệ của date. VD: tháng 2 phải có 28-29 ngày, năm có 12 tháng,....
                    try {
                        df.parse(k);
                        df.parse(dateString); // parse dateString thành kiểu Date
                        kq = true;
                    } catch (ParseException ex) { // quăng lỗi nếu dateString ko hợp lệ
                        System.out.println("Invalid date");
                        kq = false;
                    }

                    if (kq == false || txtMaso.getText().isEmpty() || txtDiachi.getText().isEmpty() || txtGioitinh.getText().isEmpty() || txtHoten.getText().isEmpty() || txtNamsinh.getText().isEmpty() || txtNgaydilam.getText().isEmpty() || txtTrinhdo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "bạn chưa nhập đầy đủ thông tin hoặc nhập sai thông tin ");
                    } else {

                        int chk = ps.executeUpdate();
                        if (chk > 0) {
                            txtMaso.setText("");
                            txtDiachi.setText("");
                            txtGioitinh.setText("");
                            txtHoten.setText("");
                            txtNamsinh.setText("");
                            txtNgaydilam.setText("");
                            txtTrinhdo.setText("");
                            // btn.setRowCount(0);
                            JOptionPane.showMessageDialog(null, "Saved");

                            // table.setModel((TableModel) new Table());
                            Connection cn1 = kn.getConnect();

                            table.setPreferredScrollableViewportSize(new Dimension(930, 230));
                            Statement st = null;
                            ResultSet rs = null;

                            //   btn.setRowCount(0);
                            String sql = "Select * FROM NHANVIEN";
                            try {
                                st = cn1.createStatement();
                                rs = st.executeQuery(sql);
                                int i = 1;
                                while (rs.next()) {
                                    Vector data1 = new Vector();

                                    data1.add(i);
                                    data1.add(rs.getString(1));
                                    data1.add(rs.getString(2));
                                    data1.add(rs.getString(3));
                                    data1.add(rs.getString(4));
                                    data1.add(rs.getString(5));
                                    data1.add(rs.getString(6));
                                    data1.add(rs.getString(7));
                                    data.add(rs.getString(8));
                                    data.add(data1);

                                    table.setModel(new DefaultTableModel(data, header));
                                    i++;
//                                    table.removeAll();
//                                    //dftb.setRowCount(0);
//                                    try {
//                                        Connect a = new Connect();
//                                        Connection cnn1 = a.getConnect();
//                                        Vector row = null, col;
//                                        int dem;
//                                        col = new Vector();
//                                        Statement st1 = cnn1.createStatement();
//                                        ResultSet rs1 = st1.executeQuery("Select * FROM STAFF");
//                                        ResultSetMetaData meta = rs1.getMetaData();
//                                        dem = meta.getColumnCount();
//                                        for (int l = 1; l <= dem; l++) {
//                                            col.add(meta.getColumnName(l));
//                                        }
//                                        tbn.setColumnIdentifiers(col);
//                                        while (rs.next()) {
//                                            row = new Vector();
//                                            for (int q = 1; q <= dem; q++) {
//                                                row.addElement(rs.getString(q));
//                                            }
//                                            tbn.addRow(row);
//
//                                        }
//                                        table.setModel(new DefaultTableModel(row, col));
//                                        dftb.setRowCount(0);
//                                        table.removeAll();
//                                        Nhanvien nv = new Nhanvien();
//                                         Connection cn0 = kn.getConnect();
//        table.setPreferredScrollableViewportSize(new Dimension(930, 230));
//        Statement st0 = null;
//        ResultSet rs0 = null;
//        String sql0 = "Select * FROM STAFF";
//        try {
//            st = cn0.createStatement();
//            rs = st.executeQuery(sql);
//            int i = 1;
//            while (rs.next()) {
//                Vector data1 = new Vector();
//
//                data1.add(i);
//                data1.add(rs.getString(1));
//                data1.add(rs.getString(2));
//                data1.add(rs.getString(3));
//                data1.add(rs.getString(4));
//                data1.add(rs.getString(5));
//                data1.add(rs.getString(6));
//                data1.add(rs.getString(7));
//                // data.add(rs.getString(8));
//                data.add(data1);
//                table.setModel(new DefaultTableModel(data, header));
//                i++;
//
//            }
//
//        } catch (SQLException ec) {
//        }
//                                    } catch (SQLException ex) {
//                                    }
                                    btnBoqua.setVisible(true);
                                    btnLuu.setVisible(true);
                                }

                            } catch (SQLException ex) {
                            }
                            dftb.setRowCount(0);
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
        btnBoqua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnXoa.setVisible(true);
                btnThem.setVisible(true);
                btnSua.setVisible(true);
                btnBoqua.setVisible(false);
                btnLuu.setVisible(false);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
//        btnLuu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Saved");
//
////     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        //HighLight
//        btnLuu.setVisible(false);
//        btnThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                txtMaso.setText("");
//                txtHoten.setText("");
//                txtMaso.requestFocus();
//                btnLuu.setVisible(true);
//
//            }
//        });
//        btnThem.addKeyListener(new KeyAdapter() {
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    int i;
//                    //switch(i){
//
//                    if ("".equals(txtHoten.getText()) || "".equals(txtMaso.getText())) {
//                        JOptionPane.showMessageDialog(null, "ban chua dien ho ten nv");
//                        JOptionPane.showMessageDialog(null, "bạn chưa điền gì cả");
//                        txtMaso.requestFocus();
//                        i = 1;
//
//                    }
//
//                    if ("".equals(txtHoten.getText())) {
//                        JOptionPane.showMessageDialog(null, "ban chua dien ho ten nv");
//                        txtHoten.requestFocus();
//                        i = 2;
//                    } else if ("".equals(txtMaso.getText())) {
//                        JOptionPane.showMessageDialog(null, "ban chua dien ma so nv");
//                        txtMaso.requestFocus();
//                        i = 3;
//                    } else if (!"".equals(txtHoten.getText()) || txtMaso.getText() != "") {
//                        btnThem.setBackground(Color.LIGHT_GRAY);
//                        txtMaso.requestFocus();
//
//                        txtHoten.setText("");
//                        txtMaso.setText("");
//                        JOptionPane.showMessageDialog(null, "saved");
//                        i = 4;
//                    }
//
//                }
//
//            }
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
//        txtMaso.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                txtMaso.setForeground(Color.red);
//                
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    txtHoten.requestFocus();
//                    txtMaso.setForeground(Color.BLACK);
//                    txtHoten.setForeground(Color.red);
//                   
//                }
//            }
//        });
//        txtMaso.addMouseListener(new MouseAdapter() {
//            public void MouseClicked(MouseEvent evt){
//                txtMaso.selectAll();
//                txtMaso.setText("");
//            }
//        
//        });
//        //
//        txtHoten.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent evt) {
//                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//                    btnThem.requestFocus();
//                    btnThem.setBackground(Color.red);
//                    txtMaso.setForeground(Color.BLACK);
//                    txtHoten.setForeground(Color.BLACK);
//                }
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
