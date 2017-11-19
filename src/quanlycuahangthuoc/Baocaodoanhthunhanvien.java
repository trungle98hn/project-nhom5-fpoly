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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public final class Baocaodoanhthunhanvien extends JFrame {

    //JPanel
    JPanel pnlMain = new JPanel();
    JPanel pnlLeft = new JPanel();
    JPanel pnlRight = new JPanel();
    JPanel pnlTop = new JPanel();
    JPanel pnlTopB = new JPanel();
    JPanel pnlTieude = new JPanel();

    //JLabel
    JLabel lblTieude = new JLabel("Doanh thu bán thuốc theo nhân viên");
    JLabel lblDSnhanvien = new JLabel("Danh sách nhân viên");
    JLabel lblDSngayban = new JLabel("Danh sách ngày bán");
    JLabel lblNhanvien = new JLabel("Tìm nhân viên");
    JLabel lblNgay = new JLabel("Tìm ngày");

    //JTextField
    JTextField txtNhanvien = new JTextField();
    JTextField txtNgay = new JTextField();
    
    //JButton
    JButton btnTim = new JButton("Tìm");
    
    public Baocaodoanhthunhanvien() {
        
        pnlMain.setLayout(new BorderLayout());
        pnlLeft.setLayout(new BorderLayout());
        pnlRight.setLayout(new BorderLayout());
        pnlTieude.setLayout(new FlowLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlTopB.setLayout(new GridBagLayout());
        //
        lblTieude.setForeground(Color.red);
        lblDSnhanvien.setForeground(Color.red);
        lblDSngayban.setForeground(Color.red);
        lblNhanvien.setForeground(Color.red);
        lblNgay.setForeground(Color.red);
        //table
        String[] headerleft = {"STT", "Mã nhân viên", "Tên"};
        Object[][] dataleft = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},
            {"", "", ""},};
        JTable tableleft = new JTable(dataleft, headerleft);
        tableleft.setPreferredScrollableViewportSize(new Dimension(380, 335));
        tableleft.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableleft.setFillsViewportHeight(true);
        JScrollPane scrleft = new JScrollPane(tableleft);
        //table 2
        String[] headeright = {"STT", "Ngày bán ", "Số hóa đơn", "Doanh thu", "Ghi chú"};
        Object[][] dataright = {
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},
            {"", "", "", "", ""},};
        JTable tableright = new JTable(dataright, headeright);
        tableright.setPreferredScrollableViewportSize(new Dimension(580, 335));
        tableright.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableright.setFillsViewportHeight(true);
        JScrollPane scrright = new JScrollPane(tableright);
        //
        pnlTopB.add(lblNhanvien, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTopB.add(txtNhanvien, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlTopB.add(lblNgay, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTopB.add(txtNgay, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlTopB.add(btnTim, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
//        pnlMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlLeft.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlRight.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lblTieude.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
        pnlTopB.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        lblDSnhanvien.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        lblDSngayban.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 5));
        //
        pnlTieude.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlTieude.add(lblTieude);
        //
        pnlRight.add(lblDSngayban, BorderLayout.NORTH);
        pnlRight.add(scrright, BorderLayout.CENTER);
        //
        pnlLeft.add(lblDSnhanvien, BorderLayout.NORTH);
        pnlLeft.add(scrleft, BorderLayout.CENTER);
        //
        pnlTop.add(pnlTieude,BorderLayout.NORTH);
        pnlTop.add(pnlTopB,BorderLayout.CENTER);
        //
        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlLeft, BorderLayout.WEST);
        pnlMain.add(pnlRight, BorderLayout.EAST);
        
        this.add(pnlMain);
    }
    
}
