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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
;

/**
 *
 * @author dell
 */
public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    public String matricule;
    private JButton modif;
    private JButton supp;

    public ButtonEditor(JFrame frame) {
        panel = new JPanel();
         emailS.fr=frame;
        panel.setOpaque(false); // Placez cette ligne ici
        modif = new JButton("Modifier");
     supp = new JButton("Supprimer");
        modif.setBackground(Color.GREEN);
        modif.setForeground(Color.WHITE);
         supp.setBackground(Color.RED);
         supp.setForeground(Color.WHITE);  
        modif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              emailS.mat=matricule;
          
              Modification_Emp win=new Modification_Emp();
              win.setVisible(true);
        
            }
        });
        supp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(matricule);
                 try {
         java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_conge", "root", "");

        String sql = "DELETE FROM employes  WHERE matricule= ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,matricule); // tu peux remplacer par une valeur fixe si besoin
       
        int res=pst.executeUpdate();
        
        if (res>0) {
            JOptionPane.showMessageDialog(null, "Suppression reussie !");
           Gestion_employe win=new Gestion_employe();
           win.setVisible(true);
           frame.dispose();
           
        }
         pst.close();
        con.close();
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erreur lors de Suppression  : " + ex.getMessage());
       }
            }
        });
        panel.add(modif);
        panel.add(supp);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        matricule=table.getModel().getValueAt(row, 1).toString();
        
        panel.setBackground(table.getBackground());
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        
        return matricule;
    }
    
    
    



}
