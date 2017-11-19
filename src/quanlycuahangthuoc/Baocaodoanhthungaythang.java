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
public class Baocaodoanhthungaythang extends JFrame{
    //jpanel
    JPanel pnlMain = new JPanel();
    JPanel pnlTieude = new JPanel();
    JPanel pnlTop = new JPanel();
    JPanel pnlTopB= new JPanel();
    JPanel pnlBottom= new JPanel();
    
    
    //jlabel
    JLabel lblTieude = new JLabel("Doanh thu bán thuốc theo tháng");
    JLabel lblTungay = new JLabel("Từ ngày");
    JLabel lblDenngay = new JLabel("Đến ngày");
    
    //JTEXTFILE
    JTextField txtTungay= new JTextField();
    JTextField txtDengay = new JTextField();
    
    //jbutton
    JButton btnLoc = new JButton("Lọc");

    public Baocaodoanhthungaythang(){
        pnlMain.setLayout(new BorderLayout());
        pnlTieude.setLayout(new FlowLayout());
        pnlTopB.setLayout(new GridBagLayout());
        pnlTop.setLayout(new BorderLayout());
        pnlBottom.setLayout(new BorderLayout());
        
        pnlTopB.add(lblTungay, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTopB.add(txtTungay, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
        pnlTopB.add(lblDenngay, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
        pnlTopB.add(txtDengay, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 120, 0));
      
        pnlTopB.add(btnLoc, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST,
                GridBagConstraints.NONE,
                new Insets(10, 20, 0, 0), 0, 0));
       
     //table
        String[] header = {"STT", "Ngày", "Doanh thu"};
        Object[][] data = {
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
        JTable table = new JTable(data, header);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scrDanhsach = new JScrollPane(table);
        //
        lblTieude.setForeground(Color.red);
        lblDenngay.setForeground(Color.red);
        lblTungay.setForeground(Color.red);
        //
        pnlMain.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5,5));
        pnlTopB.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        pnlTieude.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnlTieude.add(lblTieude);
        
        pnlTop.add(pnlTieude, BorderLayout.NORTH);
        pnlTop.add(pnlTopB, BorderLayout.CENTER);
        
        pnlBottom.add(scrDanhsach, BorderLayout.CENTER);
        
        pnlMain.add(pnlTop,  BorderLayout.NORTH);
        pnlMain.add(pnlBottom,  BorderLayout.CENTER);
        
        
        this.add(pnlMain);
    }
//    public static void main(String[] args) {
//        Baocaodoanhthungaythang B = new Baocaodoanhthungaythang();
//        B.setSize(900, 550);
//        B.setLocationRelativeTo(null);
//        B.setVisible(true);
//        
//    }
}
