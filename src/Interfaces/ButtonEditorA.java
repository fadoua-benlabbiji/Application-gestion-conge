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
import java.awt.FlowLayout;
import java.awt.Color;


import java.awt.event.ActionEvent;



public class ButtonEditorA extends AbstractCellEditor implements TableCellEditor {
    private JPanel panel;
    public String currentMatricule;
    private JButton accepterButton;
    private JButton refuserButton;

    public ButtonEditorA() {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        panel.setOpaque(true);
        panel.setBackground(Color.WHITE); // Fond blanc constant

        // Bouton "Accepter"
        accepterButton = new JButton("Accepter");
        accepterButton.setBackground(new Color(0, 150, 0));
        accepterButton.setForeground(Color.WHITE);
        accepterButton.setOpaque(true);
        accepterButton.setBorderPainted(false);
        accepterButton.addActionListener(this::accepterButtonPerformed);

        // Bouton "Refuser"
        refuserButton = new JButton("Refuser");
        refuserButton.setBackground(new Color(150, 0, 0));
        refuserButton.setForeground(Color.WHITE);
        refuserButton.setOpaque(true);
        refuserButton.setBorderPainted(false);
        refuserButton.addActionListener(this::refuserButtonPerformed);

        // Ajouter les boutons au panneau
        panel.add(accepterButton);
        panel.add(refuserButton);
    }

    private void accepterButtonPerformed(ActionEvent evt) {
        fireEditingStopped();
        emailS.accep=currentMatricule;
        Accepter_demande win = new Accepter_demande();
        win.setVisible(true);
        System.out.println(currentMatricule);
    }

    private void refuserButtonPerformed(ActionEvent evt) {
        fireEditingStopped();
        refuser_demande win = new refuser_demande();
        win.setVisible(true);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
         currentMatricule=table.getModel().getValueAt(row, 1).toString();
        panel.setBackground(Color.WHITE); // Forcer fond blanc même lors du clic
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
