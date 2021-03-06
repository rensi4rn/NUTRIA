package NutriaApp;

import NutriaDao.IngredientDaoImpl;
import NutriaModel.Ingredient;
import NutriaTableModel.IngredientTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author Ariel
 */
public class JDialogFindIngredient extends javax.swing.JDialog {

    /**
     * Creates new form JDialogFindIngredient
     */
    
    private Ingredient selectedIngredient;
    private IngredientTableModel ingredientTableModel;
    private IngredientDaoImpl ingredientDao;
    private List<Ingredient> originalIngredientList;
    
    public JDialogFindIngredient(JDialog parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
        initCustomComponents();
    }
    
    private void initCustomComponents() {
        try {
            ingredientDao = new IngredientDaoImpl();
            ingredientTableModel = new IngredientTableModel();
            originalIngredientList = ingredientDao.queryForAll();
            ingredientTableModel.setIngredientList(originalIngredientList);
            jTableResultIngredients.setModel(ingredientTableModel);
            jTableResultIngredients.removeColumn(jTableResultIngredients.getColumn("id"));
        } catch(SQLException ex) {
            //TODO: handle initCustomComponents
        }
    }
    
    public Ingredient getSelectedIngredient() {
        return this.selectedIngredient;
    }
    
    private void findIngredient(String text) {
        List<Ingredient> ingredientList = originalIngredientList;
        List<Ingredient> filteredIngredientList = new ArrayList<>();
        for(Ingredient ingredient : ingredientList) {
            if(ingredient.getName().toLowerCase().contains(text.toLowerCase())) {
               filteredIngredientList.add(ingredient);
            }
        }
        ingredientTableModel.setIngredientList(filteredIngredientList);
        ingredientTableModel.fireTableDataChanged();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFindINgredient = new javax.swing.JLabel();
        jTextFieldFindIngredient = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultIngredients = new javax.swing.JTable();
        jButtonSelectIngredient = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelFindINgredient.setText("Buscar");

        jTextFieldFindIngredient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldFindIngredientKeyReleased(evt);
            }
        });

        jTableResultIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTableResultIngredients);

        jButtonSelectIngredient.setText("Seleccionar");
        jButtonSelectIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectIngredientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFindINgredient)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldFindIngredient))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jButtonSelectIngredient)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFindIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFindINgredient))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSelectIngredient)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldFindIngredientKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFindIngredientKeyReleased
        findIngredient(jTextFieldFindIngredient.getText());
    }//GEN-LAST:event_jTextFieldFindIngredientKeyReleased

    private void jButtonSelectIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectIngredientActionPerformed
        int rowIndex = jTableResultIngredients.getSelectedRow();
        selectedIngredient = (Ingredient)ingredientTableModel.getObjectAtRow(rowIndex);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonSelectIngredientActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSelectIngredient;
    private javax.swing.JLabel jLabelFindINgredient;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultIngredients;
    private javax.swing.JTextField jTextFieldFindIngredient;
    // End of variables declaration//GEN-END:variables
}
