package GUI;
import Lógica.Puesto;
import Lógica.Empleado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class PuestoView extends javax.swing.JFrame {
    Puesto op = new Puesto();
    Empleado mod;

    public PuestoView() {
        initComponents();
        txtidpuesto.setEditable(false);
        op.mostrar(TablePuesto);
    }
    
    //Constructor que obtiene los datos del login
    public PuestoView(Empleado mod) {
        initComponents();
        txtidpuesto.setEditable(false);
        op.mostrar(TablePuesto);
        mod.getPuesto();
        mod.getNombreEmpleado();
        this.mod = mod;
        System.out.println(mod.getNombreEmpleado());
    }

    //Método para borrar el contenido de los TextField
    void limpiar(){
        txtidpuesto.setText(null);
        txtpuesto.setText(null);
    }
    
    public void llenarDatos(){
        Object ob [] = new Object[1];
        ob[0]=txtpuesto.getText();
    }

    //Método para verificar si el nombre de puesto a registrar ya está en la base de datos
    public boolean validarRegistros (){
        boolean bandera = false;
        DefaultTableModel modelPuesto = new DefaultTableModel ();
        for (int i=0; i<TablePuesto.getRowCount(); i++){
            if (TablePuesto.getValueAt(i, 1).equals(txtpuesto.getText())){
                bandera = true;
            }
        }
        llenarDatos();
        return bandera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        txtidpuesto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtpuesto = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablePuesto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(390, 490));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso de Datos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puesto");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, -1));

        Guardar.setText("Guardar");
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 90, 30));

        txtidpuesto.setEditable(false);
        txtidpuesto.setBackground(new java.awt.Color(0, 0, 0));
        txtidpuesto.setForeground(new java.awt.Color(255, 255, 255));
        txtidpuesto.setBorder(null);
        txtidpuesto.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtidpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 160, 20));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 170, 20));

        txtpuesto.setBackground(new java.awt.Color(0, 0, 0));
        txtpuesto.setForeground(new java.awt.Color(255, 255, 255));
        txtpuesto.setBorder(null);
        txtpuesto.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 160, 20));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 170, 20));

        Cancelar.setText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel2.add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 550));

        TablePuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablePuesto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePuestoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablePuesto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 450, 350));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Puesto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 360, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Empleado.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar (30px).png"))); // NOI18N
        jLabel7.setText("Menú");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 70, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (27px).png"))); // NOI18N
        jLabel10.setText(" Salir");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 60, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Acción que realiza el botón guardar, llamando al método nuevoRegistro de la clase Puesto.
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(txtpuesto.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo está vacio, verifique su información e inténtelo de nuevo");
        }else if(validarRegistros()==true){
            JOptionPane.showMessageDialog(null, "El puesto ya está registrado");
        }else{
            op.nuevoRegistro(txtpuesto);
            op.mostrar(TablePuesto);
            limpiar();      
        }
    }//GEN-LAST:event_GuardarActionPerformed

    //Carga los datos de la tabla a los campos textField
    private void TablePuestoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePuestoMouseClicked
        DefaultTableModel modelPuesto = (DefaultTableModel) TablePuesto.getModel();
        txtidpuesto.setText(modelPuesto.getValueAt(TablePuesto.getSelectedRow(),0)+"");
        txtpuesto.setText(modelPuesto.getValueAt(TablePuesto.getSelectedRow(),1)+"");
        Guardar.setEnabled(false);
    }//GEN-LAST:event_TablePuestoMouseClicked

    //Botón para salir del programa
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Salir?");
        if(resp ==0){
           System.exit(0);
        } 
    }//GEN-LAST:event_jLabel10MouseClicked

    //Botón para regresar al menú principal
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar al menú principal?");
        if(resp ==0){
            Menu mn = new Menu(mod);
            mn.setVisible(true);
            this.setVisible(false); 
       }  
    }//GEN-LAST:event_jLabel7MouseClicked

     //Boton cancelar, limpia los campos y reestablece los botones
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        limpiar();
        Guardar.setEnabled(true);
    }//GEN-LAST:event_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(PuestoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuestoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuestoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuestoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuestoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable TablePuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtidpuesto;
    private javax.swing.JTextField txtpuesto;
    // End of variables declaration//GEN-END:variables
}
