/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
/**
 *
 * @author dell
 */

    public class ButtonRenderer extends JPanel implements TableCellRenderer {
    private JButton modif;
    private JButton supp;
    public String matricule;

    public ButtonRenderer() {
        setLayout(new FlowLayout());
        modif = new JButton("Modifier");
        supp= new JButton("Supprimer");
        add(modif);
        add(supp);
        modif.setBackground(Color.GREEN);
        modif.setForeground(Color.WHITE);
      
        supp.setBackground(Color.RED);
       supp.setForeground(Color.WHITE); 
         this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
         this.setBackground(Color.WHITE);

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int  currentRow = row;
      
        return this;
    }
}
    

