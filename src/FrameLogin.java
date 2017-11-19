package quanlycuahangthuoc;


import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class FrameLogin extends javax.swing.JFrame{
    Frame fr=new JFrame("Login");

    public FrameLogin() throws HeadlessException {
     fr.setLocationRelativeTo(this);
        //fr.setSize(50,60);
       
        boolean k=true;
        JLabel id=new JLabel("ID");
        JLabel pass=new JLabel("Pass");
        JTextField txtID=new JTextField(5);
        JPasswordField txtPass=new JPasswordField(5);
        fr.add(id);
        fr.add(txtID);
        fr.add(pass);
        fr.add(txtPass);
        if(k=true){
        
        
        }
    }
   
    
    }
