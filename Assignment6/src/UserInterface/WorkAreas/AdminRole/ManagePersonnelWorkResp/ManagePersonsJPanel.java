package UserInterface.WorkAreas.AdminRole.ManagePersonnelWorkResp;

import Business.Business;
import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class ManagePersonsJPanel extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    public ManagePersonsJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        refreshTable();
    }

    public void refreshTable() {
        int rc = EmployeeTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) EmployeeTable.getModel()).removeRow(i);
        }

        EmployeeDirectory ed = business.getEmployeeDirectory();
        for (EmployeeProfile ep : ed.getEmployeeList()) {
            Object[] row = new Object[3];
            row[0] = ep.getPerson().getPersonId();
            row[1] = ep.getPerson().getEmail();
            row[2] = ep.getPerson().getPhone();
            ((DefaultTableModel) EmployeeTable.getModel()).addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PhoneTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(null);

        Back.setText("<< Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back);
        Back.setBounds(20, 450, 76, 32);

        Next.setText("Next >>");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next);
        Next.setBounds(500, 450, 80, 32);

        jLabel1.setText("Employees");
        add(jLabel1);
        jLabel1.setBounds(20, 60, 190, 16);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24));
        jLabel2.setText("Manage Personnel (HR)");
        add(jLabel2);
        jLabel2.setBounds(21, 20, 550, 29);

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EmployeeTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(EmployeeTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 80, 560, 150);

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        add(AddButton);
        AddButton.setBounds(350, 390, 70, 32);

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        add(DeleteButton);
        DeleteButton.setBounds(510, 390, 70, 32);

        UpdateButton.setText("Update");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        add(UpdateButton);
        UpdateButton.setBounds(430, 390, 70, 32);

        jLabel3.setText("Name:");
        add(jLabel3);
        jLabel3.setBounds(30, 250, 100, 16);
        add(NameTextField);
        NameTextField.setBounds(30, 270, 200, 30);

        jLabel4.setText("Email:");
        add(jLabel4);
        jLabel4.setBounds(30, 310, 100, 16);
        add(EmailTextField);
        EmailTextField.setBounds(30, 330, 200, 30);

        jLabel5.setText("Phone:");
        add(jLabel5);
        jLabel5.setBounds(250, 250, 100, 16);
        add(PhoneTextField);
        PhoneTextField.setBounds(250, 270, 200, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        
        AdministerPersonJPanel mppd = new AdministerPersonJPanel(business, CardSequencePanel);
        CardSequencePanel.add(mppd);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_NextActionPerformed

    private void EmployeeTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeTableMousePressed
        int selectedrow = EmployeeTable.getSelectedRow();
        if (selectedrow >= 0) {
            NameTextField.setText(EmployeeTable.getValueAt(selectedrow, 0).toString());
            if (EmployeeTable.getValueAt(selectedrow, 1) != null) {
                EmailTextField.setText(EmployeeTable.getValueAt(selectedrow, 1).toString());
            }
            if (EmployeeTable.getValueAt(selectedrow, 2) != null) {
                PhoneTextField.setText(EmployeeTable.getValueAt(selectedrow, 2).toString());
            }
        }
    }//GEN-LAST:event_EmployeeTableMousePressed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String name = NameTextField.getText().trim();
        String email = EmailTextField.getText().trim();
        String phone = PhoneTextField.getText().trim();

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
        person.setPhone(phone);

        EmployeeDirectory ed = business.getEmployeeDirectory();
        EmployeeProfile ep = ed.newEmployeeProfile(person);

        JOptionPane.showMessageDialog(this, "Employee added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        NameTextField.setText("");
        EmailTextField.setText("");
        PhoneTextField.setText("");
        refreshTable();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        int selectedrow = EmployeeTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an employee to update", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String oldName = EmployeeTable.getValueAt(selectedrow, 0).toString();
        String newName = NameTextField.getText().trim();
        String email = EmailTextField.getText().trim();
        String phone = PhoneTextField.getText().trim();

        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name is required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PersonDirectory pd = business.getPersonDirectory();
        Person person = pd.findPerson(oldName);
        
        if (person != null) {
            person.setPersonId(newName);
            person.setEmail(email);
            person.setPhone(phone);
            person.updateTimestamp();
            
            JOptionPane.showMessageDialog(this, "Employee updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedrow = EmployeeTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an employee to delete", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String name = EmployeeTable.getValueAt(selectedrow, 0).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            EmployeeDirectory ed = business.getEmployeeDirectory();
            EmployeeProfile ep = ed.findEmployee(name);
            if (ep != null) {
                ed.getEmployeeList().remove(ep);
                
                UserAccountDirectory uad = business.getUserAccountDirectory();
                UserAccount ua = uad.findUserAccount(name);
                if (ua != null) {
                    uad.getUserAccountList().remove(ua);
                }
                
                JOptionPane.showMessageDialog(this, "Employee deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                NameTextField.setText("");
                EmailTextField.setText("");
                PhoneTextField.setText("");
                refreshTable();
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Back;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JButton Next;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
