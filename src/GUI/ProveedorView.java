package GUI;
import Lógica.Empleado;
import Lógica.Proveedor;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProveedorView extends javax.swing.JFrame {
    Proveedor op = new Proveedor();
    Empleado mod;
    Conexion connect = new Conexion();
    
    public ProveedorView() {
        initComponents();     
        txtidproveedor.setEditable(false);
        op.mostrar(TableProveedor);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
    }
    
    //Constructor que obtiene los datos del login
    public ProveedorView(Empleado mod){
        initComponents();
        setLocationRelativeTo(null);
        txtidproveedor.setEditable(false);
        op.mostrar(TableProveedor);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
        this.mod = mod;
        mod.getPuesto();
        mod.getNombreEmpleado();
        System.out.println(mod.getNombreEmpleado());
    }
    
    //Método para limpiar todos los campos del TextField
    void limpiar(){
        txtidproveedor.setText(null);
        txtnombreproveedor.setText(null);
    }
    
    //Método para verificar si ya el nombre del proveedor a registrar
    public boolean validarRegistros(){
        boolean bandera = false;
        Connection con = connect.conectar();
        String proveedor = txtnombreproveedor.getText();
        String Consulta = "select proveedor.nombreProveedor from proveedor where nombreProveedor ='"+proveedor+"'";
         try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Consulta);
            if(rs.next()){
                bandera = true;
            }else{
                bandera = false;
            } 
        }catch(Exception e){
            System.out.println(e);
        }
        return bandera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidproveedor = new javax.swing.JTextField();
        txtnombreproveedor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Guardar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proveedores");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Perpetua Titling MT", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 350, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 350, -1));

        txtidproveedor.setEditable(false);
        txtidproveedor.setBackground(new java.awt.Color(0, 0, 0));
        txtidproveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtidproveedor.setBorder(null);
        txtidproveedor.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtidproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 150, 20));

        txtnombreproveedor.setBackground(new java.awt.Color(0, 0, 0));
        txtnombreproveedor.setForeground(new java.awt.Color(255, 255, 255));
        txtnombreproveedor.setBorder(null);
        txtnombreproveedor.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtnombreproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 150, 20));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 160, 10));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 160, 20));

        Guardar.setText("Guardar");
        Guardar.setBorder(null);
        Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel2.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 90, 30));

        Editar.setText("Actualizar");
        Editar.setBorder(null);
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPanel2.add(Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 90, 30));

        Eliminar.setText("Eliminar");
        Eliminar.setBorder(null);
        Eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        jPanel2.add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingreso de Datos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 350, 80));

        Cancelar.setText("Cancelar");
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel2.add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 90, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 550));

        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProveedor);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 130, -1, 370));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Proveedor.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 100, 100));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Proveedor");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 330, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar (30px).png"))); // NOI18N
        jLabel6.setText("Menú");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 80, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (27px).png"))); // NOI18N
        jLabel7.setText(" Salir");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Acción que realiza el botón guardar, llamando al método nuevoRegistro de la clase Proveedor.
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(txtnombreproveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo está vacio, verifique su información e inténtelo de nuevo");
        }else{
            if(validarRegistros()==false){
                op.nuevoRegistro(txtnombreproveedor);
                op.mostrar(TableProveedor);
                limpiar(); 
            }else{
                JOptionPane.showMessageDialog(null, "El proveedor ya está registrado");
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed

    //Acción que realiza el actualizar guardar, llamando al método modificarRegistro de la clase Proveedor.
    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        if(txtnombreproveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo está vacio, verifique su información e inténtelo de nuevo");
        } else{
            if(validarRegistros()==false){
                int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el registro seleccionado?");
                if(resp ==0){
                    validarRegistros();
                    op.modificarRegistro(txtidproveedor, txtnombreproveedor);
                    op.mostrar(TableProveedor);
                    limpiar();
                }
            }else{
                JOptionPane.showMessageDialog(null, "El proveedor ya está registrado");
            }
        }
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
        Guardar.setEnabled(true); 
    }//GEN-LAST:event_EditarActionPerformed

    //Acción que realiza el botón eliminar, llamando al método borrarRegistro de la clase Proveedor.
    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el registro seleccionado?");
        if(resp ==0){
            op.borrarRegistro(TableProveedor);
            op.mostrar(TableProveedor);
            limpiar();
        } 
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
        Guardar.setEnabled(true);
    }//GEN-LAST:event_EliminarActionPerformed

    //Carga los datos de la tabla a los campos textField
    private void TableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProveedorMouseClicked
        DefaultTableModel modelProveedor = (DefaultTableModel) TableProveedor.getModel();
        txtidproveedor.setText(modelProveedor.getValueAt(TableProveedor.getSelectedRow(),0)+"");
        txtnombreproveedor.setText(modelProveedor.getValueAt(TableProveedor.getSelectedRow(),1)+"");
        Guardar.setEnabled(false);
        Eliminar.setEnabled(true);
        Editar.setEnabled(true);
    }//GEN-LAST:event_TableProveedorMouseClicked

    //Botón para regresar al menú principal
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar al menú principal?");
        if(resp ==0){
            Menu mn = new Menu(mod);
            mn.setVisible(true);
            this.setVisible(false); 
       }
    }//GEN-LAST:event_jLabel6MouseClicked

    //Botón para salir del programa
    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Salir?");
        if(resp ==0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    //Boton cancelar, limpia los campos y reestablece los botones
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        limpiar();
        Guardar.setEnabled(true);
        Eliminar.setEnabled(false);
        Editar.setEnabled(false);
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
            java.util.logging.Logger.getLogger(ProveedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProveedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProveedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProveedorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProveedorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Guardar;
    private javax.swing.JTable TableProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtidproveedor;
    private javax.swing.JTextField txtnombreproveedor;
    // End of variables declaration//GEN-END:variables
}
