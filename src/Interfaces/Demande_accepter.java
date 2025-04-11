/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Interfaces;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.Dimension;
/**
/**
 *
 * @author ELITEBOOK
 */
public class Demande_accepter extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Demande_accepter() {
        
    
        initComponents();
         chargerDonnees();
           
          
       configurerTable();
};
    
    
    
  private void configurerTable() {
 jScrollPane1.getViewport().setBackground(Color.WHITE);
      // Couleur du fond général
         jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
         jTable1.setRowHeight(30);
         
         
         
  DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBackground(Color.WHITE); 
        cell.setForeground(Color.BLACK);
        cell.setFont(new Font("Arial", Font.BOLD, 14));
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        return cell;
    }
};

DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBackground(new Color(0, 102, 204)); 
        cell.setForeground(Color.WHITE);
        cell.setFont(new Font("Arial", Font.BOLD, 15));
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        return cell;
    }
};

JTableHeader header = jTable1.getTableHeader();
header.setPreferredSize(new Dimension(0, 30)); // Hauteur de 30 pixels

// Appliquer les renderers
for (int i = 0; i < jTable1.getColumnCount(); i++) {
    jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    jTable1.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
}


    // Forcer le redessin
    jTable1.getTableHeader().repaint();
    jTable1.repaint();
    

    }
   
    
   
    
    
    
    private void chargerDonnees() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Vider les anciennes lignes
       String URL = "jdbc:mysql://localhost:3306/gestion_conge";
        String UTILISATEUR = "root";  // L'utilisateur pour se connecter � MySQL
        String MOT_DE_PASSE = "";  
         String query = "SELECT matricule, date_debut, date_fin, type_conge, statut FROM demandes WHERE statut = 'acceptée'";
        //connexion
            try (java.sql.Connection con = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
          PreparedStatement statement = con.prepareStatement(query)) { 
       
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        int compteur = 1;
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (rs.next()) {
            String matricule = rs.getString("matricule");
            String dateDebutStr = rs.getString("date_debut");
            String dateFinStr = rs.getString("date_fin");
            String type = rs.getString("type_conge");
            String statut = rs.getString("statut");

            // Conversion en LocalDate
            java.time.LocalDate dateDebut = java.time.LocalDate.parse(dateDebutStr, formatter);
            java.time.LocalDate dateFin = java.time.LocalDate.parse(dateFinStr, formatter);

            // Calcul de la durée
            long duree = java.time.temporal.ChronoUnit.DAYS.between(dateDebut, dateFin);

            // Ajouter à la table
            Object[] row = {
                compteur++,
                matricule,
                dateDebutStr,
                dateFinStr,
                duree,
                type,
                statut
            };
            model.addRow(row);
        }

        stmt.close();
        

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    
    
    
    
    

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Gestion = new javax.swing.JButton();
        accepter = new javax.swing.JButton();
        refuser = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        admin2 = new javax.swing.JButton();
        deconnexion2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        home1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1172, 564));

        jTable1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N", "matricule", "Dtae_debut", "Date_fin", "Durée", "Type", "statut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 0));
        jLabel3.setText("Les demandes Accepter");

        Gestion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Gestion.setForeground(new java.awt.Color(51, 0, 255));
        Gestion.setText("Demande En cours");
        Gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionActionPerformed(evt);
            }
        });

        accepter.setBackground(new java.awt.Color(51, 204, 0));
        accepter.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        accepter.setForeground(new java.awt.Color(255, 255, 255));
        accepter.setText("Demande  Acceptée");
        accepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepterActionPerformed(evt);
            }
        });

        refuser.setBackground(new java.awt.Color(255, 51, 0));
        refuser.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        refuser.setForeground(new java.awt.Color(255, 255, 255));
        refuser.setText("Demande Refusée");
        refuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuserActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CongeManager");

        admin2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        admin2.setForeground(new java.awt.Color(51, 51, 255));
        admin2.setText("Admin");
        admin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin2ActionPerformed(evt);
            }
        });

        deconnexion2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deconnexion2.setForeground(new java.awt.Color(51, 51, 255));
        deconnexion2.setText("Deconnexion");
        deconnexion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexion2ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setText("Historique  des Demandes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 255));
        jButton6.setMnemonic('G');
        jButton6.setText("Gestion des Demandes");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 255));
        jButton10.setText("Gestion des Employés");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        home1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        home1.setForeground(new java.awt.Color(51, 51, 255));
        home1.setText("Accueil");
        home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(deconnexion2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(home1)
                .addGap(27, 27, 27)
                .addComponent(admin2)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addGap(26, 26, 26)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton10)
                .addGap(78, 78, 78)
                .addComponent(deconnexion2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(359, 359, 359)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(Gestion)
                                .addGap(100, 100, 100)
                                .addComponent(accepter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(refuser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(307, 307, 307))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accepter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refuser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gestion, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1324, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        Gestion_demande win= new  Gestion_demande();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GestionActionPerformed

    private void accepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accepterActionPerformed
        Demande_accepter win=new    Demande_accepter();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accepterActionPerformed

    private void refuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refuserActionPerformed

        Demande_Refuser win= new  Demande_Refuser();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refuserActionPerformed

    private void admin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin2ActionPerformed
        // TODO add your handling code here:
        Admin win=new Admin();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_admin2ActionPerformed

    private void deconnexion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexion2ActionPerformed
        // TODO add your handling code here:
        login win=new login();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deconnexion2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Historique win=new Historique();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Gestion_demande win=new Gestion_demande();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Gestion_employe win=new Gestion_employe();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1ActionPerformed
        // TODO add your handling code here:
        acceuil win=new acceuil();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_home1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Demande_accepter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demande_accepter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demande_accepter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demande_accepter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demande_accepter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Gestion;
    private javax.swing.JButton accepter;
    private javax.swing.JButton admin2;
    private javax.swing.JButton deconnexion2;
    private javax.swing.JButton home1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refuser;
    // End of variables declaration//GEN-END:variables
}
