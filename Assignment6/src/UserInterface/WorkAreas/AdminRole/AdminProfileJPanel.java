package UserInterface.WorkAreas.AdminRole;

import Business.UserAccounts.UserAccount;
import javax.swing.JPanel;
import java.text.SimpleDateFormat;

public class AdminProfileJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    UserAccount userAccount;

    public AdminProfileJPanel(UserAccount ua, JPanel jp) {
        CardSequencePanel = jp;
        this.userAccount = ua;
        initComponents();
        populateData();
    }

    private void populateData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        NameLabel.setText(userAccount.getPersonId());
        UsernameLabel.setText(userAccount.getUserLoginName());
        RoleLabel.setText(userAccount.getRole());
        
        if (userAccount.getLastAccessTime() != null) {
            LastAccessLabel.setText(sdf.format(userAccount.getLastAccessTime()));
        }
        
        if (userAccount.getLastUpdatedTime() != null) {
            LastUpdatedLabel.setText(sdf.format(userAccount.getLastUpdatedTime()));
        }
        
        if (userAccount.getAssociatedPersonProfile().getPerson().getEmail() != null) {
            EmailLabel.setText(userAccount.getAssociatedPersonProfile().getPerson().getEmail());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UsernameLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        RoleLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LastAccessLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LastUpdatedLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(30, 400, 100, 32);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24));
        jLabel2.setText("My Profile");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 29);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel1.setText("Name:");
        add(jLabel1);
        jLabel1.setBounds(50, 80, 150, 19);

        NameLabel.setText("-");
        add(NameLabel);
        NameLabel.setBounds(220, 80, 300, 16);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel3.setText("Username:");
        add(jLabel3);
        jLabel3.setBounds(50, 120, 150, 19);

        UsernameLabel.setText("-");
        add(UsernameLabel);
        UsernameLabel.setBounds(220, 120, 300, 16);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel4.setText("Role:");
        add(jLabel4);
        jLabel4.setBounds(50, 160, 150, 19);

        RoleLabel.setText("-");
        add(RoleLabel);
        RoleLabel.setBounds(220, 160, 300, 16);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel5.setText("Last Access:");
        add(jLabel5);
        jLabel5.setBounds(50, 200, 150, 19);

        LastAccessLabel.setText("-");
        add(LastAccessLabel);
        LastAccessLabel.setBounds(220, 200, 300, 16);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel6.setText("Last Updated:");
        add(jLabel6);
        jLabel6.setBounds(50, 240, 150, 19);

        LastUpdatedLabel.setText("-");
        add(LastUpdatedLabel);
        LastUpdatedLabel.setBounds(220, 240, 300, 16);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel7.setText("Email:");
        add(jLabel7);
        jLabel7.setBounds(50, 280, 150, 19);

        EmailLabel.setText("-");
        add(EmailLabel);
        EmailLabel.setBounds(220, 280, 300, 16);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel LastAccessLabel;
    private javax.swing.JLabel LastUpdatedLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel RoleLabel;
    private javax.swing.JLabel UsernameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}

