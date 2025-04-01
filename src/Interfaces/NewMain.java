/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Interfaces;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class NewMain extends JFrame {
    private JTextField txtCIN, txtMatricule, txtEmail, txtTel;
    private JComboBox<String> cmbTypeConge;
    private JTextArea txtJustification;
    private JSpinner txtDateDebut, txtDateFin;
    private Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);

    public NewMain() {
        setTitle("Formulaire de Demande de Congé");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(980,800);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 20));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titre = new JLabel("DEMANDE DE CONGÉ", SwingConstants.CENTER);
        titre.setFont(new Font("segoe ui black", Font.BOLD, 33));
        titre.setForeground(new Color(51, 51,255));
        mainPanel.add(titre, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridLayout(2, 1, 20, 20));
        contentPanel.setOpaque(false);

        JPanel infoPanel = createSectionPanel("Informations Personnelles");
        addInfosPersonnelles(infoPanel);

        JPanel congePanel = createSectionPanel("Détails du Congé");
        addInfosConge(congePanel);

        contentPanel.add(infoPanel);
        contentPanel.add(congePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        buttonPanel.setOpaque(false);
        JButton btnAnnuler = createStyledButton("Annuler", new Color(200, 50, 50));
        JButton btnEnvoyer = createStyledButton("Envoyer", new Color(51,204,0));

        btnAnnuler.addActionListener(e -> openLoginScreen());
        btnEnvoyer.addActionListener(e -> submitForm());

        buttonPanel.add(btnAnnuler);
        buttonPanel.add(btnEnvoyer);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
        setVisible(true);
    }
     private void openLoginScreen() {
    // Fermer la fenêtre actuelle
    this.dispose(); // Ferme la fenêtre actuelle (celle avec les boutons)

    // Ouvrir la fenêtre de login
     // Affiche la fenêtre de login
}
    private void addInfosPersonnelles(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int row = 0;

        addLabel(panel, "CIN:", 0, row);
        txtCIN = new JTextField(15);
        stylizeComponent(txtCIN, "Entrez votre numéro CIN");
        addComponent(panel, txtCIN, 1, row++);

        addLabel(panel, "Matricule:", 0, row);
        txtMatricule = new JTextField(15);
        stylizeComponent(txtMatricule, "Entrez votre matricule");
        addComponent(panel, txtMatricule, 1, row++);

        addLabel(panel, "Email:", 0, row);
        txtEmail = new JTextField(15);
        stylizeComponent(txtEmail, "Entrez votre adresse email");
        addComponent(panel, txtEmail, 1, row++);

        addLabel(panel, "Téléphone:", 0, row);
        txtTel = new JTextField(15);
        stylizeComponent(txtTel, "Entrez votre numéro de téléphone");
        addComponent(panel, txtTel, 1, row++);
    }

    private void addInfosConge(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int row = 0;

        addLabel(panel, "Type de congé:", 0, row);
        cmbTypeConge = new JComboBox<>(new String[]{"Annuel", "Maladie", "Mariage", "Naissance", "Accouchement", "Décès proche"});
        stylizeComponent(cmbTypeConge, "Choisissez un type de congé");
        addComponent(panel, cmbTypeConge, 1, row++);

        addLabel(panel, "Date début:", 0, row);
        txtDateDebut = new JSpinner(new SpinnerDateModel());
        txtDateDebut.setEditor(new JSpinner.DateEditor(txtDateDebut, "dd/MM/yyyy"));
        stylizeComponent((JComponent) txtDateDebut.getEditor(), "Choisissez la date de début");
        addComponent(panel, txtDateDebut, 1, row++);

        addLabel(panel, "Date fin:", 0, row);
        txtDateFin = new JSpinner(new SpinnerDateModel());
        txtDateFin.setEditor(new JSpinner.DateEditor(txtDateFin, "dd/MM/yyyy"));
        stylizeComponent((JComponent) txtDateFin.getEditor(), "Choisissez la date de fin");
        addComponent(panel, txtDateFin, 1, row++);

        addLabel(panel, "Justification:", 0, row);
        txtJustification = new JTextArea(3, 15);
        txtJustification.setLineWrap(true);
        txtJustification.setWrapStyleWord(true);
        stylizeComponent(txtJustification, "Expliquez la raison du congé");
        JScrollPane scrollPane = new JScrollPane(txtJustification);
        scrollPane.setBorder(txtJustification.getBorder());
        addComponent(panel, scrollPane, 1, row++);
    }

    private void stylizeComponent(JComponent comp, String tooltip) {
        comp.setFont(fieldFont);
        comp.setBackground(new Color(245, 245, 245));
        comp.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        comp.setToolTipText(tooltip);
    }

    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(150, 150, 150)),
            title,
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 16),
            new Color(0,0,0)
        ));
        panel.setOpaque(false);
        return panel;
    }

    private void addLabel(JPanel panel, String text, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        panel.add(label, gbc);
    }

    private void addComponent(JPanel panel, Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets=new Insets(10,10,5,0);
        panel.add(component, gbc);
    }

    private JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        return button;
    }

   private Connection connectDB() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/gestion_conge",
            "root",
            ""
        );
    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "Driver MySQL non trouvé: " + e.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur de connexion à la base de données: " + e.getMessage());
    }
    return null;
}
    

 private boolean estEmploye(String cin, String matricule) {
    if (cin == null || cin.isEmpty() || matricule == null || matricule.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Le CIN et le Matricule sont obligatoires!");
        
       
        return false;
    }

    try (Connection conn = connectDB()) {
        if (conn != null) {
            String sql = "SELECT COUNT(*) FROM employes WHERE cin = ? AND matricule = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cin);
                ps.setString(2, matricule);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return rs.getInt(1) > 0;
                    }
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, 
            "Erreur lors de la vérification de l'employé: " + e.getMessage());
    }
    return false;
}



private void submitForm() {
    String cin = txtCIN.getText();
    String matricule = txtMatricule.getText();
    String email=txtEmail.getText();
    String tel= txtTel.getText();
     if ( cin.isEmpty()  || matricule.isEmpty()||email.isEmpty()) {
       JOptionPane.showMessageDialog(this, "❌ Veuillez remplir tous les champs.");
            return;}
    if (estEmploye(cin, matricule)) {
        try (Connection conn = connectDB()) {
            if (conn != null) {
                String sql = "INSERT INTO demandes (cin, matricule, email, telephone, type_conge, date_debut, date_fin, justification) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, cin);
                ps.setString(2, matricule);
                ps.setString(3, txtEmail.getText());
                ps.setString(4, txtTel.getText());
                ps.setString(5, cmbTypeConge.getSelectedItem().toString());
                ps.setDate(6, new java.sql.Date(((Date) txtDateDebut.getValue()).getTime()));
                ps.setDate(7, new java.sql.Date(((Date) txtDateFin.getValue()).getTime()));
                ps.setString(8, txtJustification.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Demande enregistrée avec succès !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement !");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vous n'êtes pas un employé enregistré.");
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewMain::new);
    }
}