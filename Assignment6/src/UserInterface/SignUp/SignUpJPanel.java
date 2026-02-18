package UserInterface.SignUp;

import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SignUpJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public SignUpJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NUIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UsernameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        SignUpButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(30, 450, 100, 32);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24));
        jLabel2.setText("Student Sign Up");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 29);

        jLabel1.setText("Full Name");
        add(jLabel1);
        jLabel1.setBounds(50, 80, 150, 16);

        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });
        add(NameTextField);
        NameTextField.setBounds(50, 100, 250, 30);

        jLabel3.setText("NUID");
        add(jLabel3);
        jLabel3.setBounds(50, 140, 150, 16);
        add(NUIDTextField);
        NUIDTextField.setBounds(50, 160, 250, 30);

        jLabel4.setText("Username");
        add(jLabel4);
        jLabel4.setBounds(50, 260, 150, 16);
        add(UsernameTextField);
        UsernameTextField.setBounds(50, 280, 250, 30);

        jLabel5.setText("Password");
        add(jLabel5);
        jLabel5.setBounds(50, 320, 150, 16);
        add(PasswordField);
        PasswordField.setBounds(50, 340, 250, 30);

        jLabel6.setText("Confirm Password");
        add(jLabel6);
        jLabel6.setBounds(50, 380, 150, 16);
        add(ConfirmPasswordField);
        ConfirmPasswordField.setBounds(50, 400, 250, 30);

        SignUpButton.setText("Sign Up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });
        add(SignUpButton);
        SignUpButton.setBounds(200, 450, 100, 32);

        jLabel7.setText("Email");
        add(jLabel7);
        jLabel7.setBounds(50, 200, 150, 16);
        add(EmailTextField);
        EmailTextField.setBounds(50, 220, 250, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        String name = NameTextField.getText().trim();
        String nuid = NUIDTextField.getText().trim();
        String email = EmailTextField.getText().trim();
        String username = UsernameTextField.getText().trim();
        String password = new String(PasswordField.getPassword());
        String confirmPassword = new String(ConfirmPasswordField.getPassword());

        if (name.isEmpty() || nuid.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, "Password must be at least 4 characters", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserAccountDirectory uad = business.getUserAccountDirectory();
        if (uad.findUserAccount(username) != null) {
            JOptionPane.showMessageDialog(this, "Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person existingPerson = pd.findPerson(name);
        
        if (existingPerson != null && existingPerson.getNuid() != null && !existingPerson.getNuid().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A student account with this name already exists", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Person person;
        if (existingPerson != null) {
            person = existingPerson;
        } else {
            person = pd.newPerson(name);
        }
        
        person.setNuid(nuid);
        person.setEmail(email);

        StudentDirectory sd = business.getStudentDirectory();
        StudentProfile studentProfile = sd.newStudentProfile(person);

        UserAccount newAccount = uad.newUserAccount(studentProfile, username, password);

        JOptionPane.showMessageDialog(this, "Account created successfully! You can now login.", "Success", JOptionPane.INFORMATION_MESSAGE);

        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_SignUpButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField NUIDTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}

