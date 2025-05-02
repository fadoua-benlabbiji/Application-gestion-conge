/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
;

/**
 *
 * @author dell
 */
public class ButtonEditorP extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
  
  private String currentMatricule;
      private JButton profileButton;
    

    public ButtonEditorP() {
        panel = new JPanel();
       
        panel.setOpaque(false); // Placez cette ligne ici
        
         profileButton=new JButton("Profile");
         
           profileButton.setBackground(Color.BLUE);
          profileButton.setForeground(Color.WHITE);
        
           profileButton.addActionListener(this::profileButtonPerformed);
    
    
        panel.add(profileButton);
        
    }
    
    
    
    
     private void profileButtonPerformed(ActionEvent evt) {
       
        fireEditingStopped();
        Employe win = new Employe(currentMatricule);
        win.setVisible(true);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      
       // Récupération fiable du matricule
        currentMatricule = table.getModel().getValueAt(row, 1).toString();
        System.out.println("Matricule sélectionné: " + currentMatricule + " (Ligne: " + row + ")");
        
        
        
         System.out.println(currentMatricule);

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
      
        return currentMatricule; // Retourne le matricule plutôt que null
    }
    }
    
    
    




