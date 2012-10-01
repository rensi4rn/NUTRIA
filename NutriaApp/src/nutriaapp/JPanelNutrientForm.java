package NutriaApp;

import NutriaModel.Nutrient;
import NutriaModel.NutrientDaoImpl;
import java.sql.SQLException;
import javax.swing.JDialog;

/**
 *
 * @author Ariel
 */
public class JPanelNutrientForm extends javax.swing.JPanel {

    /**
     * Creates new form JPanelNutrientForm
     */
    private Long id;
    private NutrientDaoImpl nutrientDao;
    private Nutrient currentNutrient;
    private Boolean success = false;
    private JDialog owner;
    
    public JPanelNutrientForm(JDialog owner) {
        this.owner = owner;
        initComponents();
        try {
            initCustomComponents();
        } catch(Exception ex) {
            //TODO: handle exception on init
        }
    }
    
    public JPanelNutrientForm(JDialog owner, Long id) {
        this.owner = owner;
        this.id = id;
        initComponents();
        try {
            initCustomComponents();
        } catch(Exception ex) {
            //TODO: handle exception on init
        }
    }
    
    public Boolean getSuccess() {
        return this.success;
    }
    
    private void initCustomComponents() throws SQLException {
        nutrientDao = new NutrientDaoImpl();
        if (id != null) {
            currentNutrient = nutrientDao.queryForId(id);
            mappNutrientToForm();
        } else {
            currentNutrient = new Nutrient();
        }
    }
    
    private void mappNutrientToForm() {
        jTextFieldNutrientName.setText(currentNutrient.getName());
        jComboBoxNutrientUnit.setSelectedItem(currentNutrient.getUnit());
    }
    
    private void processSave() {
        validateForm();
        mappFormToNutrient();
        try {
            nutrientDao.createOrUpdate(currentNutrient);
            id = currentNutrient.getId();
            success = true;
        } catch(SQLException ex) {
            //TODO: handle save exception
        }
    }
    
    private void mappFormToNutrient() {
        currentNutrient.setName(jTextFieldNutrientName.getText());
        currentNutrient.setUnit(jComboBoxNutrientUnit.getSelectedItem().toString());
    }
    
    private void validateForm() {
        //TODO: validate Form
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNutrientName = new javax.swing.JTextField();
        jComboBoxNutrientUnit = new javax.swing.JComboBox();
        jLabelNutrientName = new javax.swing.JLabel();
        jLabelNutrientUnit = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jComboBoxNutrientUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%", "Mcal/Kg." }));

        jLabelNutrientName.setText("Nombre");

        jLabelNutrientUnit.setText("Unidad");

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.setToolTipText("");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNutrientUnit)
                                .addGap(82, 82, 82)
                                .addComponent(jComboBoxNutrientUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNutrientName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNutrientName, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButtonSave)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNutrientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNutrientName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNutrientUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNutrientUnit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        processSave();
        this.owner.setVisible(false);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.owner.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxNutrientUnit;
    private javax.swing.JLabel jLabelNutrientName;
    private javax.swing.JLabel jLabelNutrientUnit;
    private javax.swing.JTextField jTextFieldNutrientName;
    // End of variables declaration//GEN-END:variables
}
