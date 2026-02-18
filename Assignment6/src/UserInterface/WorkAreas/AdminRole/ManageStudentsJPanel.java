package UserInterface.WorkAreas.AdminRole;

import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ManageStudentsJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public ManageStudentsJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        int rc = StudentTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) StudentTable.getModel()).removeRow(i);
        }

        StudentDirectory sd = business.getStudentDirectory();
        for (StudentProfile sp : sd.getStudentList()) {
            Object[] row = new Object[3];
            row[0] = sp.getPerson().getPersonId();
            row[1] = sp.getPerson().getNuid();
            row[2] = sp.getPerson().getEmail();
            ((DefaultTableModel) StudentTable.getModel()).addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NUIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
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
        jLabel2.setText("Manage Students");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 29);

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NUID", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StudentTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(StudentTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 550, 150);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        add(AddButton);
        AddButton.setBounds(350, 400, 70, 32);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        add(DeleteButton);
        DeleteButton.setBounds(510, 400, 70, 32);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        add(UpdateButton);
        UpdateButton.setBounds(430, 400, 70, 32);

        jLabel1.setText("Name:");
        add(jLabel1);
        jLabel1.setBounds(30, 240, 100, 16);
        add(NameTextField);
        NameTextField.setBounds(30, 260, 200, 30);

        jLabel3.setText("NUID:");
        add(jLabel3);
        jLabel3.setBounds(30, 300, 100, 16);
        add(NUIDTextField);
        NUIDTextField.setBounds(30, 320, 200, 30);

        jLabel4.setText("Email:");
        add(jLabel4);
        jLabel4.setBounds(250, 240, 100, 16);
        add(EmailTextField);
        EmailTextField.setBounds(250, 260, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void StudentTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMousePressed
        int selectedrow = StudentTable.getSelectedRow();
        if (selectedrow >= 0) {
            NameTextField.setText(StudentTable.getValueAt(selectedrow, 0).toString());
            if (StudentTable.getValueAt(selectedrow, 1) != null) {
                NUIDTextField.setText(StudentTable.getValueAt(selectedrow, 1).toString());
            }
            if (StudentTable.getValueAt(selectedrow, 2) != null) {
                EmailTextField.setText(StudentTable.getValueAt(selectedrow, 2).toString());
            }
        }
    }//GEN-LAST:event_StudentTableMousePressed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String name = NameTextField.getText().trim();
        String nuid = NUIDTextField.getText().trim();
        String email = EmailTextField.getText().trim();

        if (name.isEmpty() || nuid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and NUID are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.findPerson(name);
        
        if (person == null) {
            person = pd.newPerson(name);
        }
        
        person.setNuid(nuid);
        person.setEmail(email);

        StudentDirectory sd = business.getStudentDirectory();
        StudentProfile sp = sd.newStudentProfile(person);

        JOptionPane.showMessageDialog(this, "Student added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        NameTextField.setText("");
        NUIDTextField.setText("");
        EmailTextField.setText("");
        refreshTable();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        int selectedrow = StudentTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a student to update", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String oldName = StudentTable.getValueAt(selectedrow, 0).toString();
        String newName = NameTextField.getText().trim();
        String nuid = NUIDTextField.getText().trim();
        String email = EmailTextField.getText().trim();

        if (newName.isEmpty() || nuid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and NUID are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.findPerson(oldName);
        
        if (person != null) {
            person.setPersonId(newName);
            person.setNuid(nuid);
            person.setEmail(email);
            person.updateTimestamp();
            
            JOptionPane.showMessageDialog(this, "Student updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedrow = StudentTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = StudentTable.getValueAt(selectedrow, 0).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            StudentDirectory sd = business.getStudentDirectory();
            StudentProfile sp = sd.findStudent(name);
            if (sp != null) {
                sd.getStudentList().remove(sp);
                
                UserAccountDirectory uad = business.getUserAccountDirectory();
                UserAccount ua = uad.findUserAccount(name);
                if (ua != null) {
                    uad.getUserAccountList().remove(ua);
                }
                
                JOptionPane.showMessageDialog(this, "Student deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                NameTextField.setText("");
                NUIDTextField.setText("");
                EmailTextField.setText("");
                refreshTable();
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Back;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField NUIDTextField;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTable StudentTable;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

