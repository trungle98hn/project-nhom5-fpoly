/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Menu extends JFrame implements ActionListener {

    JMenuBar menubar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    JMenu Baocao = new JMenu("Báo cáo");
    JMenuItem itThuoc = new JMenuItem("Thuốc");
    JMenuItem itNhanvien = new JMenuItem("Nhân viên");
    JMenuItem itHoadon = new JMenuItem("Hóa đơn");
    JMenuItem itthoat = new JMenuItem("Thoát");
    JMenuItem itDoanhthungaythang = new JMenuItem("Doanh thu bán thuốc theo ngày/tháng");
    JMenuItem itDoanhthunhanvien = new JMenuItem("Doanh thu bán thuốc theo nhân viên");
    FrameLogin fr = new FrameLogin();

    JPanel pnlTong = new JPanel();
    JPanel pnlTrong = new JPanel();

    public Menu() {
        //color
//          JLabel id=new JLabel("ID");
//        JLabel pass=new JLabel("Pass");
//        JTextField txtID=new JTextField(5);
//        JPasswordField txtPass=new JPasswordField(5);
//        fr.add(id);
//        fr.add(txtID);
//        fr.add(pass);
//        fr.add(txtPass);

        //
        setTitle("Quản lý cửa hàng thuốc");

        pnlTong.setLayout(new BorderLayout());

        menu.add(itThuoc);
        menu.add(itNhanvien);
        menu.add(itHoadon);
        menu.add(itthoat);
        menu.addSeparator();

        Baocao.add(itDoanhthungaythang);
        Baocao.add(itDoanhthunhanvien);
        Baocao.addSeparator();

        menubar.add(menu);
        menubar.add(Baocao);

        pnlTong.add(menubar, BorderLayout.PAGE_START);
        pnlTong.add(pnlTrong, BorderLayout.CENTER);

        this.add(pnlTong);
        itThuoc.addActionListener(this);
        itNhanvien.addActionListener(this);
        itHoadon.addActionListener(this);
        itDoanhthunhanvien.addActionListener(this);
        itDoanhthungaythang.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == itThuoc) {
            Thuoc t = new Thuoc();
            pnlTrong.removeAll();
            pnlTrong.add(t.pnlMain, BorderLayout.CENTER);
            pnlTrong.validate();
            pnlTrong.repaint();
        } else if (ae.getSource() == itNhanvien) {
            Nhanvien nv = new Nhanvien();
            pnlTrong.removeAll();
            pnlTrong.add(nv.pnlMain, BorderLayout.CENTER);
            pnlTrong.validate();
            pnlTrong.repaint();
        } else if (ae.getSource() == itHoadon) {
            Hoadon hd = new Hoadon();
            pnlTrong.removeAll();
            pnlTrong.add(hd.pnlMain, BorderLayout.CENTER);
            pnlTrong.validate();
            pnlTrong.repaint();
        } else if (ae.getSource() == itDoanhthunhanvien) {
            Baocaodoanhthunhanvien Bcdtnv = new Baocaodoanhthunhanvien();
            pnlTrong.removeAll();
            pnlTrong.add(Bcdtnv.pnlMain, BorderLayout.CENTER);
            pnlTrong.validate();
            pnlTrong.repaint();
        } else if (ae.getSource() == itDoanhthungaythang) {
            Baocaodoanhthungaythang Bcdtnt = new Baocaodoanhthungaythang();
            pnlTrong.removeAll();
            pnlTrong.add(Bcdtnt.pnlMain, BorderLayout.CENTER);
            pnlTrong.validate();
            pnlTrong.repaint();
        }

    }

}
