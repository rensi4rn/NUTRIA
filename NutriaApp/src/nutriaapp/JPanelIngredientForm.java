package NutriaApp;

import NutriaModel.Ingredient;
import NutriaModel.IngredientDaoImpl;
import NutriaModel.NutrientIngredient;
import NutriaModel.NutrientsByIngredientTableModel;
import java.sql.SQLException;
import javax.swing.JDialog;

/**
 *
 * @author Ariel
 */
public class JPanelIngredientForm extends javax.swing.JPanel {

    /**
     * Creates new form JPanelIngredientForm
     */
    private Long ingredientId;
    private Ingredient ingredient;
    private IngredientDaoImpl ingredientDao;
    private NutrientsByIngredientTableModel nutrientsByIngredientTableModel;
    private JDialog container;
    private Boolean success = false;
    
    public JPanelIngredientForm(JDialog container) {
        this.container = container;
        initComponents();
        initCustomComponents();
    }
    
    public JPanelIngredientForm(JDialog container, Long ingredientId) {
        this.container = container;
        this.ingredientId = ingredientId;
        initComponents();
        initCustomComponents();
    }
    
    public Boolean getSuccess() {
        return this.success;
    }
    
    private void initCustomComponents() {
        try {
            ingredientDao = new IngredientDaoImpl();
            if(ingredientId != null) {
                ingredient = ingredientDao.queryForId(ingredientId);
                ingredient = ingredientDao.populateNutrients(ingredient);
            } else {
                ingredient = new Ingredient();
            }
            nutrientsByIngredientTableModel = new NutrientsByIngredientTableModel();
            mappIngredientToForm();
        } catch(SQLException ex) {
            //TODO: handle initCustomComponents
        }
    }
    
    private void mappIngredientToForm() {
        if (ingredient.getName() != null)
            jTextFieldName.setText(ingredient.getName());
        if (ingredient.getPrice() != null)
            jTextFieldPrice.setText(ingredient.getPrice().toString());
        if (ingredient.getRoundingFactor() != null)
            jComboBoxRoundingFactor.setSelectedItem(ingredient.getRoundingFactor());
        else
            jComboBoxRoundingFactor.setSelectedItem("1");
        
        if (ingredient.getNutrients() != null)
            nutrientsByIngredientTableModel.setNutrientList(ingredient.getNutrients());
        
        jTableNutrientsByIngredient.setModel(nutrientsByIngredientTableModel);
        jTableNutrientsByIngredient.removeColumn(jTableNutrientsByIngredient.getColumn("id"));
    }
    
    private void mappFormToIngredient() {
        ingredient.setName(jTextFieldName.getText());
        ingredient.setPrice(Double.parseDouble(jTextFieldPrice.getText()));
        ingredient.setRoundingFactor(Double.parseDouble(jComboBoxRoundingFactor.getSelectedItem().toString()));
        ingredient.setNutrients(nutrientsByIngredientTableModel.getNutrientList());
    }
    
    private void processSave() {
        mappFormToIngredient();
        try {
            ingredientDao.createOrUpdate(ingredient);
            ingredientId = ingredient.getId();
            success = true;
        } catch(SQLException ex) {
            //TODO: handle ingredient save exception
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

        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jLabelPrice = new javax.swing.JLabel();
        jComboBoxRoundingFactor = new javax.swing.JComboBox();
        jLabelRoundingFactor = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelNutrientsByIngredient = new javax.swing.JPanel();
        jButtonAddNutrient = new javax.swing.JButton();
        jButtonRemoveNutrient = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNutrientsByIngredient = new javax.swing.JTable();

        jLabelName.setText("Nombre");

        jLabelPrice.setText("Precio");

        jComboBoxRoundingFactor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "10", "1", "0.1", "0.01", "0.001" }));
        jComboBoxRoundingFactor.setToolTipText("");

        jLabelRoundingFactor.setText("Factor de Redondeo");

        jButtonSave.setText("Guardar");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancelar");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanelNutrientsByIngredient.setBorder(javax.swing.BorderFactory.createTitledBorder("Nutrientes"));

        jButtonAddNutrient.setText("Agregar Nutriente");
        jButtonAddNutrient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddNutrientActionPerformed(evt);
            }
        });

        jButtonRemoveNutrient.setText("Quitar Nutriente");
        jButtonRemoveNutrient.setToolTipText("");
        jButtonRemoveNutrient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveNutrientActionPerformed(evt);
            }
        });

        jTableNutrientsByIngredient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nutriente", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNutrientsByIngredient);

        javax.swing.GroupLayout jPanelNutrientsByIngredientLayout = new javax.swing.GroupLayout(jPanelNutrientsByIngredient);
        jPanelNutrientsByIngredient.setLayout(jPanelNutrientsByIngredientLayout);
        jPanelNutrientsByIngredientLayout.setHorizontalGroup(
            jPanelNutrientsByIngredientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutrientsByIngredientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNutrientsByIngredientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNutrientsByIngredientLayout.createSequentialGroup()
                        .addComponent(jButtonAddNutrient)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonRemoveNutrient))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNutrientsByIngredientLayout.setVerticalGroup(
            jPanelNutrientsByIngredientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNutrientsByIngredientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNutrientsByIngredientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddNutrient)
                    .addComponent(jButtonRemoveNutrient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButtonSave)
                        .addGap(67, 67, 67)
                        .addComponent(jButtonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelNutrientsByIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelRoundingFactor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxRoundingFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelName)
                                    .addComponent(jLabelPrice))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrice)
                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRoundingFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRoundingFactor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelNutrientsByIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.container.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        processSave();
        if(success) {
            container.setVisible(false);
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonAddNutrientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddNutrientActionPerformed
        JDialog findNutrientDialog = new JDialog(container, "Buscar Nutriente", true);
        JPanelFindNutrient findNutrient = new JPanelFindNutrient(findNutrientDialog);
        findNutrientDialog.setContentPane(findNutrient);
        findNutrientDialog.setSize(500, 500);
        findNutrientDialog.setResizable(false);
        findNutrientDialog.setVisible(true);
        if (findNutrient.getSelectedNutrient() != null) {
            System.out.println("Successfully got nutrientId");
            ingredient.getNutrients().add(new NutrientIngredient(findNutrient.getSelectedNutrient(),
                    ingredient,
                    0D));
            nutrientsByIngredientTableModel.setNutrientList(ingredient.getNutrients());
            nutrientsByIngredientTableModel.fireTableDataChanged();
        }
    }//GEN-LAST:event_jButtonAddNutrientActionPerformed

    private void jButtonRemoveNutrientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveNutrientActionPerformed
        int rowIndex = jTableNutrientsByIngredient.getSelectedRow();
        NutrientIngredient toRemove = (NutrientIngredient)nutrientsByIngredientTableModel.getObjectAtRow(rowIndex);
        ingredient.getNutrients().remove(toRemove);
        nutrientsByIngredientTableModel.setNutrientList(ingredient.getNutrients());
        nutrientsByIngredientTableModel.fireTableDataChanged();
    }//GEN-LAST:event_jButtonRemoveNutrientActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddNutrient;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonRemoveNutrient;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JComboBox jComboBoxRoundingFactor;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPrice;
    private javax.swing.JLabel jLabelRoundingFactor;
    private javax.swing.JPanel jPanelNutrientsByIngredient;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNutrientsByIngredient;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables
}
