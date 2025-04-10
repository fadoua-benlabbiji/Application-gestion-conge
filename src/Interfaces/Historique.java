/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package Interfaces;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;
import java.awt.Dimension;

import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Color;
/**
/**
 *
 * @author ELITEBOOK
 */
public class Historique extends javax.swing.JFrame {

   public Historique() {
    initComponents();
    chargerDonnees();

    // Configuration de la table
    configurerTable();
}

private void configurerTable() {
    
         jScrollPane1.getViewport().setBackground(Color.WHITE);
         // Couleur du fond général
         jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
         jTable1.setRowHeight(30);

    
 DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int statutColumnIndex = table.getColumn("statut").getModelIndex();
            Object statutValue = table.getValueAt(row, statutColumnIndex);
            String statut = statutValue != null ? statutValue.toString().toLowerCase() : "";
            switch (statut) {
                case "acceptée":
              
                    cell.setBackground(new Color(204, 255, 204)); // vert clair
                    break;
                case "refusée":
                
                    cell.setBackground(new Color(255, 204, 204)); // rouge clair
                    break;
                case "En cours":
                    cell.setBackground(Color.WHITE); // blanc
                    break;
                default:
                    // Si le statut est inconnu, utiliser alternance classique
                    cell.setBackground(Color.WHITE);
            }
            // Couleur du texte
            cell.setForeground(Color.BLACK);
            // Centrage
            cell.setHorizontalAlignment(SwingConstants.CENTER);
            // Police
            cell.setFont(new Font("Arial", Font.BOLD, 14));
            // Bordure
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
    String query = "SELECT matricule, date_debut, date_fin, type_conge, statut FROM demandes";
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
        accepter = new javax.swing.JButton();
        Gestion5 = new javax.swing.JButton();
        refuser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        admin1 = new javax.swing.JButton();
        deconnexion1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        home = new javax.swing.JButton();

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
                "N°", "matricule", "Dtae_debut", "Date_fin", "Durée", "Type", "statut"
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
        jLabel3.setForeground(new java.awt.Color(51, 0, 255));
        jLabel3.setText("Historique des Demandes");

        accepter.setBackground(new java.awt.Color(51, 204, 0));
        accepter.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        accepter.setForeground(new java.awt.Color(255, 255, 255));
        accepter.setText("Demande Accepter");
        accepter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepterActionPerformed(evt);
            }
        });

        Gestion5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        Gestion5.setForeground(new java.awt.Color(51, 0, 255));
        Gestion5.setText("Demande en cours");
        Gestion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Gestion5ActionPerformed(evt);
            }
        });

        refuser.setBackground(new java.awt.Color(255, 51, 0));
        refuser.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        refuser.setForeground(new java.awt.Color(255, 255, 255));
        refuser.setText("Demande Refuser");
        refuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuserActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CongeManager");

        admin1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        admin1.setForeground(new java.awt.Color(51, 51, 255));
        admin1.setText("Admin");
        admin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin1ActionPerformed(evt);
            }
        });

        deconnexion1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deconnexion1.setForeground(new java.awt.Color(51, 51, 255));
        deconnexion1.setText("Deconnexion");
        deconnexion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnexion1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Historique  des Demandes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 255));
        jButton4.setMnemonic('G');
        jButton4.setText("Gestion des Demandes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 255));
        jButton9.setText("Gestion des Employés");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        home.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        home.setForeground(new java.awt.Color(51, 51, 255));
        home.setText("Accueil");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(deconnexion1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(home)
                .addGap(27, 27, 27)
                .addComponent(admin1)
                .addGap(26, 26, 26)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton9)
                .addGap(78, 78, 78)
                .addComponent(deconnexion1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(Gestion5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(accepter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(refuser, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Gestion5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accepter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refuser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accepterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accepterActionPerformed
        Demande_accepter win=new    Demande_accepter();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_accepterActionPerformed

    private void Gestion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Gestion5ActionPerformed
        Gestion_demande win= new  Gestion_demande();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Gestion5ActionPerformed

    private void refuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refuserActionPerformed

        Demande_Refuser win= new  Demande_Refuser();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_refuserActionPerformed

    private void admin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin1ActionPerformed
        // TODO add your handling code here:
        Admin win=new Admin();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_admin1ActionPerformed

    private void deconnexion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnexion1ActionPerformed
        // TODO add your handling code here:
        login win=new login();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deconnexion1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Historique win=new Historique();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        Gestion_employe win=new Gestion_employe();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        // TODO add your handling code here:
        acceuil win=new acceuil();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Gestion_demande win=new Gestion_demande();
        win.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historique().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Gestion5;
    private javax.swing.JButton accepter;
    private javax.swing.JButton admin1;
    private javax.swing.JButton deconnexion1;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refuser;
    // End of variables declaration//GEN-END:variables
}
