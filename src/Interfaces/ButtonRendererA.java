/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JButton;

/**
 *
 * @author dell
 */



public class ButtonRendererA extends JPanel implements TableCellRenderer {
    private JButton accepterButton;
    private JButton refuserButton;

    public ButtonRendererA() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        accepterButton = new JButton("Accepter");
        refuserButton = new JButton("Refuser");

        // Style des boutons
        accepterButton.setBackground(Color.GREEN);
        accepterButton.setForeground(Color.WHITE);

        refuserButton.setBackground(Color.RED);
        refuserButton.setForeground(Color.WHITE);

        // Ajout des boutons au panneau
        add(accepterButton);
        add(refuserButton);

        // Fond et bordure du panneau
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE); // Fond blanc
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Toujours fond blanc, même si sélectionné
        this.setBackground(Color.WHITE);
        return this;
    }
}
