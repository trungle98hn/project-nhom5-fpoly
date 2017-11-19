/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlycuahangthuoc;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */

     class render extends DefaultTableCellRenderer{
       private static final long serialVersionUID = 6703872492730589499L;
public static int curentrow=-1;
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(row%2 == 0){
            cellComponent.setBackground(new Color(190, 220, 190));
        }
       
         else {
            cellComponent.setBackground(new Color(230, 255, 250));
        }
         if(row == curentrow)
            this.setBackground(new Color(250, 250, 150));
         this.setOpaque(true);
        return cellComponent;
    }
    
      
        
      }

