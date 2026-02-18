package UserInterface.WorkAreas.AdminRole;

import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.FacultyDirectory;
import Business.Profiles.FacultyProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ManageFacultyJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public ManageFacultyJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        int rc = FacultyTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) FacultyTable.getModel()).removeRow(i);
        }

        FacultyDirectory fd = business.getFacultyDirectory();
        for (FacultyProfile fp : fd.getFacultyList()) {
            Object[] row = new Object[2];
            row[0] = fp.getPerson().getPersonId();
            row[1] = fp.getPerson().getEmail();
            ((DefaultTableModel) FacultyTable.getModel()).addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FacultyTable = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
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
        jLabel2.setText("Manage Faculty");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 29);

        FacultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        FacultyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FacultyTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(FacultyTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 70, 550, 150);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        add(AddButton);
        AddButton.setBounds(350, 350, 70, 32);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        add(DeleteButton);
        DeleteButton.setBounds(510, 350, 70, 32);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        add(UpdateButton);
        UpdateButton.setBounds(430, 350, 70, 32);

        jLabel1.setText("Name:");
        add(jLabel1);
        jLabel1.setBounds(30, 240, 100, 16);
        add(NameTextField);
        NameTextField.setBounds(30, 260, 200, 30);

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

    private void FacultyTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FacultyTableMousePressed
        int selectedrow = FacultyTable.getSelectedRow();
        if (selectedrow >= 0) {
            NameTextField.setText(FacultyTable.getValueAt(selectedrow, 0).toString());
            if (FacultyTable.getValueAt(selectedrow, 1) != null) {
                EmailTextField.setText(FacultyTable.getValueAt(selectedrow, 1).toString());
            }
        }
    }//GEN-LAST:event_FacultyTableMousePressed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String name = NameTextField.getText().trim();
        String email = EmailTextField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.findPerson(name);
        
        if (person == null) {
            person = pd.newPerson(name);
        }
        
        person.setEmail(email);

        FacultyDirectory fd = business.getFacultyDirectory();
        FacultyProfile fp = fd.newFacultyProfile(person);

        JOptionPane.showMessageDialog(this, "Faculty added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        NameTextField.setText("");
        EmailTextField.setText("");
        refreshTable();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        int selectedrow = FacultyTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a faculty to update", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String oldName = FacultyTable.getValueAt(selectedrow, 0).toString();
        String newName = NameTextField.getText().trim();
        String email = EmailTextField.getText().trim();

        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.findPerson(oldName);
        
        if (person != null) {
            person.setPersonId(newName);
            person.setEmail(email);
            person.updateTimestamp();
            
            JOptionPane.showMessageDialog(this, "Faculty updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedrow = FacultyTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a faculty to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = FacultyTable.getValueAt(selectedrow, 0).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this faculty?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            FacultyDirectory fd = business.getFacultyDirectory();
            FacultyProfile fp = fd.findFaculty(name);
            if (fp != null) {
                fd.getFacultyList().remove(fp);
                
                UserAccountDirectory uad = business.getUserAccountDirectory();
                UserAccount ua = uad.findUserAccount(name);
                if (ua != null) {
                    uad.getUserAccountList().remove(ua);
                }
                
                JOptionPane.showMessageDialog(this, "Faculty deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                NameTextField.setText("");
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
    private javax.swing.JTable FacultyTable;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

